package lotto.converter;

import java.util.List;

public class SortNumbersConverter implements Converter<List<Integer>, List<Integer>> {

    @Override
    public List<Integer> convert(final List<Integer> source) {
        return source.stream()
                .sorted()
                .toList();
    }

}
