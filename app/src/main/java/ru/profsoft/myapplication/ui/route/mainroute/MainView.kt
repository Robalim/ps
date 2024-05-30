package ru.profsoft.myapplication.ui.route.mainroute

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import ru.profsoft.myapplication.domain.model.Location

@Composable
fun MainView(locations: List<Location>) {
    Column(modifier = Modifier, verticalArrangement = Arrangement.SpaceEvenly) {
        LazyColumn {
            items(locations, key = { it.id}) {
                Row {
                    Text(text = "This is the location with latitude =  ${it.latitude} and longitude = ${it.longitude}")
                }
            }
        }
        GoogleMap {
            for (location in locations) {
                Marker(
                    state = MarkerState(position = LatLng(location.latitude, location.longitude)),
                    title = "Point ${location.id}",
                    snippet = "Marker ${location.id}"
                )
            }
        }
    }

}