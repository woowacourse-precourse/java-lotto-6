package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorStatus;
import lotto.exception.LottoArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+$");
    private static final Pattern LOTTO_NUMBER_PATTERN = Pattern.compile("^(\\d{1,2},)+(\\d{1,2})$");

    public Integer inputMoney() {
        String money = readline(INPUT_MONEY_MESSAGE);
        validateNumberFormat(money);
        return Integer.parseInt(money);
    }

    public List<Integer> inputWinningLotto() {
        String winningLotto = readline(INPUT_WINNING_LOTTO_MESSAGE);
        validateWinningLottoFormat(winningLotto);
        return parseWinningLotto(winningLotto);
    }

    public Integer inputBonusBall() {
        String bonusBall = readline(INPUT_BONUS_BALL_MESSAGE);
        validateNumberFormat(bonusBall);
        return Integer.parseInt(bonusBall);
    }

    private String readline(String message) {
        System.out.println(message);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    private void validateNumberFormat(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new LottoArgumentException(ErrorStatus.POSITIVE_INTEGER_FORMAT_ERROR);
        }
    }

    private void validateWinningLottoFormat(String winningLotto) {
        if (!LOTTO_NUMBER_PATTERN.matcher(winningLotto).matches()) {
            throw new LottoArgumentException(ErrorStatus.LOTTO_NUMBER_FORMAT_ERROR);
        }
    }

    private List<Integer> parseWinningLotto(String winningLotto) {
        return Arrays.stream(winningLotto.split(","))
                .map(Integer::parseInt)
                .toList();
    }

}
