package lotto;

import java.util.List;
import java.util.ArrayList;
public class Start_game {
    //private static final int ArrayList = 0;
    public static int money = 0;
    public static int game_count = 0;
    public static int bonus_number = 0;
    private Input_function input_function = new Input_function();
    private Calculation calculation = new Calculation();
    private List<Integer> user_lottos = new ArrayList<>();
    
    public void run() {
        money = input_function.get_money();
        game_count = calculation.get_game_count(money);
        Lotto lotto_number = new Lotto(input_function.get_lotto_number());
        bonus_number = input_function.get_bonus_number(lotto_number.get_lotto_numbers());

        for(int i=0;i<10;i++) {
            user_lottos = calculation.generate_lotto();
            System.out.println(user_lottos);
        }

        System.out.println(lotto_number.get_lotto_numbers().toString());
        System.out.println(bonus_number);
    }
}
