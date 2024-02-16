package com.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Basetest;
import com.pages.Page_welcome;

public class Tc_welcome {

	Basetest base = new Basetest();

	@BeforeTest

	public void url_launch() {
		try {

			base.setup();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void login() throws InterruptedException {
		Page_welcome lg = new Page_welcome(base.getdriver());
		lg.login();
		lg.departure_city();
		lg.destination_city();
		lg.choose_flight();
		lg.validate_purchase();
		lg.ID_display();
		base.teardown();
	}
}
