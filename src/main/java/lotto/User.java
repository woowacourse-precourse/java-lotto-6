package lotto;

import java.util.List;

public class User {

    private int totalReturn = 0;
    private List<Lotto> lottoList;

    public int getTotalReturn() {
        return totalReturn;
    }

    public void setTotalReturn(int totalReturn) {
        this.totalReturn = totalReturn;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void setLottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }
}
