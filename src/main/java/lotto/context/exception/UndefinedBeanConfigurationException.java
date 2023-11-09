package lotto.context.exception;

public class UndefinedBeanConfigurationException extends BeanException {
    public UndefinedBeanConfigurationException(String beanName) {
        super("undefined bean configuration : " + beanName);
    }
}
