package lotto.controller;

import lotto.model.Constant;
import lotto.view.Message;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
    public static int convertMoney(String moneyString) {
        int money = 0;
        try {
            money =  Integer.parseInt(moneyString);
        } catch (Exception e){
            throw new IllegalArgumentException(Message.ERROR_MONEY);
        }

        if(money % Constant.LOTTO_PRICE != 0){
            throw new IllegalArgumentException();
        }

        return money;
    }

    public static List<Integer> convertNumber(String numberString) {
        List<Integer> numbers = new ArrayList<>();

        for (String n : numberString.split(",")) {
            int num = checkNumberValid(numbers, n.trim());
            numbers.add(num);
        }

        checkValidSize(numbers);

        return numbers;
    }

    public static void checkValidSize(List<Integer> numbers){
        if (numbers.size() != Constant.LOTTO_SELECT_NUMBER) {
            throw new IllegalArgumentException(Message.ERROR_WINNING_COUNT);
        }
    }

    public static int checkNumberValid(List<Integer> numbers, String numString) {
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

    public static int convertBonus(String bonusString, List<Integer> winning) {
        int bonus;

        try {
            bonus = Integer.parseInt(bonusString);
        } catch (Exception e) {
            throw new IllegalArgumentException(Message.ERROR_BONUS_RANGE);
        }

        checkBonusValid(bonus, winning);

        return bonus;
    }

    public static void checkBonusValid(int bonus, List<Integer> winning) {
        if(winning.contains(bonus)) {
            throw new IllegalArgumentException(Message.ERROR_BONUS_DUPLICATE);
        }
        if (bonus < Constant.LOTTO_START_NUMBER || bonus > Constant.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(Message.ERROR_BONUS_RANGE);
        }
    }
}
