package lotto.controller;

import lotto.model.Constant;
import lotto.view.Message;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
    public static int convertMoney(String moneyString) {
        int money = 0;
        try {
            money = Integer.parseInt(moneyString);
        } catch (Exception e) {
            throw new IllegalArgumentException(Message.ERROR_MONEY);
        }

        validateMoney(money);

        return money;
    }

    public static List<Integer> convertNumber(String numberString) {
        List<Integer> numbers = new ArrayList<>();

        for (String n : numberString.split(",")) {
            int num = validateNumber(numbers, n.trim());
            numbers.add(num);
        }
        validateLottoSize(numbers);

        return numbers;
    }

    public static int convertBonus(String bonusString, List<Integer> winning) {
        int bonus;

        try {
            bonus = Integer.parseInt(bonusString);
        } catch (Exception e) {
            throw new IllegalArgumentException(Message.ERROR_BONUS_RANGE);
        }
        validateBonus(bonus, winning);

        return bonus;
    }

    private static void validateMoney(int money){
        if (money % Constant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_SELECT_NUMBER) {
            throw new IllegalArgumentException(Message.ERROR_WINNING_COUNT);
        }
    }

    private static int validateNumber(List<Integer> numbers, String numString) {
        int num;

        try {
            num = Integer.parseInt(numString);
        } catch (Exception e) {
            throw new IllegalArgumentException(Message.ERROR_WINNING_RANGE);
        }
        if (numbers.contains(num)) {
            throw new IllegalArgumentException(Message.ERROR_WINNING_DUPLICATE);
        }
        if (num < Constant.LOTTO_START_NUMBER || num > Constant.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(Message.ERROR_WINNING_RANGE);
        }

        return num;
    }

    private static void validateBonus(int bonus, List<Integer> winning) {
        if (winning.contains(bonus)) {
            throw new IllegalArgumentException(Message.ERROR_BONUS_DUPLICATE);
        }
        if (bonus < Constant.LOTTO_START_NUMBER || bonus > Constant.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(Message.ERROR_BONUS_RANGE);
        }
    }
}
