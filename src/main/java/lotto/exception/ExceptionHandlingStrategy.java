package lotto.exception;

import java.util.function.BiConsumer;
import lotto.service.LottoGameService;
import lotto.view.LottoGameView;

public interface ExceptionHandlingStrategy {
    void apply(LottoGameView lottoGameView, LottoGameService lottoGameService,
               BiConsumer<LottoGameView, LottoGameService> inputBehavior);
}
