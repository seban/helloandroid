package com.sebastiannowak;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Package: com.sebastiannowak
 * User: seban
 */
public class HelloAndroid extends Activity {

  private static final int BAD_NAME_DIALOG = 1;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    final TextView textView = (TextView) findViewById(R.id.textView);
    final EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
    final Button submitName = (Button) findViewById(R.id.submitName);
    submitName.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Editable name = nameEditText.getText();
        if (name.length() == 0) {
          // komunikat o błędzie
          showDialog(BAD_NAME_DIALOG);
          textView.setText("You had to say your name");
        } else {
          // wyświetlenie powitania
          textView.setText("Welcome, " + name + "!");
        }
      }
    });
  }

  @Override
  protected Dialog onCreateDialog(int id) {
   Dialog dialog;
   switch (id) {
     case BAD_NAME_DIALOG:
       AlertDialog.Builder alertBuilder = new AlertDialog.Builder(HelloAndroid.this);
       alertBuilder.setTitle("Alert")
         .setMessage("Bad name was submitted")
         .setIcon(R.drawable.icon);
       alertBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialogInterface, int i) { /* nothing to do here */ }
       });
       dialog = alertBuilder.create();
       break;
     default:
       dialog = null;
   }
   return dialog;
 }
}