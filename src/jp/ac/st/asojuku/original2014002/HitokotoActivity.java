package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HitokotoActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hitokotoactivity);
	}

	@Override
	protected void onResume() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onResume();
		Intent intent = this.getIntent();
		String strHitokoto = intent.getStringExtra("hitokoto");
		TextView txvHITOKOTO = (TextView)findViewById(R.id.tv1);
		txvHITOKOTO.setText(strHitokoto);
	}
	

}
