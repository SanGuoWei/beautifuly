package com.jie.controllers;

import com.jfinal.config.Routes;

public class AppRouter extends Routes {

	@Override
	public void config() {
		add("/", MainController.class);
		add("/user", UserController.class);
	}

}
