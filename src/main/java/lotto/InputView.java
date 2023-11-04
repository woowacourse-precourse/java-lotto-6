package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    // 테스트를 위해 분리
    public String inputStr() {
        return readLine();
    }

    public int inputPurchaseAmount(String inputStr) {
        int purchaseAmount = Integer.parseInt(inputStr);

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력 받습니다.");
        }
        return purchaseAmount;
    }
}
