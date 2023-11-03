package lotto.view;

import lotto.model.Lotto;
import lotto.model.Result;

import java.util.List;

//TODO: 인터페이스를 사용하기 (현재는 파라미터에 어떤 값을 넣을지 정하지 못하였다)
public class OutputView {

    public void printBoughtLotto(List<Lotto> boughtLotto) {
        System.out.printf("%s개를 구매했습니다.%s", boughtLotto.size(), System.lineSeparator());
        for (Lotto lotto : boughtLotto) {
            System.out.println(lotto.toString());
        }
    }

    public void printWinningStatistics(Result result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        result.print();
    }

    public void printTotalReturn(Double totalReturn) {
        System.out.printf("총 수익률은 %s%%입니다.", String.format("%.1f", totalReturn * 100));
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
