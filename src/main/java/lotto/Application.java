package lotto;

import static lotto.Input.*;
import static lotto.Lotto.*;
import static lotto.Output.*;

public class Application {
    public static void main(String[] args) {
        input_price();
        lotto_random(lotto_count);
        output_price(lotto_count);
        output_lotto(numbers_list);
        try{
            input_winner();
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 1-45까지의 숫자 6개를 입력헤주세요.");
            input_winner();
        }



    }
}
