package br.leandro.com.zupmovies;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import br.leandro.com.zupmovies.Services.searchService;
import br.leandro.com.zupmovies.Services.R;

public class DetailActivity extends AppCompatActivity {

    public static final String MOVIE_DETAIL = "movie_detail";
    public static final String IMAGE_URL = "image_url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getActionBar();

        final searchService.Detail detail = getIntent().getParcelableExtra(MOVIE_DETAIL);
        final String imageUrl =  getIntent().getStringExtra(IMAGE_URL);
        Glide.with(this).load(imageUrl).into( (ImageView) findViewById(R.id.main_backdrop));

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.main_collapsing);
        collapsingToolbarLayout.setTitle(detail.Title);

        ((TextView) findViewById(R.id.grid_title)).setText(detail.Title);
        ((TextView) findViewById(R.id.grid_writers)).setText(detail.Writer);
        ((TextView) findViewById(R.id.grid_actors)).setText(detail.Actors);
        ((TextView) findViewById(R.id.grid_director)).setText(detail.Director);
        ((TextView) findViewById(R.id.grid_genre)).setText(detail.Genre);
        ((TextView) findViewById(R.id.grid_released)).setText(detail.Released);
        ((TextView) findViewById(R.id.grid_plot)).setText(detail.Plot);
        ((TextView) findViewById(R.id.grid_runtime)).setText(detail.Runtime);



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
