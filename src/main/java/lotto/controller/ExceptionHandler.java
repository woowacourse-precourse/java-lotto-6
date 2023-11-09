package lotto.controller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lotto.view.OutputView;

public class ExceptionHandler implements InvocationHandler {

    private final Object target;

    public ExceptionHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(target,args);
        }catch (InvocationTargetException e){
            if(e.getTargetException() instanceof IllegalArgumentException){
                OutputView.renderingError(e.getTargetException().getMessage());
                return invoke(proxy,method,args);
            }
            throw e.getTargetException();
        }
    }
}
