package joy.uibestpractice;

import java.util.ArrayList;
import java.util.List;

import joy.demo.uibestpractice.R;
import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ListView msgListView ;
	private EditText inpuText ;
	private Button sendButton ;
	private MsgAdapter adapter ;
	private List<Msg> msgList =new ArrayList<Msg>() ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE) ;
		setContentView(R.layout.activity_main) ;
		initMsgs() ;
		Log.i("Joy", "init") ;
		adapter =new MsgAdapter(MainActivity.this, R.layout.msg_item, msgList) ;
		inpuText =(EditText)findViewById(R.id.input_text) ;
		sendButton =(Button)findViewById(R.id.send) ;
		msgListView=(ListView)findViewById(R.id.msg_list_view) ;
		msgListView.setAdapter(adapter) ;
		sendButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String content=inpuText.getText().toString() ;
				if(!"".equals(content))
				{
					Msg msg =new Msg(content, Msg.TYPE_SENT) ;
					msgList.add(msg);
					adapter.notifyDataSetChanged() ;//当有新的消息时，刷新listview中的显示
					msgListView.setSelection(msgList.size()) ;//将listview定位到最后一行
					inpuText.setText("") ;//清空输入框
				}
				
			}
		}) ;
		
		
	}
	
	private void initMsgs()
	{
		Msg msg1=new Msg("Hello Wu", Msg.TYPE_RECEIVED) ;
		msgList.add(msg1) ;
		Msg msg2=new Msg("Hello liu", Msg.TYPE_SENT) ;
		msgList.add(msg2) ;
		Msg msg3 =new Msg("I Love You", Msg.TYPE_RECEIVED) ;
		msgList.add(msg3) ;
	}

}
 