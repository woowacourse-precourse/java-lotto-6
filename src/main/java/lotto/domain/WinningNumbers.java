package lotto.domain;

import java.util.List;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

/**
 * 당첨 번호들을 저장하는 클래스
 */
public class WinningNumbers {
    private List<Number> winningNumbers;

    private WinningNumbers(final List<Number> winningNumbers) {
        Validator.validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    /**
     * 당첨 번호 리스트를 통해 당첨 번호 객체를 생성하는 메서드
     *
     * @param winningNumbers 당첨 번호 리스트
     * @return 당첨 번호 객체
     */
    public static WinningNumbers from(final List<Number> winningNumbers) {
        return new WinningNumbers(winningNumbers);
    }

    /**
     * 입력된 로또 번호 리스트와 당첨 번호가 일치하는 개수를 계산하는 메서드
     *
     * @param numbers 로또 번호 리스트
     * @return 일치하는 번호의 개수
     */
    public int countMatchedNumbers(final List<Number> numbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    /**
     * 특정 숫자를 포함하는 지 확인하는 메서드
     *
     * @param number 특정 숫자
     * @return 특정 숫자를 포함하면 true, 그렇지 않으면 false
     */
    public boolean contains(final Number number) {
        return winningNumbers.contains(number);
    }

    private static class Validator {
        /**
         * 당첨 번호의 유효성을 검증하는 메서드
         *
         * @param winningNumbers 당첨 번호
         */
        private static void validateWinningNumbers(final List<Number> winningNumbers) {
            validateDuplication(winningNumbers);
        }

        private static void validateDuplication(final List<Number> winningNumbers) {
            if (isDuplicated(winningNumbers)) {
                throw LottoException.from(ErrorMessage.DUPLICATED_NUMBER_ERROR);
            }
        }

        private static boolean isDuplicated(final List<Number> winningNumbers) {
            int uniqueSize = getUniqueSize(winningNumbers);
            return uniqueSize != winningNumbers.size();
        }

        private static int getUniqueSize(final List<Number> winningNumbers) {
            return (int) winningNumbers.stream()
                    .distinct()
                    .count();
        }
    }
}
