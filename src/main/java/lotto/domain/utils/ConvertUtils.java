package lotto.domain.utils;

import java.util.Arrays;
import java.util.List;

public class ConvertUtils {

    public static List<Integer> convertStringToList(String target, String delimiter){
        target = target.replaceAll(" ", "");
        return Arrays.stream(target.split(delimiter))
                .map(Integer::valueOf)
                .toList();

    }


}
