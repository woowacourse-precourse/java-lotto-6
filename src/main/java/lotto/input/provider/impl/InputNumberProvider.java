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
            return Integer.parseInt(input);
        }catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionStatus.INPUT_OUT_OF_RANGE.getMessage());
        }
    }

    @Override
    public List<Integer> getMultiple(int number) throws IllegalArgumentException, IOException {
        String input = reader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
        List<Integer> result = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            try {
                Integer value = Integer.parseInt(token);
                result.add(value);
            }catch (NumberFormatException exception) {
                throw new IllegalArgumentException(ExceptionStatus.INPUT_OUT_OF_RANGE.getMessage());
            }
        }
        if (result.size() != number)
            throw new IllegalArgumentException(ExceptionStatus.INPUT_NUM_IS_WRONG.getMessage());
        return result;
    }
}
