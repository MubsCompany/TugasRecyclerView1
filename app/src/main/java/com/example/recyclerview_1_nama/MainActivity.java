package com.example.recyclerview_1_nama;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvlistvetical;
    RecyclerView rvlisthorizontal;

    String[] namaBuah = {"Apple", "Blueberies", "Cherries", "Lemon", "Orange", "Pomegranate", "Raspberry", "Strawberry"};
    String[] jenisBuah = {"Berries","Tuber","Onion","Spread","Green Fruit",};

    int[] imageBuah = {R.drawable.apple, R.drawable.blueberries, R.drawable.cherries, R.drawable.lemon, R.drawable.orange, R.drawable.pomegranate, R.drawable.raspberry, R.drawable.strawberry};
    int[] imageJenis = {R.drawable.berries,R.drawable.tuber,R.drawable.onion,R.drawable.watermelon,R.drawable.grapes};

    BuahAdapter adapter;
    JenisAdapter adapterDua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        adapterDua = new JenisAdapter();
        adapter = new BuahAdapter();

        rvlistvetical = findViewById( R.id.list );
        rvlisthorizontal = findViewById( R.id.listdua );

        rvlistvetical.setLayoutManager( new LinearLayoutManager( this, LinearLayoutManager.VERTICAL, false ) );
        rvlisthorizontal.setLayoutManager( new LinearLayoutManager( this,LinearLayoutManager.HORIZONTAL,true ) );

        rvlistvetical.setAdapter(adapter);
        rvlisthorizontal.setAdapter( adapterDua );


    }


    private class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.MyViewHolder> {


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.list_vertical, viewGroup, false );

            return new MyViewHolder( v );
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {

            myViewHolder.txtNamaBuah.setText( namaBuah[position] );
            myViewHolder.imgBuah.setImageResource( imageBuah[position] );
            myViewHolder.itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText( MainActivity.this, "Don't choose " + namaBuah[position], Toast.LENGTH_SHORT ).show();
                }
            } );
        }

        @Override
        public int getItemCount() {
            return namaBuah.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView imgBuah;
            TextView txtNamaBuah;


            public MyViewHolder(@NonNull View itemView) {
                super( itemView );

                imgBuah = itemView.findViewById( R.id.img );
                txtNamaBuah = itemView.findViewById( R.id.txt );
            }
        }
    }



    //Jenis Buah
    private class JenisAdapter extends RecyclerView.Adapter<JenisAdapter.MyViewHolderDua>{


        @NonNull
        @Override
        public MyViewHolderDua onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View a = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.list_horizontal,viewGroup,false );

            return new MyViewHolderDua( a );
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolderDua myViewHolderDua, final int i) {

myViewHolderDua.txtJenis.setText( jenisBuah[i] );
myViewHolderDua.imgJenis.setImageResource( imageJenis[i] );

myViewHolderDua.itemView.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText( MainActivity.this, "Do you like " + jenisBuah[i], Toast.LENGTH_SHORT ).show();
    }
} );
        }

        @Override
        public int getItemCount() {
            return jenisBuah.length;
        }

        public class MyViewHolderDua extends RecyclerView.ViewHolder {

            ImageView imgJenis;
            TextView txtJenis;

            public MyViewHolderDua(@NonNull View itemView) {
                super( itemView );

                imgJenis = itemView.findViewById( R.id.imgdua );
                txtJenis = itemView.findViewById( R.id.txtdua );
            }
        }
    }
}
