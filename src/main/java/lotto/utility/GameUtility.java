package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.GameNumberConstants;
import lotto.constants.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.ResultNumber;
import lotto.domain.Customer;

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

    public static LottoResult getUserLottoResult(Customer user) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : user.getLottoTickets()) {
            int numberOfMatchingNumbers = findNumberOfCommonElements(lotto.getNumbers(), ResultNumber.getWinningNumber());
            int hasBonusNumber = 0; //기본으로 dont care이다.
            if (numberOfMatchingNumbers == Rank.getNumberOfMatchesRequiredFromIndex(2)) {
                hasBonusNumber = hasBonusNumberInLotto(ResultNumber.getBonusNumber(), lotto.getNumbers());
            }
            lottoResult.addNumberOfPrizeFromIndex(getIndexFromConditions(numberOfMatchingNumbers, hasBonusNumber));
        }
        return lottoResult;
    }

    //로또 숫자 범위만큼의 배열을 만들어서 배열에 로또 번호랑, 당첨번호에 해당하는 숫자 각각 +1하여 결론적으로 +2된 인덱스 개수를 리턴한다.
    private static int findNumberOfCommonElements(List<Integer> firstList, List<Integer> secondList) {
        int[] array = new int[GameNumberConstants.MAX_LOTTO_NUMBER.getValue() + 1]; //0번 인덱스는 제외
        firstList.stream().forEach(number -> array[number]++);
        secondList.stream().forEach(number -> array[number]++);
        return (int) Arrays.stream(array).filter(number -> number == 2).count();
    }

    private static int hasBonusNumberInLotto(int bonusNumber, List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().anyMatch(number -> number == bonusNumber)) {
            return 1;
        }
        return -1;
    }

    private static int getIndexFromConditions(int numberOfMatchingNumbers, int hasBonusNumber) {
        return Rank.getIndexFromConditions(numberOfMatchingNumbers, hasBonusNumber);
    }

    public static double calculateRateOfReturn(int winningPrize, int payment) {
        return 100 * (double) winningPrize / (double) payment;
    }

    public static int calculateWinningPrize(Customer user) {
        int winningPrize = 0;
        LottoResult lottoResult = user.getLottoResult();
        for (int index = 1; index <= GameNumberConstants.NUMBER_OF_WINNING_PRIZE.getValue(); index++) {
            winningPrize += lottoResult.getNumberOfPrizeFromIndex(index) * Rank.getPrizeFromIndex(index);
        }
        return winningPrize;
    }


}
