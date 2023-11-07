package Model;

import Controller.ModelHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Domain {
    private final ModelHandler MODEL = ModelHandler.getInstance();
    private final Service SERVICE = Service.getInstance();
    private final List<Integer> LOTTO_WINNING_NUMBER = MODEL.setInputWinningNumber();

    public static final int LOTTO_PRICE = 1000;
    private final int BONUS_NUMBER = MODEL.setBonusNumber();
    private final int PRICE = MODEL.setPrice();
    private final int LOTTO_NUM = PRICE / LOTTO_PRICE;

    private List<Lotto> myLotto;
    private List<Integer> duplicatedNumberCount;
    private List<Integer> winningRanking;
    private List<Boolean> duplicatedBonusNumber;
    private int winnings;
    private double revenueRate;

    private Domain() {
        myLotto = new ArrayList<>();
        duplicatedNumberCount = new ArrayList<>();
        duplicatedBonusNumber = new ArrayList<>();
        winningRanking = new ArrayList<>();
        winnings = 0;
        revenueRate = 0;
    }

    private class Singleton {
        private static final Domain INSTANCE = new Domain();
    }

    public static Domain getInstance() {
        return Singleton.INSTANCE;
    }

    private void setWinningRanking() {
        for (int i = 0; i < duplicatedNumberCount.size(); i++) {
            int rank = SERVICE.calWinningsRank(duplicatedNumberCount.get(i), duplicatedBonusNumber.get(i));
            winningRanking.add(rank);
        }
    }

    private void sumWinnings() {
        for (var Ranking : winningRanking) {
            if (Ranking != 0) {
                winnings += SERVICE.getMyWinning(Ranking);
            }
        }
    }

    private void setRevenueRate() {
        revenueRate = winnings / PRICE;
    }

    private void setMyLotto() {
        for(int i = 0; i < LOTTO_NUM; i++) {
            myLotto.add(new Lotto(SERVICE.lottoGenerator()));
        }
    }

    //로또 당첨 횟수 = 총 myLotto 사이즈 만큼 나옴
    public void compareNumbers() {
        for (var e : myLotto) {
            duplicatedBonusNumber.add(bonusNumberDuplicateCount(e.getNumbers()));
            duplicatedNumberCount.add(numberDuplicateCount(e.getNumbers()));
        }
    }

    private int numberDuplicateCount(List<Integer> list) {
        Set<Integer> set = new HashSet<>(LOTTO_WINNING_NUMBER);

        return (int) list.stream()
                .filter(set::contains)
                .count();
    }

    private boolean bonusNumberDuplicateCount(List<Integer> list) {
        for (int number : list) {
            if (number == BONUS_NUMBER) {
                return true;
            }
        }
        return false;
    }
}
