package com.gmail1998milatisidik;

import android.os.Parcel;
import android.os.Parcelable;


public class item implements Parcelable{
    private String no, name, jurusan, universitas, daftar;

    public item(String no, String name, String jurusan, String universitas, String daftar ) {
        this.no = no;
        this.name = name;
        this.jurusan = jurusan;
        this.universitas = universitas;
        this.daftar = daftar;
    }


    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getUniversitas(){
        return universitas;
    }

    public String getDaftar() {
        return daftar;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJurusan(String jurusan) {
        jurusan = jurusan;
    }

    public void setUniversitas_date(String universitas) {
        this.universitas = universitas;
    }

    public void setDaftar(String daftar) { daftar = daftar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.no);
        parcel.writeString(this.name);
        parcel.writeString(this.jurusan);
        parcel.writeString(this.universitas);
        parcel.writeString(this.daftar);
    }

    public item(){
    }

    protected item(Parcel in ){
        this.no = in.readString();
        this.name = in.readString();
        this.jurusan = in.readString();
        this.universitas = in.readString();
        this.daftar = in.readString();
    }

    public static final Parcelable.Creator<item> CREATOR = new Parcelable.Creator<item>(){

        @Override
        public item createFromParcel(Parcel source) {
            return new item(source);
        }

        @Override
        public item[] newArray(int size) {
            return new item[size];
        }
    };
}