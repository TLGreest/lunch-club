package controllers

import javax.inject.Inject

import play.api.mvc.{Action, Controller}

/**
  * Created by tom on 02/11/16.
  */
class NewPage2Controller @Inject extends Controller {

  def newPage2(name: String = "Tom") = Action {
    Ok(views.html.newPage2(name))
  }

}
