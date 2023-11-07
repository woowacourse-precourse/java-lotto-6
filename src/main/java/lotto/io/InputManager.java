package lotto.io;

public abstract class InputManager<T>  {
    ConsoleAdapter consoleAdapter= new ConsoleAdapter();
    public abstract T input();
    public abstract T validation(String  input);

    protected void setConsoleAdapter(ConsoleAdapter consoleAdapter){
        this.consoleAdapter=consoleAdapter;
    };
}