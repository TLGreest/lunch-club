package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by tom on 02/11/16.
  */
class NewPage3Controller extends Controller{
    def newPage3(name: String = "Shane") = Action {
      Ok(views.html.newPage3(name))
    }
}
