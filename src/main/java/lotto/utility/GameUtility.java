package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.GameNumberConstants;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.ResultNumber;
import lotto.domain.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameUtility {

    private GameUtility() {}

    public static User buyTickets(int payment) {
        int ticketAmount = payment / GameNumberConstants.LOTTO_PRICE.getValue();
        return new User(payment, generateLottoNumberRepeatNTimes(ticketAmount));
    }

    public static List<Lotto> generateLottoNumberRepeatNTimes(int repeatNumber) {
        List<Lotto> lotties = new ArrayList<>();
        for (int i = 0; i < repeatNumber; i++) {
            lotties.add(new Lotto(generateLottoNumber()));
        }

        return lotties;
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static void checkLottoWinning(User user) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : user.getLottoTickets()) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            lottoNumbers.retainAll(ResultNumber.getWinningNumber());
            int numberOfMatchingNumbers = lottoNumbers.size();
            Boolean hasBonusNumber = lotto.getNumbers().contains(ResultNumber.getBonusNumber());
            checkRank(numberOfMatchingNumbers, hasBonusNumber, lottoResult);
        }
        user.setLottoResult(lottoResult);
    }

    public static void checkRank(int numberOfMatchingNumbers, boolean hasBonusNumber, LottoResult lottoResult) {
        if (numberOfMatchingNumbers == 6) {
            lottoResult.addFirst_place();
        }
        if (numberOfMatchingNumbers == 5 && hasBonusNumber == true) {
            lottoResult.addSecond_place();
        }
        if (numberOfMatchingNumbers == 5 && hasBonusNumber == false) {
            lottoResult.addThird_place();
        }
        if (numberOfMatchingNumbers == 4) {
            lottoResult.addForth_place();
        }
        if (numberOfMatchingNumbers == 3) {
            lottoResult.addFifth_place();
        }
    }
}
