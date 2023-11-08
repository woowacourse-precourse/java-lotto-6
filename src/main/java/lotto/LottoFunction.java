package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoFunction {

    Integer getQuantity(String input) {
        Validator.isInteger(input);
        Integer amount = Integer.parseInt(input);
        Validator.isMultipleOfThousand(amount);
        return (amount / 1000);
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    List<Lotto> buyLotto(int amount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = generateLottoNumbers();
            lottoList.add(new Lotto(numbers));
        }
        return lottoList;
    }



}
