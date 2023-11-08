package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static Integer getInteger() {
        try {
            String readLine = Console.readLine();
            return Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력해야 합니다.");
        }
    }
}
