package lotto.model;

import java.util.Arrays;

public enum Statistic {

    THREE(3, 5_000){
        public String printCount(int count){
            return "3개 일치 (5,000원) - " + count + "개";
        }
    },
    FOUR(4, 50_000){
        public String printCount(int count){
            return "4개 일치 (50,000원) - " + count + "개";
        }
    },
    FIVE(5, 1_500_000){
        public String printCount(int count){
            return "5개 일치 (1,500,000원) - " + count + "개";
        }
    },
    BONUS(5, 30_000_000){
        public String printCount(int count){
            return "5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개";
        }
    },
    SIX(6, 2_000_000_000){
        public String printCount(int count){
            return "6개 일치 (2,000,000,000원) - " + count + "개";
        }
    },;

    private final int matchingNumbers;
    private final int prize;

    Statistic(int matchingNumbers, int prize){
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
    }

    public static Statistic getRank(int numberOfMatch) {
        return Arrays.stream(values())
                .filter(statistic -> statistic.matchingNumbers == numberOfMatch)
                .findFirst()
                .orElseThrow();
    }

    public int getPrize(){
        return prize;
    }

    public abstract String printCount(int count);
}
