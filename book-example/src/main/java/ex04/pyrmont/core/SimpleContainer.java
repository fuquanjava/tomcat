package ex04.pyrmont.core;

import java.beans.PropertyChangeListener;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import javax.management.ObjectName;
import javax.naming.directory.DirContext;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.*;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.juli.logging.Log;

public class SimpleContainer implements Container {

    public static final String WEB_ROOT =
            System.getProperty("user.dir") + File.separator + "webroot";

    public SimpleContainer() {
    }

    public String getInfo() {
        return null;
    }

    public Loader getLoader() {
        return null;
    }

    public void setLoader(Loader loader) {
    }

    public Log getLogger() {
        return null;
    }

    @Override
    public ObjectName getObjectName() {
        return null;
    }

    @Override
    public String getDomain() {
        return null;
    }

    @Override
    public String getMBeanKeyProperties() {
        return null;
    }

    @Override
    public Pipeline getPipeline() {
        return null;
    }

    public void setLogger(Logger logger) {
    }

    public Manager getManager() {
        return null;
    }

    public void setManager(Manager manager) {
    }

    public Cluster getCluster() {
        return null;
    }

    public void setCluster(Cluster cluster) {
    }

    @Override
    public int getBackgroundProcessorDelay() {
        return 0;
    }

    @Override
    public void setBackgroundProcessorDelay(int delay) {

    }

    public String getName() {
        return null;
    }

    public void setName(String name) {
    }

    public Container getParent() {
        return null;
    }

    public void setParent(Container container) {
    }

    public ClassLoader getParentClassLoader() {
        return null;
    }

    public void setParentClassLoader(ClassLoader parent) {
    }

    public Realm getRealm() {
        return null;
    }

    public void setRealm(Realm realm) {
    }

    @Override
    public void backgroundProcess() {

    }

    public DirContext getResources() {
        return null;
    }

    public void setResources(DirContext resources) {
    }

    public void addChild(Container child) {
    }

    public void addContainerListener(ContainerListener listener) {
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
    }

    public Container findChild(String name) {
        return null;
    }

    public Container[] findChildren() {
        return null;
    }

    public ContainerListener[] findContainerListeners() {
        return null;
    }


    public void invoke(Request request, Response response)
            throws IOException, ServletException {

        String servletName = ((HttpServletRequest) request).getRequestURI();
        servletName = servletName.substring(servletName.lastIndexOf("/") + 1);
        URLClassLoader loader = null;
        try {
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(WEB_ROOT);
            String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();
            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        Class myClass = null;
        try {
            myClass = loader.loadClass(servletName);
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }

        Servlet servlet = null;

        try {
            servlet = (Servlet) myClass.newInstance();
            servlet.service((HttpServletRequest) request, (HttpServletResponse) response);
        } catch (Exception e) {
            System.out.println(e.toString());
        } catch (Throwable e) {
            System.out.println(e.toString());
        }


    }

    public Container map(Request request, boolean update) {
        return null;
    }

    public void removeChild(Container child) {
    }

    public void removeContainerListener(ContainerListener listener) {
    }


    public void removePropertyChangeListener(PropertyChangeListener listener) {
    }

    @Override
    public void fireContainerEvent(String type, Object data) {

    }

    @Override
    public void logAccess(Request request, Response response, long time, boolean useDefault) {

    }

    @Override
    public AccessLog getAccessLog() {
        return null;
    }

    @Override
    public int getStartStopThreads() {
        return 0;
    }

    @Override
    public void setStartStopThreads(int startStopThreads) {

    }

    @Override
    public File getCatalinaBase() {
        return null;
    }

    @Override
    public void addLifecycleListener(LifecycleListener listener) {

    }

    @Override
    public LifecycleListener[] findLifecycleListeners() {
        return new LifecycleListener[0];
    }

    @Override
    public void removeLifecycleListener(LifecycleListener listener) {

    }

    @Override
    public void init() throws LifecycleException {

    }

    @Override
    public void start() throws LifecycleException {

    }

    @Override
    public void stop() throws LifecycleException {

    }

    @Override
    public void destroy() throws LifecycleException {

    }

    @Override
    public LifecycleState getState() {
        return null;
    }

    @Override
    public String getStateName() {
        return null;
    }
}