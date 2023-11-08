/**
 * @Package_name : model
 * @Class_name : LottoWinResultsHolder
 * <p>
 * Create Date : 2023-11-07 Create User : 정은채
 */
package model;

import java.util.HashMap;
import java.util.Map;
import model.enums.LottoWinResults;

public class LottoWinResultsHolder {
    private Map<String, Integer> winResults = new HashMap<>();

    public LottoWinResultsHolder() {
        winResults.put(LottoWinResults.LOTTO_3SAME.getMessage(), 0);
        winResults.put(LottoWinResults.LOTTO_4SAME.getMessage(), 0);
        winResults.put(LottoWinResults.LOTTO_5SAME.getMessage(), 0);
        winResults.put(LottoWinResults.LOTTO_5SAME_BONUS.getMessage(), 0);
        winResults.put(LottoWinResults.LOTTO_6SAME.getMessage(), 0);
    }

    /**
     * Description : winResults 의 값 갱신
     *
     * @Method : lottoWinResultsAdd()
     */
    public void lottoWinResultsAdd(String winResult) {
        if (winResult != LottoWinResults.LOTTO_NOTHING.getMessage()) {
            winResults.put(winResult, winResults.get(winResult) + 1);
        }
    }

    /**
     * Description : winResults 반환
     *
     * @Method : getWinResults()
     */
    public Map<String, Integer> getWinResults() {
        return winResults;
    }

}
