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
    private Display_function display_function = new Display_function();
    private List<List<Integer>> all_lotto_numbers = new ArrayList<>();
    private int[] scoreBoard = {0,0,0,0,0,0,0,0};
    private int totalPrize = 0;
    
    public void run() {
        money = input_function.getMoney();
        game_count = calculation.get_game_count(money);
        Lotto lotto_number = new Lotto(input_function.get_lotto_number());
        bonus_number = input_function.getBonusNumber(lotto_number.get_lotto_numbers());
        calculation.generate_all_lotto_numbers(all_lotto_numbers, game_count);
        calculation.get_all_score(all_lotto_numbers, lotto_number.get_lotto_numbers(), bonus_number, scoreBoard);
        
        display_function.displayUserLottonumbers(all_lotto_numbers,game_count);
        display_function.displayScore(scoreBoard);

        totalPrize = calculation.getAllPrize(scoreBoard);
        display_function.displayEarningRate(totalPrize, money);
    }
}
