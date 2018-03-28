package com.example.nacho.world_cup_russia_2018.View;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nacho.world_cup_russia_2018.Config.URLRest;
import com.example.nacho.world_cup_russia_2018.Properties.ListTeams;
import com.example.nacho.world_cup_russia_2018.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

             /*----------- Variables -------------*/

    ActionBar actionBar;
    ListView lstmenu;
    DrawerLayout drawerLayout;
    TextView textView;
    ImageView Main;
    Toolbar toolbar;
    String json = "https://my-json-server.typicode.com/juanrebella/gitCloneMirror2/oceania";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*- Action Bar-*/
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_bar_icon);
        actionBar.setDisplayHomeAsUpEnabled(true);

        lstmenu = findViewById(R.id.lstMenu);
        drawerLayout = findViewById(R.id.navigation_drawer_layout);



        NavigationView navigationView = findViewById(R.id.navigation_view);
        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }

        setupNavigationDrawerContent(navigationView);

        List<ListTeams> teams = new ArrayList<>();

        ListTeams equipos = new ListTeams();

        int idTeam;
        int group;
        String teamName;
        int trophies;




        try {
            JSONObject object = new JSONObject(json);

            idTeam = object.getInt("team_id");
            group = object.getInt("group_id");
            teamName = object.getString("name");
            trophies = object.getInt("trophies");


            equipos.setIdTeam(idTeam);
            equipos.setGroup(group);
            equipos.setTeamName(teamName);
            equipos.setTrophies(trophies);

            teams.add(equipos); //creamos un objeto Fruta y lo insertamos en la lista


        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayAdapter adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, teams);
        lstmenu.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Inflamos el menú

        getMenuInflater().inflate(R.menu.menu_icons, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.refreshMain:
                //ABRIMOS EL DRAWER
                //Refrescaríamos la pantalla para ver noticias

                Toast.makeText(this, "Refrescando ...", Toast.LENGTH_SHORT).show();
                return true;

            case android.R.id.home:
                //ABRIMOS EL DRAWER
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setupNavigationDrawerContent( NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected( MenuItem menuItem) {

                        switch (menuItem.getItemId()) {
                            case R.id.item_navigation_drawer_news:

                                /*- Pasta -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentNews = new Intent(MainActivity.this, MainActivity.class);
                                finish();
                                startActivity(intentNews);

                                return true;

                            case R.id.item_navigation_drawer_teams:

                                /*- Minutas -*/
                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentTeams = new Intent(MainActivity.this, TeamsActivity.class);
                                finish();
                                startActivity(intentTeams);

                                return true;

                            case R.id.item_navigation_drawer_matches:

                                /*- Ensalada -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentMatches = new Intent(MainActivity.this, MatchesActivity.class);
                                finish();
                                startActivity(intentMatches);

                                return true;

                            case R.id.item_navigation_drawer_groups:
                                /*- Parrilla -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentGroups = new Intent(MainActivity.this, GroupsActivity.class);
                                finish();
                                startActivity(intentGroups);

                                return true;

                            case R.id.item_navigation_drawer_stadiums:

                                /*- Mariscos -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentStadiums = new Intent(MainActivity.this, StadiumsActivity.class);
                                finish();
                                startActivity(intentStadiums);

                                return true;

                            case R.id.item_navigation_drawer_about_us:

                                /*- Mariscos -*/

                                menuItem.setChecked(true);
                                drawerLayout.closeDrawer(GravityCompat.START);

                                Intent intentAboutUs = new Intent(MainActivity.this, AboutUsActivity.class);
                                finish();
                                startActivity(intentAboutUs);

                                return true;


                        }
                        return true;
                    }
                });
    }


}
