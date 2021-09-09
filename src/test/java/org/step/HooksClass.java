package org.step;

import java.io.File;

import org.base.LibGlobal;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksClass extends LibGlobal {

	@Before
	public void beforeScenario() {
//		getDriver();
//		launchUrl("https://www.facebook.com/");

	}

	@After
	public void afterScenario(Scenario s) {
//		if (s.isFailed()) {
//			TakesScreenshot ts = (TakesScreenshot) driver;
//			byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
//			s.embed(screenshotAs, s.getName() + ".png");
//		}
//		driver.close();
	}

}
