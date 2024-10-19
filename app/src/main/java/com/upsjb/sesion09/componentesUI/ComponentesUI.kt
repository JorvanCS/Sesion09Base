package com.upsjb.sesion09.componentesUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.upsjb.sesion09.modelo.Personas

@Composable
fun CajaTextoGenerica(texto:String,label:String,
                      onvalue:(String)->Unit){
    OutlinedTextField(value = texto, label = { Text(text = label)},
        onValueChange =onvalue )
}
@Composable
fun BotonGenerico(texto:String, icono: ImageVector, onclick:()->Unit){
    Button(onClick = onclick) {
        Icon(imageVector = icono, contentDescription = null)
        Text(text = texto)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarra(titulo:String,colorBarra: Color){
    TopAppBar(title = { Text(text = titulo) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorBarra
        )
    )
}
//Boton flotante de accion
@Composable
fun BotonFlotante(onclick:()->Unit){
    FloatingActionButton(onClick = onclick) {
        Icon(imageVector = Icons.Default.Add, contentDescription = null)
    }
}
//IconButton
@Composable
fun IconButtonGenerico(onclick:()->Unit,icono:ImageVector){
    IconButton(onClick = { onclick()}) {
        Icon(imageVector = icono, contentDescription = icono.name)
    }
}

@Composable
fun ItemPersona(persona: Personas,
                   onEdit:()->Unit,onDelete:()->Unit){
    Card(modifier = Modifier.fillMaxWidth().padding(5.dp)) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Column(modifier = Modifier.fillMaxSize().weight(2.5f)) {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = "Nombres: ${persona.nombres}")
                    Text(text = "Apellidos: ${persona.apellidos}")
                }
                Row (modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly){
                    Text(text = "DNI: ${persona.dni}")
                    Text(text = "FecNacimiento: ${persona.fecNacimiento}")
                }
            }
            Row(modifier = Modifier
                .weight(1f)
                .padding(3.dp),
                horizontalArrangement = Arrangement.End) {
                IconButtonGenerico(onclick = { onEdit() },
                    icono = Icons.Default.Edit)
                IconButtonGenerico(onclick = { onDelete()},
                    icono = Icons.Default.Delete)
            }
        }
    }
    HorizontalDivider(modifier = Modifier.padding(2.dp))
}
//Dialogo personalizado
@Composable
fun DialogoPersonalizado(visible:Boolean,cancelaAccion:()->Unit,
                         aceptaAccion:()->Unit){
    if (visible){
        AlertDialog(
            title = { Text(text = "Confirmación")},
            text = { Text(text = "¿Desea eliminar?")},
            onDismissRequest = { cancelaAccion },
            confirmButton = {
                TextButton(onClick = { aceptaAccion()}) {
                    Text(text = "Aceptar")
                }
            },
            dismissButton = {
                TextButton(onClick = { cancelaAccion()}) {
                    Text(text = "Cancelar", color = Color.Red)
                }
            }
        )
    }
}

@Composable
fun DialogoEliminar(cancelaAccion:()->Unit,
                    aceptaAccion:()->Unit){
    AlertDialog(
        title = { Text(text = "Confirmación")},
        text = { Text(text = "¿Desea eliminar la persona?")},
        onDismissRequest = { cancelaAccion },
        confirmButton = {
            TextButton(onClick = { aceptaAccion()}) {
                Text(text = "Aceptar")
            }
        },
        dismissButton = {
            TextButton(onClick = { cancelaAccion()}) {
                Text(text = "Cancelar", color = Color.Red)
            }
        }
    )
}


