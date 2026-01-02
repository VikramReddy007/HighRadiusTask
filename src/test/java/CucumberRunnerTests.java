import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Scenarios",
        glue = "src.main.java.Steps"
)
public class CucumberRunnerTests {
}