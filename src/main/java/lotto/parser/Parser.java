package lotto.parser;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;

public class Parser {
    // 구입 금액을 구입 수량으로 변환한다.
    public static int parsePurchaseAmount(String input) {
        int purchaseAmount = parse(input);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
        }
        return purchaseAmount / 1000;
    }

    // 당첨 번호 목록을 Lotto 객체로 변환한다.
    public static Lotto parseWinningNumbers(String input) {
        List<Integer> winningNumbers = Stream.of(input.split(","))
                .map(winningNumber -> parse(winningNumber.strip()))
                .toList();
        return new Lotto(winningNumbers);
    }

    // 보너스 번호를 숫자로 변환한다.
    public static int parseBonusNumber(String input) {
        return parse(input);
    }

    private static int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
