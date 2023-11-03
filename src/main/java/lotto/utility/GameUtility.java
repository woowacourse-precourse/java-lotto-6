package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.GameNumberConstants;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameUtility {

    private GameUtility() {}

    public static User buyLotties(int payment) {
        int purchaseLottoAmount = payment / GameNumberConstants.LOTTO_PRICE.getValue();
        return new User(generateLottoNumberRepeatNTimes(purchaseLottoAmount),payment);
    }

    public static Lotties generateLottoNumberRepeatNTimes(int repeatNumber) {
        List<Lotto> lotties = new ArrayList<>();
        for (int i = 0; i < repeatNumber; i++) {
            lotties.add(new Lotto(generateLottoNumber()));
        }

        return new Lotties(lotties);
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
