package lotto.util.reader;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Logger;
import lotto.util.RegxPattern;

public class MagicNumberConsoleReader implements ConsoleReader {
        @Override
        public String readLine() {
                String magicNumber;
                while (true) {
                        try {
                                Logger.info("\n보너스 번호를 입력해 주세요.");
                                magicNumber = Console.readLine();
                                validate(magicNumber);
                                break;
                        } catch (IllegalArgumentException e) {
                                Logger.error(e.getMessage());
                        }

                }

                return magicNumber;
        }

        private void validate(String numbers) {
                if (!numbers.matches(RegxPattern.LOTTO_NUMBER_RANGE)) {
                        throw new IllegalArgumentException("보너스 숫자는 1에서 45사이의 숫자만 입력가능합니다.");
                }
        }
}
