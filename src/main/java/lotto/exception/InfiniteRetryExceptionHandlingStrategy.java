package lotto.exception;

import java.util.function.Function;
import lotto.controller.ExceptionHandlingStrategy;
import lotto.controller.LottoGameView;

public class InfiniteRetryExceptionHandlingStrategy implements ExceptionHandlingStrategy {

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
