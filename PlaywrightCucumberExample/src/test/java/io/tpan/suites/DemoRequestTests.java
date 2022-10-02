package io.tpan.suites;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@SuiteDisplayName("Test Use Cases")
@IncludeEngines("cucumber")
@SelectClasspathResource("Features")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")
public class DemoRequestTests {
}
