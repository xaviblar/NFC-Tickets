package com.example.xavier.nfc_tickets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

    Button register;
    Button login;
    EditText userName;
    EditText password;
    public static DriverList driverList=new DriverList();
    Driver d= new Driver("a","a","a","a");

    Bundle extras;
    String bundleExtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        driverList.add(d);
        extras=getIntent().getExtras();
        if(extras!=null){
            bundleExtras=extras.getString("done");
            Toast.makeText(getApplicationContext(),bundleExtras,Toast.LENGTH_SHORT).show();
        }
        register=(Button)findViewById(R.id.button2);
        login=(Button)findViewById(R.id.button);
        userName=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=userName.getText().toString();
                String pass=password.getText().toString();
                if(driverList.notRegistered2(user,pass)){
                    Toast.makeText(getApplicationContext(),"Usuario no registrado",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
