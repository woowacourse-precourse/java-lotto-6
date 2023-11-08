package lotto.model.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.domain.constants.LottoGameConstants;
import lotto.model.domain.constants.PrizeConstants;

public class WinningConfirm {
    private final Map<PrizeConstants, Integer> winningCounts;

    public WinningConfirm(List<Lotto> lottos, WinningNumbers winningNumbers) {
        this.winningCounts = winningCount(lottos, winningNumbers);
    }

    /**
     * 로또리스트와 당첨번호를 받아 당첨통계를 맵으로 반환한다
     *
     * @param lottos
     * @param winningNumbers
     * @return key 당첨상수 value 당첨횟수 의 Map
     */
    private Map<PrizeConstants, Integer> winningCount(List<Lotto> lottos, WinningNumbers winningNumbers) {
        Map<PrizeConstants, Integer> result = new EnumMap<>(PrizeConstants.class);

        for (Lotto lotto : lottos) {
            int matchingNumbers = countMatchingNumbers(lotto.getNumbers(), winningNumbers.getLotto());
            boolean isBonusNumberCorrect = checkBonusMatch(lotto.getNumbers(), winningNumbers.getBonus());

            PrizeConstants prizeConstants = determinePrizeType(matchingNumbers, isBonusNumberCorrect);
            result.put(prizeConstants, result.getOrDefault(prizeConstants, 0) + 1);
        }
        return result;
    }

    /**
     * 당첨번호와 일치하는 숫자를 계산한다
     *
     * @param lottoNumbers
     * @param winningNumbers
     * @return 일치하는 숫자 개수
     */
    private int countMatchingNumbers(List<Integer> lottoNumbers, Lotto winningNumbers) {
        int count = 0;
        List<Integer> answer = winningNumbers.getNumbers();
        for (int lottoNumber : lottoNumbers) {
            if (answer.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 보너스 번호를 체크한다
     *
     * @param numbers
     * @param bonus
     * @return 보너스번호가 일치하면 true
     */
    private boolean checkBonusMatch(List<Integer> numbers, int bonus) {
        return numbers.contains(bonus);
    }

    /**
     * 당첨횟수와 보너스번호일치여부를 받아 반환할 상수를 정한다
     *
     * @param matchingNumbers
     * @param isBonusNumberCorrect
     * @return PrizeConstants 당첨상수
     */
    private PrizeConstants determinePrizeType(int matchingNumbers, boolean isBonusNumberCorrect) {
        if (matchingNumbers + LottoGameConstants.BONUS_COUNT.getValue() == PrizeConstants.SIX_MATCH.ordinal()) {
            return PrizeConstants.SIX_MATCH;
        }
        if (matchingNumbers == PrizeConstants.FIVE_MATCH.ordinal() && isBonusNumberCorrect) {
            return PrizeConstants.FIVE_MATCH_WITH_BONUS;
        }
        return PrizeConstants.values()[matchingNumbers];
    }

    public Map<PrizeConstants, Integer> getWinningCounts() {
        return this.winningCounts;
    }
}
