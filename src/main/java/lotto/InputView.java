package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    public static String playerInput() {
        return Console.readLine();
    }

    public static int getPurchaseAmount() {
        try {
            OutputView.printMessage("구입 금액을 입력해 주세요");
            String input = playerInput().trim();
            if (!input.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해 주세요.");
            }
            int purchaseAmount = Integer.parseInt(input);
            if (purchaseAmount < 0) {
                throw new IllegalArgumentException("[ERROR] 음수 값을 입력할 수 없습니다.");
            }
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return getPurchaseAmount();
        }
    }

    public static List<Integer> getWinningNumbers() {
        try {
            OutputView.printMessage("당첨 번호를 입력해 주세요");
            String input = playerInput().trim(); // 입력된 문자열 앞뒤 공백 제거
            String[] numberStrings = input.split(",");

            Set<Integer> uniqueNumbers = new HashSet<>();

            for (String numberString : numberStrings) {
                int number = Integer.parseInt(numberString);
                if (number < 1 || number > 45 || !uniqueNumbers.add(number)) {
                    throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 중복되지 않는 숫자 6개를 쉼표로 구분하여 입력해 주세요.");
                }
            }

            if (uniqueNumbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 중복되지 않는 숫자 6개를 입력해 주세요.");
            }

            return StringUtil.convertToIntegerList(input, ",");
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return getWinningNumbers();
        }
    }

    public static int getBonusNumber(Set<Integer> winningNumbers) {
        try {
            OutputView.printMessage("보너스 번호를 입력해 주세요");
            int bonusNumber = Integer.parseInt(playerInput().trim());

            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력해 주세요.");
            }

            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 이미 당첨 번호로 선택된 숫자입니다.");
            }

            return bonusNumber;
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }
}
