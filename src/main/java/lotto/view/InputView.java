package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

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
            if (number.length == 6) {
                break;
            }
            System.out.println(" [ERROR] 당첨 번호는 6자리 숫자여야 합니다.");
        } while (true);

        return winningNumbers;
    }

    public int readBonusNumber() {
        int bonusNumber = 0;
        do {
            bonusNumber = readInputNumber();
            if (bonusNumber > 0 && bonusNumber <= 45) {
                break;
            }
            System.out.println("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        } while (true);

        return bonusNumber;
    }

    private int readInputNumber() {
        System.out.println(bonusNumber);

        String input = "";
        do {
            input = Console.readLine();
            if (!input.isEmpty()) {
                break;
            }
            System.out.println("[ERROR] 빈 값은 입력할 수 없습니다.");
        } while (true);

        int number = Integer.parseInt(input);
        return number;
    }
}
