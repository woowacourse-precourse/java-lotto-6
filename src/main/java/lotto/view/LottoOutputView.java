package lotto.view;

import lotto.Lotto;

import java.util.List;

public class LottoOutputView {

    public LottoOutputView() {
    }

    public void presentLottoList(List<Lotto> lottos) {
        System.out.println("8개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }
}
