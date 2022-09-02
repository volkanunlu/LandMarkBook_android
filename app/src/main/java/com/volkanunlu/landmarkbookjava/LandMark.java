package com.volkanunlu.landmarkbookjava;

import java.io.Serializable;

public class LandMark implements Serializable {

    String name;
    String country;
    int image;  //resimi int olarak tutma sebebimiz, resimlerin integer olarak atılması sebebiyle.

    public LandMark(String name, String country, int image){
        this.name=name;
        this.country=country;
        this.image=image;


    }


}
