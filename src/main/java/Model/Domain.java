package Model;

import View.ViewString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Domain {
    private final Service SERVICE = Service.getInstance();
    public static final int LOTTO_PRICE = 1000;

    private List<Lotto> myLotto = new ArrayList<>();
    private List<Integer> lottoWinningNumber;
    private List<Integer> duplicatedNumberCount = new ArrayList<>();
    private List<Integer> winningRanking = new ArrayList<>();
    private List<Boolean> duplicatedBonusNumber = new ArrayList<>();
    private int bonusNumber;
    private int lottoNum;
    private int winnings;
    private int price;
    private double revenueRate;

    private Domain() {
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
        for (int i = 0; i < myLotto.size(); i++) {
            int rank = SERVICE.calWinningsRank(duplicatedNumberCount.get(i), duplicatedBonusNumber.get(i));
            winningRanking.add(rank);
        }
    }

    public void setLottoWinningNumber(String winnerNumber) {
        this.lottoWinningNumber = SERVICE.makeLotto(winnerNumber);
    }

    public void setMyLotto() {
        for(int i = 0; i < lottoNum; i++) {
            myLotto.add(new Lotto(SERVICE.lottoGenerator()));
        }
    }

    //로또 당첨 횟수 = 총 myLotto 사이즈 만큼 나옴
    public void compareNumbers() {
        for (var e : myLotto) {
            duplicatedBonusNumber.add(isBonusNumberDuplicated(e.getNumbers()));
            duplicatedNumberCount.add(countNumberDuplicates(e.getNumbers()));
        }
    }

    public void calculateWinnings() {
        winnings = winningRanking.stream()
                .filter(ranking -> ranking != 0)
                .mapToInt(SERVICE::getMyWinning)
                .sum();
    }

    public void calculateRevenueRate() {
        revenueRate = Math.round((double) winnings / price * 1000) / 10.0;
    }

    private int countNumberDuplicates(List<Integer> list) {
        Set<Integer> winningNumberSet = new HashSet<>(lottoWinningNumber);
        return (int) list.stream().filter(winningNumberSet::contains).count();
    }

    private boolean isBonusNumberDuplicated(List<Integer> list) {
        return list.contains(bonusNumber);
    }

    public void printMyLotto() {
        System.out.println(lottoNum + "개를 구매했습니다.");
        myLotto.forEach(lotto ->
                System.out.println("[" + formatLottoNumbers(lotto.getNumbers()) + "]")
        );
    }

    private String formatLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public Map<Integer, Long> calculateStatistics() {
        Map<Integer, Long> statistics = new HashMap<>();
        statistics.put(1, 0L); // 6개 일치
        statistics.put(2, 0L); // 5개 일치, 보너스 볼 일치
        statistics.put(3, 0L); // 5개 일치
        statistics.put(4, 0L); // 4개 일치
        statistics.put(5, 0L); // 3개 일치

        winningRanking.forEach(rank -> statistics.merge(rank, 1L, Long::sum));

        return statistics;
    }

    public void printStatistics() {
        Map<Integer, Long> stats = calculateStatistics();

        System.out.println("당첨 통계\n-----------");
        for (int rank = 0; rank < 5; rank++) {
            String rankDescription = ViewString.values()[rank].getSentence();
            System.out.println(rankDescription + stats.get(5 - rank) + "개");
        }
        System.out.println("총 수익률은 " + revenueRate + "%입니다.");
    }
}
