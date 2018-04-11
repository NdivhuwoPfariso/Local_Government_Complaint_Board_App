package app.complaint.goverment.local.local_government_complaint_app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_page extends AppCompatActivity {

    private TextInputEditText userEmail;
    private TextInputEditText userPassword;
    private Button reg, login;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_page);

        mAuth = FirebaseAuth.getInstance();
        reg = (Button) findViewById(R.id.reg);
        login = (Button) findViewById(R.id.loginbtn);
        userEmail = (TextInputEditText) findViewById(R.id.userLogin);
        userPassword = (TextInputEditText) findViewById(R.id.passwordLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login(userEmail.getText().toString(), userPassword.getText().toString());

            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Login_page.this, Register_page.class);
                startActivity(intent);
            }
        });
    }


    public void Login(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(Login_page.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(Login_page.this, Home_Page.class);
                                    startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Login_page.this, "Login Failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                    }
                });

    }

    @Override
    protected void onStart() {
        super.onStart();

        // FirebaseUser currentUser = mAuth.getCurrentUser();
        // updateUI(currentUser);

    }
}
