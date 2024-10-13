package ma.tp_celebrity_list;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.ImageView;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_splash);

      ImageView logo = findViewById(R.id.logo);

      logo.animate().rotation(360f).setDuration(2000);
      logo.animate().scaleX(0.5f).scaleY(0.5f).setDuration(3000);
      logo.animate().alpha(0f).setDuration(6000);

      Thread t = new Thread() {
         @Override
         public void run() {
            try {
               sleep(6000);
               Intent intent = new Intent(SplashActivity.this, ListActivity.class);
               startActivity(intent);
               finish();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      };
      t.start();
   }
   @Override
   protected void onPause() {
      super.onPause();
      this.finish();
   }
}
