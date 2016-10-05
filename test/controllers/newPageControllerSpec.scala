package controllers

import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.api.mvc.Result
import play.api.test.FakeRequest
import play.api.test.Helpers._

import scala.concurrent.Future

/**
  * Created by tom on 04/10/16.
  */
class newPageControllerSpec extends PlaySpec with OneAppPerSuite {

  "NewPageController" should {
    "not return 404" when {
      "we try to hit the route /newPage" in {
        route(app, FakeRequest(GET, "/newPage")).map(status(_)) must not be Some(NOT_FOUND)
      }
    }
  }

  "render a page" when {
    "we try to hit the route /newPage" in {
      val result: Option[Future[Result]] = route(app, FakeRequest(GET, "/newPage"))

      result.map(status(_)) mustBe Some(OK)

      val text: String = result.map(contentAsString(_)).get
      text must include ("This is a new page.")
    }
  }


}
