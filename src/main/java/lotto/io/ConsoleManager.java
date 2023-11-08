package lotto.io;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCount;
import lotto.domain.lotto.LottoStatistic;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.Price;
import lotto.domain.lotto.WinningNumber;
import lotto.domain.lotto.random.LottoNumberParser;

import static lotto.util.StringConverter.toInt;
import static lotto.util.StringConverter.toLong;

public class ConsoleManager {
    private final View view;
    private final LottoNumberParser lottoNumberParser;

    public ConsoleManager(View view, LottoNumberParser lottoNumberParser) {
        this.view = view;
        this.lottoNumberParser = lottoNumberParser;
    }

    public Price getPrice() {
        while (true) {
            String value = view.readPurchasePrice();
            try {
                return new Price(toLong(value));
            } catch (IllegalArgumentException e) {
                view.printErrorMessage(e.getMessage());
            }
        }
    }

    public Lotto getLottoNumbers() {
        while (true) {
            String line = view.readWinningNumbers().trim();
            try {
                return lottoNumberParser.parseNumber(line);
            } catch (IllegalArgumentException e) {
                view.printErrorMessage(e.getMessage());
            }
        }
    }

    public BonusNumber getBonusNumber() {
        while (true) {
            String value = view.readBonusNumber();
            try {
                return new BonusNumber(toInt(value));
            } catch (IllegalArgumentException e) {
                view.printErrorMessage(e.getMessage());
            }
        }
    }

    public WinningNumber getWinningNumber() {
        while (true) {
            try {
                return new WinningNumber(getLottoNumbers(), getBonusNumber());
            } catch (IllegalArgumentException e) {
                view.printErrorMessage(e.getMessage());
            }
        }
    }

    public void printLottoCount(LottoCount count) {
        view.printLottoCountMessage(count);
    }

    public void printLottos(Lottos lottos) {
        view.printPurchaseLottos(lottos.getLottos());
    }

    public void printLottoStatistic(LottoStatistic lottoStatistic) {
        view.printLottoStatistic(lottoStatistic.getAnswer());
    }
}
