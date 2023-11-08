package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoPlayer {
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE = 100;
    private int initialAmount;
    private int lottoCount;
    private List<Lotto> lottoList = new ArrayList<>();

    public LottoPlayer(int initialAmount) {
        this.initialAmount = initialAmount;
        this.lottoCount = calculateLottoCount(initialAmount);
    }

    private int calculateLottoCount(int initialAmount) {
        return initialAmount / LOTTO_PRICE;
    }

    public void lottoGeneration(List<Integer> lottoNumbers) {
        lottoList.add(new Lotto(lottoNumbers));
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public double computeRateOfReturn(int income) {
        return (double) PERCENTAGE * income / initialAmount;
    }

    public List<Integer> getLottoNumberByIndex(int index) {
        return lottoList.get(index).getNumbers();
    }
}
