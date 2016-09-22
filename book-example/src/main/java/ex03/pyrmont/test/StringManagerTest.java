package ex03.pyrmont.test;

import org.apache.catalina.tribes.util.StringManager;

import java.util.Locale;

/**
 * fuquanemail@gmail.com 2016/9/22 10:54
 * description:
 */
public class StringManagerTest {
    public static void main(String[] args) {

        Locale myLocale  =  Locale.getDefault();

        System.out.println(myLocale.getCountry());

        System.out.println(myLocale.getLanguage());

        System.out.println(myLocale.getDisplayCountry());

        System.out.println(myLocale.getDisplayLanguage());


        StringManager sm =
                StringManager.getManager("ex03.pyrmont.connector.http");

        String str = sm.getString("httpConnector.alreadyInitialized");
        System.err.println(str);

    }
}
