package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final String OUTPUT_LOTTO_AMOUNT = "개를 구매했습니다.";

    private static final String OUTPUT_WINNING_STATISITCS = "당첨 통계";

    public static void outputLottoAmountMessage(int amount){
        System.out.println();
        System.out.println(amount+OUTPUT_LOTTO_AMOUNT);
    }

    public static void outputSortingLottoNumber(List<Integer> number){
        System.out.println(number.toString());
    }

    public static void outputWinningStatisitcs(){
        System.out.println('\n'+OUTPUT_WINNING_STATISITCS);
    }
}
