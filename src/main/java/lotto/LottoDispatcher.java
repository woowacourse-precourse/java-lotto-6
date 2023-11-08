package lotto;

public class LottoDispatcher {
    Lotto lotto;
    LottoTable lottoTable;
    int luckNumber;

    public LottoDispatcher(Lotto lotto, LottoTable lottoTable, int luckNumber) {
        this.lotto = lotto;
        this.lottoTable = lottoTable;
        this.luckNumber = luckNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoTable getLottoTable() {
        return lottoTable;
    }

    public int getLuckNumber() {
        return luckNumber;
    }
}