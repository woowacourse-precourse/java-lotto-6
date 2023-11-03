package lotto.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterModel {

    public List<Integer> convertStringToIntList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
