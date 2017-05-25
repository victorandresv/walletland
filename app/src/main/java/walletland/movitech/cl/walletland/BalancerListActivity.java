package walletland.movitech.cl.walletland;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BalancerListActivity extends AppCompatActivity {

    String option;
    AlertDialog.Builder form;
    EditText title;
    EditText quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balancer_list);
        getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

        title = new EditText(this);
        title.setHint(getResources().getString(R.string.name));
        quantity = new EditText(this);
        quantity.setHint(getResources().getString(R.string.quantity));

        option = getIntent().getStringExtra("option");
        form = new AlertDialog.Builder(this);

        if(option.contains("in")){
            getSupportActionBar().setSubtitle(getResources().getString(R.string.in));
            form.setTitle(getResources().getString(R.string.in));
        } else {
            getSupportActionBar().setSubtitle(getResources().getString(R.string.out));
            form.setTitle(getResources().getString(R.string.in));
        }

        form.setMessage(getResources().getString(R.string.add_reg_message));

        LinearLayout layout = new LinearLayout(getApplicationContext());
        layout.setPadding(20, 0, 20, 0);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(title);
        layout.addView(quantity);
        form.setView(layout);

        form.setPositiveButton(getResources().getString(R.string.add), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if(option.contains("in")){

                } else {

                }
            }
        });
        form.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.balancer_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addNew:
                form.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
    }
}
