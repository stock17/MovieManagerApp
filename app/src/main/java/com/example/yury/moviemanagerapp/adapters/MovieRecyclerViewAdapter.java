package com.example.yury.moviemanagerapp.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yury.moviemanagerapp.R;
import com.example.yury.moviemanagerapp.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {

    List<Movie> movies;
    Context context;
    @BindView(R.id.tvOverview)
    TextView tvOverview;

    public MovieRecyclerViewAdapter(Context context, List<Movie> movies) {
        this.movies = movies;
        this.context = context;
    }

    private Context getContext() {
        return context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.tvTitle.setText(movie.getTitle());
        holder.tvOverview.setText(movie.getOverview());

        Picasso.with(getContext())
                .load(movie.getPosterPath())
                .into(holder.ivMovieImage);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivMovieImage)
        ImageView ivMovieImage;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvOverview)
        TextView tvOverview;
        @BindView(R.id.cvMovie)
        CardView cvMovie;


        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
