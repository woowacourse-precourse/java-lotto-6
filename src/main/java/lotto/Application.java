package lotto;

import lotto.domain.LottoNumbersGenerator;
import lotto.handler.LottoHandler;
import lotto.manager.LottoManager;
import lotto.view.LottoReader;
import lotto.view.LottoWriteParser;
import lotto.view.LottoWriter;

public class Application {
    public static void main(String[] args) {

        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        LottoManager lottoManager = new LottoManager(lottoNumbersGenerator);
        LottoReader lottoReader = new LottoReader();
        LottoWriter lottoWriter = new LottoWriter();
        LottoWriteParser lottoWriteParser = new LottoWriteParser();

        LottoHandler lottoHandler = new LottoHandler(lottoManager, lottoReader, lottoWriter, lottoWriteParser);
        lottoHandler.run();
    }
}
