package lotto;

import java.util.List;

public class LottoGame {

    public List<Integer> generateLottoNums() {
        return null;
    }

    public int getLottoCounts(int price) {
        return price / 1000;
    }

    /**
     * @param ranks 당첨금 받는 rank만 들어온다.
     */
    public void printResult(List<Rank> ranks) {

    }

    /**
     * @param ranks 당첨금 받는 rank만 들어온다.
     */
    public void printEarningRate(List<Rank> ranks, int price) {
        System.out.println("총 수익률은 " + getEarningRate(ranks, price) +"입니다.");
    }


    /**
     * @param ranks 당첨금 받는 rank만 들어온다.
     */
    public String getEarningRate(List<Rank> ranks, int price) {
        Integer prizeSum = ranks.stream()
                .map(rank -> rank.name())
                .map(name -> Prize.valueOf(name))
                .map(Prize::getValue)
                .reduce((x, y) -> x + y)
                .get();

        double earningRate = (double) prizeSum / price * 100;

        return String.format("%.1f", earningRate) + "%";
    }
}
