package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
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

    HashSet<Integer> getLuckyNumbers(String input) {

        HashSet<Integer> luckyNumber = new HashSet<>();
        List<String> inputNumber = new ArrayList<>(List.of(input.split(",")));

        for (String splitInput : inputNumber) {
            validator.isInteger(splitInput);
            int number = Integer.parseInt(splitInput);
            validator.isInRange(number);
            luckyNumber.add(number);
        }

        if (luckyNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
        return luckyNumber;
    }

}
