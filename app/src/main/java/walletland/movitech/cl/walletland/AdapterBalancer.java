package walletland.movitech.cl.walletland;

import android.content.Context;
import android.icu.text.NumberFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
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
            Log.d("QUANTITY", ":"+Data.get(position).getQuantity());
            name.setText(Data.get(position).getName());
            String balanceValue = String.format ("%,d", Data.get(position).getQuantity());
            quantity.setText("$"+balanceValue);
            datetime.setText(Data.get(position).getDatetime());
        } catch (Exception e){

        }

        return ViewInflater;
    }
}
