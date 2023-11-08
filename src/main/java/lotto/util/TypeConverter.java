package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class TypeConverter {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTT_NUM = 1;
    private static final int MAX_LOTT_NUM = 45;
    private static final String SPLIT_UNIT = ",";

    public Customer convertStringToCustomer(String input) {
        int paymentAmount = toInt(input);
        validatePrice(paymentAmount);
        return createCustomer(paymentAmount);
    }

    public Lotto convertStringToLotto(String input) {
        String[] split = input.split(SPLIT_UNIT);
        validateSize(split.length);
        return makeLotto(split);
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER_CONVERSION_ERROR, e);
        }
    }

    private void validatePrice(int paymentAmount) {
        if (paymentAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASED_AMOUNT_INPUT_ERROR);
        }
    }

    private Customer createCustomer(int paymentAmount) {
        return new Customer(paymentAmount / LOTTO_PRICE, paymentAmount);
    }

    private void validateSize(int size) {
        if(size != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE_ERROR);
        }
    }

    private Lotto makeLotto(String[] input) {
        List<Integer> numbers = new ArrayList<>();
        for (String str : input) {
            int number =  toInt(str);
            validateNumberRange(number);
            numbers.add(number);
        }

        return new Lotto(numbers);
    }

    private void validateNumberRange(int number) {
        if(number < MAX_LOTT_NUM || number > MAX_LOTT_NUM) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE_ERROR);
        }
    }

}

