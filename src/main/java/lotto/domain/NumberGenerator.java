package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.configuration.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.configuration.LottoConfig.*;

public class NumberGenerator {

    public int createOne(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.Error.MESSAGE + Constants.Error.CONVERT_NUMBER_ERROR);
        }
        return number;
    }

    public List<List<Integer>> createRandomNumberLists(int lottoCount) {
        List<List<Integer>> randomNumberLists = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(START.getValue(), END.getValue(), COUNT.getValue())
            );
            randomNumberLists.add(randomNumbers);
        }
        return randomNumberLists;
    }

    public List<Integer> createNumbers(String input) {
        return Arrays.stream(input.split(Constants.Rule.DELIM))
                .map(this::createOne)
                .collect(Collectors.toList());
    }

}
