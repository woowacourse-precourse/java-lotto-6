package lotto;
import camp.nextstep.edu.missionutils.Console;
public class Input {
    public static int lotto_count = 0;
    public static int[] winner_list = new int[6];
    public static int bonus_num = 0;

    public static void input_price(){
        try{
            lotto_count = 0;
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            int input_price = Integer.parseInt(input);
            if(input_price % 1000 != 0 || input_price == 0){
                throw new IllegalArgumentException();
            }
            lotto_count = input_price / 1000;
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 0보다 큰 1000으로 나누어 떨어지는 금액을 입력해 주세요.");
            input_price();
        }
    }

    public static void input_winner(){


    }

    public static void input_bonus(){

    }
}
