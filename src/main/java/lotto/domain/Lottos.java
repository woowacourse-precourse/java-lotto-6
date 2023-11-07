package lotto.domain;

import java.util.List;
import java.util.Map;

import static lotto.domain.LottoPrice.LOTTO_UNIT_PRICE;

public class Lottos {
    private final List<Lotto> issuedLottos;

    public Lottos(List<Lotto> issuedLottos) {
        this.issuedLottos = issuedLottos;
    }

    public ResultStatics calculateResult(LottoResult lottoResult) {
        Map<LottoPrize, Integer> prizeResult = lottoResult.mappingPrizeResult(issuedLottos);
        int phrasedMoney = calculatePhrasedMoney();
        return new ResultStatics(prizeResult, phrasedMoney);
    }

    public int calculatePhrasedMoney() {
        int phrasedMoney = issuedLottos.size() * LOTTO_UNIT_PRICE;
        return phrasedMoney;
    }

    public int issuedSize() {
        return issuedLottos.size();
    }

    public List<Lotto> getIssuedLottos() {
        return issuedLottos;
    }

    public Lotto getOrdinalLotto(int ordinal) {
        return issuedLottos.get(ordinal);
    }
}
