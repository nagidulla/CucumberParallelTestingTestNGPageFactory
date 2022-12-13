package runners;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;




@CucumberOptions(
		features="src/test/resources/features/search-many.feature",
		glue="steps"
	)
public class SearchManyFeature {
	
	
	@Test
	public void runCukes() {
	
		new TestNGCucumberRunner(getClass()).runCukes();
		
	}

}
