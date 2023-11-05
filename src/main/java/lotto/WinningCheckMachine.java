package lotto;

import lotto.code.GameMessage;
import lotto.code.PrizeCode;
import lotto.utils.PrintUtils;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static lotto.code.GameMessage.WINNING;

public class WinningCheckMachine {
    private Map<PrizeCode, Integer> prizeCount = new EnumMap<>(PrizeCode.class);
    private double totalWinningMoney = 0;
    private double rate = 0;

    public WinningCheckMachine() {
        for (PrizeCode prizeCode : PrizeCode.values()) {
            this.prizeCount.put(prizeCode, 0);
        }
    }

    public void check(List<Lotto> lottos, List<Integer> winnerNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            lotto.checkWinning(winnerNumbers, bonusNumber);
            PrizeCode prizeCode = lotto.getPrizeCode();
            if (prizeCode != null) {
                int count = this.prizeCount.get(prizeCode);
                this.prizeCount.put(prizeCode, count + 1);
                this.totalWinningMoney += prizeCode.getPrizeMoney();
            }
        }
    }

    public void calculateOfRate(int amount) {
        this.rate = (totalWinningMoney / (double) amount) * 100;
    }

    public void print() {
        PrintUtils.print("");
        PrintUtils.print(WINNING);
        PrintUtils.print("---");


        for (PrizeCode prizeCode : PrizeCode.values()) {
            int count = this.prizeCount.get(prizeCode);
            PrintUtils.print(getWinningMessage(prizeCode, count));
        }

        PrintUtils.print(GameMessage.TOTAL_RATE.getMessage().replace("($rate$)", String.valueOf(rate)));
    }

    private String getWinningMessage(PrizeCode prizeCode, int count){
        String message = prizeCode.getMessage();

        int amount = prizeCode.getPrizeMoney();
        DecimalFormat df = new DecimalFormat("###,###");
        String money = df.format(amount);

        message = message.replace("($money$)", money);
        message = message.replace("($count$)", String.valueOf(count));

        return message;
    }

}
