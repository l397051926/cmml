
package com.lj.cmml.cmmluser.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;


/**
 * application configuration
 */
@Configuration
public class AppConfiguration implements WebMvcConfigurer {

  public static final String PATH_PATTERN = "/**";
  public static final String LOCALE_LANGUAGE_COOKIE = "language";
  public static final int COOKIE_MAX_AGE = 3600;


  /**
   * Cookie
   * @return local resolver
   */
  @Bean(name = "localeResolver")
  public LocaleResolver localeResolver() {
    CookieLocaleResolver localeResolver = new CookieLocaleResolver();
    localeResolver.setCookieName(LOCALE_LANGUAGE_COOKIE);
    /** set default locale **/
    localeResolver.setDefaultLocale(Locale.US);
    /** set cookie max age **/
    localeResolver.setCookieMaxAge(COOKIE_MAX_AGE);
    return localeResolver;
  }

  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
    /**  **/
    lci.setParamName("language");

    return lci;
  }


  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    registry.addResourceHandler("/ui/**").addResourceLocations("file:ui/");
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/ui/").setViewName("forward:/ui/index.html");
    registry.addViewController("/").setViewName("forward:/ui/index.html");
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping(PATH_PATTERN).allowedOrigins("*").allowedMethods("*");
  }


  /**
   * Turn off suffix-based content negotiation
   *
   * @param configurer configurer
   */
  @Override
  public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
    configurer.favorPathExtension(false);
  }




}
