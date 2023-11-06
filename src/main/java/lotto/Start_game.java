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
    private List<List<Integer>> all_lotto_numbers = new ArrayList<>();
    
    public void run() {
        money = input_function.get_money();
        game_count = calculation.get_game_count(money);
        Lotto lotto_number = new Lotto(input_function.get_lotto_number());
        bonus_number = input_function.get_bonus_number(lotto_number.get_lotto_numbers());
        calculation.generate_all_lotto_numbers(all_lotto_numbers, game_count);
        

        System.out.println(lotto_number.get_lotto_numbers().toString());
        System.out.println(bonus_number);

        for(List<Integer> user_lotto_number:all_lotto_numbers) {
            System.out.println(user_lotto_number.toString());
        }
    }
}
