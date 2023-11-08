package lotto.model;

import lotto.controller.exception.Errorcode;
import lotto.controller.exception.Exception;

import java.util.ArrayList;
import java.util.List;

public class ValidValues {
    public int validPurchase(String input) {
        int price;
        try {
            price = Integer.parseInt(input);
            Exception.price(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Errorcode.NOT_NUMBER.getMessage());
        }
        return price;
    }

    public List<Integer> validLotto(String input) {
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String number : input.split(",")) {
                numbers.add(Integer.parseInt(number));
            }
            Exception.lotto(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Errorcode.NOT_NUMBER.getMessage());
        }
        return numbers;
    }


    public Bonus validBonus(String input, List<Integer> winning) {
        int bonus;
        try {
            bonus = Integer.parseInt(input);
            Exception.bonus(bonus, winning);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Errorcode.NOT_NUMBER.getMessage());
        }
        return new Bonus(bonus);
    }
}
