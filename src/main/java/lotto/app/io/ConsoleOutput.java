package lotto.app.io;

import lotto.app.game.io.Output;

public class ConsoleOutput implements Output {

    public void print(final Object message) {
        System.out.print(message.toString());
    }

    public void println() {
        System.out.println();
    }

    public void println(final Object message) {
        System.out.println(message.toString());
    }

}