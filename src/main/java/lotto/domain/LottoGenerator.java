package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.constants.Config;
import lotto.constant.messages.Error;

public class LottoGenerator {

    private int numberOfLotto;


    public void configMoney(String input) {
        validate(input);
        this.numberOfLotto = Integer.parseInt(input) / Config.LOTTO_PRICE.getConfig();
    }


    private List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(Config.LOTTO_MIN_NUMBER.getConfig(),
                Config.LOTTO_MAX_NUMBER.getConfig(), Config.LOTTO_SIZE.getConfig());
    }

    public Lottos generateLottos() {
        Lottos lottos = new Lottos();
        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(new Lotto(generateLotto()));
        }
        return lottos;
    }


    private void validate(String input) {
        isAllDigit(input);
        isParsible(input);
        isDividable(input);
        isLessThanLowerBound(input);
    }

    private void isLessThanLowerBound(String input) {
        if (Integer.parseInt(input) < Config.LOTTO_PRICE.getConfig()) {
            throw new IllegalArgumentException(Error.MONEY_TOO_SMALL.getMessage());
        }
    }

    private void isDividable(String input) {
        if (Integer.parseInt(input) % Config.LOTTO_PRICE.getConfig() > 0) {
            throw new IllegalArgumentException(Error.NOT_DIVIDABLE.getMessage());
        }

    }

    private void isParsible(String input) {
        try {
            Integer.parseInt(input);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(Error.MONEY_TOO_LARGE.getMessage());
        }
    }

    private void isAllDigit(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(Error.NOT_DIGIT.getMessage());
        }
    }
}