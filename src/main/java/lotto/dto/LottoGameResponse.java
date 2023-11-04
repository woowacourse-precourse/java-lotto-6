package lotto.dto;

import java.util.List;

public class LottoGameResponse {
    private int count;
    private List<List<Integer>> buyLottoNumbers;

    public LottoGameResponse(int count, List<List<Integer>> buyLottoNumbers) {
        this.count = count;
        this.buyLottoNumbers = buyLottoNumbers;
    }

    public int getCount() {
        return count;
    }

    public List<List<Integer>> getBuyLottoNumbers() {
        return buyLottoNumbers;
    }
}
