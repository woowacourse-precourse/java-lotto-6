package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.HashSet;
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
        if (!inputStr.matches("^\\d+(,\\d+)*$")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자로 구성되고 쉼표(,)로 구분됩니다.");
        }

        List<Integer> prizeNumber = Arrays.stream(inputStr.split(","))
                .map(s -> {
                    int num = Integer.parseInt(s);
                    if (num > 45) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 45 이하의 숫자로 구성됩니다.");
                    }
                    return num;
                })
                .collect(Collectors.toList());

        if (prizeNumber.size() != new HashSet<>(prizeNumber).size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되면 안됩니다.");
        }

        if (prizeNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자로 구성됩니다.");
        }

        return prizeNumber;
    }
}
