package user;

import java.util.List;
import lottomachine.LottoResult;
import java.util.HashMap;
import java.util.Map;

public class TotalResult {
    private List<LottoResult> totalResult;


    public TotalResult(List<LottoResult> resultList) {
        this.totalResult = resultList;

    }

    public List<LottoResult> getTotalResult() {
        return totalResult;
    }

}
