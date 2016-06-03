package mac.com.macassignment.Assignment1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.animators.ScaleInAnimator;
import mac.com.macassignment.R;

/**
 * Created by Ankitkumar on 6/2/2016.
 */

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerItemViewHolder> {
        private ArrayList<RecyclerData> myList;
        int mLastPosition = 0;
        ScaleInAnimator animator = new ScaleInAnimator();
        Context context;

    private RemoveClickListner mListner;
        public RecyclerAdapter(ArrayList<RecyclerData> myList,RemoveClickListner listner) {
            this.myList = myList;
            mListner=listner;
        }
        public RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
            RecyclerItemViewHolder holder = new RecyclerItemViewHolder(view);
            return holder;
        }
        @Override
        public void onBindViewHolder(RecyclerItemViewHolder holder, final int position) {
            Log.d("onBindViewHoler ", myList.size() + "");
            holder.etTitleTextView.setText(myList.get(position).getTitle());
            holder.etDescriptionTextView.setText(myList.get(position).getDescription());



        }
        public void animate(RecyclerView.ViewHolder viewHolder) {
        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.anticipate_overshoot_interpolator);
        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
    }
        @Override
        public int getItemCount() {
            return(null != myList?myList.size():0);
        }
        public void notifyData(ArrayList<RecyclerData> myList) {
            Log.d("notifyData ", myList.size() + "");
            this.myList = myList;
            notifyDataSetChanged();
        }
        public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
            private final TextView etTitleTextView;
            private final TextView etDescriptionTextView;
            private LinearLayout mainLayout;
            public Button crossImage;
            public RecyclerItemViewHolder(final View parent) {
                super(parent);
                etTitleTextView = (TextView) parent.findViewById(R.id.txtTitle);
                etDescriptionTextView = (TextView) parent.findViewById(R.id.txtDescription);
                crossImage = (Button) parent.findViewById(R.id.crossImage);
                mainLayout = (LinearLayout) parent.findViewById(R.id.mainLayout);
                mainLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(itemView.getContext(), "Position:" + Integer.toString(getPosition()), Toast.LENGTH_SHORT).show();
                    }
                });
                crossImage.setOnClickListener(new AdapterView.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mListner.OnRemoveClick(getAdapterPosition()
                        );
                    }
                });
            }
        }


    }


