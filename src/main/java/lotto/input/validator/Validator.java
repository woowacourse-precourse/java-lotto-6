package lotto.input.validator;

import java.util.List;

public interface Validator {
    public void validate(Integer number) throws IllegalArgumentException;
    public void validate(List<Integer> numbers) throws IllegalArgumentException;
}
