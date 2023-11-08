package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.Rank;

public class OutputView {
    public void showLottoNum(int num, List<Lotto> lottoGames) {
        System.out.println("\n" + num + "개를 구매했습니다.");
        for (int i = 0; i < lottoGames.size(); i++) {
            Lotto lotto = lottoGames.get(i);
            List<Integer> numbers = lotto.getLottoNumber();
            System.out.println(numbers);
        }
    }

    public void showLottoGameResult(int count, String lottoPrize, int lottoNum) {
        System.out.println(count + "개 일치 (" + lottoPrize + "원) - " + lottoNum + "개");
    }

    public void showProfitResult(double profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }

    public void showBonusResult(int count, String lottoPrize, int lottoNum) {
        System.out.println(count + "개 일치, 보너스 볼 일치 (" + lottoPrize + "원) - " + lottoNum + "개");
    }

    public void resultStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
