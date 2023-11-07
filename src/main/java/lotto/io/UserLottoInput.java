package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidMoneyInput;

public class UserLottoInput implements LottoInput {
    @Override
    public long getMoneyAmount() {
        String input = Console.readLine();
        validateNumericString(input);
        return Long.parseLong(input);
    }

    private void validateNumericString(String input) {
        for (Character c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new InvalidMoneyInput();
            }
        }
    }
}
