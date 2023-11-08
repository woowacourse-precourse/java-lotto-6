package lotto;

import lotto.enums.LottoResult;

import java.util.List;

/**
 * 로또 클래스
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    /**
     * 로또 번호를 검증한다.
     * @param numbers
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 당첨 번호와 보너스 번호를 받아서 로또 결과를 반환한다.
     * @param winningNums 당첨 번호
     * @param bonusNumber 보너스 번호
     * @return 로또 당첨 결과
     */
    public LottoResult getLottoResult(List<Integer> winningNums, int bonusNumber) {
        int matchCount = (int) numbers.stream()
                .filter(winningNums::contains)
                .count();

        boolean isBonusMatch = numbers.contains(bonusNumber);

        return LottoResult.parse(matchCount, isBonusMatch);
    }

    /**
     * 로또 번호를 문자열로 반환한다.
     * @return 로또 번호 문자열
     */
    @Override
    public String toString() {
        return numbers.toString();
    }

}
