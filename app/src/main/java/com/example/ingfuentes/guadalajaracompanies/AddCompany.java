package com.example.ingfuentes.guadalajaracompanies;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class AddCompany extends Activity {
    static final int SELECT_PICTURE =1;
    String selectedImagePath;
    ListItem listItem = new ListItem();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_company);
        TextView tvCounter = (TextView)findViewById(R.id.txtCounter);
        tvCounter.setText("("+GlobalClass.counter+")");
        //CODIGO EXTRA, AGREGADO PARA LA FUNCIONALIDAD DE LA GALERIA DE FOTOS
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_company, menu);
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

    public void addCounter(View view){
        setCounter();
        addItem();
        clearFields();
    }

    public void setCounter(){
        TextView tvCounter = (TextView)findViewById(R.id.txtCounter);
        GlobalClass.counter++;
        tvCounter.setText("("+GlobalClass.counter+")");
    }
    public void addItem(){
        EditText etName = (EditText)findViewById(R.id.editTxtCompanyName);
        EditText etGiro = (EditText)findViewById(R.id.editTxtGiro);
        ImageView ivImg = (ImageView)findViewById(R.id.imgCompany);
        listItem = new ListItem();
        listItem.setImgCompany(ivImg.getDrawable());
        //listItem.setImgCompany(getResources().getDrawable(R.drawable.baymax));
        listItem.setTxtCompanyName(etName.getText().toString());
        listItem.setTxtCompanyGiro(etGiro.getText().toString());
        GlobalClass.arrView.add(listItem);
    }

    public void clearFields(){
        EditText etName = (EditText)findViewById(R.id.editTxtCompanyName);
        EditText etGiro = (EditText)findViewById(R.id.editTxtGiro);
        ImageView ivImg = (ImageView)findViewById(R.id.imgCompany);
        etName.setText("");
        etGiro.setText("");
        ivImg.setImageResource(R.drawable.baymax);
    }
    //CODIGO EXTRA, AGREGADO PARA LA FUNCIONALIDAD DE LA GALERIA DE FOTOS
    public void imgGallery(View view){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),SELECT_PICTURE);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
                ImageView selectedImage = (ImageView)findViewById(R.id.imgCompany);
                selectedImage.setImageURI(selectedImageUri);
            }
        }
    }//Termina onActivityResult

    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }//Termina getPath
}
