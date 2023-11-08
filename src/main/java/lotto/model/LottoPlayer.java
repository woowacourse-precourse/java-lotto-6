package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoPlayer {
    private static final int LOTTO_PRICE = 1000;
    private int initialAmount;
    private int lottoCount;
    private List<Lotto> lottoList = new ArrayList<>();

    public LottoPlayer(int initialAmount) {
        this.initialAmount = initialAmount;
        this.lottoCount = initialAmount / LOTTO_PRICE;
    }

    public void lottoGeneration(List<Integer> lottoNumbers) {
        lottoList.add(new Lotto(lottoNumbers));
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
