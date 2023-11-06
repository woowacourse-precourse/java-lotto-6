package lotto.io.output;

import static lotto.utils.constant.IOConstant.GET_BONUS_NUMBER;
import static lotto.utils.constant.IOConstant.GET_LOTTO_MONEY;
import static lotto.utils.constant.IOConstant.GET_WINNING_NUMBERS;

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
    public void printResult() {
        // todo 결과 출력 형식 결정시 구현
    }

    @Override
    public void printStatistics() {
        // todo 통계 출력 형식 결정시 구현
    }

    @Override
    public void printProfitRate() {
        // todo 수익률 출력 형식 결정시 구현
    }
}
