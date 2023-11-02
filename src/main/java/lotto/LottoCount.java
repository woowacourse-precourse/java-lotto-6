package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoCount {
    private final static int UNIT = 1000;
    private static int count;

    public static void setCount() {
        int input = Integer.parseInt(Console.readLine());
        if (input % UNIT != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }
}
