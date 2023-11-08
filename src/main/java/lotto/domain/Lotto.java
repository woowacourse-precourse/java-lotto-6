package lotto.domain;

import lotto.lottoenum.LottoRanking;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException{
        validate(numbers);
        List<Integer> modifiableNumbers = new ArrayList<>(numbers);
        Collections.sort(modifiableNumbers);
        this.numbers = modifiableNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 개수는 6개 입니다.");
        }
        if(checkDuplicate(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또번호는 중복되면 안됩니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getLottoDetail(){
        return numbers;
    }
    private boolean checkDuplicate(List<Integer> numbers) {
        Set<Integer> checkDup = new HashSet<>();
        for (Integer num : numbers) {
            if (checkDup.contains(num)) {
                return true; // 중복 발견
            }
            checkDup.add(num);
        }
        return false;
    }
}
