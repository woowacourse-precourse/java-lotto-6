package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
가import lotto.constants.messages.Error;

public class LottoGenerator {

    private Integer money;
    private final int numberOfTickets;


    public LottoGenerator(String input) {
        checkInputFormat(input);
        int money = Integer.parseInt(input);
        this.money = money;
        this.numberOfTickets = money / 1000;
    }


    private List<Integer> generateLottoNumber() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 6) {
            numbers.add(Randoms.pickNumberInRange(1, 45));
        }
        return new ArrayList<>(numbers.stream().toList());
    }

    public Lottos generateMyTickets() {
        Lottos lottos = new Lottos();
        for (int i = 0; i < numberOfTickets; i++) {
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
        if (Integer.parseInt(input) < 1000) {
            throw new IllegalArgumentException(Error.MONEY_TOO_SMALL.getMessage());
        }
    }

    private void isDividable(String input) {
        if (Integer.parseInt(input) % 1000 > 0) {
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