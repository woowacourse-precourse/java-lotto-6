package lotto.controller;

import java.util.function.Function;

public interface ExceptionHandler {

    Object applyFunction(LottoGameView lottoGameView, Function<LottoGameView, Object> function);
}
