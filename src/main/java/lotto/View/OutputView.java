package lotto.View;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OutputView
{
    public void printLotto(List<List<Integer>> lotto)
    {
        lotto.stream()
                .map(innerList -> innerList.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]")))
                .forEach(System.out::println);
    }
}
