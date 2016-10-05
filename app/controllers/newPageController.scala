package controllers

import com.google.inject.{Inject, Singleton}
import play.api.mvc.{Action, Controller}

/**
  * Created by tom on 04/10/16.
  */
class NewPageController @Inject() extends Controller {

  @Singleton
  class BreakfastAppController @Inject() extends Controller {

    def newPage = Action {
      Ok(views.html.newPage("This is a new page."))
    }

  }

}