package lynxdom.com.listapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class pictureDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);

        Intent intent = getIntent();
        int index = intent.getIntExtra("lynxdom.com.picIndex", -1);
        if (index>-1) {
            int picRef = get_image(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            scaleImg(img, picRef);
        }

    }

    private int get_image(int index) {
        switch (index) {
            case 0: return R.drawable.peach;
            case 1: return R.drawable.tamatoes;
            case 2: return R.drawable.squash;
            default: return -1;

        }
    }

    private void scaleImg(ImageView imgView, int pic) {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth>screenWidth) {
            int calcRatio = Math.round((float)imgWidth/(float)screenWidth);
            options.inSampleSize = calcRatio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaleImage = BitmapFactory.decodeResource(getResources(), pic, options);

        imgView.setImageBitmap(scaleImage);

    }
}
