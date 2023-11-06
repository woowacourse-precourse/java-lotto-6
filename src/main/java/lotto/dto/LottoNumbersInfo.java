package lotto.dto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.message.LottoResult;
import lotto.utils.LottoUtil;

public class LottoNumbersInfo {

    public final int bonusNumber;

    private final List<Integer> winningNumbers;
    private final List<Lotto> lottos;

    public LottoNumbersInfo(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoUtil.validateLottoNum(bonusNumber);

        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
        this.lottos = lottos;
    }

    public HashMap<LottoResult, BigDecimal> getResult() {
        HashMap<LottoResult, BigDecimal> result = initResult();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCountWith(winningNumbers);
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
