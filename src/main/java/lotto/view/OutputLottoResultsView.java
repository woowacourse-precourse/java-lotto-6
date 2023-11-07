package lotto.view;

import lotto.domain.WinningLotto;

public class OutputLottoResultsView {
    private static final String OUTPUT_MESSAGE = "당첨 통계\n---\n";

    public static void printResults(WinningLotto lotto){
        System.out.println(OUTPUT_MESSAGE);
        for (Integer number : lotto.getWin().getNumbers()) {
            System.out.println(number);
        }
    }
}
