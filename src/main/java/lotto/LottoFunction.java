package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoFunction {

    Validator validator = new Validator();

    int divideThousand(String input) {
        int quotient;
        validator.isInteger(input);
        quotient = Integer.parseInt(input) / 1000;
        validator.isMultipleOfThousand(quotient);
        return quotient;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
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
