package com.upsjb.sesion09.navegacion

sealed class ElementosNav(val ruta:String) {
    object Principal: ElementosNav(RutasNav.Principal.name)
    object Registro: ElementosNav(RutasNav.Registro.name)
}