package lotto.service;
import java.util.*;
import java.util.function.Predicate;
import lotto.domain.UserLotto;

public class ConsistencyService {
    private static List<Integer> totalConsistency = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
    private static int bonusConsistency = 0;
    private static int rateMoney;
    private static int capital;
    private static long rateOfReturn;
    private static List<Integer> moneyList = new ArrayList<>(Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000));
    private static UserLotto userLotto;
    public ConsistencyService(int capital, UserLotto userLotto){
        this.capital = capital;
        this.userLotto = userLotto;
    }
    public List<Integer> winnerGraph(List<List<Integer>> numList){
        numList.stream().forEach(list->{
            bonusConsistency = 0;
            int lottoCount = getLottoConsistency(list);
            if(isContains(list)){
                bonusConsistency = 1;
            }

            if(lottoCount >= 3){
                setTotalConsistency(lottoCount);
            }

        });
        return totalConsistency;
    }

    private static void setTotalConsistency(int lottoCount) {
        if(lottoCount-3 == 2 && bonusConsistency == 1){
            totalConsistency.set(3, totalConsistency.get(3)+1);
            return;
        }
        if(lottoCount-3 == 2 && bonusConsistency == 0){
            totalConsistency.set(lottoCount -3, totalConsistency.get(lottoCount -3)+1);
            return;
        }
        if(lottoCount-3 == 3){
            totalConsistency.set(4, totalConsistency.get(4)+1);
            return;
        }
        totalConsistency.set(lottoCount-3, totalConsistency.get(lottoCount-3)+1);
    }

    private int getLottoConsistency(List<Integer> list) {
        return (int) list.stream()
                .filter(lotto ->
                    userLotto.getLotto().getUserNumbers().stream().anyMatch(Predicate.isEqual(lotto)))
                .count();

    }

    private boolean isContains(List<Integer> list) {
        return list.contains(userLotto.getBonusLotto().getBonusNumber());
    }

    public void setRateMoney(){
        for(int i=0;i<5;i++){
            rateMoney += moneyList.get(i)*totalConsistency.get(i);
        }
    }

    public double getRateOfReturn(){
        return ((double) rateMoney/capital)*100;
    }

}
