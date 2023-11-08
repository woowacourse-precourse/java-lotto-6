package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCount;
import lotto.domain.lotto.LottoResult;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static lotto.io.LottoMessage.*;

public class View implements InputView, OutputView {

    @Override
    public String readPurchasePrice() {
        printLottoMessage(INPUT_PURCHASE_PRICE);
        return Console.readLine();
    }

    @Override
    public String readWinningNumbers() {
        printLottoMessage(INPUT_WINNING_NUMBERS);
        return Console.readLine();
    }

    @Override
    public String readBonusNumber() {
        printLottoMessage(INPUT_WINNING_BONUS_NUMBER);
        return Console.readLine();
    }

    @Override
    public void printLottoMessage(LottoMessage lottoMessage) {
        System.out.println(lottoMessage.getMessage());
    }

    @Override
    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    @Override
    public void printLottoCountMessage(LottoCount count) {
        System.out.println(String.format(PRINT_LOTTO_COUNT.getMessage(), count.getCount()));
    }

    @Override
    public void printPurchaseLottos(List<Lotto> lottos) {
        StringBuilder lottoNumber = new StringBuilder();

        for (Lotto lotto : lottos) {
            lottoNumber.append("[");
            for (int i = 0; i < lotto.getLottoSize(); i++) {
                lottoNumber.append(lotto.getNumbers().get(i));
                if (i != lotto.getLottoSize() - 1) {
                    lottoNumber.append(", ");
                }
            }
            lottoNumber.append("]\n");
        }

        System.out.println(lottoNumber.toString());
    }

    @Override
    public void printLottoStatistic(Map<LottoResult, Integer> lottoResultMap) {
        StringBuilder statistic = new StringBuilder();
        statistic.append(LOTTO_STATISTIC_MESSAGE.getMessage());
        for (LottoResult key : lottoResultMap.keySet()) {
            if (key.isLose()) continue;

            statistic.append(String.format(SAME_NUMBER_COUNT_MESSAGE.getMessage(), key.getHitNumberCount()));
            if (key.getHasBonus()) {
                statistic.append(BONUS_NUMBER_MESSAGE.getMessage());
            }
            statistic.append(String.format(WINNER_PRICE_MESSAGE.getMessage(), toMoneyFormat(key.getPrizeMoney())));
            statistic.append(String.format(TOTAL_COUNT_MESSAGE.getMessage(), lottoResultMap.get(key)));

        }
        System.out.println(statistic);
    }

    private String toMoneyFormat(int money) {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT.getMessage());
        return decimalFormat.format(money);
    }

    public void printLottoEarningRate(double rate) {
        System.out.printf((LOTTO_EARNING_RATE.getMessage()) + "%n", rate);
    }
}
