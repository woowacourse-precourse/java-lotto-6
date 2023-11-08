package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.UI.InputNum;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkLottoNumbers(numbers);
        this.numbers = numbers;
    }


    private void checkLottoNumbers(List<Integer> numbers) {
        InputNum inputNum = new InputNum();
            try{
                validate(numbers);
                checkLottoNumberDup(numbers);
                checkLottoNumberRange(numbers);
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException(e.getMessage());
//                System.out.println(e.getMessage());
//                inputNum.inputLottoNumbers();
            }
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6가지를 입력해주세요.");
        }
    }

    private void checkLottoNumberDup(List<Integer> numbers) {
        List<Integer> checkDup = new ArrayList<>();
        for (int number : numbers) {
            if (checkDup.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨번호는 중복없이 입력해주세요.");
            }
            checkDup.add(number);
        }
    }
    private void checkLottoNumberRange(List<Integer> numbers){
        for(int number : numbers){
            if (number < 1 || number > 45){
                throw new IllegalArgumentException("[ERROR] 당첨번호는 1 ~ 45 사이의 숫자를 입력해주세요.");
            }
        }
    }

    public List<List<Integer>> getMatchedNumber(List<List<Integer>> randomNumbers, int bonusNumber) {
        List<List<Integer>> matchedNumber = new ArrayList<>();
        for (List<Integer> randomNumber : randomNumbers) {
            matchedNumber.add(countMatchedNumber(randomNumber, bonusNumber));
        }
        return matchedNumber;
    }

    private List<Integer> countMatchedNumber(List<Integer> randomNumber, int bonusNumber) {
        List<Integer> matchedNumber = new ArrayList<>();
        int count = 0;
        int bonus = 0;
        for (int number : numbers) {
            if (randomNumber.contains(number)) {
                count++;
            }
            if (randomNumber.contains(bonusNumber)){
                bonus++;
            }
        }
        matchedNumber.add(count);
        matchedNumber.add(bonus);
        return matchedNumber;
    }
}
