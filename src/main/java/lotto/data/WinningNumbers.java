package lotto.data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import lotto.data.Lotto;
import lotto.message.LottoResult;

public class WinningNumbers extends Lotto {
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateLottoNum(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    public HashMap<LottoResult, BigDecimal> getResultWith(List<Lotto> lottos) {
        HashMap<LottoResult, BigDecimal> result = initResult();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCountWith(getNumbers());
            LottoResult lottoResult = LottoResult.of(matchCount, lotto.contains(bonusNumber));
            BigDecimal count = result.get(lottoResult).add(BigDecimal.ONE);
            result.put(lottoResult, count);
        }
        return result;
    }

    private HashMap<LottoResult, BigDecimal> initResult() {
        HashMap<LottoResult, BigDecimal> result = new HashMap<>();
        result.put(LottoResult.FIRST, BigDecimal.ZERO);
        result.put(LottoResult.SECOND, BigDecimal.ZERO);
        result.put(LottoResult.THIRD, BigDecimal.ZERO);
        result.put(LottoResult.FOURTH, BigDecimal.ZERO);
        result.put(LottoResult.FIFTH, BigDecimal.ZERO);
        result.put(LottoResult.NONE, BigDecimal.ZERO);
        return result;
    }

}
