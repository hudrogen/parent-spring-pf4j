package ru.innopolis.autowiredplugin;

import com.hudrogen.api.Greeting;
import org.pf4j.Extension;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPlugin;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredPlugin extends SpringPlugin {



    public AutowiredPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    protected ApplicationContext createApplicationContext() {
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
}
