package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.GameNumberConstants;
import lotto.constants.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.ResultNumber;
import lotto.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameUtility {

    private GameUtility() {}

    public static User buyTickets(int payment) {
        int ticketAmount = payment / GameNumberConstants.LOTTO_PRICE.getValue();
        return new User(payment, generateLottoNumberRepeatNTimes(ticketAmount));
    }

    public static List<Lotto> generateLottoNumberRepeatNTimes(int repeatNumber) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < repeatNumber; i++) {
            lottoTickets.add(new Lotto(generateLottoNumber()));
        }

        return lottoTickets;
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static void checkLottoWinning(User user) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : user.getLottoTickets()) {
            int numberOfMatchingNumbers = findNumberOfCommonElements(lotto.getNumbers(), ResultNumber.getWinningNumber());
            boolean hasBonusNumber = hasBonusNumberInLotto(ResultNumber.getBonusNumber(), lotto.getNumbers());
            checkRank(numberOfMatchingNumbers, hasBonusNumber, lottoResult);
        }
        user.setLottoResult(lottoResult);
    }

    private static int findNumberOfCommonElements(List<Integer> firstList, List<Integer> secondList) {
        int[] array = new int[GameNumberConstants.MAX_LOTTO_NUMBER.getValue()]; //List에 존재하면 값에 해당하는 인덱스 +1된다.
        firstList.stream().forEach(number -> array[number]++);
        secondList.stream().forEach(number -> array[number]++);
        return (int) Arrays.stream(array).filter(number -> number == 2).count();
    }

    private static boolean hasBonusNumberInLotto(int bonusNumber, List<Integer> lottoNumbers) {
        return lottoNumbers.stream().anyMatch(number -> number == bonusNumber);
    }

    private static void checkRank(int numberOfMatchingNumbers, boolean hasBonusNumber, LottoResult lottoResult) {
        if (numberOfMatchingNumbers == Rank.FIRST_PLACE_CONTDITION.getNumberOfMatchesRequired()) {
            lottoResult.addFirst_place();
        }
        if (numberOfMatchingNumbers == Rank.SECOND_PLACE_CONTDITION.getNumberOfMatchesRequired()
                && hasBonusNumber == Rank.SECOND_PLACE_CONTDITION.isHasBonusNumber()) {
            lottoResult.addSecond_place();
        }
        if (numberOfMatchingNumbers == Rank.THIRD_PLACE_CONTDITION.getNumberOfMatchesRequired()
                && hasBonusNumber == Rank.THIRD_PLACE_CONTDITION.isHasBonusNumber()) {
            lottoResult.addThird_place();
        }
        if (numberOfMatchingNumbers == Rank.FORTH_PLACE_CONTDITION.getNumberOfMatchesRequired()) {
            lottoResult.addForth_place();
        }
        if (numberOfMatchingNumbers == Rank.FIFTH_PLACE_CONTDITION.getNumberOfMatchesRequired()) {
            lottoResult.addFifth_place();
        }
    }

}
