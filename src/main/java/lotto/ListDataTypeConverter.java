package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class ListDataTypeConverter {

    public static List<String> intergerToString(List<Integer> elements) {
        return elements.stream().map(element -> Integer.toString(element)).collect(Collectors.toList());
    }

}
