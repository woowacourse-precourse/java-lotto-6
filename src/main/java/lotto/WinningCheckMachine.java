package lotto;

import lotto.code.GameMessage;
import lotto.code.PrizeType;
import lotto.dto.LottoPurchaseDto;
import lotto.dto.WinningLottoNumberDto;
import lotto.utils.PrintUtils;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static lotto.code.GameMessage.WINNING;

public class WinningCheckMachine {
    private Map<PrizeType, Integer> prizeCount = new EnumMap<>(PrizeType.class);
    private double totalWinningMoney = 0;
    private double rate = 0;

    public WinningCheckMachine() {
        for (PrizeType prizeType : PrizeType.values()) {
            this.prizeCount.put(prizeType, 0);
        }
    }

    public void check(List<Lotto> lottos, WinningLottoNumberDto winningLottoNumber, LottoPurchaseDto lottoPurchase) {
        checkLotto(lottos, winningLottoNumber);
        calculateOfRate(lottoPurchase.getAmount());
        print();
    }

    public void checkLotto(List<Lotto> lottos, WinningLottoNumberDto winningLottoNumber) {
        for (Lotto lotto : lottos) {
            PrizeType prizeType = lotto.checkWinning(winningLottoNumber);
            if (prizeType != null) {
                int count = this.prizeCount.get(prizeType);
                this.prizeCount.put(prizeType, count + 1);
                this.totalWinningMoney += prizeType.getPrizeMoney();
            }
        }
    }

    public void calculateOfRate(int amount) {
        this.rate = (this.totalWinningMoney / (double) amount) * 100;
    }

    public void print() {
        PrintUtils.print("");
        PrintUtils.print(WINNING);
        PrintUtils.print("---");


        for (PrizeType prizeType : PrizeType.values()) {
            int count = this.prizeCount.get(prizeType);
            PrintUtils.print(getWinningMessage(prizeType, count));
        }

        PrintUtils.print(GameMessage.TOTAL_RATE.getMessage().replace("($rate$)", String.valueOf(rate)));
    }

    private String getWinningMessage(PrizeType prizeType, int count){
        String message = prizeType.getMessage();

        int amount = prizeType.getPrizeMoney();
        DecimalFormat df = new DecimalFormat("###,###");
        String money = df.format(amount);

        message = message.replace("($money$)", money);
        message = message.replace("($count$)", String.valueOf(count));

        return message;
    }

}
