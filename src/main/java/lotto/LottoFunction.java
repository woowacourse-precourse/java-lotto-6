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

    HashSet<Integer> getLuckyNumbers(String input) {

        HashSet<Integer> luckyNumber = new HashSet<>();
        List<String> inputNumber = new ArrayList<>(List.of(input.split(",")));

        for (String splitInput : inputNumber) {
            Validator.isInteger(splitInput);
            int number = Integer.parseInt(splitInput);
            Validator.isInRange(number);
            luckyNumber.add(number);
        }

        if (luckyNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
        return luckyNumber;
    }

    Integer getBonusNumber(String input, HashSet<Integer> luckyNumbers) {

        Validator.isInteger(input);
        Integer bonusNumber = Integer.parseInt(input);

        Validator.isInRange(bonusNumber);

        if (luckyNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR]");
        }
        return bonusNumber;
    }

    void getRank(List<Lotto> lottos, List<Integer> luckyNumbers, Integer bonusNumber) {
        for (Lotto lotto : lottos) {

        }
    }


}
