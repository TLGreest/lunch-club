package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{Action, Controller}

@Singleton
class HomePageController @Inject() extends Controller {

  def landing(info: String = "Good morning Tom") = Action {
    Ok(views.html.landing(info))
  }



}
