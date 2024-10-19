package com.upsjb.sesion09.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.upsjb.sesion09.componentesUI.BotonFlotante
import com.upsjb.sesion09.componentesUI.BotonGenerico
import com.upsjb.sesion09.componentesUI.DialogoEliminar
import com.upsjb.sesion09.componentesUI.ItemPersona
import com.upsjb.sesion09.componentesUI.TopBarra
import com.upsjb.sesion09.modelo.Personas
import com.upsjb.sesion09.navegacion.ElementosNav

val listaPersonas= mutableStateListOf<Personas>()
@Composable
fun PrincipalUI(navcontrolador: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { TopBarra(titulo = "APP RT Firebase", Color(0xFFc1f1e0)) },
        floatingActionButton = {
            BotonFlotante {
                //navegar a Registros
                navcontrolador.navigate(ElementosNav.Registro.ruta)
            }
        }
    ) { innerPadding ->

        var abrirDialogoEliminar by remember { mutableStateOf(false) }
        //
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Listado de Personas")
            BotonGenerico(texto = "Cargar Datos", icono = Icons.Default.Search) {
                //verDatos(dao)

            }
            if (abrirDialogoEliminar) {
                DialogoEliminar(cancelaAccion = { abrirDialogoEliminar = false }) {
                    //si confirma el usuario

                    abrirDialogoEliminar = false
                    //verDatos(dao)

                }
            }
            LazyColumn {
                items(listaPersonas) {
                    ItemPersona(persona = it, onEdit = {
                            //editar

                        }, onDelete = {
                            abrirDialogoEliminar = true
                        }
                    )
                }
            }

        }
    }
}