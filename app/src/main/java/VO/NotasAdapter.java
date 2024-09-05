package VO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lifemanager.R;

import java.util.ArrayList;
import java.util.List;

public class NotasAdapter extends BaseAdapter {

    ArrayList<NotasOBJ> Notas;
    Context contexto;

    public NotasAdapter(Context contexto, ArrayList<NotasOBJ> notas){
        this.Notas = notas;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return Notas.size();
    }

    @Override
    public Object getItem(int position) {
        return Notas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NotasOBJ notas = Notas.get(position);

        View vn = LayoutInflater.from(contexto).inflate(R.layout.activity_bloco_de_nota_view,parent,false);
        TextView blocotitulo = vn.findViewById(R.id.bloco_titulo);
        TextView blococonteudo = vn.findViewById(R.id.bloco_conteudo);

        blocotitulo.setText(notas.getTitulo());
        blococonteudo.setText(notas.getConteudo());
        return vn;
    }
}
