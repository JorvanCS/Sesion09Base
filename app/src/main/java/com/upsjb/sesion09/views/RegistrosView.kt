package com.upsjb.sesion09.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.upsjb.sesion09.componentesUI.BotonGenerico
import com.upsjb.sesion09.componentesUI.CajaTextoGenerica
import com.upsjb.sesion09.componentesUI.TopBarra

@Composable
fun RegistrosUI(navcontrolador: NavController){
    //Variables de estado
    var nombres by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }
    var expandir by remember { mutableStateOf(false) }
    //obtener el contexto
    val contexto= LocalContext.current

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { TopBarra(titulo = "APP RT Firebase", colorBarra = Color(0xFFc1f1e0)) }
    ) {paddingX->
        Column(modifier = Modifier
            .padding(paddingX)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Box (modifier = Modifier.fillMaxWidth().padding(10.dp).background(Color(0xFFaac7ff)), contentAlignment = Alignment.Center){
                Text(text = "Registrar Persona ", fontSize = 20.sp)
            }
            CajaTextoGenerica(texto = nombres, label = "Nombres") {
                nombres=it
            }
            CajaTextoGenerica(texto = apellidos, label = "Apellidos") {
                apellidos=it
            }
            CajaTextoGenerica(texto = dni, label = "DNI") {
                dni=it
            }
            Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                BotonGenerico(texto = "Aceptar", icono = Icons.Default.Done) {

                }
                BotonGenerico(texto = "Cancelar", icono = Icons.Default.Clear) {
                    //regresar a la vista principal
                    navcontrolador.popBackStack()
                }
            }
        }
    }
}