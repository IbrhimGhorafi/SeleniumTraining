package com.example.trainingselenium;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.example.trainingselenium.StepDefs"},
        plugin = {"pretty", "html:target/ReportHTML/reporte.html", "json:target/cucumber.json"}
)
public class TestRunner {
}
