package lotto.view;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public InputView() {
    }

    public int getPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String purchaseAmountString = Console.readLine();
            if (isNumeric(purchaseAmountString)) {
                int purchaseAmount = Integer.parseInt(purchaseAmountString);
                if (!(purchaseAmount % 1000 == 0 && purchaseAmount >= 1000)) {
                    throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력하세요.");
                }
                return purchaseAmount;
            }
        }
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = new ArrayList<>();
        String numberString = Console.readLine();

        String[] numberTokens = numberString.split(",");

        for (String token : numberTokens) {
            int number = Integer.parseInt(token.trim());

            if (number < 1 || number > 45 || winningNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 중복되지 않는 숫자를 입력하세요.");
            }

            winningNumbers.add(number);
        }

        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하세요.");
        }

        return winningNumbers;
    }

    public int getBonusNumber() {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            int number = Integer.parseInt(Console.readLine());
            if (number >= 1 && number <= 45) {
                return number;
            } else {
                System.out.println("[ERROR] 1~45 사이의 숫자를 입력하세요.");
            }
        }
    }
}

