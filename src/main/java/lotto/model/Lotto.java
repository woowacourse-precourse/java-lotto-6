package lotto.model;

import java.util.*;
import lotto.model.LottoConstantsNumber;
import camp.nextstep.edu.missionutils.Randoms;
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean validateInputPurchaseAmount(int price) {
        return (price >= 1000 && price % 1000 == 0);
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

}
