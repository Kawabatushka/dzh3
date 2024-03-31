package ru.stankin.labs.dzh2

import android.os.Parcel
import android.os.Parcelable

data class landmarkItem(
    val name: String,
    val city: String,
    val country: String,
    val estimatedAgeYears: Int,
    val heightMeters: Double
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(city)
        parcel.writeString(country)
        parcel.writeInt(estimatedAgeYears)
        parcel.writeDouble(heightMeters)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<landmarkItem> {
        override fun createFromParcel(parcel: Parcel): landmarkItem {
            return landmarkItem(parcel)
        }

        override fun newArray(size: Int): Array<landmarkItem?> {
            return arrayOfNulls(size)
        }
    }
}

/**
 * Function to generate a list of landmarks.
 */
fun generateLandmarks(): List<landmarkItem> = mutableListOf(
    landmarkItem("Great Wall of China", "Beijing", "China", 2200, 8.8),
    landmarkItem("Machu Picchu", "Cusco", "Peru", 600, 0.79),
    landmarkItem("Taj Mahal", "Agra", "India", 369, 73.0),
    landmarkItem("Colosseum", "Rome", "Italy", 1950, 48.5),
    landmarkItem("Petra", "Ma'an", "Jordan", 2300, 80.0),
    landmarkItem("Christ the Redeemer", "Rio de Janeiro", "Brazil", 92, 30.0),
    landmarkItem("Eiffel Tower", "Paris", "France", 134, 324.0),
    landmarkItem("Pyramids of Giza", "Giza", "Egypt", 4650, 139.0),
    landmarkItem("Angkor Wat", "Siem Reap", "Cambodia", 879, 65.0),
    landmarkItem("Statue of Liberty", "New York City", "United States", 137, 93.0),
    landmarkItem("Stonehenge", "Wiltshire", "United Kingdom", 5000, 5.0),
    landmarkItem("Alhambra", "Granada", "Spain", 800, 35.0),
    landmarkItem("Mesa Verde", "Montezuma County", "United States", 800, 2.0),
    landmarkItem("Burj Khalifa", "Dubai", "United Arab Emirates", 13, 828.0),
    landmarkItem("Mount Rushmore", "Keystone", "United States", 80, 18.0),
    landmarkItem("Acropolis of Athens", "Athens", "Greece", 2500, 156.0),
    landmarkItem("Sydney Opera House", "Sydney", "Australia", 50, 65.0),
    landmarkItem("Chichen Itza", "Yucatán", "Mexico", 1210, 24.0),
    landmarkItem("Neuschwanstein Castle", "Bavaria", "Germany", 157, 65.0),
    landmarkItem("Sphinx", "Giza", "Egypt", 4650, 20.0)
)
