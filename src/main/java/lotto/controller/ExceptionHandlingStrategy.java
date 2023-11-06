package lotto.controller;

import java.util.function.Function;

public interface ExceptionHandlingStrategy {

    Object applyFunction(LottoGameView lottoGameView, Function<LottoGameView, Object> function);
}
