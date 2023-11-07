package lotto.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IntegerListUtil {

    public static List<Integer> parseListseperatedBy(String input, String seperateStandard) {
        return Arrays.stream(input.split(seperateStandard))
                .filter(s -> !s.isEmpty())
                .map(IntegerUtil::trimAndParseInt) //TODO: parseInt로 바꿀지
                .collect(Collectors.toList());
    }
}
