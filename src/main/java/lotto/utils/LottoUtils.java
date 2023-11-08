package lotto.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
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
        systemMessage.printPurchasedResult(amount);
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
        for (String s : input) {
            int number = parser(s);
            numbers.add(number);
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Constants.NUMBER_RANGE_ERROR);
        }
        isNumbersDuplicate(numbers);
        return numbers;
    }

    public void setBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber = parser(systemMessage.getBonusNumbers());
        winningNumbers.add(bonusNumber);
        isNumbersDuplicate(winningNumbers);
    }

    public void setLottoResult(List<Lotto> lottos, List<Integer> winningNumbers) {
        systemMessage.setPrintResult();
        int threeWin = 0;
        int fourWin = 0;
        int fiveWin = 0;
        int bonusWin = 0;
        int wholeWin = 0;
        for (Lotto lotto : lottos) {
            compareLottoResult(lotto, winningNumbers);
            if (lotto.getSize() == 3) {
                threeWin++;
            }
            if (lotto.getSize() == 4) {
                fourWin++;
            }
            if (lotto.getSize() == 5) {
                fiveWin++;
            }
            if (lotto.getSize() == 6 && lotto.getNumbers().contains(winningNumbers.get(6))) {
                bonusWin++;
            }
            if (lotto.getSize() == 6) {
                wholeWin++;
            }
        }
        systemMessage.printLottoResult(threeWin, fourWin, fiveWin, bonusWin, wholeWin);
    }

    private void compareLottoResult(Lotto lotto, List<Integer> winningNumbers) {
        lotto.getNumbers().retainAll(winningNumbers);
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
