package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputLotto {


    public static int purchaseAmount(String inputPurchaseAmount) {

        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);

        return purchaseAmount;
    }


    public static int purchaseNumber(int purchaseAmount) {

        int purchaseNumber = purchaseAmount / 1000;
        System.out.println(purchaseNumber + "개를 구매했습니다."); // 로또 구입개수

        return purchaseNumber;
    }

    public static List<List<Integer>> makeLottoNumbers(int purchaseNumber) {

        List<List<Integer>> saveLottoNumbers = new ArrayList<>();

        //로또번호생성, 출력
        for (int i = 0; i < purchaseNumber; i++) {
            List<Integer> mutableLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6); //로또번호생성
            List<Integer> lottoNumbers = new ArrayList<>(mutableLottoNumbers);
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers); // 로또번호 출력
            saveLottoNumbers.add(lottoNumbers);
        }
        System.out.println("");

        return saveLottoNumbers;
    }

    public static void winningResult(int bonusMatchCount, int[] matchCounts) {

        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        // 결과 출력
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank.Prize prize : Rank.Prize.values()) {
            int prizeAmount = prize.getPrizeAmount();
            String formattedPrizeAmount = decimalFormat.format(prizeAmount);

            if (prize.getMatchCount() == 5 && prize.hasBonus() && bonusMatchCount > 0) {
                System.out.println(prize.getMessage() + " (" + formattedPrizeAmount + "원) - " + decimalFormat.format(bonusMatchCount) + " 개");
            }

            if (!(prize.getMatchCount() == 5 && prize.hasBonus() && bonusMatchCount > 0)) {
                int matchCount = matchCounts[prize.getMatchCount()];
                System.out.println(prize.getMessage() + " (" + formattedPrizeAmount + "원) - " + decimalFormat.format(matchCount) + "개");
            }
        }
    }

        public static void rateOfReturn (int winningAmount, int purchaseAmount){

            double rateOfReturn = ((double) winningAmount * 100) / purchaseAmount;
            rateOfReturn = Math.round(rateOfReturn * 100.0) / 100.0; // 소수점 둘째 자리에서 반올림
            System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");

        }


}
