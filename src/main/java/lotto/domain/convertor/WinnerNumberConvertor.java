package lotto.domain.convertor;

import java.util.List;
import java.util.stream.Collectors;
public class WinnerNumberConvertor implements Convertor<List<String>, List<Integer>> {
    @Override
    public List<Integer> convert(List<String> value) {
        return convertInputValue(value);
    }

    public List<Integer> convertInputValue(List<String> inputValue) {
        return inputValue.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}