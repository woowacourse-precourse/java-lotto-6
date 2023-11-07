package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String LOTTO_NUMBERS_DELIMITER = ",";

    public String getPlayerAmount() {
        //TODO "구입금액을 입력해 주세요." 출력
        return Console.readLine();

    }

    public List<String> getLottoWinningNumbers() {
        //TODO "당첨 번호를 입력해 주세요." 출력
        String winningNumbers = Console.readLine();
        return Arrays.asList(winningNumbers.split(LOTTO_NUMBERS_DELIMITER));
    }

    public String getBonusNumber() {
        //TODO "보너스 번호를 입력해 주세요." 출력
        return Console.readLine();
    }
}
