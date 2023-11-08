package lotto;

import java.util.HashMap;
import java.util.Map;
public class WinResult {

    private final static Integer WIN_RESULT_INITIALIZATION = 0;
    private final static Integer WIN_RESULT_INCREMENT = 1;
    private Map<Rankings, Integer> winResult;

    public WinResult() {
        winResult = new HashMap<>();
        winResult.put(Rankings.FIRST, WIN_RESULT_INITIALIZATION);
        winResult.put(Rankings.SECOND, WIN_RESULT_INITIALIZATION);
        winResult.put(Rankings.THIRD, WIN_RESULT_INITIALIZATION);
        winResult.put(Rankings.FOURTH, WIN_RESULT_INITIALIZATION);
        winResult.put(Rankings.FIFTH, WIN_RESULT_INITIALIZATION);
    }

    public void setWinresult(Rankings rankings) {
        if(!(rankings == Rankings.NOTHING)) {
            this.winResult.replace(rankings, this.winResult.get(rankings) + WIN_RESULT_INCREMENT);
        }
    }

}
