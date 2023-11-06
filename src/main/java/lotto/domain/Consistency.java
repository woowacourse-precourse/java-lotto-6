package lotto.domain;
import java.util.*;
import java.util.function.Predicate;

public class Consistency {
    private static int lottoConsistency;
    private static int bonusConsistency = 0;
    private static int rateMoney;
    private static int capital;
    private static long rateOfReturn;
    private static List<Integer> moneyList = new ArrayList<>();
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

    private static void setLottoConsistency(List<Integer> list) {
        lottoConsistency = (int) Math.max(list.stream().filter(lotto->userLotto.getLotto().getUserNumbers().stream().anyMatch(Predicate.isEqual(lotto))).count(), lottoConsistency);
    }

    private static boolean isContains(List<Integer> list) {
        return list.contains(userLotto.getBonusLotto().getBonusNumber());
    }

    private List<Integer> setMoneyList(){
        moneyList.add(5000, 50000, 1500000, 30000000, 2000000000);
    }
}
