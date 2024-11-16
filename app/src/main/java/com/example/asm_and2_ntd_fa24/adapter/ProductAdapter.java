package com.example.asm_and2_ntd_fa24.adapter;

<<<<<<< HEAD
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
=======
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
>>>>>>> 4fc3654 (Initial commit)

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

<<<<<<< HEAD
import com.example.asm_and2_ntd_fa24.R;
import com.example.asm_and2_ntd_fa24.model.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    ArrayList<Product> list;

    public ProductAdapter(ArrayList<Product> list) {
        this.list = list;
=======
import com.example.asm_and2_ntd_fa24.DAO.SanPhamDAO;
import com.example.asm_and2_ntd_fa24.R;
import com.example.asm_and2_ntd_fa24.models.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Product> list;
    private SanPhamDAO sanPhamDAO;

    public ProductAdapter(Context context, ArrayList<Product> list, SanPhamDAO sanPhamDAO) {
        this.context = context;
        this.list = list;
        this.sanPhamDAO = sanPhamDAO;
>>>>>>> 4fc3654 (Initial commit)
    }

    @NonNull
    @Override
<<<<<<< HEAD
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        Product product = list.get(position);
        holder.tvName.setText(product.getTenSP());
        holder.tvPrice.setText(product.getGiaSP() + " VNĐ");
    }

=======
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_product, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNamePR.setText(list.get(position).getTensp());
        holder.tvPrice.setText(list.get(position).getGiaban() + " VND");
        holder.tvQuantity.setText("SL: " + list.get(position).getSoluong());


        //update
        holder.tvUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogUpdate(list.get(holder.getAdapterPosition()));
            }
        });

        //delete
        holder.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogDelete(list.get(holder.getAdapterPosition()).getTensp(),
                        list.get(holder.getAdapterPosition()).getMasp());
            }
        });



    }



>>>>>>> 4fc3654 (Initial commit)
    @Override
    public int getItemCount() {
        return list.size();
    }

<<<<<<< HEAD
    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
=======
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamePR, tvPrice, tvQuantity, tvUpdate, tvDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNamePR = itemView.findViewById(R.id.tvNamePR);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            tvUpdate = itemView.findViewById(R.id.tvUpdate);
            tvDelete = itemView.findViewById(R.id.tvDelete);


        }
    }

    private void showDialogUpdate(Product product){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_update, null);
        builder.setView(view);

        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show();

        EditText edtTenSP = view.findViewById(R.id.edtTenSP);
        EditText edtGiaSP = view.findViewById(R.id.edtGiaSP);
        EditText edtSoLuong = view.findViewById(R.id.edtSoLuong);
        Button btnSuaSP = view.findViewById(R.id.btnSuaSP);
        Button btnHuy = view.findViewById(R.id.btnHuy);

        //dua du lieu vao edt o dialog
        edtTenSP.setText(product.getTensp());
        edtGiaSP.setText(String.valueOf(product.getGiaban()));
        edtSoLuong.setText(String.valueOf(product.getSoluong()));

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnSuaSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int masp = product.getMasp();
                String tensp = edtTenSP.getText().toString();
                String giaban = edtGiaSP.getText().toString();
                String  soluong = edtSoLuong.getText().toString();

                if(tensp.length() == 0 || giaban.length() == 0 || soluong.length() == 0){
                    Toast.makeText(context, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
                    Product productcs = new Product(masp, tensp, Integer.parseInt(giaban), Integer.parseInt(soluong));
                    boolean check = sanPhamDAO.chinhSuaSP(productcs);
                    if (check){
                        Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
                        loadData();
                        dialog.dismiss();
                    }
                    else {
                        Toast.makeText(context, "Sửa thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    private  void showDialogDelete(String tensp, int masp){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Thong bao");
        builder.setMessage("Ban co chac chan muon xoa san pham");
        builder.setPositiveButton("Xoa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                boolean check = sanPhamDAO.xoaSP(masp);
                if(check){
                    Toast.makeText(context, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                    loadData();
                }
                else {
                    Toast.makeText(context, "Xoa that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Huy", null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void loadData(){
        list.clear();
        list = sanPhamDAO.getDS();
        notifyDataSetChanged();
    }
>>>>>>> 4fc3654 (Initial commit)
}
