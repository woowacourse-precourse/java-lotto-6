package controller;

import camp.nextstep.edu.missionutils.Console;
import model.ErrorMessage;
import model.Lotto;
import model.LottoInit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    private static final String SEPERATE = ",";

    public static int purchasePrice() {
        int price;
        while (true) {
            try {
                price = Integer.parseInt(Console.readLine());
                return price;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.WRONG_ORDER_TYPE.getMessage());
            }
        }
    }

    public static List<Integer> prizeNumber() {
        String inputNumber = Console.readLine();
        List<String> strPrizeNumbers = Arrays.asList(inputNumber.split(SEPERATE));
        List<Integer> prizeNumbers = new ArrayList<>();
        for (String prize : strPrizeNumbers) {
            int number = Integer.parseInt(prize);
            validateNumber(number);
            prizeNumbers.add(number);
        }
        Lotto.duplicateCheck(prizeNumbers);
        Lotto.validate(prizeNumbers);

        return prizeNumbers;
    }

    public static int bonusNumber() {
        int bonus = Integer.parseInt(Console.readLine());
        validateNumber(bonus);
        return bonus;
    }

    private static void validateNumber(int number) {
        if (number < LottoInit.LOTTO_MINIMUM.getInitial() || number > LottoInit.LOTTO_MAXIMUM.getInitial()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_RANGE_NUMBER.getMessage());
        }
    }
}
