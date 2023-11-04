package lotto.service;

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
}
