package service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import utility.Utility;
import validator.Validator;

import java.util.ArrayList;
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
            Lotto lotto = new Lotto(Utility.SortAscending(generateRandomNumbers()));
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
}
