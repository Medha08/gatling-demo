
val gatlingVersion = "3.8.3"

lazy val root = (project in file("."))
  .enablePlugins(GatlingPlugin)
  .settings(
    name         := "gatling-kafka-plugin",
    scalaVersion := "2.13.10",
    libraryDependencies ++= Seq(
      "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion,
      "io.gatling"            % "gatling-test-framework"    % gatlingVersion,
      "ru.tinkoff" %% "gatling-kafka-plugin" % "0.9.0"
    ),
    //schemaRegistrySubjects ++= avroSchemas,
    //    schemaRegistryUrl := "http://test-schema-registry:8081",
    resolvers ++= Seq(
      "Confluent" at "https://packages.confluent.io/maven/",
    ))

// Enterprise Cloud (https://cloud.gatling.io/) configuration reference: https://gatling.io/docs/gatling/reference/current/extensions/sbt_plugin/#working-with-gatling-enterprise-cloud
// Enterprise Self-Hosted configuration reference: https://gatling.io/docs/gatling/reference/current/extensions/sbt_plugin/#working-with-gatling-enterprise-self-hosted

