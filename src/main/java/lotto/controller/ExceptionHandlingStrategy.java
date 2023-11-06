package lotto.controller;

import java.util.function.BiConsumer;
import lotto.service.LottoGameService;

public interface ExceptionHandlingStrategy {
    void apply(LottoGameView lottoGameView, LottoGameService lottoGameService,
               BiConsumer<LottoGameView, LottoGameService> inputBehavior);
}
