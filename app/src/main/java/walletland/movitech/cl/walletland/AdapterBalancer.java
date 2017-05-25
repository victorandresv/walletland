package walletland.movitech.cl.walletland;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

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
            ViewInflater = inflater.inflate(R.layout.activity_balancer_list, null);
        } else {
            ViewInflater = convertView;
        }

        TextView name = (TextView) ViewInflater.findViewById(R.id.name);
        TextView quantity = (TextView) ViewInflater.findViewById(R.id.quantity);
        TextView datetime = (TextView) ViewInflater.findViewById(R.id.datetime);
        Button delete = (Button) ViewInflater.findViewById(R.id.buttonDelete);

        name.setText(Data.get(position).getName());
        quantity.setText(Data.get(position).getQuantity());
        datetime.setText(Data.get(position).getDatetime());

        return ViewInflater;
    }
}
