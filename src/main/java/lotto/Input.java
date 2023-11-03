package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.Lotto.*;

public class Input {
    public static List<List<Integer>> numbers_list = new ArrayList<>();
    public static int lotto_count = 0;
    public static List<Integer> winner = new ArrayList<>();
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
                winner = new ArrayList<>();
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                String[] tmp = input.split(",");
                for(String s : tmp){
                    // 예외 1 : 숫자가 아닌 문자나 공백이 들어갔을 경우, 예외 2, 1보다 작거나 45보다 클 경우
                    if(s.matches("[+]?\\d*(\\.\\d+)?") == false || s.equals("") || Integer.parseInt(s)<1||45<Integer.parseInt(s)){
                        throw new IllegalArgumentException();
                    }
                    winner.add(Integer.parseInt(s));
                }
                Lotto l1 = new Lotto(winner);
                dup_check(winner);
    }

    public static void input_bonus(){
        bonus_num = 0;
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        bonus_validate(input);
    }

    public static void bonus_validate(String input){
        if(input.matches("[+]?\\d*(\\.\\d+)?") == false){ // 숫자가 아닌 경우
            throw new IllegalArgumentException();
        }
        bonus_num = Integer.parseInt(input);
        if(bonus_num<1||45<bonus_num){// 1~45의 숫자가 아닌 경우
            throw new IllegalArgumentException();
        }
        if(winner.contains(bonus_num)){//당첨 숫자와 중복되었을 경우
            throw new IllegalArgumentException();
        }
    }


}
