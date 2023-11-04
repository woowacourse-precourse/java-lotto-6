package lotto.domain;

import lotto.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class Prize {
    private List<Integer> prizeNumber;
    private int bonusNumber;

    public Prize(String prizeNumber, int bonusNumber) {
        this.bonusNumber = bonusNumber;
        this.prizeNumber = makePrizeNumbers(prizeNumber);
    }

    public List<Integer> makePrizeNumbers(String prizeNumber){
        List<String> numbers = List.of(prizeNumber.split(","));
        List<Integer> prizeNumbers = new ArrayList<>();
        for (String number : numbers){
            prizeNumbers.add(Utils.ChangeStringToInt(number));
        }

        return prizeNumbers;
    }


}
