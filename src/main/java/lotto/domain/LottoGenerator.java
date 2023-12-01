package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.ExceptionCode;
import lotto.utils.vadliator.Validator;

public class LottoGenerator {

    private static final LottoGenerator instance = new LottoGenerator();
    public static final int priceOfLotto = 1000;

    private LottoGenerator() {
    }

    public static LottoGenerator getInstance() {
        return instance;
    }


    public LottoBundle generateLottoBundle(final int purchasePrice) {
        ExceptionCode e = ExceptionCode.INVALID_PURCHASE_PRICE;

        validate(purchasePrice, e);
        int countOfLotto = purchasePrice / priceOfLotto;

        List<Lotto> lottos = createLottos(e, countOfLotto);

        return new LottoBundle(lottos);
    }

    private List<Lotto> createLottos(final ExceptionCode e, final int countOfLotto) {
        List<Lotto> lottos = new ArrayList<>(countOfLotto);
        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(createLotto(e));
        }
        return lottos;
    }

    public Lotto createLotto(final ExceptionCode e) {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(
                        Lotto.START_NUMBER,
                        Lotto.END_NUMBER,
                        Lotto.SIZE
                ),
                e
        );
    }

    private void validate(final int purchasePrice, final ExceptionCode e) {
        Validator.isPositiveNumber(purchasePrice, e);
        Validator.isNoRemainders(purchasePrice, priceOfLotto, e);
    }
}
