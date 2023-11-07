package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.Constants.INVALID_MONEY_FORMAT;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printBuyLottoCount(int total, List<Lotto> lottoList){
        System.out.println();
        System.out.println(total + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printGradeResult(String gradeComment, int count){
        System.out.println(gradeComment + count + "개");
    }

    public void printRateOfReturn(String rateOfReturn){
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
