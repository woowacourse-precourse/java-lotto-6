package lotto.view;

import lotto.model.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String INPUT_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_MESSAGE_FORM = "%d개를 구매했습니다.";
    private static final String INPUT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String PURCHASED_LOTTO_FORM = "[%s]";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String DELIMITER = "---";
    private static final String WINNING_5th_LOTTO = "3개 일치 (5,000원) - %d개";
    private static final String WINNING_4th_LOTTO = "4개 일치 (50,000원) - %d개";
    private static final String WINNING_3rd_LOTTO = "5개 일치 (1,500,000원) - %d개";
    private static final String WINNING_2nd_LOTTO = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String WINNING_1st_LOTTO = "6개 일치 (2,000,000,000원) - %d개";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f";
    private static final String RATE_OF_RETURN_MESSAGE2 = "%입니다.";


    public OutputView() {
    }

    public void inputPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY);
    }

    public void printPurchaseNumber(int num) {
        String purchaseNumber = String.format(PURCHASE_MESSAGE_FORM, num);
        System.out.println(purchaseNumber);
    }

    public void inputLottoNumber() {
        System.out.println(INPUT_LOTTO_NUMBER);
    }

    public void inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            String numbersAsString = numbers.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            String formattedNumbers = String.format(PURCHASED_LOTTO_FORM, numbersAsString);
            System.out.println(formattedNumbers);
        }
        System.out.println();
    }


    public void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DELIMITER);
    }

    public void printWinning5th(int prize) {
        System.out.println(String.format(WINNING_5th_LOTTO, prize));
    }

    public void printWinning4th(int prize) {
        System.out.println(String.format(WINNING_4th_LOTTO, prize));
    }

    public void printWinning3rd(int prize) {
        System.out.println(String.format(WINNING_3rd_LOTTO, prize));
    }

    public void printWinning2nd(int prize) {
        System.out.println(String.format(WINNING_2nd_LOTTO, prize));
    }

    public void printWinning1st(int prize) {
        System.out.println(String.format(WINNING_1st_LOTTO, prize));
    }

    public void printRateOfReturn(float rate) {
        System.out.print(String.format(RATE_OF_RETURN_MESSAGE, rate));
        System.out.println(RATE_OF_RETURN_MESSAGE2);
    }
}
