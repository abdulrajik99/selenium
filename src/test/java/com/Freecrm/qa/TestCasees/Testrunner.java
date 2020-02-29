package com.Freecrm.qa.TestCasees;

import org.testng.TestNG;

import com.relevantcodes.extentreports.ExtentReports;

import Com.qa.ExtentReportListner.ExtentRepoterNg;

public class Testrunner {
	static TestNG testng;
	@SuppressWarnings("deprecation")
	public static void main(String args[])
	{
		ExtentRepoterNg ext=new ExtentRepoterNg();
		testng=new TestNG();
		testng.setTestClasses(new Class[]{LoginPageTest.class});
		testng.addListener(ext);
		testng.run();
	}
}
