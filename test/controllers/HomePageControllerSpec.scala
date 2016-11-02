package controllers

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by tom on 19/10/16.
  */
class HomePageControllerSpec extends PlaySpec with OneAppPerSuite {

  "HomePageController" should {
    "not return 404" when {
      "I go to the route /landing" in {
        val result = route(app, FakeRequest(GET, "/landing"))

        status(result.get) must not be (NOT_FOUND)
      }
    }
    "render the correct page with the expected text" when {
      "I go the homepage" in {
        val result = controller.landing()(FakeRequest(GET, "/landing"))
        status(result) must be (OK)

        contentAsString(result) must include ("Good morning Tom")
      }
    }
      "I go the homepage after noon" in {
        val result = controller.landing("Good afternoon Tom")(FakeRequest(GET, "/landing"))
        status(result) must be (OK)

        contentAsString(result) must include ("Good afternoon Tom")
      }
  }

  object TestController extends HomePageController
  val controller = TestController

}