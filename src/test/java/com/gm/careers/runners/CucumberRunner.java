package com.gm.careers.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json"    //generate the nice json report
        },
        features = "src/test/resources/features",
        glue = "com/gm/careers/stepDefinitions",
        dryRun = false,
        tags = "@interview"
)
public class CucumberRunner {


}
