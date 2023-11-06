package lotto.io;

import lotto.game.io.Output;

public class ConsoleOutput implements Output {

    public void print(Object message) {
        System.out.print(message.toString());
    }

    public void println() {
        System.out.println();
    }

    public void println(Object message) {
        System.out.println(message.toString());
    }

}