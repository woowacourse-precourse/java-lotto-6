package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InputManager {
    private InputManager() {}

    private static class SingletonHelper {
        private static final InputManager inputManager = new InputManager();
    }

    public static InputManager getInstance() {
        return SingletonHelper.inputManager;
    }

    public int readPurchase() {
        int money = 0;

        while(true) {
            try {
                String input = Console.readLine();
                validateInputMoneyFormat(input);

                money = Integer.parseInt(input);
                validateInputMoneyUnit(money);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    public List<Integer> readWinningNumber() {
        String[] inputs;
        while (true) {
            try {
                String input = Console.readLine();
                inputs = input.split(",");

                validateWinningNumberSize(inputs);
                validateWinningNumberFormat(inputs);
                validateInputNumberRange(inputs);
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return StringArrToIntegerList(inputs);
    }

    public int readInputBonusNumber() {
        String input;

        while (true) {
            try {
                input = Console.readLine();

                validateInputBonusNumberFormat(input);
                validateInputNumberRange(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(input);
    }

    public void validateInputMoneyFormat(String input) {
        Pattern pattern = Pattern.compile("[0-9]+");

        if(!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자만 입력 가능합니다.");
        }
    }

    public void validateInputMoneyUnit(int money) {
        int remainder = money % 1000;

        if(remainder != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000단위로 입력 가낭흡니다.");
        }
    }

    public void validateWinningNumberSize(String[] inputs) {
        if(inputs.length != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void validateWinningNumberFormat(String[] inputs) {
        Pattern pattern = Pattern.compile("[0-9]{1,2}");

        for(String input : inputs) {
            if(!pattern.matcher(input).matches()) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1 ~ 45 사이의 숫자만 입력 가능합니다.");
            }
        }
    }

    public void validateInputNumberRange(String[] inputs) {
        for(String input : inputs) {
            int inputNumber = Integer.parseInt(input);

            if(inputNumber < 1 || inputNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1 ~ 45 사이의 숫자만 입력 가능합니다.");
            }
        }
    }

    public void validateInputNumberRange(String input) {
        int inputNumber = Integer.parseInt(input);

        if(inputNumber < 1 || inputNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자만 입력 가능합니다.");
        }
    }

    public List<Integer> StringArrToIntegerList(String[] inputs) {
        List<Integer> winningNumbers = new ArrayList<>();

        for(String input : inputs) {
            winningNumbers.add(Integer.parseInt(input));
        }

        return winningNumbers;
    }



    public void validateInputBonusNumberFormat(String input) {
        Pattern pattern = Pattern.compile("[0-9]{1,2}");

        if(!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자만 입력 가능합니다.");
        }
    }
}
