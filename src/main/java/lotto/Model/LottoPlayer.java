package lotto.Model;

import java.util.ArrayList;

public class LottoPlayer {

        private Integer currentAmount, spentAmount, earnedAmount;
        private ArrayList<Lotto> ownedLottos;
        public LottoPlayer(Integer insertData){
            CacheValidator.validateCache(insertData);
            this.currentAmount=insertData;
            this.spentAmount=0;
            this.earnedAmount=0;
        }

        public Integer orderLottos(){
            Integer purchaseQuantity = currentAmount/1000;
            payMoney(currentAmount);
            return purchaseQuantity;
        }

        private void payMoney(Integer cache){
            if( cache <= currentAmount ) {
                currentAmount -= cache;
                spentAmount+=cache;
            }
        }




}
