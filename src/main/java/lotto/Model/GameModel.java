package lotto.Model;
public class GameModel {
    private LottoPlayer lottoPlayer;

    public void lottoIssuance(Integer insertData){
        lottoPlayer = new LottoPlayer(insertData);
        Integer purchaseQuanity = lottoPlayer.orderLottos();
    }
}
