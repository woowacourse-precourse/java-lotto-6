package lotto.container.exception;

public class NoSuchBeanException extends IllegalStateException {
    public NoSuchBeanException(String beanName) {
        super("cannot find bean : " + beanName);
    }
}
