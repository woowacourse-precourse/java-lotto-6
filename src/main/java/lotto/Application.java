package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.awt.AWTEventMulticaster.add;

public class Application {
    public static void main(String[] args) {
        int buy = 0;
        int lotteryCount =0;
        int bonusNumber=0;
        List<Integer> lottoResults = new ArrayList<>();
        List<List<Integer>> lottoNumbersList = new ArrayList<>();
        Lotto lotto = new Lotto(lottoResults);
        System.out.println("구입 금액을 입력해 주세요.");
        buy = Integer.parseInt(readLine());

        lotteryCount = buy / 1000;
        System.out.println(lotteryCount + "개를 구매했습니다.");
        lottoNumbersList=lotto.generateRandomLottoNumbers(lotteryCount);
        lotto.printLottoNumbers(lottoNumbersList);

        System.out.println("당첨 번호를 입력해 주세요.");
        for(int i=0; i<6; i++){
            String temp;
            temp = readLine();
            lottoResults.add(Integer.valueOf(temp));
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber=Integer.parseInt(readLine());

        int[][] results = lotto.countMatchingNumbers(lottoNumbersList, lottoResults, bonusNumber);
        int[] counts = results[0]; // counts 배열
        int[] bonusCounts = results[1]; // bonusCounts 배열

        int[] ranks = lotto.calculateLottoPrize(counts, bonusCounts);
        lotto.printLottoPrize(ranks);
        lotto.calculateProfitRate(buy, ranks);
    }
}
