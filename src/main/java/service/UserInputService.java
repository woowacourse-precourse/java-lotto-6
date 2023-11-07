package service;

import static util.ErrorMessage.AMOUNT_MUST_BE_DIVIDED_BY_PRICE;
import static util.ErrorMessage.ONLY_INPUT_NUMBER;
import static util.LottoValidationValue.LOTTO_PRICE;
import static util.Split.INPUT_SEPERATOR;

import camp.nextstep.edu.missionutils.Console;
import domain.Amount;
import domain.BonusNumber;
import domain.Lotto;
import java.util.ArrayList;
import java.util.List;

public class UserInputService {

    private static String input() {
        return Console.readLine();
    }

    // amount
    public static Amount amount() {
        while (true) {
            try {
                Amount amount = MakeObjectService.amount(Integer.parseInt(input()));
                if(amount.isValid()){
                    return amount;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(ONLY_INPUT_NUMBER.get());
            }
        }
    }

    //lotto
    public static Lotto lotto() {
        List<Integer> numbers = new ArrayList<>();

        while (true) {
            if (checkIsNumberList(input().split(INPUT_SEPERATOR.get()), numbers)) {
                Lotto lotto = MakeObjectService.lotto(numbers);
                if (lotto.isValid()) {
                    return lotto;
                }
            }
            numbers.clear();
        }
    }

    private static boolean checkIsNumberList(String[] input, List<Integer> numbers) {
        int count = 0;
        while (count < input.length) {
            try {
                numbers.add(Integer.parseInt(input[count]));
                count++;
            } catch (IllegalArgumentException e) {
                System.out.println(ONLY_INPUT_NUMBER.get());
                numbers.clear();
                return false;
            }
        }
        return true;
    }

    //bonusNumber
    public static BonusNumber bonusNumber(Lotto lotto) {
        while (true) {
            try {
                int number = Integer.parseInt(input());
                BonusNumber bonusNumber = MakeObjectService.bonusNumber(number, lotto);
                if (bonusNumber.isValid()) {
                    return bonusNumber;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(ONLY_INPUT_NUMBER.get());
            }
        }
    }
}
