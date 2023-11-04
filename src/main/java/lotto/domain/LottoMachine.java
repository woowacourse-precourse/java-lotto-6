package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.validation.LottoMachineValidationHandler;

public class LottoMachine {

    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int RANGE_LOTTO_NUMBER = 6;

    public List<Lotto> generateLottos(int purchaseLottoCount) {
        validationLottoCount(purchaseLottoCount);
        final List<Lotto> lottos = new ArrayList<>();
        for(int count = 0; count < purchaseLottoCount; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER, RANGE_LOTTO_NUMBER);
            lottos.add(new Lotto(numbers));
        }

        return Collections.unmodifiableList(lottos);
    }

    private void validationLottoCount(int purchaseLottoCount) {
        LottoMachineValidationHandler.validationMinGenerateLottoCount(purchaseLottoCount);
    }
}
