package lotto.view;

import lotto.Lotto;
import lotto.LottoResult;

import java.util.List;

public class LottoOutputView {

    public LottoOutputView() {
    }

    public void presentLottoList(List<Lotto> lottos) {
        System.out.println();
        System.out.println("8개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }

    public void presentLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계\n---\n");
        System.out.println(lottoResult);
    }
}
