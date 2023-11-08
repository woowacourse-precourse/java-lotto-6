package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.ExceptionMsg;
import lotto.verifier.LottoNumberVerifier;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sortNumbers();
        verifyDuplicated();
    }

    public void verifyDuplicated(){
        HashSet<Integer> set = new HashSet();
        try{
            for (Integer integer: numbers) {
                set.add(integer);
            }
        }catch (Exception e){
            throw new IllegalArgumentException(ExceptionMsg.DUPLICATE_LOTTO_NUM.getMessage());
        }

    }



    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMsg.NOT_SIX_INPUT_NUMBERS.getMessage());
        }
    }
    // 입력한 로또 번호와 생성된 로또 번호 사이에 몇개의 숫자가 맞는지 반환
    public int countMatchedNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    // 로또 번호 리스트를 반환하는 메서드
    public List<Integer> getNumbers() {
        return numbers;
    }

    // 보너스 번호가 포함되어 있는지 확인하는 메서드
    public boolean isContainedBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    // 로또 번호를 정렬하는 메서드
    public void sortNumbers() {
        Collections.sort(this.numbers);
    }

}
