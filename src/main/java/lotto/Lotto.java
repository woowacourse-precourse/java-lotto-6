package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers(){
        return numbers;
    }

    public int CorrectLottoCount(Lotto winningNumbers){
        return (int)numbers.stream().filter(winningNumbers::containNumber).count();
    }

    public boolean containNumber(int number){
        return numbers.contains(number);
    }



    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void PrintInfo(List<Integer> lottoNumber) {
        for (Integer number : lottoNumber) {
            System.out.println(number);
        }
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}

