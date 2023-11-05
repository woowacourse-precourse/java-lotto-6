package lotto;

import java.util.List;
import java.util.ArrayList;
public class Start_game {
    //private static final int ArrayList = 0;
    public static int money = 0;
    public static int game_count = 0;

    public void run() {
        Input_function input_function = new Input_function();
        Calculation calculation = new Calculation();
        List<Integer> lotto_number = new ArrayList<>();
        money = input_function.get_money();
        game_count = calculation.get_game_count(money);

        System.out.println(money);
        System.out.println(game_count);

        for(int i=0;i<10;i++) {
            lotto_number = calculation.generate_lotto();
            System.out.println(lotto_number);
        }
    }
}
