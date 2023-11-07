package lotto.io;

public abstract class InputManager<T>  {
    ConsoleAdapter consoleAdapter= new ConsoleAdapter();
    public abstract T input();
    public abstract T validation(String  input);

    protected void setConsoleAdapter(ConsoleAdapter consoleAdapter){
        this.consoleAdapter=consoleAdapter;
    };

    public static void validateNumberRange(Integer number) {
        if (number > 45 || number < 1) throw new IndexOutOfBoundsException();
    }
}