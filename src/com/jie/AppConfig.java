package com.jie;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.jie.controllers.AppRouter;

public class AppConfig extends JFinalConfig {

	/**
	 * 配置常量
	 */
	@Override
	public void configConstant(Constants me) {
		me.setDevMode(Parameters.DEVMODE);
		me.setViewType(ViewType.JSP);
	}

	/**
	 * 配置路由
	 */
	@Override
	public void configRoute(Routes me) {
		me.add(new AppRouter());// 添加路由
	}

	@Override
	public void configEngine(Engine me) {

	}

	public static DruidPlugin createDruidPlugin() {
		DruidPlugin plugin = new DruidPlugin(Parameters.URL, Parameters.USER, Parameters.PASSWORD, Parameters.DRIVER);
		return plugin;
	}

	/**
	 * 配置插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		// 配置数据库连接池插件
		DruidPlugin druidPlugin = createDruidPlugin();
		me.add(druidPlugin);
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		// 所有映射在 MappingKit 中自动化搞定
		_MappingKit.mapping(arp);
		me.add(arp);
	}

	/**
	 * 配置全局拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {

	}

	/**
	 * 配置处理器
	 */
	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("ctx"));
	}

}
