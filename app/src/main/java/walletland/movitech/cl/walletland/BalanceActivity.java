package walletland.movitech.cl.walletland;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BalanceActivity extends AppCompatActivity {

    TextView textBalance;
    Button buttonIn;
    Button buttonOut;
    Intent intentBalancerList;
    TblRegisters Registers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        textBalance = (TextView) findViewById(R.id.textBalance);
        buttonIn = (Button) findViewById(R.id.buttonIn);
        buttonOut = (Button) findViewById(R.id.buttonOut);
        intentBalancerList = new Intent(this, BalancerListActivity.class);

        buttonIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentBalancerList.putExtra("option", "in");
                startActivityForResult(intentBalancerList, 1);
            }
        });
        buttonOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentBalancerList.putExtra("option", "out");
                startActivityForResult(intentBalancerList, 1);
            }
        });

        Registers = new TblRegisters(this);
        textBalance.setText(String.valueOf(Registers.getSum("IN")-Registers.getSum("OUT")));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            textBalance.setText(String.valueOf(Registers.getSum("IN")-Registers.getSum("OUT")));
        }
    }
}
