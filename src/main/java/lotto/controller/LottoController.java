package lotto.controller;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.controller.RandNumber.makeUniqueNumber;

public class LottoController {
    public static List<Lotto> listOfLotto(int count){
        List<Lotto> lottery = new ArrayList<>();
        for (int i = 0; i < count; i++){
            lottery.add(makelottory());
        }
        return lottery;
    }

    public static Lotto makelottory(){
        Lotto lotto = null;
        List<Integer> number = makeUniqueNumber();
        lotto = new Lotto(number);
        return lotto;
    }

    public static List<Integer> sortNumber(Lotto lotto) {
        List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
