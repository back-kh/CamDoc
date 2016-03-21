package m1.gic.camdoc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by THUON Nimol on 3/9/2016.
 */
public class ListViewAdapter extends BaseAdapter {

    ArrayList<Document> data;
    Context context;

    public void setData(ArrayList<Document> data, Context context){
        this.data = data;
        this.context = context;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.layout_list_view, null);

            Document document = data.get(position);

//            String image = data.get(position).getImage();
//            ImageView imageView = (ImageView) convertView.findViewById(R.id.list_view_image);

//            byte[] b = Base64.decode(image, Base64.DEFAULT);
//            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);

//            imageView.setImageBitmap(bitmap);
            TextView textView = (TextView) convertView.findViewById(R.id.list_view_text);
            textView.setText(document.getName());


        }

        return convertView;
    }
}
