package controllers

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by tom on 02/11/16.
  */
class NewPage3Spec extends PlaySpec with OneAppPerSuite {

  "NewPage3Controller" should {
    "not return 404" when {
      "I go to the route /newPage3" in {
        val result = route(app, FakeRequest(GET, "/newPage3"))

        status(result.get) must not be NOT_FOUND
      }
    }

    "render the correct page with the expected header" when {
      "I go to the newPage3" in {
        val result = controller.newPage3()(FakeRequest(GET, "/newPage3"))
        status(result) must be (OK)

        contentAsString(result) must include ("This is the header")

      }
    }

    "render the correct page with the expected text" when {
      "I go to the newPage3 with Shane" in {
        val result = controller.newPage3("Shane")(FakeRequest(GET, "/newPage3"))
        status(result) must be (OK)

        contentAsString(result) must include ("Shane")
      }

      "I go to the newPage3 with Tom" in {
        val result = controller.newPage3("Tom")(FakeRequest(GET, "/newPage3" ))
        status(result) must be (OK)

        contentAsString(result) must include ("Tom")
      }
    }


  }
  object TestController extends NewPage3Controller
  val controller = TestController
}
