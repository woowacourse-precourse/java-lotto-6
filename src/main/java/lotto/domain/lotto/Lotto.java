package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Lotto 의 개념 객체를 나타내는 클래스입니다.
 */
public class Lotto {
        public static final int LOTTO_NUMBER_SIZE = 6;
        /**
         * 로또를 구성하는 숫자입니다.
         */
        private final List<Integer> numbers;

        /**
         * Lotto 의 생성자 함수로 숫자 리스트를 입력받고, 유효성 검사를 실시합니다.
         * 유효성 검사를 통과 후 numbers 필드를 초기화 합니다.
         * @param numbers 로또 볼 번호
         */
        public Lotto(List<Integer> numbers) {
                validate(numbers);
                validateDuplicateNumber(numbers);
                this.numbers = numbers;
        }

        /**
         * 숫자 리스트의 길이가 6인지 검증합니다.
         * @param numbers 숫자 리스트
         * @throws IllegalArgumentException : 숫자 리스트의 길이가 6이 아닌 경우
         */
        private void validate(List<Integer> numbers) {
                if (numbers.size() != LOTTO_NUMBER_SIZE) {
                        throw new IllegalArgumentException("로또는 6가지의 서로 다른 수여야 합니다.");
                }
        }

        /**
         * 중복되지 않은 6가지의 수로 구성됨을 검증합니다.
         * @param numbers 숫자 리스트
         * @throws IllegalArgumentException : 숫자 리스트에 중볻된 숫자가 포함된 경우
         */
        private void validateDuplicateNumber(List<Integer> numbers) {
                Set<Integer> numberSet = new HashSet<>(numbers);
                if (numberSet.size() != LOTTO_NUMBER_SIZE) {
                        throw new IllegalArgumentException("로또는 중복된 숫자를 포함할 수 없습니다.");
                }
        }

        /**
         * 로또에 주어진 숫자의 포함 여부를 반환합니다.
         *
         * @param number 숫자
         * @return 숫자 포함 여부
         */
        public boolean hasNumber(int number) {
                return numbers.contains(number);
        }

        /**
         * 주어진 로또와의 유사도를 반환하는 메서드로, 일치하는 숫자의 개수를 반환합니다.
         *
         * @param target 로또
         * @return 일치하는 숫자의 수
         */
        public long matchCount(Lotto target) {
                return numbers.stream().filter(target::hasNumber).count();
        }
}
