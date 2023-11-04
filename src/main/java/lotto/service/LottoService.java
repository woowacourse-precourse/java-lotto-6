package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    private static final String COMMAS = ",";

    public List<Integer> convertToLottoIntegerList(String userInput) {
        return Arrays.stream(userInput.split(COMMAS))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> generateRandomLottoNumbers(){

        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int count = 0; count < 8; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }
}
