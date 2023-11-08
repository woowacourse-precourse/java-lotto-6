package lotto.global.view.io;

import lotto.global.view.output.OutputView;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;

import static lotto.global.constant.exception.ExceptionMessage.EXCEPTION_PREFIX;

public class LottoInputView implements InvocationHandler {

    private final InputProcessor inputProcessor;

    public LottoInputView(InputProcessor inputProcessor) {
        this.inputProcessor = inputProcessor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        while (true) {
            try {
                return method.invoke(inputProcessor, args);
            } catch (InvocationTargetException e) {
                checkIllegalArgumentException(e);
                OutputView.printMessageLine(EXCEPTION_PREFIX.getMessage() + e.getTargetException().getMessage());
            }
        }
    }

    private void checkIllegalArgumentException(InvocationTargetException e) throws Throwable {
        if(!(e.getTargetException() instanceof IllegalArgumentException)) {
            throw e.getTargetException();
        }
    }
}
