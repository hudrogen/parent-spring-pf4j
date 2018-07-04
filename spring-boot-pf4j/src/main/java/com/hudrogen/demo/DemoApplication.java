package com.hudrogen.demo;

import com.hudrogen.controller.BaseController;
import com.hudrogen.demo.simple.Greetings;
import com.hudrogen.demo.web.BaseControllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;


	public static void main(String[] args) {

		/**Сюда нужно указать путь папке, в которой лежат плагины*/
		System.setProperty("pf4j.pluginsDir", "C:\\Users\\salimgaraev\\IdeaProjects\\parent-spring-pf4j\\customeshop");
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Greetings greetings = applicationContext.getBean(Greetings.class);
		greetings.printGreetings();

		BaseControllers contr = applicationContext.getBean(BaseControllers.class);
		List<BaseController> baseControllerList = contr.getBaseControllerList();
		System.out.println("Количество полученных бинов= " + baseControllerList.size());


		// stop plugins
//		PluginManager pluginManager = applicationContext.getBean(PluginManager.class);
//
//		pluginManager.loadPlugins();
//
//		pluginManager.startPlugins();

//		List<PluginWrapper> list = pluginManager.getPlugins();
//		for (PluginWrapper pluginWrapper : list) {
//			System.out.println(pluginWrapper.getPluginId());
//
//			List<?> extensions = pluginManager.getExtensions(pluginWrapper.getPluginId());
//			for (Object extension : extensions) {
//
//				System.out.println(extension);
//
//			}
//
//		}

		//pluginManager.stopPlugins();

		System.out.println("=============");

	}
}
