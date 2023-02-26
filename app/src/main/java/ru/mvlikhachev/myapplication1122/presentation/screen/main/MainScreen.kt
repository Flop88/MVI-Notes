package ru.mvlikhachev.myapplication1122.presentation.screen.main

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ru.mvlikhachev.myapplication1122.domain.model.NoteModel
import ru.mvlikhachev.myapplication1122.presentation.items.NoteItem
import ru.mvlikhachev.myapplication1122.presentation.screen.error.ErrorItem
import ru.mvlikhachev.myapplication1122.presentation.screen.loading.LoadingItem

@Composable
fun MainScreen(
    navController: NavHostController
) {

    val viewModel = hiltViewModel<MainViewModel>()

    val state by viewModel.state.collectAsState()

    when {
        state.isLoading -> {
            LoadingItem()
        }
        state.data.isNotEmpty() -> {
            MainScreenContent(navController = navController, data = state.data)
        }
        state.error != null -> {
            ErrorItem(state.error) {
                viewModel.sendEvent(MainScreenEvent.LoadingData)
            }
        }
    }
}

@Composable
fun MainScreenContent(navController: NavHostController, data: List<NoteModel>) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item {
                Text(
                    text = "My Super Notes",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 16.dp, bottom = 48.dp)
                )
            }
            items(data) { item ->
                NoteItem(item, modifier = Modifier.padding(vertical = 8.dp, horizontal = 24.dp))
            }
        }
    }
}