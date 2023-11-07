package lotto.parser;

import static lotto.exception.ErrorMessage.NOT_INTEGER;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.exception.LottoException;
import lotto.validator.Validator;

public class Parser {
    private static final String DELIMITER = ",";

    // 구입 금액을 구입 수량으로 변환한다.
    public static int parsePurchaseAmount(String input) {
        int purchaseAmount = parse(input);
        return Validator.validateUnit(purchaseAmount);
    }

    // 당첨 번호 목록을 Lotto 객체로 변환한다.
    public static Lotto parseWinningNumbers(String input) {
        List<Integer> winningNumbers = Stream.of(input.split(DELIMITER))
                .map(winningNumber -> parse(winningNumber.strip()))
                .toList();
        return new Lotto(winningNumbers);
    }

    // 보너스 번호를 숫자로 변환한다.
    public static int parseBonusNumber(String input, Lotto winningLotto) {
        int bonusNumber = parse(input);
        Validator.validateUnique(bonusNumber, winningLotto);
        return bonusNumber;
    }

    private static int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw LottoException.of(NOT_INTEGER);
        }
    }
}
