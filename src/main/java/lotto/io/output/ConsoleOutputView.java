package lotto.io.output;

import static lotto.utils.constant.IOConstant.GET_BONUS_NUMBER;
import static lotto.utils.constant.IOConstant.GET_LOTTO_MONEY;
import static lotto.utils.constant.IOConstant.GET_WINNING_NUMBERS;
import static lotto.utils.constant.IOConstant.LOTTO_COUNT;
import static lotto.utils.constant.IOConstant.PROFIT_RATE;
import static lotto.utils.constant.IOConstant.RESULT;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    @Override
    public void printGetLottoMoney() {
        System.out.println(GET_LOTTO_MONEY.getValue());
    }

    @Override
    public void printGetWinningNumbers() {
        System.out.println(GET_WINNING_NUMBERS.getValue());
    }

    @Override
    public void printGetBonusNumber() {
        System.out.println(GET_BONUS_NUMBER.getValue());
    }

    @Override
    public void printLottosInfo(int count, String lottosInfo) {
        System.out.println("\n" + count + LOTTO_COUNT.getValue());
        System.out.println(lottosInfo);
    }

    @Override
    public void printResult() {
        System.out.println(RESULT.getValue());
    }

    @Override
    public void printStatistics(String statistics) {
        System.out.println(statistics);
    }

    @Override
    public void printProfitRate(float profitRate) {
        System.out.println(PROFIT_RATE.getValue().formatted(profitRate));
    }
}
