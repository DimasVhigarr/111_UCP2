package com.example.ujian2.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ujian2.R
import com.example.ujian2.data.ContactUiState
import com.example.ujian2.data.OrderUIState

@Composable
fun HalamanHasil(
    contactUiState: ContactUiState,
    onBackButtonclicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = stringResource(id = R.string.nama))
        Text(text = contactUiState.nama)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = stringResource(id = R.string.nim))
        Text(text = contactUiState.nim)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = stringResource(id = R.string.konsentrasi))
        Text(text = contactUiState.konsentrasi)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = stringResource(id = R.string.judul))
        Text(text = contactUiState.judul)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = stringResource(id = R.string.dospem1))
        Text(text = contactUiState.dospem1)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))

        Text(text = stringResource(id = R.string.dospem2))
        Text(text = contactUiState.dospem2)
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            modifier = Modifier,
            onClick = onBackButtonclicked,
        ) {
            Text(stringResource(R.string.back))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HalamanHasilPreview() {
    Ujian2Theme {
        HalamanHasil(
            contactUiState = ContactUiState(),
            onBackButtonclicked = { /*TODO*/ })
    }
}