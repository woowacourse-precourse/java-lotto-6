package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;
import utility.Utility;
import validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {
    final static int THOUSAND = 1000;
    Validator validator = new Validator();

    public int getMoneyByUserInput(String input) {
        validator.checkIsNumber(input);
        int money = Integer.parseInt(input);
        validator.checkMinMoney(money);
        validator.checkDividedByThousand(money);
        return money;
    }

    public List<Lotto> generateLotto(int lottoAmount) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = new Lotto(Utility.sortAscending(generateRandomNumbers()));
            lottos.add(lotto);
        }
        return lottos;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public int calculateLottoAmount(int money) {
        return money / THOUSAND;
    }

    public List<Integer> getWinNumbersByUserInput(String input) {
        validator.checkStartOrEndWithComma(input);
        List<String> numbers = Arrays.stream(Utility.splitByComma(input)).toList();
        validator.checkCount(numbers);
        List<Integer> winNumbers = new ArrayList<Integer>();
        for(String number : numbers){
            validator.checkIsNumber(number);
            winNumbers.add(Integer.parseInt(number));
        }
        validator.checkDuplicateNumber(winNumbers);
        return winNumbers;
    }
}
