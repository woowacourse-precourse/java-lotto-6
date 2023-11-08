package lotto;

import java.util.Collections;
import java.util.List;

import lotto.LottoEnum.Prize;

public class OutputManagaer {
    public void outputMessageInputBudget() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void outputOwnNumbers(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers.toString());
        }
    }

    public void outputMessageInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void outputResult(List<Prize> lottoResults,int totalReward) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", Collections.frequency(lottoResults, LottoEnum.Prize.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개\n", Collections.frequency(lottoResults, LottoEnum.Prize.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", Collections.frequency(lottoResults, LottoEnum.Prize.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", Collections.frequency(lottoResults, LottoEnum.Prize.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", Collections.frequency(lottoResults, LottoEnum.Prize.FIRST));
        System.out.printf("총 수익률은 %f.1 %%입니다.\n", (((float)totalReward) / 1000 / lottoResults.size() * 100));
    }
}