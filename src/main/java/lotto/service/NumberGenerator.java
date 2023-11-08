package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.configuration.LottoConfig.*;
import static lotto.configuration.Constants.Config.*;
import static lotto.configuration.Constants.*;

public class NumberGenerator {

    public int createOne(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Errors.MESSAGE + Errors.CONVERT_NUMBER_ERROR);
        }
        return number;
    }

    public List<List<Integer>> createRandomNumberLists(int count) {
        List<List<Integer>> randomNumberLists = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(START.getValue(), END.getValue(), COUNT.getValue())
            );
            randomNumberLists.add(randomNumbers);
        }
        return randomNumberLists;
    }

    public List<Integer> createNumbers(String input) {
        return Arrays.stream(input.split(DELIM))
                .map(this::createOne)
                .collect(Collectors.toList());
    }

}
