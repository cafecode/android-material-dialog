package me.cafecode.android.material.dialog.sample;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import me.cafecode.android.material.dialog.MaterialDialog;


public class MainActivity extends ActionBarActivity {

    enum DialogMenu {
        BASIC_PROGRESS,
        BASIC_PROGRESS_WITH_TITLE,
        BASIC,
        MATERIAL_BASIC
    }

    private static final int REFER_INDEX = 0;
    private static final int TITLE_INDEX = 1;
    private static final int DESCRIPTION_INDEX = 2;

    private ListView mListView;

    private Object[][] mDialogMenu = new Object[][]{
            {DialogMenu.BASIC, "Basic", "Basic"},
            {DialogMenu.BASIC_PROGRESS, "Basic progress dialog", "Description"},
            {DialogMenu.BASIC_PROGRESS_WITH_TITLE, "Basic progress with title dialog", "Description"},
            {DialogMenu.MATERIAL_BASIC, "Material basic", "Description"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list);

        mListView.setAdapter(new DialogMenuAdapter(this));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DialogMenu whichMenu = (DialogMenu) mDialogMenu[position][REFER_INDEX];
                switch (whichMenu) {
                    case BASIC:
                        showBasicDialog();
                        break;
                    case BASIC_PROGRESS:
                        showBasicProgressDialog();
                        break;
                    case BASIC_PROGRESS_WITH_TITLE:
                        showBasicProgressWithTitleDialog();
                        break;
                    case MATERIAL_BASIC:
                        showMaterialBasicDialog();
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private void showBasicDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("Message")
                .setNegativeButton("CANCEL", null)
                .setPositiveButton("AGREE", null)
                .setNeutralButton("NEUTRAL", null)
                .show();
    }

    private void showBasicProgressDialog() {
        ProgressDialog.show(this, null, "Loading...", true, true);
    }

    private void showBasicProgressWithTitleDialog() {
        ProgressDialog.show(this, "Progress Title", "Loading...", true, true);
    }

    private void showMaterialBasicDialog() {
        new MaterialDialog.Builder(this).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class DialogMenuAdapter extends ArrayAdapter {

        public DialogMenuAdapter(Context context) {
            super(context, 0);
        }

        @Override
        public int getCount() {
            return mDialogMenu.length;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            TextView titleText = (TextView) convertView.findViewById(android.R.id.text1);
            String title = (String) mDialogMenu[position][TITLE_INDEX];
            titleText.setText(title);
            return convertView;
        }
    }
}
