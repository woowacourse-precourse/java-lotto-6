package lotto.model;

import lotto.view.OutputView;

public class Player {
    private final int[] matchCount = new int[5];
    private long total = 0;
    private int price;
    private int bonusNumber;
    private int count;

    public void updatePrice(int price) {
        System.out.println(price);
        this.price = price;
        updateCount(price);
    }
    public void updateCount(int price) {
        this.count = price / 1000;
    }



    public void updateMatchCountAndTotal(EnumRanking.Ranking ranking) {
        if (ranking != EnumRanking.Ranking.LAST) {
            long rankingPrice = EnumRanking.Ranking.getPrice(ranking);
            this.matchCount[ranking.ordinal()] += 1;
            this.total += rankingPrice;
        }
    }
    public void updateBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
    public int getCount() {return this.count;}

    public int getPrice() {
        return price;
    }
    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public long getTotal() {
        return this.total;
    }

    public int getMatchNum(int cnt) {
        return this.matchCount[cnt];
    }

}
