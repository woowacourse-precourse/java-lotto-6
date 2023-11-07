package lotto.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Model.VO.LottoData;

public class LottoPlayer {

        private Integer spentAmount, earnedAmount;
        private ArrayList<Lotto> ownedLottos;
        public LottoPlayer(Integer insertData){
            CacheValidator.validateCache(insertData);
            this.ownedLottos = new ArrayList<>();
            this.spentAmount=insertData;
            this.earnedAmount=0;
        }

        public Integer orderLottos(){
            Integer purchaseQuantity = spentAmount/1000;
            return purchaseQuantity;
        }

        public void receiveLotto(Lotto lotto){
            ownedLottos.add(lotto);
        }


        public ArrayList<LottoData> getLottoDatas(){
            ArrayList<LottoData> playerLottoDatas = ownedLottos.stream()
                    .map(Lotto::getData)
                    .collect(Collectors.toCollection(ArrayList::new));
            return playerLottoDatas;
        }

        public ScoreBoard calculateScore(LottoData answerLotto,Integer bonusNumber){
            ScoreBoard roundScore = new ScoreBoard();
            List<Integer> answerNumbers = answerLotto.getNumbers();
            for (Lotto lotto : ownedLottos) {
                Prize prize = lotto.calculatePrize(answerNumbers,bonusNumber);
                getReward(prize);
                roundScore.recordScore(prize);
            }

            return roundScore;
        }

        public double getEarnRate(){
            return (spentAmount / earnedAmount) * 100;
        }
        private void getReward(Prize prize) {
            earnedAmount += prize.getReward();
        }




}
