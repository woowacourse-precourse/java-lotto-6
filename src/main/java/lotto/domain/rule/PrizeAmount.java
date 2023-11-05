package lotto.domain.rule;

import static lotto.constant.LottoConstant.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.output.MessageType;
import lotto.output.OutputMessage;

public class PrizeAmount {
    private static Map<Integer, PrizeAmount> prizeAmounts = new HashMap();

    private int lottoCount;
    private int bonusCount;
    private int amount;
    private int rank;

    private PrizeAmount(int lottoCount, int bonusCount, int amount, int rank) {
        this.lottoCount = lottoCount;
        this.bonusCount = bonusCount;
        this.amount = amount;
        this.rank = rank;
    }

    public PrizeAmount(){
        gernerate();
    }

    private void gernerate(){
        prizeAmounts.put(MATCH_ALL_THREE_COUNT, new PrizeAmount(3,0,5000,5));
        prizeAmounts.put(MATCH_ALL_FOUR_COUNT, new PrizeAmount(4,0,50000,4));
        prizeAmounts.put(MATCH_ALL_FIVE_COUNT, new PrizeAmount(5,0,1500000,3));
        prizeAmounts.put(MATCH_ALL_SIX_COUNT, new PrizeAmount(5,1,30000000,2));
        prizeAmounts.put(MATCH_ALL_SEVEN_COUNT, new PrizeAmount(6,0,2000000000,1));
    }

    public static Map<Integer, PrizeAmount> getPrizeAmounts() {
        return Collections.unmodifiableMap(prizeAmounts);
    }

    public void classifyWin(List<Integer> winRecord) {
        int threeMatch = 0;
        int fourMatch = 0;
        int fiveMatch = 0;
        int sixMatch = 0;
        int sevenMatch = 0;

        for (Integer integer : winRecord) {
            if(integer == 3){
                threeMatch++;
            }

            if(integer == 4){
                fourMatch++;
            }

            if(integer == 5){
                fiveMatch++;
            }

            if(integer == 6){
                sixMatch++;
            }

            if(integer == 7){
                sevenMatch++;
            }
        }

        OutputMessage.printf(MessageType.MATCH_THREE_COUNT, threeMatch);
        OutputMessage.printf(MessageType.MATCH_FOUR_COUNT, fourMatch);
        OutputMessage.printf(MessageType.MATCH_FIVE_COUNT, fiveMatch);
        OutputMessage.printf(MessageType.MATCH_SIX_COUNT, sixMatch);
        OutputMessage.printf(MessageType.MATCH_SEVEN_COUNT, sevenMatch);

    }

    public int getAmount() {
        return this.amount;
    }
}
