package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static lotto.controller.LottoGameController.bonusNumber;
import static lotto.controller.LottoGameController.winningLotto;

public class Lotto {
    private final List<Integer> numbers;
    public final int LOTTO_NUMBER_SIZE = 6;
    public int countWinningNum;
    public boolean hasBonus;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
        if (numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int countSameNum() {
        int sameNum =  (int) this.numbers.stream().filter(winningLotto.numbers::contains).count();
        this.countWinningNum = sameNum;
        return sameNum;
    }



    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public void checkHasBonus(){
        if(this.numbers.contains(bonusNumber)) this.hasBonus = true;
    }
}

