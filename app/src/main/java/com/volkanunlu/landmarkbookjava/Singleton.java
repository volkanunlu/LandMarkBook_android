package com.volkanunlu.landmarkbookjava;

public class Singleton {

      private LandMark setLandMark;
      private static Singleton singleton; //statik bir obje oluşturduk

      private Singleton(){

      }

      public LandMark getSetLandMark(){ //get metodunu verdik
            return  setLandMark;

      }

      public void setSetLandMark(LandMark setLandMark){  //set metodunu verdik.
            this.setLandMark=setLandMark;


      }

      public static Singleton getInstance(){  //obje daha önce var mı yok mu ona göre instance oluşturuyoruz
            //bu sayede her zaman bana aynı objeyi döndürecek.

            if (singleton==null){
                  singleton=new Singleton();

            }
            return  singleton;
      }


}
