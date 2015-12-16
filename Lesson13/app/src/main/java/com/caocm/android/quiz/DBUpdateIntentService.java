package com.caocm.android.quiz;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.caocm.android.quiz.db.QuizDatabaseHelper;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class DBUpdateIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_UPDATEDB = "com.caocm.android.quiz.action.UPDATEDB";
    private static final String ACTION_BAZ = "com.caocm.android.quiz.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.caocm.android.quiz.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.caocm.android.quiz.extra.PARAM2";

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionDBUpdate(Context context, String param1, String param2) {
        Intent intent = new Intent(context, DBUpdateIntentService.class);
        intent.setAction(ACTION_UPDATEDB);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, DBUpdateIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    public DBUpdateIntentService() {
        super("DBUpdateIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_UPDATEDB.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionUpdateDB(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
    }
    private boolean downloadQuestions(){
        ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()){
            return true;
        }else{
            return false;
        }
    }
    private boolean downloadData(){

        return false;
    }
    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionUpdateDB(String param1, String param2) {
        QuizDatabaseHelper dbHelper = new QuizDatabaseHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbHelper.insertQustion(db,"Which one of the following statements might explain why the Music application plays songs using a Service, rather than by using one of its Activities?"
                , "Activities have user interfaces."
                , "Playing a song takes a lot of time."
                , "The user might want to listen to music and do something else at the same time."
                , "The Activity class would need a BroadcastReceiver to play music."
                , null
                , 2);

        dbHelper.insertQustion(db,"Which one of the four fundamental components of Android applications is designed to provide an interface to the user?"
                , "ContentProvider"
                , "Activity"
                , "BroadcastReceiver"
                , "Service"
                , null
                , 1);
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
