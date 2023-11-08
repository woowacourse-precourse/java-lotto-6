package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;

public class InputView {

    private InputView() {

    }

    public static int getInputNumber() {
        System.out.println("구입금액을 입력해 주세요.");

        while (true) {
            try {
                return checkInputNumber(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int checkInputNumber(String input) {
        int inputNumber = 0;
        try {
            inputNumber = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(System.lineSeparator() + "[ERROR] 숫자만 입력 가능합니다. 다시 입력해주세요.");
        }
        if (inputNumber == 0 || inputNumber % 1000 != 0) {
            throw new IllegalArgumentException(System.lineSeparator() + "[ERROR] 1,000원 단위의 숫자만 입력 가능합니다. 다시 입력해주세요.");
        }
        return inputNumber;
    }

    public static int getBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        while (true) {
            try {
                return checkNumber(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int checkNumber(String input) {
        int inputNumber = 0;

        try {
            inputNumber = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(System.lineSeparator() + "[ERROR] 숫자만 입력 가능합니다. 다시 입력해주세요.");
        }

        if (inputNumber < Lotto.LOTTO_NUMBER_MIN || inputNumber > Lotto.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(System.lineSeparator() + "[ERROR] 로또 번호는 1~45 사이의 숫자입니다.");
        }

        return inputNumber;
    }

    public static List<Integer> winningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        while (true) {
            try {
                return conversionNumber(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> conversionNumber(String inputWinningNumbers) {
        String[] inputWinningNumber = inputWinningNumbers.split(",");
        if (inputWinningNumber.length != Lotto.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(System.lineSeparator() + "[ERROR] 6개의 숫자를 입력해 주세요.");
        }
        Set<Integer> numbers = new HashSet<>();
        for (String s : inputWinningNumber) {
            numbers.add(checkNumber(s));
        }
        if (numbers.size() != Lotto.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(System.lineSeparator() + "[ERROR] 중복된 숫자가 있습니다.");
        }
        return new ArrayList<>(numbers);
    }
}
