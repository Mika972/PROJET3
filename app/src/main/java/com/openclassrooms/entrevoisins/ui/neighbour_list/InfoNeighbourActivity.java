package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

/** After the click, retrieve the data of the selected neighbor, declare the tags,
 *  then load this data into the tags 
 * */
public class InfoNeighbourActivity extends AppCompatActivity {

    /** Declaration of the variable to give the methods of NeighbourApiService */
    private NeighbourApiService mFavApiServiceInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_neighbour);

        /**  NeighbourApiService dependency injection  */
        mFavApiServiceInfo = DI.getNeighbourApiService();

        Intent intent = getIntent();
        /** retrieval of the information of the selected neighbour coming from the parent activity */
        Neighbour theNeighbour = (Neighbour) intent.getSerializableExtra(MyNeighbourRecyclerViewAdapter.EXTRA_NEIGHBOUR);

        ImageView theAvatarImage    = (ImageView) findViewById(R.id.avatarImageView);
        TextView textViewBigName    = (TextView) findViewById(R.id.bigName);
        TextView textViewSmallName  = (TextView) findViewById(R.id.smallName);
        TextView textViewAddress    = (TextView) findViewById(R.id.textViewAddress);
        TextView textPhoneNumber    = (TextView) findViewById(R.id.textViewPhone);
        TextView textAboutMeLife    = (TextView) findViewById(R.id.aboutMeTextView);
        TextView textFacebook       = (TextView) findViewById(R.id.textViewNetSocial);
        FloatingActionButton neighbourFavoriteBtn = (FloatingActionButton) findViewById(R.id.favorites);

        Glide.with(theAvatarImage).load(theNeighbour.getAvatarUrl()).into(theAvatarImage);
        textViewBigName.setText(theNeighbour.getName());
        textViewSmallName.setText(theNeighbour.getName());
        textViewAddress.setText(theNeighbour.getAddress());
        textPhoneNumber.setText(theNeighbour.getPhoneNumber());
        textFacebook.setText("www.facebook.fr/" + theNeighbour.getName());
        textAboutMeLife.setText(theNeighbour.getAboutMe());

        /** ! It only manages the addition of the neighbour in the favorites list !*/
        neighbourFavoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFavApiServiceInfo.createFavoriteNeighbour(theNeighbour);
            }
        });
    }
}