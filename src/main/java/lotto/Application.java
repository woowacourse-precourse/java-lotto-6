package lotto;

import lotto.application.LottoProcessor;
import lotto.domain.DefaultLottoGenerator;
import lotto.domain.LottoGenerator;

public class Application {
    public static void main(final String[] args) {
        final LottoGenerator lottoGenerator = new DefaultLottoGenerator();
        final LottoProcessor lottoProcessor = new LottoProcessor(lottoGenerator);
        lottoProcessor.run();
    }
}
