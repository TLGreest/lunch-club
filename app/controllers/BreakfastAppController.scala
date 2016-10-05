package controllers

import com.google.inject.{Inject, Singleton}
import play.api.mvc.{Action, Controller}

/**
  * Created by tom on 21/09/16.
  */
@Singleton
class BreakfastAppController @Inject() extends Controller {

  def home = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def newPage = Action {
    Ok(views.html.newPage("This is a new page."))
  }

}