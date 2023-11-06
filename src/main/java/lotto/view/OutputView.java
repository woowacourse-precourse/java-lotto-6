package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.LottoStatistics;

public class OutputView {
    public void printLottoNumbers(List<Lotto> myLotto){
        System.out.println(myLotto.size() + "개를 구매했습니다.");

        for(Lotto lotto : myLotto){
            System.out.println(lotto);
        }
    }

    public void printLottoStatistics(LottoStatistics lottoStatistics){
        System.out.println("당첨통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + lottoStatistics.firstCount());
        System.out.println("4개 일치 (50,000원) - " + lottoStatistics.secondCount());
        System.out.println("5개 일치 (1,500,000원) - " + lottoStatistics.thirdCount());
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoStatistics.forthCount());
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoStatistics.fifthCount());

        System.out.println("총 수익률은 " + lottoStatistics.returnRate() + "% 입니다.");
    }
}
