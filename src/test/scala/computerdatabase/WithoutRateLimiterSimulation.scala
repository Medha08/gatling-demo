package computerdatabase

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration.DurationInt

class WithoutRateLimiterSimulation extends Simulation {

  private val baseUrl = "http://localhost:8080"
  private val contentType = "application/json"
  private val endpoint = "/test"

  val httpProtocol: HttpProtocolBuilder = http.baseUrl(baseUrl)
    .acceptHeader("*/*")
    .contentTypeHeader(contentType)


  val scn: ScenarioBuilder = scenario("RecordedSimulationWithoutRateLimiter-1")
    .exec(http("client-1-request")
      .get(endpoint)
      .header("x-client-id","client-1")
      .check(status.is(200)))

  val scn2: ScenarioBuilder = scenario("RecordedSimulationWithoutRateLimiter-2")
    .exec(http("client-2-request")
      .get(endpoint)
      .header("x-client-id","client-2")
      .check(status.is(200)))

  val scn3: ScenarioBuilder = scenario("RecordedSimulationWithoutRateLimiter-3")
    .exec(http("client-3-request")
      .get(endpoint)
      .header("x-client-id","client-3")
      .check(status.is(200)))

  setUp(scn.inject(constantUsersPerSec(5) during (20 seconds)),
    scn2.inject(constantUsersPerSec(5) during (20 seconds)),
    scn3.inject(constantUsersPerSec(20) during (20 seconds)))
    .protocols(httpProtocol)


}
