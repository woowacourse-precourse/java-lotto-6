package lotto.util.TypeConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static lotto.Common.ErrorMessage.*;

public class UserPromptConverter {

    public Integer convertingStringToInteger(String promptValue) {
        try {
            return Integer.parseInt(promptValue);
        }catch ( IllegalArgumentException e){
            throw new  IllegalArgumentException(INPUT_NOT_INTEGER.getMessage());
        }
    }

    public List<Integer> convertingStringToListInteger(String PromptValue) {
        try {
            return Arrays.stream(PromptValue.split(","))
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INPUT_WRONG_SEPARATOR.getMessage());
        }
    }




}
