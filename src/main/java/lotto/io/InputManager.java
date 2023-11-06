package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class InputManager<T>  {
    ConsoleAdapter consoleAdapter= new ConsoleAdapter();
    public abstract T input();
    public abstract T validation(String  input);

    protected ConsoleAdapter getConsoleAdapter() {
        return consoleAdapter;
    }

    protected void setConsoleAdapter(ConsoleAdapter consoleAdapter){
        this.consoleAdapter=consoleAdapter;
    };
}