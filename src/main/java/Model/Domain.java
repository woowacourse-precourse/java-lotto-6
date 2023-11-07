package Model;

import Controller.ModelHandler;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Domain {
    public static final int LOTTO_PRICE = 1000;
    private final Service SERVICE = Service.getInstance();
    private final List<Integer> lottoWinningNumber = SERVICE.lottoGenerator();
    private List<Lotto> myLotto;
    private List<Integer> correctNumberCount;
    private List<Integer> winningRanking;
    private int bonusNumber;
    private int price;
    private int winnings;
    private double revenueRate;

    private Domain() {
    }

    private class Singleton {
        private static final Domain INSTANCE = new Domain();
    }

    public static Domain getInstance() {
        return Singleton.INSTANCE;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void compareNumbers() {
        for (var e : myLotto) {
            correctNumberCount.add(numberFrequencyCount(e.getNumbers()));
        }
    }

    public int numberFrequencyCount(List<Integer> list) {
        Set<Integer> set = new HashSet<>(lottoWinningNumber);
        return (int) list.stream()
                .filter(set::contains)
                .count();
    }

    public void setRevenueRate() {
        revenueRate = winnings / price;
    }

    public void sumWinningPrice() {
        for (var Ranking : winningRanking) {
            if (Ranking != 0) {
                winnings += SERVICE.getMyWinning(Ranking);
            }
        }
    }
}
