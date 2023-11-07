package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            //throw new IllegalArgumentException();
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numberSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 없어야 합니다.");
        }
        numbers.stream().forEach(this::validate_Lotto_Number);
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현
    public void Output_Number() {
        System.out.println("[" + numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")) + "]");
    }

    private  void validate_Lotto_Number(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public boolean contain_Bouns_Number(int bonus_number) {
        return this.numbers.contains(bonus_number);
    }
    public int matchCount(Lotto lotto) {
        int matchCount = 0;
        for (Integer number : lotto.getNumbers()) {
            if (this.numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

}

