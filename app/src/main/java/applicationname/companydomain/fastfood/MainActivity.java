package applicationname.companydomain.fastfood;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import applicationname.companydomain.fastfood.fragments.DealsFragment;
import applicationname.companydomain.fastfood.fragments.HandlekurvFragment;
import applicationname.companydomain.fastfood.fragments.PizzaFragment;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();

            displaySelectedScreen(id);

            return true;
        }
    };

    private void displaySelectedScreen(int id) {
        Fragment fragment = null;
        switch (id) {
            case R.id.navigation_deals:
                fragment = new DealsFragment();
                break;
            case R.id.navigation_pizza:
                fragment = new PizzaFragment();
                break;
            case R.id.navigation_cart:
                fragment = new HandlekurvFragment();
                break;
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}
