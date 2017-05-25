package walletland.movitech.cl.walletland;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class AdapterBalancer extends BaseAdapter {

    private Context context;
    private ArrayList<ModelBalance> Data;

    // CONSTRUCTOR FUNCTION
    public AdapterBalancer(Context context, ArrayList<ModelBalance> Data){
        this.context = context;
        this.Data = Data;
    }

    @Override
    public int getCount() {
        return Data.size();
    }

    @Override
    public Object getItem(int position) {
        return Data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // INFLATE ITEM FROM LAYOUT
        View ViewInflater;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ViewInflater = inflater.inflate(R.layout.listview_item, null);
        } else {
            ViewInflater = convertView;
        }

        TextView name = (TextView) ViewInflater.findViewById(R.id.name);
        TextView quantity = (TextView) ViewInflater.findViewById(R.id.textQuantity);
        TextView datetime = (TextView) ViewInflater.findViewById(R.id.textDatetime);
        Button delete = (Button) ViewInflater.findViewById(R.id.buttonDelete);

        try {
            name.setText(Data.get(position).getName());
            String balanceValue = String.format ("%,d", Data.get(position).getQuantity());
            quantity.setText("$"+balanceValue);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String strDate = formatter.format(new Date(Long.parseLong(Data.get(position).getDatetime())*1000));
            datetime.setText(strDate);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    AlertDialog.Builder confirm = new AlertDialog.Builder(v.getContext());
                    confirm.setTitle(v.getResources().getString(R.string.delete_title));
                    confirm.setMessage(v.getResources().getString(R.string.delete_text));
                    confirm.setPositiveButton(v.getResources().getString(R.string.accept), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            TblRegisters Register = new TblRegisters(v.getContext());
                            Register.delete(Data.get(position).getId());
                            ((BalancerListActivity)context).loadList();
                        }
                    });
                    confirm.setNegativeButton(v.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            dialog.cancel();
                        }
                    });
                    confirm.create();
                    confirm.show();
                }
            });
        } catch (Exception e){

        }

        return ViewInflater;
    }
}
