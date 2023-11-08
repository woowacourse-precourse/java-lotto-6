package lotto;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StringSplitter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (!(source instanceof String input)) {
            throw new IllegalArgumentException(
                    "The argument should be a string: " + source);
        }

        return splitAndConvert(input);
    }

    private List<Integer> splitAndConvert(String input) {
        String[] parts = input.split(", ");

        try {
            return Arrays.stream(parts)
                    .map(part ->  Integer.parseInt(part.trim()))
                    .collect(toList());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("The input should be able to converted into numeric.");
        }

    }


}
