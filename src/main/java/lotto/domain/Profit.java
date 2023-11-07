package lotto.domain;

public record Profit(Money money, LottoResult lottoResult) {

    public double getProfitRate() {
        return (lottoResult.getTotalPrize() / money().amount()) * 100;
    }
}
