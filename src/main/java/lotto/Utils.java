package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public List<String> splitStringToList(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }
}
