package planit;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"planit.steps"},
        features = {"src/test/java/planit/features"},
        tags = "@TestTechnicalAssessment",
        plugin = {"pretty",
                "html:target/cucumber-html.html"}
)
public class Run {
}
