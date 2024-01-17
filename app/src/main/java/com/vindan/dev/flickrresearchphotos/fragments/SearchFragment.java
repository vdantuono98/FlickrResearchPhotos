package com.vindan.dev.flickrresearchphotos.fragments;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.vindan.dev.flickrresearchphotos.R;
import com.vindan.dev.flickrresearchphotos.adapters.PhotoAdapter;
import com.vindan.dev.flickrresearchphotos.api.RetrofitFlickr;
import com.vindan.dev.flickrresearchphotos.models.apiPhotosModel.DataPhotosAPI;
import com.vindan.dev.flickrresearchphotos.models.apiPhotosModel.Photo;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment implements RetrofitFlickr.OnPhotosReceived, PhotoAdapter.OnItemPhotoClick {

    private View view;
    private ImageView doneButton, backButton, searchButton;
    private TextView tagTV;
    private EditText searchText;

    private NavController navController;

    private RelativeLayout layout_edit_text;

    private RetrofitFlickr retrofitFlickr;

    private RecyclerView photosRW;
    private TextView noImageAvailable;
    private LottieAnimationView loader;
    private NestedScrollView nestedScrollViewImages;
    private String textToSearch;

    private PhotoAdapter photoAdapter;
    private int page = 1;
    private int perPage = 30;
    private List<Photo> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);

        //dichiarazione pulsanti, ET, TV
        searchText = view.findViewById(R.id.search_edit_text);
        tagTV = view.findViewById(R.id.textToSearch);
        backButton = view.findViewById(R.id.arrowBack);
        doneButton = view.findViewById(R.id.doneButton);
        searchButton = view.findViewById(R.id.searchButton);
        noImageAvailable = view.findViewById(R.id.noImageAvailable);

        //dichiarazione layout
        layout_edit_text = view.findViewById(R.id.layout_edit_text);
        photosRW = view.findViewById(R.id.photosRW);
        loader = view.findViewById(R.id.loader);
        nestedScrollViewImages = view.findViewById(R.id.nestedScrollViewImages);

        retrofitFlickr = new RetrofitFlickr();
        retrofitFlickr.setOnPhotosReceivedListener(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        searchButton.setOnClickListener(view12 -> layout_edit_text.setVisibility(View.VISIBLE));

        backButton.setOnClickListener(view1 -> navController.popBackStack());

        doneButton.setOnClickListener(view13 -> {

            textToSearch = searchText.getText().toString();
                if(textToSearch.isEmpty()){
                    layout_edit_text.setVisibility(View.GONE);

                }else {
                    tagTV.setText(textToSearch);
                    retrofitFlickr.getPhotos(textToSearch, "json", perPage, page);
                    loader.setVisibility(View.VISIBLE);

                    hideKeyboard(view13);

                    searchText.setText("");
                    layout_edit_text.setVisibility(View.GONE);
                }

        });






    }

    @Override
    public void onError(Throwable error) {
        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPhotosReceived(DataPhotosAPI dataPhotosAPI) {

        if(getContext()!=null) {
            noImageAvailable.setVisibility(View.GONE);
            loader.setVisibility(View.GONE);
            photosRW.setHasFixedSize(true);
            photosRW.setLayoutManager(new LinearLayoutManager(getContext()));
            photoAdapter = new PhotoAdapter(dataPhotosAPI.getPhotos().getPhoto(), getContext());
            photoAdapter.setOnItemPhotoClick(this);
            photosRW.setAdapter(photoAdapter);

        }
    }

    @Override
    public void onItemPhotoClick(Photo photo) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("photo", photo);
        navController.navigate(R.id.action_searchFragment_to_detailFragment, bundle);
    }

    private void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}