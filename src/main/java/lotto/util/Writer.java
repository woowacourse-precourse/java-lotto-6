package lotto.util;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.StringJoiner;
import lotto.domain.Grade;
import lotto.domain.Lottos;

public class Writer {

    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";
    private static final String RESULT_FORMAT = "%d개 일치 (%s)원 - %d개";
    private static final String BONUS_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%s)원 - %d개";
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###");
    private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.";


    public static void purchaseAmount() {
        System.out.println(PURCHASE_AMOUNT);
    }

    public static void lottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void winningNumbers() {
        System.out.println(WINNING_NUMBERS);
    }

    public static void bonusNumbers() {
        System.out.println(BONUS_NUMBERS);
    }

    public static void result(Map<Grade, Integer> result) {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (Grade grade : result.keySet()) {
            if (grade.equals(Grade.NONE)) {
                continue;
            }
            if (grade.equals(Grade.FIVE_AND_BONUS)){
                String price = DECIMAL_FORMAT.format(grade.getPrice());
                stringJoiner.add(String.format(BONUS_RESULT_FORMAT, grade.getAnswer(), price, result.get(grade)));
                continue;
            }
            String price = DECIMAL_FORMAT.format(grade.getPrice());
            stringJoiner.add(String.format(RESULT_FORMAT, grade.getAnswer(), price, result.get(grade)));
        }
        System.out.println(stringJoiner);
    }

    public static void rateOfReturn(Double rateOfReturn) {
        System.out.println(String.format(RATE_OF_RETURN_FORMAT,rateOfReturn));
    }
}
