package controllers

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by tom on 02/11/16.
  */
class NewPage2ControllerSpec extends PlaySpec with OneAppPerSuite {

  "NewPage2Controller" should {
    "not return 404" when {
      "I go to the route /newPageTwo" in {
        val result = route(app, FakeRequest(GET, "/newPage2"))

        status(result.get) must not be (NOT_FOUND)
      }
    }

    "render the correct page with the expected header" when {
      "I go to the new page" in {
        val result = controller.newPage2("")(FakeRequest(GET, "/newPage2"))
        status(result) must be(OK)

        contentAsString(result) must include("This is a new page")
      }
    }
    "render the correct paragraph" when {
      "I go to the new page and my name is Tom" in {
        val result = controller.newPage2("Tom")(FakeRequest(GET, "newPage2"))
        status(result) must be(OK)
        contentAsString(result) must include("Welcome back Tom")
      }
      "render the correct paragraph" when {
        "I go to the new page and my name is Shane" in {
          val result = controller.newPage2("Shane")(FakeRequest(GET, "newPage2"))
          status(result) must be(OK)
          contentAsString(result) must include("Welcome back Shane")
        }
      }

    }
  }
  object TestController extends NewPage2Controller
  val controller = TestController

}
