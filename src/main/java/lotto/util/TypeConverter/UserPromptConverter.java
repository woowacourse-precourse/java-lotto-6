package lotto.util.TypeConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserPromptConverter {

    public Integer convertingStringToInteger(String promptValue) {
        return Integer.parseInt(promptValue);
    }

    public List<Integer> convertingStringToListInteger(String PromptValue) {
        return Arrays.stream(PromptValue.split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

    }




}
