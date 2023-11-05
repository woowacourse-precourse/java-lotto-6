package lotto.utils;

import lotto.utils.validator.ParserValidator;
import lotto.utils.validator.UnitValidator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    public static List<Integer> parse(String winnerNumbers){
        ParserValidator.commaValid(winnerNumbers);
        List<Integer> integers = Stream.of(winnerNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        UnitValidator.validNumberUnitCheck(integers);

        return integers;
    }
}
