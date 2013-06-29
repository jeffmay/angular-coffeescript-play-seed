package browser

import org.specs2.mutable._
import play.api.test.Helpers._
import play.api.test._


/**
 * All browser-based feature specifications should live in the browser package.
 *
 * This is just a basic test that the body of the index page loads.
 */
class IntegrationSpec extends Specification {
  
  "Home page" should {

    "contain" in {
      running(TestServer(3333), HTMLUNIT) { browser =>
        browser.goTo("http://localhost:3333/")

        browser.$("body")
      }

    }
  }

}