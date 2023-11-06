package lotto.domain;

import java.util.List;

public class Calculator {
    private static final Long lottoPrice = 1000L;
    public static void calculateTheRateOfReturn(List<Integer> ranks, int amount){
        Long prizeMoney = calculateTotalPrizeMoney(ranks);
        Rank[] Ranks = Rank.values();
        for(int i = ranks.size() - 1; i >=0 ; i--){
            System.out.println(Ranks[i].getMessage()+" - "+ranks.get(i)+"개");
        }
        System.out.println("총 수익률은 "+ Math.round((double)prizeMoney/amount * 100 * 10)/(double)10+"%입니다.");
    }


    private static Long calculateTotalPrizeMoney(List<Integer> ranks) {
        Long prizeMoney = 0L;
        prizeMoney+=(Rank.FIRST.getPrice() * ranks.get(0));
        prizeMoney+=(Rank.SECOND.getPrice() * ranks.get(1));
        prizeMoney+=(Rank.THIRD.getPrice() * ranks.get(2));
        prizeMoney+=(Rank.FOURTH.getPrice() * ranks.get(3));
        prizeMoney+=(Rank.FIFTH.getPrice() * ranks.get(4));
        return prizeMoney;
    }

    public enum Rank{

        FIRST(2_000_000_000L, "6개 일치 (2,000,000,000원)"),
        SECOND(30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
        THIRD(1_500_000L, "5개 일치 (1,500,000원)"),
        FOURTH(50_000L, "4개 일치 (50,000원)"),
        FIFTH(5_000L, "3개 일치 (5,000원)");

        private final Long price;
        private final String message;

        Rank(Long price, String message) {
            this.price = price;
            this.message = message;
        }

        public Long getPrice(){
            return this.price;
        }

        public String getMessage(){
            return this.message;
        }
    }
}
