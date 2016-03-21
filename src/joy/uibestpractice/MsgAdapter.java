package joy.uibestpractice;

import java.util.List;

import joy.demo.uibestpractice.R;

import android.R.integer;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MsgAdapter extends ArrayAdapter<Msg> {
	
	private int resourceId ;
	
	public MsgAdapter(Context context, int resource, List<Msg> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		resourceId =resource ;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Msg msg =getItem(position) ;
		View view ;
		ViewHolder viewHolder ;
		if(convertView ==null)
		{
			view =LayoutInflater.from(getContext()).inflate(resourceId, null) ;
			viewHolder =new ViewHolder() ;
			viewHolder.leftLayout =(LinearLayout)view.findViewById(R.id.left_layout) ;
		    viewHolder.rightLayout =(LinearLayout)view.findViewById(R.id.right_layout) ;
		    viewHolder.leftMsg =(TextView)view.findViewById(R.id.left_msg) ;
		    viewHolder.rightMsg =(TextView)view.findViewById(R.id.right_msg) ;
		    view.setTag(viewHolder) ;
		}
		else {
			view=convertView ;
			viewHolder =(ViewHolder) view.getTag() ;
		}
		if(msg.getType() == Msg.TYPE_RECEIVED)
		{
			//������յ���Ϣ������ʾ��ߵĲ�����Ϣ�������ұߵ���Ϣ����
			viewHolder.leftLayout.setVisibility(View.VISIBLE) ;
			viewHolder.rightLayout.setVisibility(View.GONE) ;
			viewHolder.leftMsg.setText(msg.getContent()) ;
		}else if(msg.getType() ==Msg.TYPE_SENT)
		{
			//����Ƿ���ȥ����Ϣ������ʾ�ұߵ���Ϣ���֣�������ߵ���Ϣ����
			viewHolder.rightLayout.setVisibility(View.VISIBLE) ;
			viewHolder.leftLayout.setVisibility(View.GONE) ;
			viewHolder.rightMsg.setText(msg.getContent()) ;
		}
		return view;
	}
	class ViewHolder {
		LinearLayout leftLayout ;
		LinearLayout rightLayout ;
		TextView leftMsg ;
		TextView rightMsg ;
	}

}
