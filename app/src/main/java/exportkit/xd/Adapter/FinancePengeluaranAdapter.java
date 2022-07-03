package exportkit.xd.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import exportkit.xd.DataBaseHelperPengeluaran;
import exportkit.xd.FinanceActivity;
import exportkit.xd.Pemasukkan;
import exportkit.xd.Pengeluaran;
import exportkit.xd.R;

public class FinancePengeluaranAdapter extends RecyclerView.Adapter<FinancePengeluaranAdapter.MyViewHolder> {
    private List<Pengeluaran> mList = new ArrayList<>();
    private List<Pemasukkan> mListPemasukkan = new ArrayList<>();
    private FinanceActivity financeActivity;
    private DataBaseHelperPengeluaran myDB;

    public FinancePengeluaranAdapter(FinanceActivity financeActivity, DataBaseHelperPengeluaran myDB) {
        this.financeActivity = financeActivity;
        this.myDB = myDB;
    }

    public Context getContext(){
        return financeActivity;
    }

    public void setTask(List<Pengeluaran> pengeluaranList){
        this.mList = pengeluaranList;
        notifyDataSetChanged();
    }

    public void setTaskPemasukkan(List<Pemasukkan> pemasukkanList){
        this.mListPemasukkan = pemasukkanList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_finance_field, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pengeluaran item = mList.get(position);
        if (FinanceActivity.isFillPemasukkan == true){
            Pemasukkan itemPemasukkan = mListPemasukkan.get(position);
            holder.txtPemasukkanUang.setText(itemPemasukkan.getNominal());
            holder.txtPemasukkanTitle.setText(itemPemasukkan.getSumber());
        }
        holder.txtPengeluaran.setText(item.getKeterangan());
        holder.txtPengeluaranUang.setText(item.getNominal());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtPengeluaran, txtPengeluaranUang, txtPemasukkanTitle, txtPemasukkanUang;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPemasukkanUang = itemView.findViewById(R.id.txtPemasukkan);
            txtPemasukkanTitle = itemView.findViewById(R.id.txtPemasukkanTitle);
            txtPengeluaran = itemView.findViewById(R.id.txtPengeluaranFinance);
            txtPengeluaranUang = itemView.findViewById(R.id.txtPengluaranUang);
        }
    }

}
