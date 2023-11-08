package lotto.util.reader;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import lotto.util.Logger;
import lotto.util.RegxPattern;

public class MoneyConsoleReader implements ConsoleReader {
        @Override
        public String readLine() {
                String money;

                while (true) {
                        try {
                                Logger.info("구입금액을 입력해 주세요.");
                                money = Console.readLine();
                                validate(money);
                                break;
                        } catch (IllegalArgumentException e) {
                                Logger.error(e.getMessage());
                        }
                }

                return money;
        }

        private void validate(String money) {
                if (!money.matches(RegxPattern.ONLY_DIGIT)) {
                        throw new IllegalArgumentException("구입금액은 1000원 이상의 숫자만 입력할 수 있습니다.");
                }

                BigDecimal target = new BigDecimal(money);
                if (target.equals(BigDecimal.ZERO) ||
                        !target.remainder(BigDecimal.valueOf(1000)).equals(BigDecimal.ZERO)) {
                        throw new IllegalArgumentException("구입금액은 1000원 단위로 입력할 수 있습니다.");
                }
        }
}
