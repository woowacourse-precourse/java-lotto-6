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

    // 수익률 계산
    public double calculateProfitRate() {
        if(paidAmount == 0) {
            throw new ArithmeticException("투입금액이 0원입니다. 수익률을 계산할 수 없습니다.");
        }
        double totalPrize = calculateTotalPrice(); //총 상금
        double profitRate = (totalPrize / paidAmount) * 100;

        return roundToTwoDecimalPlaces(profitRate);
    }

    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100) / 100.0;
    }

    private double calculateTotalPrice() {
        return lottoResults.stream()
                .mapToDouble(LottoResult::getPrice)
                .sum();
    }
}
