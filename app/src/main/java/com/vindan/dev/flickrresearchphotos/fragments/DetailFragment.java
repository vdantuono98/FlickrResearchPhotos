package com.vindan.dev.flickrresearchphotos.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.vindan.dev.flickrresearchphotos.R;
import com.vindan.dev.flickrresearchphotos.api.RetrofitFlickr;
import com.vindan.dev.flickrresearchphotos.models.apiPhotosModel.Photo;
import com.vindan.dev.flickrresearchphotos.models.userInfoModel.DataUserInfo;

public class DetailFragment extends Fragment implements RetrofitFlickr.OnGetUserInfo {

    private View view;
    private Photo photo;
    private ImageView backArrow;
    private ImageView shareImageButton;
    private NavController navController;
    private TextView username, completeName, timeZone, textImage;
    private RelativeLayout shareProfileButton;
    private String URL;
    private ImageView imageView;

    private RetrofitFlickr retrofitFlickr;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);

        backArrow = view.findViewById(R.id.arrowBack);
        shareImageButton = view.findViewById(R.id.shareButton);

        username = view.findViewById(R.id.userName);
        completeName = view.findViewById(R.id.completeName);
        timeZone = view.findViewById(R.id.timeZone);
        textImage = view.findViewById(R.id.textImage);

        imageView = view.findViewById(R.id.image);

        shareProfileButton = view.findViewById(R.id.shareProfileButton);

        retrofitFlickr = new RetrofitFlickr();
        retrofitFlickr.setOnGetUserInfoListener(this);


        Bundle bundle = getArguments();
        if(bundle!=null) {
            photo = (Photo) bundle.getSerializable("photo");
            retrofitFlickr.getUserInfo(photo.getOwner(), "json");
        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        backArrow.setOnClickListener(view1 -> navController.popBackStack());

        if(photo != null) {
            URL = "https://live.staticflickr.com/" + photo.getServer() + "/" + photo.getId() + "_"
                    + photo.getSecret() + "_" + "w.jpg";

            textImage.setText(photo.getTitle());

            Glide.with(getContext())
                    .load(URL)
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.gray_placeholder)
                            .error(R.drawable.gray_placeholder)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .centerCrop()
                    ).into(imageView);
        }

        shareImageButton.setOnClickListener(view12 -> shareExternalLink(URL));

    }

    @Override
    public void onError(Throwable error) {
        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetUserInfo(DataUserInfo dataUserInfo) {

        if(dataUserInfo.getPerson().getUsername() != null) {
            username.setText(dataUserInfo.getPerson().getUsername().getContent());
        }else{
            username.setText("Non disponibile");
        }

        if(dataUserInfo.getPerson().getRealname() != null) {
            completeName.setText(dataUserInfo.getPerson().getRealname().getContent());
        }else{
            completeName.setText("Non disponibile");
        }

        if(dataUserInfo.getPerson().getTimezone() !=null) {
            String timezone = dataUserInfo.getPerson().getTimezone().getLabel();
            timeZone.setText(timezone);
        }else{
            timeZone.setText("Non disponibile");
        }

        shareProfileButton.setOnClickListener(view -> {
            if(dataUserInfo.getPerson().getProfileurl() != null) {
                shareExternalLink(dataUserInfo.getPerson().getProfileurl().getContent());
            }
        });
    }


    private void shareExternalLink(String textToShare){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, textToShare);
        startActivity(Intent.createChooser(intent, "Condividi link con"));

    }
}