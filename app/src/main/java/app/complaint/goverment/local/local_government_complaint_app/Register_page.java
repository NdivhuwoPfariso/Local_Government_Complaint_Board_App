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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Register_page extends AppCompatActivity {

    private Button register;

    private TextInputEditText email;
    private TextInputEditText password;
    private TextInputEditText name;
    private TextInputEditText surname;
    private TextInputEditText username;
    private TextInputEditText idno;
    private TextInputEditText address;

    private DatabaseReference userInfor;
    private Register_Users detailInfor;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Register");

        mAuth = FirebaseAuth.getInstance();

        email = (TextInputEditText) findViewById(R.id.email);
        password = (TextInputEditText) findViewById(R.id.password);
        name = (TextInputEditText) findViewById(R.id.name);
        surname = (TextInputEditText) findViewById(R.id.surname);
        username = (TextInputEditText) findViewById(R.id.userName);
        idno = (TextInputEditText) findViewById(R.id.idNo);
        address = (TextInputEditText) findViewById(R.id.address);


        userInfor = FirebaseDatabase.getInstance().getReference().child("Users");


        register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Intent intent = new Intent(Register_page.this,Login_page.class);
//                startActivity(intent);


                register(email.getText().toString(), password.getText().toString());
            }
        });


    }

    public void register(String email, String password) {


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            Toast.makeText(Register_page.this, "User Successfully Created", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();


                            detailInfor = new Register_Users(user.getUid(), name.getText().toString(), surname.getText().toString(), username.getText().toString(), idno.getText().toString(), address.getText().toString(), user.getEmail());

                            userInfor.child(user.getUid()).setValue(detailInfor);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Register_page.this, "Authentication failed", Toast.LENGTH_SHORT).show();

                        }

                    }
                });

    }
}
