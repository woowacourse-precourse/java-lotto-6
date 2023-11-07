package Model;

import Controller.ModelHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Domain {
    public static final int LOTTO_PRICE = 1000;
    private final Service SERVICE = Service.getInstance();
    private final List<Integer> lottoWinningNumber = SERVICE.lottoGenerator();
    private List<Lotto> myLotto;
    private List<Integer> duplicatedNumberCount;
    private List<Integer> winningRanking;
    private int bonusNumber;
    private int price;
    private int winnings;
    private double revenueRate;

    private Domain() {
        myLotto = new ArrayList<>();
        duplicatedNumberCount = new ArrayList<>();
        winningRanking = new ArrayList<>();
        bonusNumber = 0;
        price = 0;
        winnings = 0;
        revenueRate = 0;
    }

    private class Singleton {
        private static final Domain INSTANCE = new Domain();
    }

    public static Domain getInstance() {
        return Singleton.INSTANCE;
    }

    public void setWinningRanking() {}

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void sumWinnings() {
        for (var Ranking : winningRanking) {
            if (Ranking != 0) {
                winnings += SERVICE.getMyWinning(Ranking);
            }
        }
    }

    public void setRevenueRate() {
        revenueRate = winnings / price;
    }

    //로또 당첨 횟수 = 총 myLotto 사이즈 만큼 나옴
    public void compareNumbers() {
        for (var e : myLotto) {
            duplicatedNumberCount.add(numberFrequencyCount(e.getNumbers()));
        }
    }

    private int numberFrequencyCount(List<Integer> list) {
        Set<Integer> set = new HashSet<>(lottoWinningNumber);
        return (int) list.stream()
                .filter(set::contains)
                .count();
    }

    //중복된 숫자 만큼 등수 계산
    public void calWinningsRank() {

    }
}
