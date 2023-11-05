package lotto.view;

import java.util.List;
import lotto.domain.Budget;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningStatistics;

public class OutputView {
    private static final String COUNT_OF_USER_LOTTOS_MESSAGE = "\n%d개를 구매했습니다.";

    public static void printUserLottos(Lottos lottos, Budget budget) {
        printCountOfUserLottos(budget);
        printLottoNumbers(lottos);
    }

    private static void printLottoNumbers(Lottos lottos){
        for(Lotto lotto : lottos.getLottos()){
            printEachLottoNumbers(lotto);
        }
    }

    private static void printEachLottoNumbers(Lotto lotto){
        System.out.println("[" + lotto.toString() + "]");
    }

    private static void printCountOfUserLottos(Budget budget){
        System.out.println(String.format(COUNT_OF_USER_LOTTOS_MESSAGE, budget.getCountOfLottoLines()));
    }

    public static void printWinningStaticstics(WinningStatistics winningStatistics){

    }
}
