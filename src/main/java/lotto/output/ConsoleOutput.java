package lotto.output;

public class ConsoleOutput implements Output {

    @Override
    public void print(Object result) {
        System.out.println(result.toString());
    }
}
