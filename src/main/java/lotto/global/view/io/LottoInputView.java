package lotto.global.view.io;

import lotto.domain.lotto.WinningNumbers;
import lotto.domain.money.Money;
import lotto.global.view.output.OutputView;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static lotto.global.constant.exception.ExceptionMessage.EXCEPTION_PREFIX;
import static lotto.global.constant.exception.ExceptionMessage.MAX_INPUT_ATTEMPT_COUNT;

public class LottoInputView implements InvocationHandler {

    private final InputProcessor inputProcessor;

    public LottoInputView(InputProcessor inputProcessor) {
        this.inputProcessor = inputProcessor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int retry = 5;
        while (retry-- > 0) {
            try {
                return method.invoke(inputProcessor, args);
            } catch (InvocationTargetException e) {
                OutputView.printMessageLine(EXCEPTION_PREFIX.getMessage() + e.getTargetException().getMessage());
            }
        }
        throw new IllegalStateException(MAX_INPUT_ATTEMPT_COUNT.getMessage());
    }
}
