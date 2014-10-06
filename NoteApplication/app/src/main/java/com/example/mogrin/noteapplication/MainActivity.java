package com.example.mogrin.noteapplication;

import com.example.mogrin.noteapplication.Dialog1.onSomeEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import android.app.DialogFragment;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity implements onSomeEventListener {

    private static final int CM_DELETE_ID = 1;

    final String NAME_TEXT = "text";

    DialogFragment dlg1;
    ListView lvSimple;
    SimpleAdapter sAdapter;
    ArrayList<Map<String, Object>> data;
    Map<String, Object> m;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        dlg1 = new Dialog1();

        data = new ArrayList<Map<String, Object>>();
        String[] from = { NAME_TEXT };
        int[] to = { R.id.tvText };

        sAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);

        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(sAdapter);
        registerForContextMenu(lvSimple);
    }

    public void onButtonClick(View v) {
        dlg1.show(getFragmentManager(), "dlg1");
    }


    @Override
    public void someEvent(String s) {
        m = new HashMap<String, Object>();
        m.put(NAME_TEXT, s);
        data.add(m);
        sAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, CM_DELETE_ID, 0, "Удалить запись");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == CM_DELETE_ID) {
            AdapterContextMenuInfo acmi = (AdapterContextMenuInfo) item.getMenuInfo();
            data.remove(acmi.position);
            sAdapter.notifyDataSetChanged();
            return true;
        }
        return super.onContextItemSelected(item);
    }


}
