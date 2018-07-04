package com.hudrogen.demo;

import com.hudrogen.controller.BaseController;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;


	public static void main(String[] args) {
		System.setProperty("pf4j.pluginsDir", "C:\\Users\\salimgaraev\\IdeaProjects\\parent-spring-pf4j\\customeshop");
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		/**Ниже работает без спринг плагин стартера*/
		Greetings greetings = applicationContext.getBean(Greetings.class);
		greetings.printGreetings();

		BaseControllers contr = applicationContext.getBean(BaseControllers.class);
		List<BaseController> baseControllerList = contr.getBaseControllerList();
		System.out.println("Количество полученных бинов= " + baseControllerList.size());
		//полученный классы интерпретировать как контроллеры


		//Object autoController = applicationContext.getBean("myAutowiredComponent");

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
