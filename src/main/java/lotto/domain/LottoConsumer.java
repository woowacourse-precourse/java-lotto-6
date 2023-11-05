package lotto.domain;

import java.util.List;
import java.util.Map;

public class LottoConsumer {
    private final List<Lotto> issuedLottos;
    public LottoConsumer(List<Lotto> issuedLottos) {
        this.issuedLottos = issuedLottos;
    }

    public ResultStatics calculateResult(LottoResult lottoResult) {
        Map<LottoPrizeStatus, Integer> resultMap = lottoResult.mappingLottoResult(issuedLottos);
        int issueCount = issuedLottos.size();
        return new ResultStatics(resultMap, issueCount);
    }

    public List<Lotto> getIssuedLottos() {
        return issuedLottos;
    }
}
