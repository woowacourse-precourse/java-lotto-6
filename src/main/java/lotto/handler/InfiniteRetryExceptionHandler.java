package lotto.handler;

import java.util.function.Function;
import lotto.controller.ExceptionHandler;
import lotto.controller.LottoGameView;

public class InfiniteRetryExceptionHandler implements ExceptionHandler {

    @Override
    public Object applyFunction(LottoGameView lottoGameView, Function<LottoGameView, Object> function) {
        while (true) {
            try {
                return function.apply(lottoGameView);
            } catch (IllegalArgumentException e) {
                lottoGameView.printException(e);
            }
        }
    }
}
