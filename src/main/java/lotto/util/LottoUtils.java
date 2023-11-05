package lotto.util;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class LottoUtils {
    private static final String COMMA = ",";
    public static <T> T requestInputWithValidator(Supplier<T> inputSupplier, Function<T, T> validatorFunction) {
        try {
            T input = inputSupplier.get();
            return validatorFunction.apply(input);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return requestInputWithValidator(inputSupplier, validatorFunction);
        }
    }

    public static List<Integer> convertInputToLotto(String input) {
        List<Integer> lotto = new ArrayList<Integer>();

        String[] splitStr = input.split(COMMA);

        Arrays.stream(splitStr).forEach(
                l -> lotto.add(Integer.parseInt(l))
        );
        return lotto;
    }
}
