package lotto;

import static lotto.Service.*;
import static lotto.Lotto.*;
import static lotto.Lottery.*;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //1. 로또 구입 금액 입력 받기
        int howMuch = 0;
        int numberOfLotteries = 0;
        while(true) {
            try{
                System.out.println("구입 금액을 입력해 주세요.");
                String inputHowMuch = Console.readLine();
                howMuch = isNumber(inputHowMuch);
                numberOfLotteries = numberOfLottery(howMuch);
                break;
            } catch(IllegalArgumentException e) { }
        }
        //확인용
//        System.out.println(howMuch + ", " + numberOfLotteries);

        //2. 당첨 금액 입력 받아 저장하기


        //3. 보너스 번호 입력 받기
        int bonusNumber = 0;
        while(true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String inputBonusNumber = Console.readLine();
                bonusNumber = isNumber(inputBonusNumber);
                rangeValidation(bonusNumber);
                break;
            } catch (IllegalArgumentException e) { }
        }
        //확인용
//        System.out.println(bonusNumber);



        //4. 로또 발행


        //5. 당첨 여부 확인


        //6. 통계내기


        //7. 출력
    }
}
