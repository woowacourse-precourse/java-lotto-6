package lotto;

import java.util.List;

public class CommaParser implements Parser {
    @Override
    public List<String> split(String numbers) {
        return List.of(numbers.split(","));
    }
}
