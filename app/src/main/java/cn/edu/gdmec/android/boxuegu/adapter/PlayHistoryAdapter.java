package cn.edu.gdmec.android.boxuegu.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.edu.gdmec.android.boxuegu.R;
import cn.edu.gdmec.android.boxuegu.activity.VideoPlayActivity;
import cn.edu.gdmec.android.boxuegu.bean.VideoBean;

/**
 * Created by ASUS on 2018/4/14.
 */

public class PlayHistoryAdapter extends BaseAdapter {
    private Context mContext;
    private List<VideoBean> vb1;
    public PlayHistoryAdapter(Context context){
        this.mContext=context;
    }
    /*设置数据更新界面*/
    public void setData(List<VideoBean> vb1){
        this.vb1=vb1;
        notifyDataSetChanged();
    }
    /*获取Item的总数*/
    @Override
    public int getCount(){
        return vb1==null ? 0 : vb1.size();
    }
    /*根据position得到对应Item的对象*/
    @Override
    public VideoBean getItem(int position){
        return vb1==null ? null : vb1.get(position);
    }
    /*根据position得到对应Item的Id*/
    @Override
    public long getItemId(int position){
        return position;
    }
    /*得到相应position对应的Item视图
    * position是当前Item的位置，convertView参数就是滑出屏幕的Item的View*/
    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final ViewHolder vh;
        if (convertView==null){
            vh=new ViewHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.play_history_list_item,null);
            vh.tv_title=(TextView) convertView.findViewById(R.id.tv_adapter_title);
            vh.tv_video_title=(TextView) convertView.findViewById(R.id.tv_video_title);
            vh.iv_icon=(ImageView) convertView.findViewById(R.id.iv_video_icon);
            convertView.setTag(vh);
        }else {
            vh=(ViewHolder) convertView.getTag();
        }
        final VideoBean bean=getItem(position);
        if (bean!=null){
            vh.tv_title.setText(bean.title);
            vh.tv_video_title.setText(bean.secondTitle);
            switch (bean.chapterId){
                case 1:
                    vh.iv_icon.setImageResource(R.drawable.video_play_icon1);
                    break;
                case 2:
                    vh.iv_icon.setImageResource(R.drawable.video_play_icon2);
                    break;
                case 3:
                    vh.iv_icon.setImageResource(R.drawable.video_play_icon3);
                    break;
                case 4:
                    vh.iv_icon.setImageResource(R.drawable.video_play_icon4);
                    break;
                case 5:
                    vh.iv_icon.setImageResource(R.drawable.video_play_icon5);
                    break;
                case 6:
                    vh.iv_icon.setImageResource(R.drawable.video_play_icon6);
                    break;
                case 7:
                    vh.iv_icon.setImageResource(R.drawable.video_play_icon7);
                    break;
                case 8:
                    vh.iv_icon.setImageResource(R.drawable.video_play_icon8);
                    break;
                case 9:
                    vh.iv_icon.setImageResource(R.drawable.video_play_icon9);
                    break;
                case 10:
                    vh.iv_icon.setImageResource(R.drawable.video_play_icon10);
                    break;
                default:
                    vh.iv_icon.setImageResource(R.drawable.video_play_icon1);
                    break;

            }
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bean==null) return;
                //跳转到播放视频界面
                Intent intent=new Intent(mContext, VideoPlayActivity.class);
                intent.putExtra("videoPath",bean.videoPath);
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }
    class ViewHolder{
        public TextView tv_title,tv_video_title;
        public ImageView iv_icon;
    }
}
