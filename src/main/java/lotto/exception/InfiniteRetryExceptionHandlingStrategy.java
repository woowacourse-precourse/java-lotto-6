package lotto.exception;

import java.util.function.BiConsumer;
import lotto.service.LottoGameService;
import lotto.view.LottoGameView;

public class InfiniteRetryExceptionHandlingStrategy implements ExceptionHandlingStrategy {
    @Override
    public void apply(LottoGameView lottoGameView, LottoGameService lottoGameService,
                      BiConsumer<LottoGameView, LottoGameService> inputBehavior) {
        while (true) {
            try {
                inputBehavior.accept(lottoGameView, lottoGameService);
                return;
            } catch (IllegalArgumentException e) {
                lottoGameView.printException(e);
            }
        }
    }
}
