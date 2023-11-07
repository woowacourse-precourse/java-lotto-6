package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;

public class OutputView {
    //발행된 로또 번호 출력
    public static void IssuedLottoNumbers(int amount, List<Lotto> lottos) {
        System.out.println("\n" + amount / 1000 + "개를 구입했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    //당첨 내역 출력
    public static void LottoResults(List<LottoResult> lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for(LottoResult lottoResult : lottoResults){
            
        }
    }

    //총 수익률 출력
}
