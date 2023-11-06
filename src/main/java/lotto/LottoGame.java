package lotto;

import java.util.HashSet;
import java.util.List;

public class LottoGame {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoGame(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers,bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {

        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if(bonusNumber<0||bonusNumber>45){
            throw new IllegalArgumentException();
        }

        HashSet<Integer> set = new HashSet<>();

        for(int number: numbers){

            if(set.isEmpty()){
               set.add(number);
               continue;
            }

            if (set.contains(number)){

                throw new IllegalArgumentException();

            }

            set.add(number);


        }
    }

}
