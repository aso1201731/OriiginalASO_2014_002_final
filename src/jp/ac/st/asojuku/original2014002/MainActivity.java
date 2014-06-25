package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener{
	
	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

   
	@Override
	public void onClick(View v) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		Intent intent = null;
		switch(v.getId()) {
			case R.id.bt2: //���͂��ꂽ���e��o�^
				EditText etv = (EditText)findViewById(R.id.edt);
				String inputMsg = etv.getText().toString();
				
				if(inputMsg !=null && !inputMsg.isEmpty()) {
					helper.insertHitokoto(sdb, inputMsg);
				}
				etv.setText("");
				break;
				
			case R.id.bt3: //�`�F�b�N
				String strHitokoto = helper.selectRandomHitokoto(sdb);
				intent = new Intent(MainActivity.this, HitokotoActivity.class);
				intent.putExtra("hitokoto", strHitokoto);
				startActivity(intent);
				break;
				
			case R.id.bt1: //�����e
				intent = new Intent(MainActivity.this, MaintenanceActivity.class);
				startActivity(intent);
				break;
		}
		
	}


	@Override
	protected void onResume() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onResume();
		
		Button btnENTRY = (Button)findViewById(R.id.bt2); //�o�^�{�^��
		btnENTRY.setOnClickListener(this);
		
		Button btnMAINTE = (Button)findViewById(R.id.bt1); //�����e�{�^��
		btnMAINTE.setOnClickListener(this);
		
		Button btnCHECK = (Button)findViewById(R.id.bt3); //�`�F�b�N�{�^��
		btnCHECK.setOnClickListener(this);
		
		if(sdb == null) {
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try {
			sdb = helper.getWritableDatabase();
		} catch(SQLiteException e) {
			return;
		}
	}

}
