package com.upsjb.sesion09.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.upsjb.sesion09.views.PrincipalUI
import com.upsjb.sesion09.views.RegistrosUI

@Composable
fun ManejadorNavegacion(){
    val navControlador= rememberNavController()

    NavHost(navController = navControlador, startDestination = ElementosNav.Principal.ruta){
        //Definiendo rutas de navegacion
        composable(route = ElementosNav.Principal.ruta) {
            PrincipalUI(navControlador)
        }
        composable(route = ElementosNav.Registro.ruta) {
            RegistrosUI(navControlador)
        }
    }
}