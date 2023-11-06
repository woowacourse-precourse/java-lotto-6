package lotto;

import java.util.Comparator;

public class LottoRank {
    public enum Rank{
        NONE("3개 미만 일치", 0, 0),
        FIFTH("3개 일치 (5,000원) - ", 5000, 3),
        FOURTH("4개 일치 (50,000원) - ", 50_000, 4),
        THIRD("5개 일치 (1,500,000원) - ", 1_500_000, 5),
        SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000, 5),
        FIRST("6개 일치 (2,000,000,000원) - ", 2_000_000_000, 6);

        final String message;
        final int price;
        final int correct;

        public String getMessage() {
            return message;
        }

        public int getPrice() {
            return price;
        }

        Rank(String message, int price, int correct) {
            this.message = message;
            this.price  = price;
            this.correct = correct;
        }

        public static Rank getLottoResult(int correct, boolean bonus){
            if(correct < FIFTH.correct){
                return NONE;
            }
            if(bonus && correct == SECOND.correct){
                return SECOND;
            }
            for( Rank rank : Rank.values()){
                if(correct == rank.correct){
                    return rank;
                }
            }
            throw new IllegalArgumentException();
        }

    }




}
