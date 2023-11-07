package lotto.adapter.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.adapter.IoAdapter;

public class StandardIoAdapter implements IoAdapter {

    @Override
    public String inputStream() {
        return Console.readLine().strip();
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printNewLine() {
        System.out.println();
    }
}
