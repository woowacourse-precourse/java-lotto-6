package OutputManager;

import java.util.List;
import lotto.Lotto;
import lotto.LottoStatistics;

public class OutputManager {
    public static void printLottoData(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static void printTotalResult(LottoStatistics totalResult) {
        System.out.println(totalResult);
    }
}
