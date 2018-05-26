package gt.edu.edutec.hostapp.home.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gt.edu.edutec.hostapp.R;
import gt.edu.edutec.hostapp.entities.Inmueble;
import gt.edu.edutec.hostapp.lib.base.ImageLoader;

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.ViewHolder>{

    private ImageLoader imageLoader;
    private List<Inmueble> inmuebles;
    private VenueClickListener listener;

    public VenueAdapter(ImageLoader imageLoader, List<Inmueble> inmuebles, VenueClickListener listener) {
        this.imageLoader = imageLoader;
        this.inmuebles = inmuebles;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.venue_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Inmueble inmueble = inmuebles.get(position);
        holder.nombre.setText(inmueble.getNombre());
        imageLoader.load(holder.imagen, inmueble.getImage());
        holder.onClick(listener, inmueble);
    }

    @Override
    public int getItemCount() {
        return inmuebles.size();
    }

    public void setInmuebles(List<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nombre)
        TextView nombre;
        @BindView(R.id.imagen)
        ImageView imagen;
        @BindView(R.id.venue)
        CardView click;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void onClick(final VenueClickListener clickListener, final Inmueble inmueble){
            click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.clicked(inmueble);
                }
            });
        }

    }
}
