package lotto.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import lotto.Lotto;
import java.util.List;
import lotto.views.SystemMessage;
import lotto.constants.Constants;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoUtils {
    SystemMessage systemMessage = new SystemMessage();

    public Integer setPurchaseAmout() {
        Integer number = this.isValidAmount(systemMessage.getPurchasePrice());
        return number / 1000;
    }

    public List<Lotto> setLottoResult(Integer amount) {
        System.out.println("\n" + amount + Constants.PURCHASED_RESULT);
        List<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < amount; index++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(lotto);
            lottos.add(new Lotto(lotto));
        }
        return lottos;
    }

    public List<Integer> setLottoNumbers() {
        String[] input = systemMessage.getLottoNumbers().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < input.length; index++) {
            int number = parser(input[index]);
            numbers.add(number);
        }
        isNumbersDuplicate(numbers);
        return numbers;
    }

    public Integer setBonusNumber() {
        return parser(systemMessage.getBonusNumbers());
    }

    private Integer parser(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(Constants.LOTTO_INPUT_ERROR);
        }
        isValidNumbers(number);
        return number;
    }

    private void isValidNumbers(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(Constants.LOTTO_RANGE_ERROR);
        }
    }

    private void isNumbersDuplicate(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size()!= numbers.size()){
            throw new IllegalArgumentException(Constants.DUPLICATE_ERROR);
        }
    }

    private Integer isValidAmount(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(Constants.PURCHASE_ERROR);
        }
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(Constants.SPLIT_ERROR);
        }
        return number;
    }
}
