package lotto.service;

import static lotto.constant.LottoMessage.LOTTO_WINNING_NUMBERS_DELIMITER;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotto;

public class DrawingLottoService {
    public Lotto createWinningNumber(String inputWinningNumber) {
        List<Integer> winningNumber = validateWinningNumber(inputWinningNumber);

        return new Lotto(winningNumber);
    }

    private List<Integer> validateWinningNumber(String inputWinningNumber) {
        checkDelimiter(inputWinningNumber);

        return toIntegerList(inputWinningNumber);
    }

    private void checkDelimiter(String inputWinningNumber) {
        if (!inputWinningNumber.contains(LOTTO_WINNING_NUMBERS_DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 6개의 당첨 번호를 쉼표(,) 기준으로 구분하여 입력해 주세요.");
        }
    }

    private List<Integer> toIntegerList(String inputWinningNumber) {
        try {
            return Stream.of(inputWinningNumber.split(LOTTO_WINNING_NUMBERS_DELIMITER)).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호은 숫자만 입력이 가능합니다.");
        }
    }
}
