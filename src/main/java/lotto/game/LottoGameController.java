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

    public void play() {
        AmountToBuyLotto amountToBuyLotto = inputMoney();
        LottoGame lottoGame = new LottoGame(new LottoNumberGeneratorImpl());
        lottoGame.saleLotto(amountToBuyLotto);
        writer.write(lottoGame.getIssuedLottosMessage());
        WinningNumber winningNumber = inputWinningNumber();
        LottoNumber bonusNumber = inputBonusNumber(winningNumber);
        WinningStatistic winningStatistic = lottoGame.createWinningStatistic(winningNumber,
            bonusNumber);
        YieldRate yieldRate = lottoGame.calculateYieldRate(amountToBuyLotto, winningStatistic);
        writer.write(winningStatistic.getStatisticMessage());
        writer.write(yieldRate.getRateMessage());
    }


    private LottoNumber inputBonusNumber(WinningNumber winningNumber) {
        writer.write(BONUS_NUMBER_INPUT_MESSAGE);
        while (true) {
            try {
                String input = reader.read();
                LottoNumber lottoNumber = LottoNumber.newInstance(input);
                winningNumber.hasNumber(lottoNumber);
                return lottoNumber;
            } catch (IllegalArgumentException e) {
                writer.write(e.getMessage());
            }
        }
    }

    private WinningNumber inputWinningNumber() {
        writer.write(WINNING_NUMBER_INPUT_MESSAGE);
        while (true) {
            try {
                String input = reader.read();
                return WinningNumber.newInstance(input);
            } catch (IllegalArgumentException e) {
                writer.write(e.getMessage());
            }
        }

    }

    private AmountToBuyLotto inputMoney() {
        writer.write(AMOUNT_TO_BUY_LOTTO_INPUT_MESSAGE);
        while (true) {
            try {
                String input = reader.read();
                return AmountToBuyLotto.newInstance(input);
            } catch (IllegalArgumentException e) {
                writer.write(e.getMessage());
            }
        }
    }
}
