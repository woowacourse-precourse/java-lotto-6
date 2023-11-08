package lotto.service;

import static lotto.validation.Validation.validateStringForSplit;
import static lotto.validation.Validation.validateWinnerNumbers;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.PrizeResult;

public class Service {
    private static final int ZERO = 0;
    private static final int MIN_NUMBER = 1;
    private static final int SIZE = 6;
    private static final int MAX_NUMBER = 45;

    public List<Lotto> createLottos(int TicketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = ZERO; i < TicketCount; i++) {
            lottos.add(createRandomLottoNumber());
        }
        return lottos;
    }

    public Lotto createRandomLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, SIZE);
        return new Lotto(numbers);
    }

    public List<Integer> splitStringToIntegerList(String winningNumbers) {
        List<String> splitNumbers = validateStringForSplit(winningNumbers);
        return validateWinnerNumbers(splitNumbers);
    }

    public double getYield(PrizeResult prizeResult, int amount) {
        System.out.println(getAllMoney(prizeResult));
        System.out.println(amount);
        return ((double) getAllMoney(prizeResult) / amount) * 100;
    }

    private long getAllMoney(PrizeResult prizeResult) {
        int result = 0;

        for (Prize prize : Prize.values()) {
            result += prizeResult.getPrizeCount(prize) * prize.getMoney();
        }

        return result;
    }


}
