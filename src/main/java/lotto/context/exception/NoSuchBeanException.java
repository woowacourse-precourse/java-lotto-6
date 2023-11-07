package lotto.context.exception;

public class NoSuchBeanException extends BeanException {
    public NoSuchBeanException(String beanName) {
        super("cannot find bean : " + beanName);
    }
}
