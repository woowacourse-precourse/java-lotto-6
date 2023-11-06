package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Buyer buyer = new Buyer();
//        int money = buyer.getLottoPurchaseAmount();
//        int bonusNumber = buyer.getBonusNumber(lottoNumbers);
        List<List<Integer>> lottoNumbers = buyer.generateLottoNumbers();
        for (List<Integer> lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }

        System.out.println();
        List<Integer> winningNumber = buyer.getWinningNumber();
        System.out.println();
        int bonusNumber = buyer.getBonusNumber();
        System.out.println();

        // 구매한 로또 번호를 대조해 보면서 결과를 저장.
        double totalReward = 0;
        int firstPlaceCount = 0;
        int secondPlaceCount = 0;
        int thirdPlaceCount = 0;
        int fourthPlaceCount = 0;
        int fifthPlaceCount = 0;
        for (List<Integer> lottoNumber : lottoNumbers) {
            Lotto lotto = new Lotto(lottoNumber);
            long result = lotto.LottoResults(winningNumber, bonusNumber);
            totalReward += result;
            if (result == Lotto.FIFTH_PRIZE_AMOUNT) {
                fifthPlaceCount += 1;
            }
            if (result == Lotto.FOURTH_PRIZE_AMOUNT) {
                fourthPlaceCount += 1;
            }
            if (result == Lotto.THIRD_PRIZE_AMOUNT) {
                thirdPlaceCount += 1;
            }
            if (result == Lotto.SECOND_PRIZE_AMOUNT) {
                secondPlaceCount += 1;
            }
            if (result == Lotto.FIRST_PRIZE_AMOUNT) {
                firstPlaceCount += 1;
            }
        }

//        System.out.println("당첨 통계");
//        System.out.println("---");
//        System.out.println("3개 일치 (5,000원) - " + fifthPlaceCount + "개");
//        System.out.println("4개 일치 (50,000원) - " + fourthPlaceCount + "개");
//        System.out.println("5개 일치 (1,500,000원) - " + thirdPlaceCount + "개");
//        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondPlaceCount + "개");
//        System.out.println("6개 일치 (2,000,000,000원) - " + firstPlaceCount + "개");
//        System.out.println("총");

        LottoReporter.lottoReport(firstPlaceCount, secondPlaceCount, thirdPlaceCount, fourthPlaceCount, fifthPlaceCount);
        LottoReporter.rateOfReturn(totalReward, lottoNumbers.size()*1000);
        // 수익률 = (투자금 - 투자금)/ 투자금
//        당첨 통계
//        ---
//        3개 일치 (5,000원) - 1개
//        4개 일치 (50,000원) - 0개
//        5개 일치 (1,500,000원) - 0개
//        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//        6개 일치 (2,000,000,000원) - 0개
//        총 수익률은 62.5%입니다.
    }

}
