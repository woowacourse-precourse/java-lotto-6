package lotto.util;

import lotto.domain.Lotto;
import lotto.validation.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputConverter {

    private final InputValidator validator = InputValidator.getInstance();

    public int toPurchasePrice(String purchasePrice) {
        validator.purchasePrice(purchasePrice);
        return Integer.parseInt(purchasePrice);
    }

    public Lotto toLotto(String lottoNumber) {
        validator.lottoNumber(lottoNumber);

        List<Integer> numbers = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(lottoNumber, ",");
        while (st.hasMoreTokens()) {
            Integer number = Integer.valueOf(st.nextToken());
            numbers.add(number);
        }

        return new Lotto(numbers);
    }

}
