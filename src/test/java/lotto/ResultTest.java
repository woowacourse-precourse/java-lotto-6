package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.dto.LottoCompareResult;
import org.junit.jupiter.api.Test;

public class ResultTest {
    private static final LottoCompareResult first = new LottoCompareResult(6,false);
    private static final LottoCompareResult second = new LottoCompareResult(5,true);
    private static final LottoCompareResult third = new LottoCompareResult(5,false);
    private static final LottoCompareResult fourth = new LottoCompareResult(4,false);
    private static final LottoCompareResult fifth = new LottoCompareResult(3,false);

    @Test
    public void 결과_갯수_테스트() {
        Result result = new Result();

        // 결과 추가
        List<LottoCompareResult> compareResultList = new ArrayList<>(List.of(first, first,second));
        result.calculateTotalWinningMoney(compareResultList);

        // 결과 확인
        assertEquals(2, result.getCount(Rank.FIRST));
        assertEquals(1, result.getCount(Rank.SECOND));
        assertEquals(0, result.getCount(Rank.THIRD));
        assertEquals(0, result.getCount(Rank.FOURTH));
        assertEquals(0, result.getCount(Rank.FIFTH));
    }

    @Test
    public void 총_당첨금_테스트() {
        Result result = new Result();

        // 결과 추가
        List<LottoCompareResult> compareResultList = new ArrayList<>(List.of(first, second,third,fourth,fifth));
        result.calculateTotalWinningMoney(compareResultList);

        // 총 당첨금 확인
        assertEquals(2_031_555_000, result.getProfitAmount());
    }


}
