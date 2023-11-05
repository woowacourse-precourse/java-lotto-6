package lotto.view;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
    public int requestPurchaseOfLotto() {
        printPurchaseMessage();
        String input = readMessage();

        try {
            int price = Integer.valueOf(input);
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력 가능합니다.");
        }
    }

    private void printPurchaseMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private String readMessage() {
        return Console.readLine();
    }

    public int requestBonusNumber() {
        printBonusNumberMessage();
        String input = readMessage();

        try {
            int bonusNumber = Integer.valueOf(input);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }
    }

    private void printBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

}
