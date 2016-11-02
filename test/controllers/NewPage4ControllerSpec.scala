package controllers

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by tom on 02/11/16.
  */
class NewPage4ControllerSpec extends PlaySpec with OneAppPerSuite {

  "NewPageController4" should {
    "not return 404" when {
      "I go to the route /newPage4" in {
        val result = route(app, FakeRequest(GET, "/newPage4"))

        status(result.get) must not be (NOT_FOUND)
      }
    }

    "render the correct header" when {
      "I go to the route /newPage4" in {
        val result = controller.newPage4()(FakeRequest(GET,"/newPage4"))
        status(result) must be (OK)
        contentAsString(result) must include ("Header for the forth page")
      }
    }
    "render the word Word three times" in {
      val result = controller.newPage4("Word", 3)(FakeRequest(GET,"/newPage4"))
      status(result) must be (OK)
      contentAsString(result) must include ("Word Word Word")
    }
    "render the word Tom seven times" in {
      val result = controller.newPage4("Tom", 7)(FakeRequest(GET, "/newPage4"))
      status(result) must be (OK)
      contentAsString(result) must include ("Tom Tom Tom Tom Tom Tom Tom")
    }
    "render a special message if the number of words is greater than or equal to ten" in {
      val result = controller.newPage4("anyWord", 10)(FakeRequest(GET, "/newPage4"))
      status(result) must be (OK)
      contentAsString(result) must include ("A number greater than or equal to ten was entered.")
    }
  }

  object TestController extends NewPage4Controller
  val controller = TestController

}
