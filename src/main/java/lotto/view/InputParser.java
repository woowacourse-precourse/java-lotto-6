package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputParser {
    // 구입금액 string > double (int 범위 넘어설 경우 대비)
    public double convertPurchaseAmount(String amount) {
        return Double.parseDouble(amount);
    }

    // 담첨번호 String > List<Integer>
    public List<Integer> convertWinningNumbers(String numbers) {
        return Stream.of(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    // 보너스번호 String > int
    public int convertBonusNumber(String bonus) {
        return Integer.parseInt(bonus);
    }
}
