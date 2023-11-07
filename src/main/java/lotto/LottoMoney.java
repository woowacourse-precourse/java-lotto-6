package lotto;

public class LottoMoney {
    private double lottoMoney;
    private int lottoTiket;

    public LottoMoney(String inputMoney) {
        int lottoMoney = Integer.valueOf(inputMoney);
        this.lottoMoney = lottoMoney;
        this.lottoTiket = lottoMoney / 1000;
    }
}
