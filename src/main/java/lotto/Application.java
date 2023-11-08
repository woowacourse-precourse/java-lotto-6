package lotto;

import static lotto.Service.*;
import static lotto.Lotto.*;
import static lotto.Lottery.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

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

        //2. 당첨 금액 입력 받아 저장하기
        List<Integer> lottoNumbers = new ArrayList<>();
        while(true) {
            try{
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputLottoNumbers = Console.readLine();
                lottoNumbers = convertStringToIntegerList(inputLottoNumbers);
                Lotto myNumbers = new Lotto(lottoNumbers);
                break;
            } catch (IllegalArgumentException e) { }
        }

        System.out.println(lottoNumbers);


        //3. 보너스 번호 입력 받기
        int bonusNumber = 0;
        while(true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String inputBonusNumber = Console.readLine();
                bonusNumber = isNumber(inputBonusNumber);
                rangeValidation(bonusNumber);
                bonusRedundancyCheck(lottoNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) { }
        }



        //4. 로또 발행


        //5. 당첨 여부 확인


        //6. 통계내기


        //7. 출력
    }
}
