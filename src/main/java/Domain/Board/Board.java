package Domain.Board;

import Util.CheckInteger;
import View.MoneyInputErrorText;
import Domain.lotto.LottoOutcome;
import Domain.lotto.LottoPrice;

import java.util.HashMap;
import java.util.Map;
/*
    당첨 내역을 저장하는 class
 */
public class Board {
    private Map<LottoOutcome, Integer> winningRecord;
    private int money;
    private int prize;

    public Board(int money){
        CheckInteger.notZero(money, MoneyInputErrorText.zeroInserted());
        CheckInteger.checkNumMultipleOfDivider(money, LottoPrice.nomal.getValue(), MoneyInputErrorText.notMultipleOfThousand());
        this.money = money;
        this.prize = 0;
        winningRecord = new HashMap<LottoOutcome, Integer>();
        for(LottoOutcome outcome: LottoOutcome.values()){
            if(outcome == LottoOutcome.none)
                continue;
            winningRecord.put(outcome, 0);
        }
    }

    public void writeOutcome(LottoOutcome outcome){
        if(outcome != LottoOutcome.none) {
            winningRecord.put(outcome, winningRecord.get(outcome) + 1);
            prize += outcome.getPrize();
        }
    }

    public int getMoney() {
        return money;
    }

    public int getPrize() {
        return prize;
    }

    public Map<LottoOutcome, Integer> getWinningRecord() {
        return winningRecord;
    }
}
