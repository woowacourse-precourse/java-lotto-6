package lotto.model;

import static lotto.exception.Exceptions.*;

import java.util.*;
import lotto.exception.Exceptions;
import lotto.model.LottoConstantsNumber;
import camp.nextstep.edu.missionutils.Randoms;
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        this.numbers = numbers;
    }
    
    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw Exceptions.exceptionLottoSize();
        }
    }

    public static void validateInputPurchaseAmount(int price) {
        if(price<1000||price%1000!=0) {
            throw Exceptions.exceptionInputPurchaseAmount();
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<Lotto> createLottoList(int price) {
        price /= 1000;

        List<Lotto> LottoList = new ArrayList<>();
        while (price> 0) {
            LottoList.add(createLotto());
            price--;
        }

        return LottoList;
    }

    public static Lotto createLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
    }

    public static void validateInputWinningNumber(String winningNumber){
        String[] numberStrings = winningNumber.split(",");

        for (String eachNumberStr : numberStrings) {
            int eachNumber=Integer.parseInt(eachNumberStr);
            if(eachNumber<1||eachNumber>45){
                throw Exceptions.exceptionWinningNumber();
            }
        }
    }

}
