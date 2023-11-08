package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String buyAmountInput = "구매 금액을 입력해주세요";
    private final String winningNumbersInput = "당첨 번호를 입력해주세요";

    private final String bonusNumber = "보너스 번호를 입력해 주세요.";

    public int readBuyAmount(){
        System.out.println(buyAmountInput);

        int buyAmount = 0;
        do {
            try {
                buyAmount = Integer.parseInt(Console.readLine());
                if (buyAmount <= 0) {
                    throw new IllegalArgumentException("구매 금액은 0보다 커야 합니다.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
            }
        } while (true);

        return buyAmount;
    }

    public String readWinningNumbers(){
        System.out.println(winningNumbersInput);

        String winningNumbers = "";
        do {
            winningNumbers = Console.readLine();
            String[] number = winningNumbers.split(",");
            if (number.length != 6) {
                throw new IllegalArgumentException("당첨 번호는 6자리 숫자여야 합니다.");
            }
            for (String n : number) {
                if (!n.matches("\\d+")) {
                    throw new IllegalArgumentException("당첨 번호는 숫자여야 합니다.");
                }
                if (Integer.parseInt(n) < 1 || Integer.parseInt(n) > 45) {
                    throw new IllegalArgumentException("당첨 번호는 1~45 사이의 숫자여야 합니다.");
                }
            }
            break;
        } while (true);

        return winningNumbers;
    }

    public int readBonusNumber() {
        int bonusNumber = 0;
        do {
            bonusNumber = readInputNumber();
            if (bonusNumber <= 0 || bonusNumber > 45) {
                throw new IllegalArgumentException("보너스 번호는 1~45 사이의 숫자여야 합니다.");
            }
            break;
        } while (true);

        return bonusNumber;
    }

    private int readInputNumber() {
        System.out.println(bonusNumber);

        String input = "";
        do {
            input = Console.readLine();
            if (input.isEmpty()) {
                throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
            }
            break;
        } while (true);

        int number = Integer.parseInt(input);
        return number;
    }
}