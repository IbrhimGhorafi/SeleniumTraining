package com.example.trainingselenium;


import com.example.trainingselenium.Utils.CustomListener;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/ProductComparison.feature",
        glue = {"com.example.trainingselenium.StepDefs"},
        plugin = {"pretty", "html:rapport/ReportHTML/reporte.html", "json:rapport/cucumber.json"}
)
@Listeners(CustomListener.class)
public class TestRunner {
}
