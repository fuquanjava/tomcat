package ex02.pyrmont;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Constants {
    public static final String WEB_ROOT =
            System.getProperty("user.dir") + File.separator + "book-example" + File.separator + "webroot";

    public static void main(String[] args) throws IOException {
        File classPath = new File(Constants.WEB_ROOT);

        // the forming of repository is taken from the createClassLoader method in
        // org.apache.catalina.startup.ClassLoaderFactory
        String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();

        System.out.println(repository);

    }
}