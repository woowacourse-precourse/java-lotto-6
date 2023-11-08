package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.constant.LottoConstant;
import lotto.dto.PurchaseAmountRequest;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class LottoMakeService {

    public Lottos makeRandomLottos(PurchaseAmountRequest purchaseAmountRequest) {
        Integer purchaseCount =
            purchaseAmountRequest.purchaseAmount() / LottoConstant.LOTTO_PRICE.getValue();

        final List<Lotto> result = IntStream.range(0, purchaseCount)
            .mapToObj(i -> makeRandomLotto()).toList();

        return new Lottos(result);
    }

    private Lotto makeRandomLotto() {
        final List<Integer> lottoNumbers =
            Randoms.pickUniqueNumbersInRange(
                LottoConstant.LOTTO_NUMBER_MIN.getValue(),
                LottoConstant.LOTTO_NUMBER_MAX.getValue(),
                LottoConstant.LOTTO_NUMBER_COUNT.getValue()
            );
        return new Lotto(lottoNumbers);
    }
}
