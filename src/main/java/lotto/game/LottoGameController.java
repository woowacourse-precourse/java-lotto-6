package lotto.game;

import static lotto.Constants.MessageConstant.*;

import lotto.LottoNumber;
import lotto.AmountToBuyLotto;
import lotto.WinningNumber;
import lotto.WinningStatistic;
import lotto.YieldRate;
import lotto.random.LottoNumberGeneratorImpl;
import lotto.reader.Reader;
import lotto.writer.Writer;

public class LottoGameController {

    private final Reader reader;
    private final Writer writer;

    public LottoGameController(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }


    private AmountToBuyLotto inputMoney() {
        display(AMOUNT_TO_BUY_LOTTO_INPUT_MESSAGE);
        while (true) {
            try {
                String input = reader.read();
                return AmountToBuyLotto.newInstance(input);
            } catch (IllegalArgumentException e) {
                writer.write(e.getMessage());
            }
        }
    }

    private void display(String context) {
        writer.write(context);
    }

}
