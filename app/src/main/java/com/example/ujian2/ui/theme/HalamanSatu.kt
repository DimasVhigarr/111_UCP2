@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

package com.example.ujian2.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ujian2.R

@Composable
fun HalamanSatu(
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    pilihanDosen: List<String>,
    onSelectionChanged: (String) -> Unit,
    modifier: Modifier = Modifier
){
    var namaTxt by remember {
        mutableStateOf("")
    }

    var nimTxt by remember {
        mutableStateOf("")
    }

    var konsentrasiTxt by remember {
        mutableStateOf("")
    }

    var judulTxt by remember {
        mutableStateOf("")
    }

    var listData: MutableList<String> = mutableListOf(namaTxt,nimTxt,konsentrasiTxt,judulTxt)
    var dosenYgDipilih by rememberSaveable{ mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Formulir Pengajuan Skripsi",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = namaTxt,
            onValueChange = {namaTxt = it},
            label = { Text(text = stringResource(id = R.string.nama)) },
            modifier = Modifier.fillMaxWidth(0.9f)
        )
        OutlinedTextField(
            value = nimTxt,
            onValueChange = {nimTxt = it},
            label = { Text(text = stringResource(id = R.string.nim)) },
            modifier = Modifier.fillMaxWidth(0.9f)
        )
        OutlinedTextField(
            value = konsentrasiTxt,
            onValueChange = {konsentrasiTxt = it},
            label = { Text(text = stringResource(id = R.string.konsentrasi)) },
            modifier = Modifier.fillMaxWidth(0.9f)
        )
        OutlinedTextField(
            value = judulTxt,
            onValueChange = {judulTxt = it},
            label = { Text(text = stringResource(id = R.string.judul)) },
            modifier = Modifier.fillMaxWidth(0.9f)
        )

        Spacer(modifier = Modifier.height(15.dp))


        Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))) {
            pilihanDosen.forEach { item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = dosenYgDipilih == item,
                        onClick = {
                            dosenYgDipilih = item
                            onSelectionChanged(item)
                        }
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = dosenYgDipilih == item,
                        onClick = {
                            dosenYgDipilih = item
                            onSelectionChanged(item)
                        }
                    )
                    Text(item)
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
                .weight(1f, false),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = { onSubmitButtonClicked(listData) }
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HalamanSatuPreview() {
    Ujian2Theme {
        HalamanSatu(onSubmitButtonClicked = {}, pilihanDosen = listOf("dosen1", "dosen2", "dosen3"), onSelectionChanged ={} )
    }
}
