package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.GradeConstant;

public class OutputView {

    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String LOTTO_NUMBERS_CONNECTOR = ", ";

    private static final String LOTTO_AMOUNT_MESSAGE = "%d개를 구매했습니다.";

    private static final String PRINT_GRADE_MESSAGE = "당첨통계\n---";
    private static final String FIRST_GRADE_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String SECOND_GRADE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String THIRD_GRADE_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
    private static final String FOURTH_GRADE_MESSAGE = "4개 일치 (50,000원) - %d개\n";
    private static final String FIFTH_GRADE_MESSAGE = "3개 일치 (5,000원) - %d개\n";

    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printLottoAmount(int lottoAmount) {
        System.out.println();
        System.out.printf(LOTTO_AMOUNT_MESSAGE, lottoAmount);
        System.out.println();
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        List<Integer> numbersInOrder = new ArrayList<>(numbers);
        Collections.sort(numbersInOrder);

        String numbersString = numbersInOrder.stream()
                .map(Object::toString)
                .collect(Collectors.joining(LOTTO_NUMBERS_CONNECTOR));
        numbersString = String.format("%s%s%s", OPEN_BRACKET, numbersString, CLOSE_BRACKET);

        System.out.println(numbersString);
    }

    public static void printLottoGradeResult(Map<GradeConstant, Integer> gradeResult) {
        System.out.println();
        System.out.println(PRINT_GRADE_MESSAGE);
        System.out.printf(FIFTH_GRADE_MESSAGE, gradeResult.getOrDefault(GradeConstant.FIFTH, 0));
        System.out.printf(FOURTH_GRADE_MESSAGE, gradeResult.getOrDefault(GradeConstant.FOURTH, 0));
        System.out.printf(THIRD_GRADE_MESSAGE, gradeResult.getOrDefault(GradeConstant.THIRD, 0));
        System.out.printf(SECOND_GRADE_MESSAGE, gradeResult.getOrDefault(GradeConstant.SECOND, 0));
        System.out.printf(FIRST_GRADE_MESSAGE, gradeResult.getOrDefault(GradeConstant.FIRST, 0));
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }
}