package VO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lifemanager.R;

import java.util.List;

public class NotasAdapter extends ArrayAdapter<NotasOBJ> {
    private final Context context;
    private final List<NotasOBJ> notasList;

    public NotasAdapter(Context context, List<NotasOBJ> notas) {
        super(context, R.layout.notasitem, notas);
        this.context = context;
        this.notasList = notas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        NotasOBJ nota = notasList.get(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.notasitem, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.Tituloitemnote);
        TextView contentTextView = convertView.findViewById(R.id.conteudoitemnote);

        titleTextView.setText(nota.getTitle());
        contentTextView.setText(nota.getContent());

        return convertView;
    }
}
