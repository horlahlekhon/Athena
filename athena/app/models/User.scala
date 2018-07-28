package models

import javax.inject.{Inject, Singleton}


@Singleton
case class User(firstName:String,lastName:String,password:String,email:String)