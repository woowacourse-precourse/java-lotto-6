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
        while(true){
            try{
                input_winner();
                break;
            }catch(IllegalArgumentException e){
                System.out.println("[ERROR] 1-45까지의 중복되지 않는 숫자 6개를 입력헤주세요.");
            }
        }
        while(true){
            try{
                input_bonus();
                break;
            }catch(IllegalArgumentException e){
                System.out.println("[ERROR] 1-45까지의 우승 번호와 중복되지 않는 숫자 1개를 입력헤주세요.");
            }
        }



    }
}
