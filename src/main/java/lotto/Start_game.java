package lotto;

public class Start_game {
    public static int money = 0;
    public void run() {
        Input_function input_function = new Input_function();
        money = input_function.get_money();

        System.out.println(money);
    }
}
