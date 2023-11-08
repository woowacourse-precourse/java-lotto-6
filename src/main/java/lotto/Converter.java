package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Converter {
    public Converter() {

    }

    public List<String> splitNumbers(String numbers) {
        List<String> result = Arrays.asList(numbers.split(","));

        return result;
    }

    public List<Integer> convertTypes(List<String> numbers) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            String lottoNumber = numbers.get(i);
            result.add(Integer.parseInt(lottoNumber));
        }

        return result;
    }

    public List<Integer> sortToAscending(List<Integer> numbers) {
        Collections.sort(numbers);

        return numbers;
    }

    public List<Integer> convertLottoNumbersInput(String numbers) {
        List<String> splits = splitNumbers(numbers);
        List<Integer> converts = convertTypes(splits);
        List<Integer> sorts = sortToAscending(converts);

        return sorts;
    }
}
