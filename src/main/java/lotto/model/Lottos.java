package lotto.model;

import lotto.exception.ErrorMessage;
import lotto.Result;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;
    private final int purchaseAmount;
    private final int count;

    public Lottos(int purchaseAmount){
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.count = purchaseAmount/1000;
        List<Lotto> createLotte = new ArrayList<>();
        for(int i = 0;i<count;i++){
            createLotte.add(new Lotto(new RandomNumberGenerator().getRandomNumbers()));
        }
        this.lottos = createLotte;
    }

    public int getCount() {
        return count;
    }

    public boolean validatePurchaseAmount(int purchaseAmount) throws IllegalArgumentException{
        if(purchaseAmount%1000==0&&purchaseAmount!=0) return true;
        throw new IllegalArgumentException(ErrorMessage.INCORRECT_AMOUNT.getMessage());
    }

    public void checkRank(List<Integer> winningNumber, int bonusNumber){
        for(int i = 0;i<count;i++){
            int match = lottos.get(i).matchNumber(winningNumber);
            if(match==6){
                Result.MATCH_SIX.increaseCount();
            }else if(match==5&&lottos.get(i).matchBonusNumber(bonusNumber)){
                Result.MATCH_FIVE_AND_BONUS.increaseCount();
            }else if(match==5){
                Result.MATCH_FIVE.increaseCount();
            }else if(match==4){
                Result.MATCH_FOUR.increaseCount();
            }else if(match==3){
                Result.MATCH_THREE.increaseCount();
            }
        }
    }
    public double calculateProfit(){
        double total = Result.MATCH_SIX.getAmount()*Result.MATCH_SIX.getCount()+
                     Result.MATCH_FIVE_AND_BONUS.getAmount()*Result.MATCH_FIVE_AND_BONUS.getCount()+
                     Result.MATCH_FIVE.getAmount()*Result.MATCH_FIVE.getCount()+
                     Result.MATCH_FOUR.getAmount()*Result.MATCH_FOUR.getCount()+
                     Result.MATCH_THREE.getAmount()*Result.MATCH_THREE.getCount();
        return Math.round(total/(double)purchaseAmount*10000)/100.0;
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
