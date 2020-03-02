package ru.pupkov.stas.base;

public class Utils extends Pages {

   public static final String SELENOID_HOST = (String) Configuration.getInstance().getSelenoidHost();
   public static final Integer SELENOID_PORT = (Integer) Configuration.getInstance().getSelenoidPort();
   public static final String URL_HOST = (String) Configuration.getInstance().getHost();
   public static final String BROWSER_NAME = (String) Configuration.getInstance().getBrowserName();
   public static final String BROWSER_VERSION = (String) Configuration.getInstance().getBrowserVersion();

   public String email = "example@mail.ru";
   public String password = "password";
   public String incorrectPassword = "123456";
   public String desiredItem = "Кроссовки мужские Nike Renew Lucent";
}
