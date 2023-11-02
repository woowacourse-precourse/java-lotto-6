package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.exception.ErrorMessage.NOT_POSITIVE_INTEGER;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.LottoException;

public class InputView {

    private static final Pattern ZERO_OR_PASITIVE_NUMBER = Pattern.compile("^[0-9]+$");
    private static final String ENTER_MONEY = "구입금액을 입력해 주세요.";
    private static final String ENTER_MAIN_LOTTO = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_LOTTO = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_SPLIT_SIGNAL = ",";

    public int enterMoney() {
        System.out.println(ENTER_MONEY);

        return convertToInt(readLine());
    }

    private int convertToInt(String money) {
        validateNumber(money);

        return Integer.parseInt(money);
    }


    private void validateNumber(final String number) {
        if (isNotNumber(number)) {
            throw LottoException.of(NOT_POSITIVE_INTEGER);
        }

    }

    private boolean isNotNumber(final String money) {
        Matcher matcher = ZERO_OR_PASITIVE_NUMBER.matcher(money);

        return !matcher.matches();
    }

    public List<Integer> enterLotto() {
        System.out.println(ENTER_MAIN_LOTTO);

        return convertToIntegerList(readLine());
    }

    private List<Integer> convertToIntegerList(String inputLotto) {
        validateInputLotto(inputLotto);

        return Arrays.stream(inputLotto.split(LOTTO_SPLIT_SIGNAL))
                .map(Integer::valueOf)
                .toList();
    }

    private void validateInputLotto(String inputLotto) {
        Arrays.stream(inputLotto.split(LOTTO_SPLIT_SIGNAL))
                .forEach(this::validateNumber);
    }

    public int enterBonusNumber() {
        System.out.println(ENTER_BONUS_LOTTO);

        return convertToInt(readLine());
    }
}
