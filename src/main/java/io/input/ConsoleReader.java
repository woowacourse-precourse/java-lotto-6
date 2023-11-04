package io.input;

import camp.nextstep.edu.missionutils.Console;

/**
 * FD 0번 STDIN으로부터 바이트 열을 읽어옵니다.
 */
public final class ConsoleReader implements Reader {
    @Override
    public String readLine() {
        return Console.readLine().trim();
    }
}
