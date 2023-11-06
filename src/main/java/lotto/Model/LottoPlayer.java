package lotto.Model;

import java.util.ArrayList;

public class LottoPlayer {

        private Integer currentAmount, spentAmount, earnedAmount;
        private ArrayList<Lotto> ownedLottos;
        public LottoPlayer(Integer insertData){
            CacheValidator.exceptCache(insertData);
            this.currentAmount=insertData;
        }


}
