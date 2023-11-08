package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
public class Application {
    private static int moneyValidate(){
        int money;

        while(true){
           try{
               System.out.println("구입금액을 입력해 주세요.");
               money =Integer.valueOf(Console.readLine());

               if ( (money % 1000) != 0) {
                   throw new IllegalArgumentException("1,000원 단위로 입력하세요.");
               }
               break;
           }catch (NumberFormatException e){
               throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
           }
        }
        return money;
    }

    private List<Lotto> generateLottes(int trial){
        List<Lotto> Lottos = new ArrayList<>();

        for(int i=0; i< trial; i++){
            List<Integer> lottsnumber = new ArrayList<>();
            while(lottsnumber.size() < 6){
                int number =  Randoms.pickNumberInRange(1,45);
                if(!lottsnumber.contains(number)){
                    lottsnumber.add(number);
                }
            }
            Lottos.add(new Lotto(lottsnumber));
        }
        return Lottos;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money;
        int ticket;
        int bouncenumber;
        List<Lotto> Lottes;

        money = moneyValidate();
        ticket = money /1000;

        bouncenumber = Integer.valueOf(Console.readLine());

    }

}
