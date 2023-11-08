package lotto;

import static lotto.Service.*;
import static lotto.Lotto.*;
import static lotto.Lottery.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        //1. 로또 구입 금액 입력 받기
        int howMuch = 0;
        int numberOfLotteries = 0; //로또 개수
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
        List<Integer> lottoNumbers;
        while(true) {
            try{
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputLottoNumbers = Console.readLine();
                Lotto myNumbers = new Lotto(convertStringToIntegerList(inputLottoNumbers));
                lottoNumbers = myNumbers.getNumbers();
                break;
            } catch (IllegalArgumentException e) { }
        }


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


        //4. 로또 발행(+당첨 여부)
        List<Lottery> lotteries = new ArrayList<>(); //발행된 로또를 저장하는 리스트
        for (int i = 0; i < numberOfLotteries; i++) {
            lotteries.add(new Lottery(lottoNumbers, bonusNumber)); //로또 발행
        }

        //5. 통계 내기
        Map<Rank, Long> result = lotteries.stream()
                .collect(Collectors.groupingBy(Lottery::getRank, Collectors.counting()));

        System.out.println(result);


        //6. 출력
    }
}
