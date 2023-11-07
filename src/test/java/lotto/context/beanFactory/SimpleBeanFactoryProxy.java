package lotto.context.beanFactory;

import lotto.context.exception.BeanException;

import java.util.function.Supplier;

public class SimpleBeanFactoryProxy extends SimpleBeanFactory {
    public SimpleBeanFactoryProxy() {
        log("*** 테스트를 위한 빈 팩토리가 초기화되었습니다. 해당 객체는 프록시 객체로서, 실제 객체의 동작을 콘솔에 중계합니다.\n");
    }

    @Override
    public int getBeanCount() {
        return super.getBeanCount();
    }

    @Override
    public boolean contains(String beanName) {
        if (super.contains(beanName)) {
            log("해당 빈을 가지고 있습니다 : " + beanName);
        }
        if (!super.contains(beanName)) {
            log("해당 빈을 가지고 있지 않습니다 : " + beanName);
        }
        return super.contains(beanName);
    }

    @Override
    public <T> T getBean(String beanName) {
        log("등록된 빈을 검색합니다 : " + beanName);
        try {
            return super.getBean(beanName);
        } catch (BeanException e) {
            log("예외가 발생했습니다! -> " + e.getMessage());
            log("");
            throw e;
        }
    }

    @Override
    public <T> void registerBean(String beanName, Supplier<T> beanSupplier) {
        log("새로운 빈을 등록합니다 : " + beanName);
        try {
            super.registerBean(beanName, beanSupplier);
        } catch (BeanException e) {
            log("예외가 발생했습니다! -> " + e.getMessage());
            log("");
            throw e;
        }
        log();
        log("");
    }

    @Override
    public void remove(String beanName) {
        try {
            log("등록된 빈을 삭제합니다 : " + beanName);
            super.remove(beanName);
        } catch (BeanException e) {
            log("예외가 발생했습니다! -> " + e.getMessage());
            log("");
            throw e;
        }
        log();
        log("");
    }


    private void log(String message) {
        System.out.println("[" + this.getClass().getSimpleName() + "] " + message);
    }

    private void log() {
        System.out.println("현재 생성된 총 빈의 수 : " + getBeanCount());
    }
}
