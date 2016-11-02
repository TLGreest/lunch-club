package controllers

import javax.inject.Inject

import play.api.mvc.Controller
import play.api.mvc.Action

/**
  * Created by tom on 02/11/16.
  */
class NewPage4Controller @Inject() extends Controller {
  def newPage4(word: String = "Words", num: Int = 1) = Action {

    var finalString = ""
    if(num>=10) {
       finalString = "A number greater than or equal to ten was entered."
    } else {
    var i = 0
    while(i<num){
      finalString = finalString + word + " "
      i = i + 1
      }
    }

    Ok(views.html.newPage4(finalString))
  }

}
