package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;
public class Application {
    private int moneyValidate(){
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
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money;


        money = moneyValidate();

    }

}
