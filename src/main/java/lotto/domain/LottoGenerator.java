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
        validate(purchasePrice, ExceptionCode.INVALID_PURCHASE_PRICE);

        int countOfLotto = purchasePrice / priceOfLotto;
        List<Lotto> lottos = createLottos(countOfLotto);

        return new LottoBundle(lottos);
    }

    private void validate(final int purchasePrice, final ExceptionCode e) {
        Validator.isPositiveNumber(purchasePrice, e);
        Validator.isNoRemainders(purchasePrice, priceOfLotto, e);
    }

    private List<Lotto> createLottos(final int countOfLotto) {
        List<Lotto> lottos = new ArrayList<>(countOfLotto);
        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    public Lotto createLotto() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(
                        Lotto.START_NUMBER,
                        Lotto.END_NUMBER,
                        Lotto.SIZE
                )
        );
    }

    public Lotto createLotto(final List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public BonusNumber createBonusNumber(final int number, final Lotto winningLotto) {
        return new BonusNumber(number, winningLotto);
    }
}
