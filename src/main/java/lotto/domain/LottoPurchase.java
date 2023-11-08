package lotto.domain;

import java.util.ArrayList;
import java.util.List;

// LottoPurchase : 로또 구매 기능 구현
// ### ☑️ 로또 구매 개수 계산 기능
// - 사용자가 몇 장의 로또를 구매했는지 계산한다.

import lotto.util.RandomNumberUtil;

import lotto.constant.LottoNumber;

public class LottoPurchase {

    private List<Lotto> lottos = new ArrayList<>();

    private int lottoCount;
    
    public void calculateLottoCount(int money) {
        lottoCount = money / LottoNumber.PURCHASE__PRICE.getNumber();
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public void createLottos() {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(RandomNumberUtil.getRandomNumbers()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
