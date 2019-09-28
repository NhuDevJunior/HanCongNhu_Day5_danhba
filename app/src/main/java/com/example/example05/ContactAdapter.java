package com.example.example05;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.Viewhodoer> {
     List<Contact> contact;
    IonClickContact ionClickContact;
    public void setIonClickContact(IonClickContact ionClickContact) {
        this.ionClickContact = ionClickContact;
    }
    public  ContactAdapter(List<Contact> contact){
        this.contact=contact;

    }
    @NonNull
    @Override
    public Viewhodoer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_contact,parent,false);
        Viewhodoer viewhodoer=new Viewhodoer(view);
        return viewhodoer;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewhodoer holder, int position) {
          final Contact contacts=contact.get(position);
          holder.tvStyle.setText(contacts.getNumber());
          holder.tvName.setText(contacts.getName());
          holder.tvDate.setText(contacts.getDate());
          if(contacts.icon==true)
          {
              holder.imgView.setImageResource(R.drawable.callnhan_foreground);

          }
          else
          {
              holder.imgView.setImageResource(R.drawable.callgui_foreground);

          }

          holder.tvName.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
               ionClickContact.onClickName(contacts);
              }

          });
        holder.tvStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ionClickContact.onClickphone(contacts);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contact.size();
    }

    public class Viewhodoer extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvStyle;
        TextView tvDate;
        ImageView imgView;

        public Viewhodoer(@NonNull View itemView) {

            super(itemView);
            tvName = itemView.findViewById(R.id.tvname);
            tvStyle= itemView.findViewById(R.id.tvstyle);
            tvDate = itemView.findViewById(R.id.tvdate);
            imgView = itemView.findViewById(R.id.tvicon);
        }

    }
}
