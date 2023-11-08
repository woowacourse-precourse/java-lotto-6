package lotto;

import static lotto.constants.ProgramMessage.PRINT_COUNT_OF_LOTTO_ISSUED;
import static lotto.constants.ProgramMessage.PRINT_FORM_1ST_PLACE;
import static lotto.constants.ProgramMessage.PRINT_FORM_2ND_PLACE;
import static lotto.constants.ProgramMessage.PRINT_FORM_3RD_PLACE;
import static lotto.constants.ProgramMessage.PRINT_FORM_4TH_PLACE;
import static lotto.constants.ProgramMessage.PRINT_FORM_5TH_PLACE;
import static lotto.constants.ProgramMessage.REQUEST_BONUS_NUMBER;
import static lotto.constants.ProgramMessage.REQUEST_PURCHASE_AMOUNT;
import static lotto.constants.ProgramMessage.REQUEST_WINNING_NUMBER;
import static lotto.constants.ProgramMessage.WINNING_STATISTICS_LINE;
import static lotto.constants.ProgramMessage.WINNING_STATISTICS_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LottoTerminal {
    private static final int MIN_OF_LOTTO_NUMBER = 1;
    private static final int MAX_OF_LOTTO_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;
    private static final String matchesCount1stPlace = "6";
    private static final String matchesCount2ndPlace = "5+bonus";
    private static final String matchesCount3rdPlace = "5";
    private static final String matchesCount4thPlace = "4";
    private static final String matchesCount5thPlace = "3";

    private long amountPaid;
    private List<List<Integer>> allLottoIssued = new ArrayList<>();
    private long countOfLottoIssued;

    public String requestAndReadPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT.getMessage());

        return Console.readLine();
    }

    public void receivePayment(long amountPaid) {
        this.amountPaid = amountPaid;
    }

    public List<List<Integer>> LottoIssuance() {
        while (amountPaid > 0) {
            List<Integer> numbersOfLotto = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(MIN_OF_LOTTO_NUMBER, MAX_OF_LOTTO_NUMBER,
                            6));

            Lotto lotto = new Lotto(numbersOfLotto);
            allLottoIssued.add(numbersOfLotto);
            countOfLottoIssued++;
            amountPaid -= LOTTO_PRICE;
        }
        return allLottoIssued;
    }

    public void printAllLotto() {
        System.out.println();
        System.out.println(countOfLottoIssued + PRINT_COUNT_OF_LOTTO_ISSUED.getMessage());

        for (int i = 0; i < allLottoIssued.size(); i++) {
            Collections.sort(allLottoIssued.get(i));

            System.out.println(allLottoIssued.get(i));
        }
    }

    public String requestAndReadWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER.getMessage());

        return Console.readLine();
    }

    public String requestAndReadBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER.getMessage());

        return Console.readLine();
    }

    public void printWinningStatistics(HashMap<String, Integer> statistics, BigDecimal rateOfReturn) {
        System.out.println();
        System.out.println(WINNING_STATISTICS_MESSAGE.getMessage());
        System.out.println(WINNING_STATISTICS_LINE.getMessage());
        System.out.println(
                PRINT_FORM_5TH_PLACE.getMessage() + String.valueOf(statistics.get(matchesCount5thPlace)) + "개");
        System.out.println(
                PRINT_FORM_4TH_PLACE.getMessage() + String.valueOf(statistics.get(matchesCount4thPlace)) + "개");
        System.out.println(
                PRINT_FORM_3RD_PLACE.getMessage() + String.valueOf(statistics.get(matchesCount3rdPlace)) + "개");
        System.out.println(
                PRINT_FORM_2ND_PLACE.getMessage() + String.valueOf(statistics.get(matchesCount2ndPlace)) + "개");
        System.out.println(
                PRINT_FORM_1ST_PLACE.getMessage() + String.valueOf(statistics.get(matchesCount1stPlace)) + "개");
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
