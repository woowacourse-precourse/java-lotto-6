package lotto;

import lotto.controller.LottoController;
import lotto.io.ConsoleInputStream;
import lotto.io.ConsoleOutputStream;
import lotto.io.InputStream;
import lotto.io.OutputStream;

public class Application {
    public static void main(String[] args) {
        InputStream inputStream = new ConsoleInputStream();
        OutputStream outputStream = new ConsoleOutputStream();
        LottoController lottoController = new LottoController(inputStream, outputStream);

        lottoController
                .inputMoney()
                .buyLottos()
                .inputWinNumbers()
                .inputBonusNumber()
                .getWinStatistics()
                .getRateOfReturn();
    }
}