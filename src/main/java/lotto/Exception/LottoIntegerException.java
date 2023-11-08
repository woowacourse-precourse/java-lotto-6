package lotto.Exception;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoIntegerException {

    public int checkForPriceException() {
        while(true) {
            try {
                int price = Integer.parseInt(Console.readLine());
                return price;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 정수를 입력해주세요.");
            }
        }
    }

    public int checkForBonus(String initialBonus) {
        int bonus = checkInt(initialBonus);
        checkPositive(bonus);

        return bonus;
    }

    public int checkInt(String initialNumber) {    //더 구현
        while(true) {
            try {
                int number = Integer.parseInt(initialNumber);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 정수를 입력해주세요.");
            }
        }
    }

    public void checkPositive(int number) {    //더 구현
        if (number < 1 && number > 45) {
            System.out.println("[ERROR] 1부터 45까지의 숫자를 입력해주세요.");
        }
    }

}
