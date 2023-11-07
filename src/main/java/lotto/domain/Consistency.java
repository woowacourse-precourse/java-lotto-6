package lotto.domain;
import java.util.*;
import java.util.function.Predicate;

public class Consistency {
    private static int lottoConsistency;
    private static int bonusConsistency = 0;
    private static int rateMoney;
    private static int capital;
    private static long rateOfReturn;
    private static List<Integer> moneyList = new ArrayList<>(Arrays.asList(50000, 1500000, 30000000, 2000000000));
    private static UserLotto userLotto;
    public Consistency(int capital, UserLotto userLotto){
        this.capital = capital;
        this.userLotto = userLotto;
    }
    public void winnerGraph(List<List<Integer>> numList){
        numList.stream().forEach(list->{
            setLottoConsistency(list);
            if(isContains(list)){
                bonusConsistency = 1;
            }

        });
    }

    private void setLottoConsistency(List<Integer> list) {
        lottoConsistency = (int) Math.max(list.stream().filter(lotto->userLotto.getLotto().getUserNumbers().stream().anyMatch(Predicate.isEqual(lotto))).count(), lottoConsistency);
    }

    private boolean isContains(List<Integer> list) {
        return list.contains(userLotto.getBonusLotto().getBonusNumber());
    }

    public void setRateMoney(){
        if(lottoConsistency == 3){
            rateMoney = moneyList.get(0);
        }
        if(lottoConsistency == 4){
            rateMoney = moneyList.get(1);
        }
        if(lottoConsistency == 5 && bonusConsistency == 0){
            rateMoney = moneyList.get(2);
        }
        if(lottoConsistency == 5 && bonusConsistency == 1){
            rateMoney = moneyList.get(3);
        }
        if(lottoConsistency == 6){
            rateMoney = moneyList.get(4);
        }
    }

    public void setRateOfReturn(){
        rateOfReturn = ((long) rateMoney/capital)*100;
    }

    public long getRateOfReturn(){
        return rateOfReturn;
    }


}
