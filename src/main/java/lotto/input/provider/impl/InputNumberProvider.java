package lotto.input.provider.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import lotto.exception.ExceptionStatus;
import lotto.input.provider.NumberProvider;

public class InputNumberProvider implements NumberProvider {
    private final BufferedReader reader;

    public InputNumberProvider() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public Integer getSingle() throws IllegalArgumentException, IOException {
        String input = reader.readLine();
        try {
            Integer number = Integer.parseInt(input);
            if (number % 1000 != 0)
                throw new IllegalArgumentException(ExceptionStatus.MONEY_SHOULD_BE_MULTIPLE_OF_THOUSAND.getMessage());
            return number;
        }catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionStatus.INPUT_OUT_OF_RANGE.getMessage());
        }
    }

    @Override
    public List<Integer> getMultiple() throws IllegalArgumentException, IOException {
        String input = reader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
        List<Integer> result = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            try {
                Integer value = Integer.parseInt(token);
                if (0 > value || value > 45) {
                    throw new IllegalArgumentException(
                            ExceptionStatus.MONEY_SHOULD_BE_MULTIPLE_OF_THOUSAND.getMessage()
                    );
                }
                result.add(value);
            }catch (NumberFormatException exception) {
                throw new IllegalArgumentException(ExceptionStatus.INPUT_OUT_OF_RANGE.getMessage());
            }
        }
        return result;
    }
}
