package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.constants.Config;
import lotto.constant.messages.Error;

public class LottoGenerator {

    private int numberOfLotto;


    public void configMoney(String input) {
        checkInputFormat(input);
        this.numberOfLotto = Integer.parseInt(input) / Config.LOTTO_PRICE.getConfig();
    }


    private List<Integer> generateLottoNumber() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < Config.LOTTO_SIZE.getConfig()) {
            numbers.add(Randoms.pickNumberInRange(Config.LOTTO_MIN_NUMBER.getConfig(),
                    Config.LOTTO_MAX_NUMBER.getConfig()));
        }
        return new ArrayList<>(numbers.stream().toList());
    }

    public Lottos generateMyLottos() {
        Lottos lottos = new Lottos();
        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(new Lotto(generateLottoNumber()));
        }
        return lottos;
    }


    public void checkInputFormat(String input) {
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