package com.volkanunlu.landmarkbookjava;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.volkanunlu.landmarkbookjava.databinding.RecyclerRowBinding;

import java.util.ArrayList;

//Adapter layout ile kodları birbirine bağlamak için kullanılıyor.

public class LandMarkAdapter  extends RecyclerView.Adapter<LandMarkAdapter.LandMarkHolder> {
    //bizden bir sınıf yazmamızı bekler (View Holder), ayrıca 3 metotda istiyor.(Oncreate,Onbindviewholder,getItemcount)

    public LandMarkAdapter(ArrayList<LandMark> landMarkArrayList) {  //Mainlist tarafında landmarklist sayısını almak adına tanımladık.
        this.landMarkArrayList = landMarkArrayList;
    }

    ArrayList<LandMark> landMarkArrayList;

    @NonNull
    @Override
    public LandMarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Viewholder tarafında bir obje oluşturulduğunda çalışacak sınıf.

        //xml ile kodu bağlama olayımız. Bunun için de Layout Inflater kullanıyoruz.
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new LandMarkHolder(recyclerRowBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull LandMarkHolder holder, int position) { //layout içerisinde hangi verileri göstermek istiyorsak burada göstereceğiz.
        //Yardımcı sınıf ile ilişkili

        holder.binding.recyclerViewTextView.setText(landMarkArrayList.get(holder.getAdapterPosition()).name); //bindingden çekileni,setText değerini pozisyonuna göre ismini verdik.

        holder.itemView.setOnClickListener(new View.OnClickListener() {  //Tıklandığında ne olacak, her bir iteme (listener veriyoruz bu yüzden)
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(holder.itemView.getContext(),DetailsActivity.class); //getcontext ile elemanı aldık, detail sınıfına gönderdik.
              //  intent.putExtra("landmark",landMarkArrayList.get(holder.getAdapterPosition()));

                Singleton singleton=Singleton.getInstance(); //statik metodu çağırdım,bakacak daha önce obje oluşturulduysa onu oluşturulmadıysa yenisini dönecek
                singleton.setSetLandMark(landMarkArrayList.get(holder.getAdapterPosition()));  //ilk defa oluşturuyoruz,landmarkını verdik.

                holder.itemView.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() { //oluşturulacak xml kaç kere oluşturulsun.
        return landMarkArrayList.size(); //landmark arraylist sizenı verdik.
    }

    public class LandMarkHolder extends  RecyclerView.ViewHolder{ //istenen constructor metotu uyarıdan dahil ettim
        //bu sınıf görünümlerimi tutatacak yardımcı sınıf

       private RecyclerRowBinding binding;

        public LandMarkHolder(RecyclerRowBinding binding) { //constructor metot istiyor bizden
            super(binding.getRoot()); //görünümü bu şekilde verebiliyoruz.

            this.binding=binding;
        }
    }
}
