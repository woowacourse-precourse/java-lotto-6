package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoFunction {

    Integer getQuantity(String input) {
        Validator.isInteger(input);
        int amount = Integer.parseInt(input);
        Validator.isNotZero(amount);
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

    List<Integer> trimInput(String input) {
        List<Integer> output = new ArrayList<>();
        for (String sliced : List.of(input.split(","))) {
            String trimmed = sliced.trim();
            int trimmedNumber = Change.stringToInt(trimmed);
            output.add(trimmedNumber);
        }
        return output;
    }

    List<Prize> getPrizes(List<Lotto> lottos, LuckyNumber luckyNumber) {
        List<Prize> prizes = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Prize prize = lotto.compare(luckyNumber);
            prizes.add(prize);
        }
        return prizes;
    }

    Integer sumPrizes(List<Prize> prizes) {
        int sum = 0;
        for (Prize prize :
                prizes) {
            sum += prize.getPrize();
        }
        return sum;
    }

    String getEarningRate(int quantity, List<Prize> prizes) {
        float result = (float) sumPrizes(prizes) / (quantity * 1000) * 100;
        return String.format(Print.totalReturnRate, result);
    }

}
