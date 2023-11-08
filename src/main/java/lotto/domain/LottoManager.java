package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoManager {

    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private List<Integer> winningNumbers; //매주 토요일 오후 8시 35분
    private int bonusNum;
    private static final LottoManager instance = new LottoManager();

    private LottoManager() {}

    public static LottoManager getInstance() {
        return instance;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        validateLottoNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public void setBonusNum(Integer bonusNum) {
        validateBonusNumber(bonusNum);
        this.bonusNum = bonusNum;
    }

    public Integer getBonusNum() {
        return bonusNum;
    }

    public LottoResult compare(List<Integer> userNumbers) {
        int matchCount = (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean bonusMatch = userNumbers.contains(bonusNum);
        return LottoResult.valueOf(matchCount, bonusMatch);
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            validateNumberInRange(number);
        }
    }

    private void validateBonusNumber(int number) {
        validateNumberInRange(number);
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    private void validateNumberInRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }
    }
}
