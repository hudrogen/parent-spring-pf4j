package ru.innopolis.autowiredplugin;

import com.hudrogen.api.Greeting;
import com.hudrogen.controller.BaseController;
import org.pf4j.Extension;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class AutowiredPlugin extends SpringPlugin {

    @Autowired
    private ApplicationContext context;

    public AutowiredPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    protected ApplicationContext createApplicationContext() {

        /**Это должен быть родительским контекстом для оставльных*/
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.setClassLoader(getWrapper().getPluginClassLoader());
        applicationContext.register(SpringConfig.class);
        applicationContext.refresh();

        return applicationContext;
    }

    @Extension
    public static class AutowiredGreeting implements Greeting {

        @Autowired
        private MyAutowiredComponent myAutowiredComponent;

        public String getGreeting() {
            return myAutowiredComponent.getMessage();
        }
    }

    @Extension
    @RestController
    public static class AutowiredBaseController implements BaseController {

//        @Autowired
//        private MyAutowiredComponent myAutowiredComponent;

        @RequestMapping("/pluginMethod")
        public String calcMetric() {
            return "metrics are calculated";
        }

        public String getMetric() {
            return "avg metric value is 56";
        }
    }
}
