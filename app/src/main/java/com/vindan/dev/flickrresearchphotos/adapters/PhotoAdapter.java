package com.vindan.dev.flickrresearchphotos.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.vindan.dev.flickrresearchphotos.R;
import com.vindan.dev.flickrresearchphotos.models.apiPhotosModel.Photo;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder>{

    private List<Photo> list;
    private Context context;
    private OnItemPhotoClick onItemPhotoClickListener;

    public PhotoAdapter(List<Photo> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_photo_adapter, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int actualPos = position;
        Photo currentItem = list.get(actualPos);

        holder.title.setText(currentItem.getTitle());

        String url = "https://live.staticflickr.com/"+ currentItem.getServer() +"/"+currentItem.getId()+"_"
                +currentItem.getSecret()+"_"+"w.jpg";

        Glide.with(context)
                .load(url)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.gray_placeholder)
                        .error(R.drawable.gray_placeholder)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .centerCrop()
                )
                .into(holder.imageView);

        holder.container.setOnClickListener(view -> onItemPhotoClickListener.onItemPhotoClick(currentItem));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private ImageView imageView;

        private CardView container;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.titleImage);
            container = itemView.findViewById(R.id.container);

        }
    }

    public interface OnItemPhotoClick{
        void onItemPhotoClick(Photo photo);
    }

    public void setOnItemPhotoClick(OnItemPhotoClick onItemPhotoClickListener){
         this.onItemPhotoClickListener = onItemPhotoClickListener;
    }
}
