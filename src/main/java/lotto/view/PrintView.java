package lotto.view;

import static lotto.domain.MatchingCase.FIVE_MATCHING_WITH_BONUS;

import lotto.domain.MatchingCase;

public class PrintView {
    public static final String NEW_LINE = System.lineSeparator();

    public static void printLottoCount(int count) {
        System.out.printf("%d개를 구매했습니다.", count);
    }
}
