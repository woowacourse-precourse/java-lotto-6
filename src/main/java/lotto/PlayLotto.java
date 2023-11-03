package lotto;

public class PlayLotto {
    public void start(){
        int Chance = LottoIssue();
    }
    public int LottoIssue(){
        LottoInput lottoInput = new LottoInput();
        int lottoMoney = lottoInput.getLottoPrice();
        LottoPrice lottoPrice = new LottoPrice(lottoMoney);
        return lottoPrice.makeReturnNum();
    }
}
