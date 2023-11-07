package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {
    public void printLottoCnt(int lottoCnt) {
        System.out.println();
        System.out.println(lottoCnt + "개를 구매했습니다.");
    }

    public void printLotto(List<Lotto> list) {
        for (Lotto lotto : list) {
            List<Integer> numbers = new ArrayList<Integer>();
            numbers.addAll(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
            //lotto.getNumbers()
        }
    }

    public void printLottoResultHead() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printLottoResultBody(String msg, int matchAmount) {
        System.out.println(msg + matchAmount + "개");
    }

    public void printLottoResultTail(double rateOfReturn) {
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }
}
