package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.GameNumberConstants;
import lotto.constants.Rank;
import lotto.constants.WinningPrize;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.ResultNumber;
import lotto.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameUtility {

    private GameUtility() {}

    public static List<Lotto> buyTickets(int payment) {
        int ticketAmount = payment / GameNumberConstants.LOTTO_PRICE.getValue();
        return generateLottoNumberRepeatNTimes(ticketAmount);
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
        lottoNumbers = lottoNumbers.stream().collect(Collectors.toList());
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
        int[] array = new int[GameNumberConstants.MAX_LOTTO_NUMBER.getValue() + 1]; //List에 존재하면 값에 해당하는 인덱스 +1된다.
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

    public static double calculateRateOfReturn(int winningPrize, int payment) {
        return 100 * (double) winningPrize / (double) payment;
    }

    public static int calculateWinningPrize(User user) {
        int winningPrize = 0;
        LottoResult lottoResult = user.getLottoResult();
        winningPrize += lottoResult.getFirst_place() * WinningPrize.FIRST_PLACE_RETURN.getValue();
        winningPrize += lottoResult.getSecond_place() *WinningPrize.SECOND_PLACE_RETURN.getValue();
        winningPrize += lottoResult.getThird_place() * WinningPrize.THIRD_PLACE_RETURN.getValue();
        winningPrize += lottoResult.getForth_place() * WinningPrize.FORTH_PLACE_RETURN.getValue();
        winningPrize += lottoResult.getFifth_place() * WinningPrize.FIFTH_PLACE_RETURN.getValue();
        return winningPrize;
    }


}
