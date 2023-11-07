package lotto.context.exception;

public class AlreadyExistBeanException extends BeanException {
    public AlreadyExistBeanException(String beanName) {
        super("a bean with the same name already exists : " + beanName);
    }
}
