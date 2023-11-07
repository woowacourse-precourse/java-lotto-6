package lotto.model;

import java.util.List;

public class LottoGame {

    private List<List<Integer>> purchaseLottoNumbers;
    private int lottoCount;
    private float profitRate;

    public List<List<Integer>> getPurchaseLottoNumbers() {
        return purchaseLottoNumbers;
    }

    public void setPurchaseLottoNumbers(List<List<Integer>> purchaseLottoNumbers) {
        this.purchaseLottoNumbers = purchaseLottoNumbers;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public void setLottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public float getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(float profitRate) {
        this.profitRate = profitRate;
    }
}
