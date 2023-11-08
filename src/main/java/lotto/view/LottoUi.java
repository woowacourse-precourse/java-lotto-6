package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.LottoEnum;

public class LottoUi {
    private static final String MONEY_INPUT = "구입금액을 입력해 주세요.";
    private static final String COUNT_OUTPUT = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_INPUT = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT = "\n보너스 번호를 입력해 주세요.";
    private static final String RESULT_OUTPUT = "\n당첨통계\n---";
    private static final String NUMBER_FORMAT_ERROR = "[ERROR] 숫자를 입력해주세요.";

    public LottoUi() {

    }

    public void printMoneyInput() {
        System.out.println(MONEY_INPUT);
    }

    public void printCountOutput(Integer count) {
        System.out.println("\n" + count + COUNT_OUTPUT);
    }

    public void printWinningNumberInput() {
        System.out.println(WINNING_NUMBER_INPUT);
    }

    public void printBonusNumberInput() {
        System.out.println(BONUS_NUMBER_INPUT);
    }

    public void printResultOutput() {
        System.out.println(RESULT_OUTPUT);
    }

    public void printStatistics(List<LottoEnum> rankings) {
        for (int i = LottoEnum.values().length - 1; i >= 0; i--) {
            LottoEnum lottoEnum = LottoEnum.values()[i];
            Integer counts = Collections.frequency(rankings, lottoEnum);
            if (lottoEnum.getCount() >= 3) {
                System.out.print(lottoEnum.getCount() + "개 일치");
                if (lottoEnum.isBonus()) {
                    System.out.print(", 보너스 볼 일치");
                }
                System.out.printf(" (%,d원) - " + counts + "개\n", lottoEnum.getWinningMoney());
            }
        }
    }

    public void printTotalProfit(Integer totalWinningMoney, Integer money) {
        System.out.println("총 수익률은 " + String.format("%.1f", (double) totalWinningMoney / money * 100) + "%입니다.");
    }

    public Integer readInt() {
        String input = readLine();
        Integer integer;
        try {
            integer = Integer.parseInt(input);
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
        return integer;
    }

    public List<Integer> readInts() {
        String input = readLine();
        List<Integer> integers = new ArrayList<>();
        try {
            String[] tokens = input.split(",");
            for (String token : tokens) {
                Integer number = Integer.parseInt(token);
                integers.add(number);
            }
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
        return integers;
    }
}
