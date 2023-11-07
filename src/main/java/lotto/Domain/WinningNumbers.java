package lotto.Domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningNumbers {

    public static final String INVALID_RANGE_MESSAGE = "[ERROR] 1~45 사이의 숫자를 입력해주세요";
    public static final String DUPLICATE_MESSAGE = "[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.";
    public static final String NOT_NUMBER_MESSAGE = "[ERROR] 숫자를 입력해주세요";
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private Lotto winnigNumbers;
    private int bonusNumber;

    public WinningNumbers(List<Integer> winNum, String bonusNum) throws IllegalArgumentException {
        winnigNumbers = new Lotto(winNum);
        validateNumber(bonusNum);
        int bonusNumber = Integer.parseInt(bonusNum);
        validateNumberRange(bonusNumber);
        validateDuplicate(winNum, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateNumber(String bonusNum) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(bonusNum);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }

    private void validateNumberRange(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> winNum, int bonusNum)
        throws IllegalArgumentException {
        if (winNum.contains(bonusNum)) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

    public Map<Rank, Integer> getRankCount(List<Lotto> lottos) {
        Map<Rank, Integer> rankCount = new HashMap<>();

        for (Lotto lotto : lottos) {
            int sameNumbers = winnigNumbers.countSameNumbers(lotto);
            boolean isBonus = isBonusNumber(sameNumbers, lotto);
            Rank rank = Rank.getRank(sameNumbers, isBonus);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }

    public boolean isBonusNumber(int sameNumbers, Lotto lotto) {
        return sameNumbers == Rank.SECOND.getMatchedNumbers()
            && lotto.countSameBonusNumber(bonusNumber);
    }
}
