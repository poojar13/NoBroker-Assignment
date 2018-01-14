package com.example.pooja.nobrokersampleapp.Model.Adapters;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pooja.nobrokersampleapp.Model.Pojo.PropertyData;
import com.example.pooja.nobrokersampleapp.R;
import com.example.pooja.nobrokersampleapp.View.Interface.OnBottomReachedListener;

import java.util.ArrayList;

/**
 * Created by pooja on 13/1/18.
 */

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
        private ArrayList<PropertyData> propertyData;
        Context context;
        OnBottomReachedListener onBottomReachedListener;
        public RecyclerViewAdapter() {

        }

        public void setData(ArrayList<PropertyData> propertyData){
            this.propertyData = propertyData;
        }
         public void setOnBottomReachedListener(OnBottomReachedListener onBottomReachedListener){

                this.onBottomReachedListener = onBottomReachedListener;
         }
        @Override
        public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup, false);
            context = viewGroup.getContext();
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewAdapter.ViewHolder viewHolder, int i) {
            if(propertyData.size()==21){
                if (i == propertyData.size() - 1){
                    onBottomReachedListener.onBottomReached(i);
                }
            }

            viewHolder.propertyTitle.setText(propertyData.get(i).getTitle());
            viewHolder.propertySecondaryTitle.setText("at"+" "+propertyData.get(i).getSecondaryTitle());
            viewHolder.bathroom.setText(propertyData.get(i).getBathroom()+" "+ "Bathroom");
            String imageUrl = propertyData.get(i).getPhotos();

            Glide.with(context)
                    .load(imageUrl)
                    .into(viewHolder.imageView);

            viewHolder.propertyArea.setText(String.valueOf(propertyData.get(i).getPropertyArea())+" "+"sq.ft"+"\n"+"Built up Area");
            viewHolder.furnishingState.setText(propertyData.get(i).getFurnishingState().toLowerCase());
            String rupee=context.getResources().getString(R.string.rupee);
            viewHolder.deposit.setText("Deposit"+"\n"+rupee + propertyData.get(i).getDeposit());


        }

        @Override
        public int getItemCount() {
            return propertyData.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            private TextView propertyTitle,propertySecondaryTitle, deposit,furnishingState,bathroom,propertyArea;
            private ImageView imageView,favouriteIcon;
            public ViewHolder(View view) {
                super(view);
                propertyTitle = (TextView)view.findViewById(R.id.propertyTitleTextView);
                propertySecondaryTitle =(TextView)view.findViewById(R.id.propertySecondaryTitleTextView);
                bathroom =(TextView)view.findViewById(R.id.bathroomTextView);
                deposit = (TextView)view.findViewById(R.id.depositTextview);
                imageView = (ImageView)view.findViewById(R.id.propertyImageView);
                furnishingState = (TextView)view.findViewById(R.id.furnishitTextView);
                propertyArea = (TextView)view.findViewById(R.id.propertyAreaTextView);
                favouriteIcon = (ImageView)view.findViewById(R.id.favouriteIconImageView);
                favouriteIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        }

}
