package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.view.LottoUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoGame {

    private final static int LOTTO_PRICE = 1000;
    private final int purchaseAmount;

    public LottoGame(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void play() {
        int lottoCnt = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = getRandomLottos(lottoCnt);
        LottoUI.printRandomLottos(lottos, lottoCnt);
    }

    private static List<Lotto> getRandomLottos(int lottoCnt) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<lottoCnt;i++){
            lottos.add(Lotto.generateRandomLotto());
        }
        return lottos;
    }
}
