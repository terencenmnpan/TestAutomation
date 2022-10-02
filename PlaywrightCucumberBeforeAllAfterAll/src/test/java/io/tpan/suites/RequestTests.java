package io.tpan.suites;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.SuiteDisplayName;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@SuiteDisplayName("Test Use Cases")
@IncludeEngines("cucumber")
@SelectClasspathResource("Features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")
public class RequestTests {
}
