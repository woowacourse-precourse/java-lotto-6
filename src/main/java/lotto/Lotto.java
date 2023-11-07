package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
        private final List<Integer> numbers;

        public Lotto(List<Integer> numbers) {
                validate(numbers);
                duplicateCheck(numbers);
                inRangeCheck(numbers);
                this.numbers = numbers;
        }

        /**
         * 입력 숫자가 6개가 아닐 경우
         * @param numbers
         */
        private void validate(List<Integer> numbers) {
                if (numbers.size() != 6) {
                        System.out.println("[ERROR] 입력된 숫자가 6개가 아닙니다!.");
                        throw new IllegalArgumentException();
                }
        }

        /**
         * 입력 번호에 중복이 있을 경우
         * @param numbers
         */
        private void duplicateCheck(List<Integer> numbers) {
                Set<Integer> set = new HashSet<>(numbers);

                if (set.size() != 6) {
                        System.out.println("[ERROR] 중복된 숫자가 있습니다.");
                        throw new IllegalStateException();
                }
        }

        /**
         * 번호가 허용된 범위를 넘어날 경우 
         * @param numbers
         */
        private void inRangeCheck(List<Integer> numbers) {
                for (Integer number : numbers) {
                        if (0 >= number || number >= 46) {
                            System.out.println("[ERROR] 1부터 45까지의 숫자를 입력해주시요.");
                            throw new IllegalArgumentException();
                        }
                }
        }

        /**
         * 당첨번호 getter
         * @return 당첨번호 List return
         */
        public ArrayList<Integer> getWinningNumbers() {
                ArrayList<Integer> returnNumbers = new ArrayList<>();
                for (Integer num : numbers) {
                        returnNumbers.add(num);
                }
                
                return returnNumbers;
        }
}
