package be.geraerts.content;

import android.content.*;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

/**
 * @author François Geraerts
 *         <p/>
 *         Date: 30/05/12
 *         Time: 13:23
 */
public class PatientContentProvider extends ContentProvider {


    public static final Uri CONTENT_URI =
            Uri.parse("content://be.geraerts.content.PatientContentProvider/patients");


    //Create the constants used to differentiate between the different URI
    //requests.
    private static final int ALLROWS = 1;
    private static final int SINGLE_ROW = 2;

    private static final UriMatcher uriMatcher;


    //Allocate the UriMatcher object, where a URI ending in 'earthquakes' will
    //correspond to a request for all earthquakes, and 'earthquakes' with a
    //trailing '/[rowID]' will represent a single earthquake row.
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("be.geraerts.content.PatientContentProvider", "patients", ALLROWS);
        uriMatcher.addURI("be.geraerts.content.PatientContentProvider", "patients/#", SINGLE_ROW);
    }


    //Column Names  for PATIENT TABLE
    public static final String PATIENT_KEY_ID = "PATIENT_ID";
    public static final String PATIENT_NAME = "NAME";
    public static final String PATIENT_FIRST_NAME = "FIRST_NAME";
    public static final String PATIENT_TEL = "TELEPHONE";
    public static final String PATIENT_GSM1 = "GSM1";
    public static final String PATIENT_GSM2 = "GSM2";
    public static final String PATIENT_BIRTHDATE = "BIRTHDATE";

    //Column Names for ADDRESS TABLE
    public static final String AD_KEY_ID = "ADDRESS_ID";
    public static final String AD_STREET = "STREET";
    public static final String AD_NUMBER = "NUMBER";
    public static final String AD_BOX = "BOX";
    public static final String AD_POSTCODE = "POSTCODE";
    public static final String AD_CITY = "CITY";
    public static final String AD_COUNTRY = "COUNTRY";
    //public static final String AD_FKEY_PAT_ID = "PATIENT_ID";


    private PatientDatabaseHelper patientDatabaseHelper = null;

    @Override
    public boolean onCreate() {

        Context context = getContext();
        patientDatabaseHelper = new PatientDatabaseHelper(context, PatientDatabaseHelper.DATABASE_NAME, null, PatientDatabaseHelper.DATABASE_VERSION);

        return true;

    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {


        //Ouverture de la base de données en read-only (query pas de mise à jour de la db)
        SQLiteDatabase db = patientDatabaseHelper.getReadableDatabase();


        //Création de la requête de sélection
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();


        //Permet de rajouter une clause where à la requête sur la primary key du patient.
        switch (uriMatcher.match(uri)) {

            case SINGLE_ROW:
                String rowId = uri.getPathSegments().get(1);
                queryBuilder.appendWhere(PATIENT_KEY_ID + "=" + rowId);

            default:
                //queryBuilder.appendWhere(PATIENT_KEY_ID + "=" + AD_FKEY_PAT_ID); //Jointure sur les deux tables
                break;

        }

        //On va requêter sur la table PATIENT ET ADDRESS
//        queryBuilder.setTables(PatientDatabaseHelper.PATIENT_TABLE + "," + PatientDatabaseHelper.ADDRESS_TABLE);
        queryBuilder.setTables(PatientDatabaseHelper.PATIENT_TABLE);

        String groupBy = null;
        String having = null;

        //Execute the Query
        Cursor cursor = queryBuilder.query(db, projection, selection, selectionArgs, groupBy, having, sortOrder);

        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case ALLROWS:
                return "vnd.android.cursor.dir/vnd.kinecabinat.patient";
            case SINGLE_ROW:
                return "vnd.android.cursor.item/vnd.kinecabinat.patient";
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {

        SQLiteDatabase database = patientDatabaseHelper.getWritableDatabase();


//        long rowAddressId = database.insert(PatientDatabaseHelper.ADDRESS_TABLE, null, contentValues);
//        long rowID = 0;


//        if (rowAddressId > 0) {
//            Log.d(PatientDatabaseHelper.TAG, "Inserting a new patient");
//            rowID = database.insert(PatientDatabaseHelper.PATIENT_TABLE, null, contentValues);
//        }

        long rowID = 0;

        rowID = database.insert(PatientDatabaseHelper.PATIENT_TABLE, null, contentValues);
        // Insert the new row. The call to database.insert will return the row number
        // if it is successful.


        // Return a URI to the newly inserted row on success.
        if (rowID > 0) {
            Uri insertUri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(uri, null);
            return insertUri;
        }

        throw new SQLException("Failed to insert row into " + uri);
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }


    //Classe helper pour la création de la table PATIENT et ADDRESS
    private static final class PatientDatabaseHelper extends SQLiteOpenHelper {

        private static final String TAG = "PatientProvider";

        private static final String DATABASE_NAME = "kinecabinat.db";
        private static final int DATABASE_VERSION = 2;
        private static final String PATIENT_TABLE = "PATIENT";
        private static final String ADDRESS_TABLE = "ADDRESS";

        private static final String CREATE_TABLE_PATIENT =
                "create table " + PATIENT_TABLE + " ("
                        + PATIENT_KEY_ID + " integer primary key autoincrement, "
                        + PATIENT_NAME + " TEXT NOT NULL, "
                        + PATIENT_FIRST_NAME + " TEXT NOT NULL, "
                        + PATIENT_TEL + " TEXT, "
                        + PATIENT_GSM1 + " TEXT, "
                        + PATIENT_GSM2 + " TEXT, "
                        + PATIENT_BIRTHDATE + " DATE, "
                        + AD_STREET + " TEXT, "
                        + AD_NUMBER + " INTEGER, "
                        + AD_BOX + " TEXT, "
                        + AD_POSTCODE + " INTEGER, "
                        + AD_CITY + " TEXT, "
                        + AD_COUNTRY + " TEXT  "
                        + "); ";

        /*
        private static final String CREATE_TABLE_ADDRESS =
                "create table " + ADDRESS_TABLE + " ("
                        + AD_KEY_ID + " integer primary key autoincrement, "
                        + AD_STREET + " TEXT, "
                        + AD_NUMBER + " INTEGER, "
                        + AD_BOX + " TEXT, "
                        + AD_POSTCODE + " INTEGER, "
                        + AD_CITY + " TEXT NOT NULL, "
                        + AD_COUNTRY + " TEXT,  "
                        + AD_FKEY_PAT_ID + " INTEGER,"
                        + "FOREIGN KEY ( " + AD_FKEY_PAT_ID + " ) REFERENCES " + PATIENT_TABLE + "(" + PATIENT_KEY_ID + "); ";


        */

        public PatientDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            //sqLiteDatabase.beginTransaction();
            sqLiteDatabase.execSQL(CREATE_TABLE_PATIENT);
            //sqLiteDatabase.execSQL(CREATE_TABLE_ADDRESS);
            //sqLiteDatabase.endTransaction();
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");


            //TODO a supprimer après les tests sinon la db sera systématiquement supprimée
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PATIENT_TABLE);

            onCreate(sqLiteDatabase);

        }
    }


}
