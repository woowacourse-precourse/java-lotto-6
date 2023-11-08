package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {
    protected String inputValue() {
        return Console.readLine();
    }

    protected void isDigitValidate(String result) {
        Pattern PATTERN = Pattern.compile("^[0-9]+$");
        if (!PATTERN.matcher(result).matches()) {
            throw new IllegalArgumentException("[ERROR] 문자를 입력했습니다.");
        }
    }

    protected void beDividedThousandValidate(String result) {
        if (!(Integer.parseInt(result) % 1000 == 0)) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    protected void isNotZeroValidate(String result) {
        if ((Integer.parseInt(result) == 0)) {
            throw new IllegalArgumentException("[ERROR] 0원 을 입력하셨습니다.");
        }
    }
}