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

public class Register extends Activity {

    EditText name;
    EditText id;
    EditText username;
    EditText password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=(EditText)findViewById(R.id.editText5);
        id=(EditText)findViewById(R.id.editText6);
        username=(EditText)findViewById(R.id.editText3);
        password=(EditText)findViewById(R.id.editText4);
        register=(Button)findViewById(R.id.button3);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=name.getText().toString();
                String i=id.getText().toString();
                String u=username.getText().toString();
                String p=password.getText().toString();
                if(n.equals("") || i.equals("") || u.equals("") || p.equals("")){
                    Toast.makeText(getApplicationContext(),"Se debe llenar todos los espacios",Toast.LENGTH_SHORT).show();
                }
                else if(!Login.driverList.notRegistered2(u,p)){
                    Toast.makeText(getApplicationContext(),"Error al registrar usuarior",Toast.LENGTH_SHORT).show();
                }
                else{
                    Driver d= new Driver(n,i,u,p);
                    if(Login.driverList.add(d)){
                        Intent intent=new Intent(getApplicationContext(),Login.class);
                        intent.putExtra("done", "Registrado exitosamente");
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Error al registrar usuario",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
