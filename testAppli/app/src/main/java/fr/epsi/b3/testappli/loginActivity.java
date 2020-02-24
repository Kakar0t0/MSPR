package fr.epsi.b3.testappli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.CheckBox;

import fr.epsi.b3.testappli.Model.Users;
import fr.epsi.b3.testappli.prevalent.Prevalent;

public class loginActivity extends AppCompatActivity {
    private EditText InputLogin, InputPassword;
    private Button LoginButton;
    private ProgressDialog loadingBar;
    private TextView AdminLink, NotAdminLink, ForgetPasswordLink;

    private String parentDbName = "Users";
    private CheckBox chkBoxRememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginButton = (Button) findViewById(R.id.login_btn);
        InputPassword = (EditText) findViewById(R.id.login_password_input);
        InputLogin = (EditText) findViewById(R.id.login_login_input);
        AdminLink = (TextView) findViewById(R.id.admin_panel_link);
        NotAdminLink = (TextView) findViewById(R.id.not_admin_panel_link);
        ForgetPasswordLink = findViewById(R.id.forget_password_link);
        loadingBar = new ProgressDialog(this);


        LoginButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                LoginUser();

            }
        });
    }
        private void LoginUser()
        {
            String login = InputLogin.getText().toString();
            String password = InputPassword.getText().toString();

            if (TextUtils.isEmpty(login))
            {
                Toast.makeText(this, "Remplir le champ login...", Toast.LENGTH_SHORT).show();
            }
            else if (TextUtils.isEmpty(password))
            {
                Toast.makeText(this, "Remplir le champ mot de passe...", Toast.LENGTH_SHORT).show();
            }
            else
            {
                loadingBar.setTitle("Login Account");
                loadingBar.setMessage("Patientez, nous vérifions vos informations.");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();


                AllowAccessToAccount(login, password);
            }
        }

    private void AllowAccessToAccount(final String login, final String password) {



        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();


        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if (dataSnapshot.child(parentDbName).child(login).exists()) {
                    Users usersData = dataSnapshot.child(parentDbName).child(login).getValue(Users.class);

                    if (usersData.getLogin().equals(login)) {
                        if (usersData.getPassword().equals(password)) {
                            Toast.makeText(loginActivity.this, "authentification réussie...", Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();

                            Intent intent = new Intent(loginActivity.this, HomeActivity.class);
                            Prevalent.currentOnlineUser = usersData;
                            startActivity(intent);
                        }
                    }
                }
                        else
                        {
                            loadingBar.dismiss();
                            Toast.makeText(loginActivity.this, "Le login ou mot de passe est incorrect.", Toast.LENGTH_SHORT).show();
                        }
                    }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
