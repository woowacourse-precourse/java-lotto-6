package lotto.domain;

import lotto.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.Buyer.getLotteries;

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

    public void guessPrizeNumbers(Buyer buyer){
        // 비교할 List 준비
        List<Integer> compareNumbers = new ArrayList<>(prizeNumber);
        List<Lotto> Lotteries = getLotteries();

        for (int i = 0; i < Lotteries.size(); i++){
            Lotto lotto = Lotteries.get(i);
            compareNumbers.retainAll(lotto.numbers);
        }


    }



}
