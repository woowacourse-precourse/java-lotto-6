package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGame {
    private final List<Lotto> lottos = new ArrayList<>();
    private final List<Integer> winningNumber;
    private final int bonusNumber;
    private final int money;
    private static final int LOTTO_PRICE = 1000;

    public LottoGame() {
        money = User.getMoney();
        publishLottos(money);
        this.winningNumber = User.getWinningNumber();
        this.bonusNumber = User.getBonusNumber(winningNumber);
        checkLottos();
    }

    private void publishLottos(int money){
        int amount = money / LOTTO_PRICE;
        for (int i = 0; i < amount; i++){
            Lotto lotto = new Lotto(pickUniqueNumbers());
            lottos.add(lotto);
        }
        User.printLottos(amount, lottos);
    }

    private List<Integer> pickUniqueNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    private void checkLottos(){
        Map<Rank, Integer> result = setResult();
        for (Lotto lotto:lottos){
            Rank rank = Rank.checkLotto(lotto, winningNumber, bonusNumber);
            result.put(rank, result.get(rank) + 1);
        }
        User.printResult(result);
        double rateOfReturn = checkRateOfReturn(result);
        User.printRateOfReturn(rateOfReturn);
    }

    private Map<Rank, Integer> setResult() {
        Map<Rank, Integer> result = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    private double checkRateOfReturn(Map<Rank, Integer> result){
        double revenue = checkRevenue(result);
        return revenue / money * 100;
    }

    private int checkRevenue(Map<Rank, Integer> result){
        int revenue = 0;
        for (Rank rank : Rank.values()) {
            revenue += rank.getPrize() * result.get(rank);
        }
        return revenue;
    }
}
