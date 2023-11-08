package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    /**
     * 로또 번호의 유효성 검증
     * 1. 로또 번호가 6개인지 확인
     * 2. 로또 번호가 중복되지는 않았는 지 확인
     * @param numbers 로또 번호
     * @throws IllegalArgumentException 로또 번호가 중복되었거나 6개가 아닐 때
     */
    private void validate(List<Integer> numbers) {
        List<Integer> distinctWinningNumbers = numbers.stream().distinct().toList();
        if (numbers.size() != 6 || numbers.size() != distinctWinningNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 로또 번호 발행
     * @return 1부터 45 사이의 중복되지 않는 무작위 수 6개
     */
    public static Lotto issue(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        return new Lotto(sortedNumbers);
    }


    @Override
    public String toString(){
        return numbers.toString();
    }
}
