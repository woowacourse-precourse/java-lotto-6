package lotto.context.container.implementation.annotationConfig;

import lotto.context.beanFactory.BeanFactory;
import lotto.context.exception.BeanException;

public class AnnotationConfigApplicationContainerProxy extends AnnotationConfigApplicationContainer {
    public AnnotationConfigApplicationContainerProxy(BeanFactory factory, LoadingStrategy loadingStrategy, String basePackage) {
        super(factory, loadingStrategy, basePackage);
        log("*** 테스트를 위한 어노테이션 기반 애플리케이션 컨테이너가 초기화되었습니다. 해당 객체는 프록시 객체로서, 실제 객체의 동작을 콘솔에 중계합니다.\n");
    }

    @Override
    public int getBeanCount() {
        return super.getBeanCount();
    }

    @Override
    public <T> T getBean(Class<?> beanClass) {
        log("등록된 빈을 클래스를 통해 검색합니다 : " + beanClass.getSimpleName());
        log();
        return super.getBean(beanClass);
    }

    @Override
    public <T> T getBean(String beanName) {
        log("등록된 빈을 검색하고 존재하지 않으면 새로 생성합니다 : " + beanName);
        try {
            log();
            return super.getBean(beanName);
        } catch (BeanException e) {
            log("예외가 발생했습니다! -> " + e.getMessage());
            log();
            throw e;
        }
    }

    @Override
    public void remove(String beanName) {
        try {
            log("등록된 빈을 삭제합니다 : " + beanName);
            super.remove(beanName);
        } catch (BeanException e) {
            log("예외가 발생했습니다! -> " + e.getMessage());
            log();
            throw e;
        }
        log();
    }

    private void log(String message) {
        System.out.println("[" + this.getClass().getSimpleName() +"] " + message);
    }

    private void log() {
        System.out.println();
    }
}
