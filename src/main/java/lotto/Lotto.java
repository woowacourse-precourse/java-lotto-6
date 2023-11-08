package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public enum LottoConstants{
        LOTTO_PRICE(1000);
        private final int price;
        LottoConstants(int price){
            this.price = price;
        }
        public int getPrice(){
            return price;
        }
    }

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }


    private void validateLottoNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6 || new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 값이어야 합니다.");
        }
    }
    private boolean validNumberCount(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static Lotto generate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
