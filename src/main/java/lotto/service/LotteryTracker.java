package lotto.service;

import static lotto.settings.WinningAmount.FIFTH;
import static lotto.settings.WinningAmount.FIRST;
import static lotto.settings.WinningAmount.FOURTH;
import static lotto.settings.WinningAmount.SECOND;
import static lotto.settings.WinningAmount.THIRD;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.repository.BuyLottoRepository;
import lotto.repository.RankingRepository;
import lotto.repository.WinningLottoRepository;
import lotto.settings.WinningAmount;
import lotto.view.View;

public class LotteryTracker {

    Map<Integer, Integer> numberPerRank = new HashMap<>();

    private LotteryTracker() {
        int size = WinningAmount.size(); // 몇등까지 있는지
        for(int i = 1; i<= size; i++){
            numberPerRank.put(i,0);
        }
    }

    public static LotteryTracker create(){
        RankingRepository.create();
        return new LotteryTracker();
    }

    public int countLottoIn(int rank){
        return numberPerRank.get(rank);
    }

    public void matching(BuyLottoRepository buyLottos, WinningLottoRepository winningLotto) {
        int correctNum =0;
        int bonusNum = winningLotto.getBonusNumber();

        for (Lotto buyLotto : buyLottos.getLotto()) {
            correctNum = winningLotto.countMatchingNumber(buyLotto);
            increaseNumberPerRank(correctNum,buyLotto,bonusNum);
        }
    }
    public void increaseNumberPerRank(int cnt, Lotto buyLotto, int bonusNum){
        int rank = buyLotto.findRank(cnt, bonusNum);
        numberPerRank.merge(rank, 1, Integer::sum);
    }

    public void printResult() {
        //등수별 결과 출력
        for(int rank=5; rank>0;rank--){
            String prize = RankingRepository.getPrizeBy(rank);
            View.result(prize, countLottoIn(rank));
        }
    }

    public double calculateTotalRevenue() {
        int totalRevenue =0;
        int[] ranks = {0,FIRST.getIntPrize(),SECOND.getIntPrize(),THIRD.getIntPrize(),FOURTH.getIntPrize(),FIFTH.getIntPrize()};
        for(int rank=5; rank>0;rank--){
            totalRevenue += numberPerRank.get(rank) * ranks[rank];
        }

        for(int rank=5; rank>0;rank--){
            if(rank==5){
                totalRevenue += numberPerRank.get(rank) * FIFTH.getIntPrize();
            }
            else if(rank==4){
                totalRevenue += numberPerRank.get(rank)*FOURTH.getIntPrize();
            }
            else if(rank==3){
                totalRevenue +=  numberPerRank.get(rank)*THIRD.getIntPrize();
            }
            else if(rank==2){
                totalRevenue +=  numberPerRank.get(rank)*SECOND.getIntPrize();
            }
            else if(rank==1){
                totalRevenue +=  numberPerRank.get(rank)*FIRST.getIntPrize();
            }
        }
        return totalRevenue;
    }
}
