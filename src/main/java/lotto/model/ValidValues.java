package lotto.model;

import lotto.controller.exception.Errorcode;

import java.util.ArrayList;
import java.util.List;

public class ValidValues {
    public int validPurchase(String input) {
        int price;
        try {
            price = Integer.parseInt(input);
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
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Errorcode.NOT_NUMBER.getMessage());
        }
        return numbers;
    }


    public Bonus validBonus(String input) {
        int bonus;
        try {
            bonus = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Errorcode.NOT_NUMBER.getMessage());
        }
        return new Bonus(bonus);
    }
}
