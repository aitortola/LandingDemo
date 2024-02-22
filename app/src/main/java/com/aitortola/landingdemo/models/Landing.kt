package com.aitortola.landingdemo.models

import android.os.Parcel
import android.os.Parcelable

data class Landing(
    val Id: Int,
    val Orden: Int,
    val Titulo: String,
    val TituloLogin: String,
    val Link: String,
    val LinkLogin: String,
    val Imagen: String,
    val ColorTitulo: String,
    val ColorFondo: String,
    val TamanoFuente: Int,
    val TamanoFuenteTablet: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) = with(parcel) {
        writeInt(Id)
        writeInt(Orden)
        writeString(Titulo)
        writeString(TituloLogin)
        writeString(Link)
        writeString(LinkLogin)
        writeString(Imagen)
        writeString(ColorTitulo)
        writeString(ColorFondo)
        writeInt(TamanoFuente)
        writeInt(TamanoFuenteTablet)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Landing> {
        override fun createFromParcel(parcel: Parcel): Landing {
            return Landing(parcel)
        }

        override fun newArray(size: Int): Array<Landing?> {
            return arrayOfNulls(size)
        }
    }
}
