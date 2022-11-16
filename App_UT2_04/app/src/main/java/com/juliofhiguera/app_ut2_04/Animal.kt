package com.juliofhiguera.app_ut2_04

import java.io.Serializable

data class Animal(val nombre : String , val imagenId : Int ,val descripcion : String , var votos : Int = 0) : Serializable
