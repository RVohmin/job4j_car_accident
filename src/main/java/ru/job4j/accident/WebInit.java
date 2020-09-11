package ru.job4j.accident;

import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import ru.job4j.accident.config.WebConfig;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * Java - конфигурация Spring
 */
public class WebInit implements WebApplicationInitializer {
    public final static Logger LOGGER = Logger.getLogger(WebInit.class.getName());
    /**
     *
     * @param servletCxt - servlet
     */
    public void onStartup(ServletContext servletCxt) {
        // получаем контекст context
        var context = new AnnotationConfigWebApplicationContext();
        // регистрируем конфигурационный класс
        context.register(WebConfig.class, HbmConfig.class);
        context.refresh();
        // настраиваем кодировку
        var filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        filter.setForceRequestEncoding(true);
        FilterRegistration.Dynamic encoding = servletCxt.addFilter("encoding", filter);
        encoding.addMappingForUrlPatterns(null, false, "/*");
        // Диспатчер
        var servlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}