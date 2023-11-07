package lotto;

import lotto.domain.LottoNumbersGenerator;
import lotto.handler.LottoHandler;
import lotto.manager.LottoManager;
import lotto.view.LottoReader;
import lotto.view.LottoViewResolver;
import lotto.view.LottoWriter;

public class Application {
    public static void main(String[] args) {

        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        LottoManager lottoManager = new LottoManager(lottoNumbersGenerator);
        LottoReader lottoReader = new LottoReader();
        LottoWriter lottoWriter = new LottoWriter();
        LottoViewResolver lottoViewResolver = new LottoViewResolver();

        LottoHandler lottoHandler = new LottoHandler(lottoManager, lottoReader, lottoWriter, lottoViewResolver);
        lottoHandler.run();
    }
}
