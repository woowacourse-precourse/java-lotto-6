package lotto.domain.convertor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerNumberSpiltConvertor implements Convertor<String, List<String>> {
    @Override
    public List<String> convert(String value) {
        return convertInputValue(value);
    }

    public List<String> convertInputValue(String inputValue) {
        return Arrays.stream(inputValue.split(","))
                .collect(Collectors.toList());
    }
}
