package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Result;

public class OutputView {

    private static final String BEFORE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String BEFORE_BUY_LOTTO = "%d개를 구매했습니다.\n";
    private static final String BEFORE_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_STATISTICS = "당첨 통계\n---";
    private static final String SECOND_PRIZE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String PRIZE = "%d개 일치 (%s원) - %d개\n";
    private static final String BEFORE_INPUT_WINNUMBER = "당첨 번호를 입력해 주세요.";
    private static final String YIELD = "총 수익률은 %.1f%%입니다.";
    private static final String FORMAT = "###,###,###,###";


    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }


    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printBeforeInputMoney() {
        System.out.println(BEFORE_INPUT_MONEY);
    }

    public void printTicket(List<Integer> lotto) {
        System.out.println(lotto.toString());
    }

    public void printBeforeBuyLotto(long count) {
        System.out.printf(BEFORE_BUY_LOTTO, count);
    }

    public void printBeforeInputBonusNumber() {
        System.out.println(BEFORE_INPUT_BONUS_NUMBER);
    }

    public void printResult() {
        System.out.println(LOTTO_STATISTICS);
        for (Result value : Result.values()) {
            String formattedNum = changeCurrentFormat(value);
            printPrize(value, formattedNum);
        }
    }

    private void printPrize(Result value, String formattedNum) {
        if (value.isBonus()) {
            System.out.printf(SECOND_PRIZE, value.getSameCount(),
                formattedNum, value.getResultCount());
            return;
        }
        System.out.printf(PRIZE, value.getSameCount(), formattedNum,
            value.getResultCount());
    }

    private String changeCurrentFormat(Result value) {
        DecimalFormat decimalFormat = new DecimalFormat(FORMAT);
        return decimalFormat.format(value.getMoney());
    }

    public void printBeforeInputWinNumbers() {
        System.out.println(BEFORE_INPUT_WINNUMBER);
    }

    public void printYield(double yield) {
        System.out.printf(YIELD, yield);
    }
}

