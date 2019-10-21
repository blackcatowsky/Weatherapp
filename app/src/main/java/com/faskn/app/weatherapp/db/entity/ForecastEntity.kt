package com.faskn.app.weatherapp.db.entity

import androidx.room.*
import com.faskn.app.weatherapp.domain.model.City
import com.faskn.app.weatherapp.domain.model.ForecastResponse
import com.faskn.app.weatherapp.domain.model.ListItem
import com.faskn.app.weatherapp.utils.typeconverters.DataConverter

/**
 * Created by Furkan on 2019-10-21
 */

@Entity(tableName = "Forecast")
@TypeConverters(DataConverter::class)
data class ForecastEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "city")
    var city: City?,

    @ColumnInfo(name = "cnt")
    var cnt: Int?,

    @ColumnInfo(name = "cod")
    var cod: String?,

    @ColumnInfo(name = "message")
    var message: Double?,

    @ColumnInfo(name = "list")
    var list: List<ListItem>?
) {
    @Ignore
    constructor(forecastResponse: ForecastResponse) : this(

        id = 0,
        city = forecastResponse.city,
        cnt = forecastResponse.cnt,
        cod = forecastResponse.cod,
        message = forecastResponse.message,
        list = forecastResponse.list
    )
}
