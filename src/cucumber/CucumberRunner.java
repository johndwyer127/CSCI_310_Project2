package cucumber;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
		,glue={"stepDefinition"}
		)

public class CucumberRunner {

}

//	 This code will copy part of one picture to another picture
//	public static Picture makeCollage (Picture pict, Picture pict2, Picture pict3)
//	{
