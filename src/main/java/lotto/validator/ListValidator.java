package lotto.validator;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.InvalidInputException;

public class ListValidator<T> {
    private final List<T> list;

    private ListValidator(List<T> list) {
        this.list = list;
    }

    public static <T> ListValidator<T> of(List<T> list) {
        return new ListValidator<>(list);
    }

    public ListValidator<T> shouldHaveSize(int expectedSize, ErrorMessage errorMessage) {
        if (list.size() != expectedSize) {
            throw new InvalidInputException(errorMessage);
        }
        return this;
    }

    public ListValidator<T> shouldNotHaveDuplicates(ErrorMessage errorMessage) {
        if (list.stream().distinct().count() != list.size()) {
            throw new InvalidInputException(errorMessage);
        }
        return this;
    }

    public ListValidator<T> shouldAllMatch(ValidatorFunction<T> validatorFunction) {
        for (T element : list) {
            validatorFunction.validate(element);
        }
        return this;
    }

    @FunctionalInterface
    public interface ValidatorFunction<T> {
        void validate(T element);
    }


}
