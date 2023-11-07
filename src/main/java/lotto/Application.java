package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Buyer buyer = new Buyer();

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

        LottoReporter.lottoReport(firstPlaceCount, secondPlaceCount, thirdPlaceCount, fourthPlaceCount, fifthPlaceCount);
        LottoReporter.rateOfReturn(totalReward, lottoNumbers.size()*1000);

    }

}
