package lotto.model;

import java.util.List;

public class LottoTicket {
    private List<Lotto> lotto;
    private int lottoCount;
    private int totalPurchaseAmount;

    private LottoTicket() {
    }

    private LottoTicket(List<Lotto> lotto, int lottoCount, int totalPurchaseAmount) {
        this.lotto = lotto;
        this.lottoCount = lottoCount;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public static LottoTicket of(List<Lotto> lotto, int lottoCount, int totalPurchaseAmount) {
        return new LottoTicket(lotto, lottoCount, totalPurchaseAmount);
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<String> getLottoNumbers() {
        return lotto.stream().map(Lotto::toString).toList();
    }
}
