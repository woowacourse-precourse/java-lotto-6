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
}
