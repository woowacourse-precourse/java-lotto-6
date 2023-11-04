package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    // 테스트를 위해 분리
    public String inputStr() {
        return readLine();
    }

    public int inputPurchaseAmount(String inputStr) {
        if (!inputStr.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로만 구성됩니다.");
        }

        int purchaseAmount = Integer.parseInt(inputStr);

        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력 받습니다.");
        }
        return purchaseAmount;
    }

    public List<Integer> inputPrizeNumber(String inputStr) {
        List<Integer> prizeNumber = Arrays.stream(inputStr.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return prizeNumber;
    }
}
