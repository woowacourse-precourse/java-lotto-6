package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.customer.LottoNumberSpec;

/**
 * Lotto 의 개념 객체를 나타내는 클래스입니다.
 */
public class Lotto {
        private final List<Integer> numbers;
        
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
                if (numbers.size() != LottoNumberSpec.SIZE.toInt()) {
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
                if (numberSet.size() != LottoNumberSpec.SIZE.toInt()) {
                        throw new IllegalArgumentException("로또는 중복된 숫자를 포함할 수 없습니다.");
                }
        }

        /**
         * 주어진 숫자가 로또에 포함되어 있는지 반환합니다.
         * @param number 타켓 숫자
         * @return 포함 여부
         */
        public boolean hasNumber(int number) {
                return numbers.contains(number);
        }

        /**
         * 주어진 로또와의 유사도를 반환하는 메서드로, 일치하는 숫자의 개수를 반환합니다.
         * @param target 로또
         * @return 일치하는 숫자의 수
         */
        public long countMatchNumber(Lotto target) {
                return numbers.stream().filter(target::hasNumber).count();
        }
}
