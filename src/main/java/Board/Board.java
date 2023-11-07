package Board;

import java.util.HashMap;
import java.util.Map;

public class Board {
    Map<LottoOutcome, Integer> winningRecord;
    int money;

    public Board(int money){
        this.money = money;
        winningRecord = new HashMap<LottoOutcome, Integer>();
        for(LottoOutcome outcome: LottoOutcome.values()){
            if(outcome == LottoOutcome.none)
                continue;
            winningRecord.put(outcome, 0);
        }
    }

    public void writeOutcome(LottoOutcome outcome){
        if(outcome != LottoOutcome.none)
            winningRecord.put(outcome, winningRecord.get(outcome) + 1);
    }
}
