package lotto;

import static lotto.Service.*;
import static lotto.Lotto.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        //1. 로또 구입 금액 입력 받기
        int howMuch = 0; //구입한 금액
        int numberOfLotteries = 0; //로또 개수
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String inputHowMuch = Console.readLine();
                howMuch = isNumber(inputHowMuch);
                numberOfLotteries = numberOfLottery(howMuch);
                break;
            } catch (IllegalArgumentException e) {
            }
        }

        //2. 당첨 금액 입력 받아 저장하기
        List<Integer> lottoNumbers;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputLottoNumbers = Console.readLine();
                Lotto myNumbers = new Lotto(convertStringToIntegerList(inputLottoNumbers));
                lottoNumbers = myNumbers.getNumbers();
                break;
            } catch (IllegalArgumentException e) {
            }
        }

        //3. 보너스 번호 입력 받기
        int bonusNumber = 0;
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String inputBonusNumber = Console.readLine();
                bonusNumber = isNumber(inputBonusNumber);
                rangeValidation(bonusNumber);
                bonusRedundancyCheck(lottoNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
            }
        }

        //4. 로또 발행(+당첨 여부)
        List<Lottery> lotteries = new ArrayList<>(); //발행된 로또를 저장하는 리스트
        for (int i = 0; i < numberOfLotteries; i++) {
            lotteries.add(new Lottery(lottoNumbers, bonusNumber)); //로또 발행
        }

        //5. 집계하기
        Map<Rank, Long> rankCount = makeRankCountMap(lotteries);

        //6. 수익률 계산
        float rateOfReturn = calculateRateOfReturn(rankCount, howMuch);

        //7. 출력
        System.out.println(numberOfLotteries + "개를 구매했습니다.");
        for (Lottery lottery : lotteries) {
            System.out.println(lottery.getWinningNumbers());
        }

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rankCount.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + rankCount.get(Rank.FORTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCount.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCount.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCount.get(Rank.FIRST) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}
