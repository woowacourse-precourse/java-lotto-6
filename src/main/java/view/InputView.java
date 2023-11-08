package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private InputView() {
    }

    public static int inputMoney() {
        System.out.println("구입할 금액을 입력해 주세요.");
        while (true) {
            try {
                return checkInputMoney(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println(e.getMessage());
            }
        }
    }

    public static int checkInputMoney(String input) {
        int inputMoney = 0;
        try {
            inputMoney = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해주세요.");
        }
        if (inputMoney == 0 || inputMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000 단위어야 합니다.");
        }
        return inputMoney;
    }

    public static List<Integer> inputWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            String[] inputNumbers = Console.readLine().split(",");
            List<Integer> numbers = new ArrayList<>();
            for (String inputNumber : inputNumbers) {
                numbers.add(Integer.parseInt(inputNumber));
            }
            return numbers;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        } finally {
            System.out.println();
        }
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        } finally {
            System.out.println();
        }
    }
}
