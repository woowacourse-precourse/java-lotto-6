package Model;

import Controller.ModelHandler;
import View.ViewString;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Domain {
    private final ModelHandler MODEL = ModelHandler.getInstance();
    private final Service SERVICE = Service.getInstance();
    private final List<Integer> LOTTO_WINNING_NUMBER = MODEL.setWinningNumber();
    public static final int LOTTO_PRICE = 1000;

    private List<Lotto> myLotto;
    private List<Integer> duplicatedNumberCount;
    private List<Integer> winningRanking;
    private List<Boolean> duplicatedBonusNumber;
    private int bonusNumber;
    private int lottoNum;
    private int winnings;
    private int price;
    private double revenueRate;

    private Domain() {
        myLotto = new ArrayList<>();
        duplicatedNumberCount = new ArrayList<>();
        duplicatedBonusNumber = new ArrayList<>();
        winningRanking = new ArrayList<>();
        bonusNumber = 0;
        lottoNum = 0;
        winnings = 0;
        price = 0;
        revenueRate = 0;
    }

    private class Singleton {
        private static final Domain INSTANCE = new Domain();
    }

    public static Domain getInstance() {
        return Singleton.INSTANCE;
    }

    public void setBonusNumber(int number) {
        this.bonusNumber = number;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setLottoNum() {
        lottoNum = price / LOTTO_PRICE;
    }

    public void setWinningRanking() {
        for (int i = 0; i < duplicatedNumberCount.size(); i++) {
            int rank = SERVICE.calWinningsRank(duplicatedNumberCount.get(i), duplicatedBonusNumber.get(i));
            winningRanking.add(rank);
        }
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

    public void setMyLotto() {
        for(int i = 0; i < lottoNum; i++) {
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
            if (number == bonusNumber) {
                return true;
            }
        }
        return false;
    }

    public void printMyLotto() {
        System.out.println(myLotto.size() + "개를 구매했습니다.");

        for (var lotto : myLotto) {
            String printLottoLine = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.println("[" + printLottoLine + "]");
        }
    }

    public void printStatistics() {
        if(duplicatedNumberCount.size() != ViewString.values().length) {
            throw new IllegalArgumentException();
        }

        System.out.println("당첨 통계");
        System.out.println("---");

        for(int i = 0; i < duplicatedNumberCount.size(); i++) {
            System.out.println(ViewString.values()[i] +
                    Integer.toString(duplicatedNumberCount.get(i)) + "개");
        }
    }
}
