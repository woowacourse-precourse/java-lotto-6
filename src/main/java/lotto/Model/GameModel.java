package lotto.Model;

import java.util.ArrayList;
import lotto.Model.VO.LottoData;

public class GameModel {
    private LottoPlayer lottoPlayer;
    private LottoHost lottoHost;


    public void initGameModel(Integer insertData){
        lottoPlayer = new LottoPlayer(insertData);
        lottoHost = new LottoHost();
    }

    public void lottoIssuance(){
        Integer purchaseQuanity = lottoPlayer.orderLottos();
        giveLottos(purchaseQuanity);
    }

    private void giveLottos(Integer quanity){
        for(int i=0;i<quanity;i++){
            Lotto lotto = lottoHost.generateLotto();
            lottoPlayer.receiveLotto(lotto);
        }
    }

    public ArrayList<LottoData> transferPlayerLottoDatas(){
        return lottoPlayer.getLottoDatas();
    }
}
