package service;

import static util.ErrorMessage.ONLY_INPUT_NUMBER;
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
        Amount amount;
        while (true) {
            try {
                amount = MakeObjectService.amount(Integer.parseInt(input()));
            } catch (IllegalArgumentException e) {
                System.out.println(ONLY_INPUT_NUMBER.get());
                continue;
            }

            if (amount.isValid()) {
                return amount;
            }
        }
    }

    //lotto
    public static Lotto lotto() {
        List<Integer> numbers = new ArrayList<>();
        Lotto lotto = null;

        while (true) {
            if (checkIsNumberList(input().split(INPUT_SEPERATOR.get()), numbers)) {
                lotto = MakeObjectService.lotto(numbers);
            }

            if (lotto != null && lotto.isValid()) {
                return lotto;
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
        int number;
        BonusNumber bonusNumber;
        while (true) {
            try {
                number = Integer.parseInt(input());
                bonusNumber = MakeObjectService.bonusNumber(number, lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(ONLY_INPUT_NUMBER.get());
                continue;
            }
            if (bonusNumber.isValid()) {
                return bonusNumber;
            }
        }
    }
}
