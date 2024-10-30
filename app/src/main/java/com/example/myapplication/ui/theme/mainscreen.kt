package com.example.myapplication.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable

fun MainScren(
    mofifier: Modifier = Modifier
){

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHP by remember { mutableStateOf("") }
    var selectgender by remember { mutableStateOf("") }

    val jenisKelamin = listOf("laki-laki", "perempuan")
    var confirmnamaUser by remember { mutableStateOf("") }
    var confirmemailUser by remember { mutableStateOf("") }
    var confirmnoHpuser by remember { mutableStateOf("") }
    var confirmselectGenderuser by remember { mutableStateOf("") }


    Column(Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        OutlinedTextField(value = nama, onValueChange = {nama = it},
            placeholder = { Text("Masukan nama")
            }, label = { Text("nama")},
            modifier =  Modifier.fillMaxWidth().padding(5.dp)
            )

        Row () {
            jenisKelamin.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {  RadioButton(
                    selected = selectgender == item,
                    onClick = {
                        selectgender = item
                    })
                    Text(item)
                }
            }
        }
        OutlinedTextField(value = email, onValueChange = {email = it},
            placeholder = { Text("Masukan email")
            }, label = { Text("email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier =  Modifier.fillMaxWidth().padding(5.dp)
        )
        OutlinedTextField(value = noHP, onValueChange = {noHP = it},
            placeholder = { Text("Masukan nohp")
            }, label = { Text("nohp")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier =  Modifier.fillMaxWidth().padding(5.dp)
        )
        OutlinedTextField(value = alamat, onValueChange = {alamat = it},
            placeholder = { Text("Masukan alamat")
            }, label = { Text("alamat")},
            modifier =  Modifier.fillMaxWidth().padding(5.dp)



        )
        Button(onClick = {
            confirmnamaUser = nama
            confirmnoHpuser = noHP
            confirmemailUser = email
            selectgender = selectgender

        }) { Text("simpan")


        }
        Card(Modifier.size(height = 180.dp, width = 200.dp)) {
            Cardsection(params =  "nama", isiParam = confirmnamaUser)
            Cardsection(params = "jeniskelamin", isiParam = confirmselectGenderuser)
            Cardsection(params = "email", isiParam = confirmemailUser)
            Cardsection(params = "hp", isiParam = confirmnoHpuser)
        }
    }
}

@Composable
fun Cardsection(params:String, isiParam:String){
    Column (horizontalAlignment = Alignment.Start){
        Row (modifier = Modifier.fillMaxWidth().padding(2.dp),
            horizontalArrangement = Arrangement.SpaceBetween
            ){
            Text(text = params, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(
                text = "$isiParam",
                modifier = Modifier.weight(2f)
            )

        }
    }
}