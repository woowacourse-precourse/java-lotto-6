package lotto;

import static lotto.Service.*;
import static lotto.Lotto.*;
import static lotto.Lottery.*;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //1. 로또 구입 금액 입력 받기
        while(true) {
            int howMuch = 0;
            int numberOfLotteries = 0;
            try{
                System.out.println("구입 금액을 입력해 주세요.");
                String input = Console.readLine();
                howMuch = isNumber(input);
                numberOfLotteries = numberOfLottery(howMuch);
                break;
            } catch(IllegalArgumentException e) {
                howMuch = 0;
            }
        }

        //2. 번호 입력 받기
        System.out.println("당첨 번호를 입력해 주세요.");

        //3. 보너스 번호 입력 받기
        System.out.println("보너스 번호를 입력해 주세요.");


        //4. 로또 발행


        //5. 당첨 여부 확인


        //6. 통계내기


        //7. 출력
    }
}
