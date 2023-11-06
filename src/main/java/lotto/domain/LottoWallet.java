package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoWallet {

    private int paidAmount; // 사용한 금액
    private List<Lotto> lottos;
    private List<LottoResult> lottoResults;

    public LottoWallet(int paidAmount) {
        this.paidAmount = paidAmount;
        this.lottos = new ArrayList<>();
        this.lottoResults = new ArrayList<>();
    }

    public int getPaid() {
        return paidAmount;
    }

    // 로또 티켓 추가
    public void addLotto(Lotto ticket) {
        lottos.add(ticket);
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void addLottoResult(LottoResult lottoResult) {
        lottoResults.add(lottoResult);
    }

    // 로또 결과 저장
    public void setLottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = new ArrayList<>(lottoResults);
    }

    public List<LottoResult> getLottoResults() {
        return lottoResults;
    }

}
