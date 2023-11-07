package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.model.LottoModel;
import lotto.model.LottoPrize;
import lotto.view.LottoBuyView;
import lotto.view.LottoInputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.model.LottoPrize.getPrizeRankByMatch;

public class LottoController {
    static LottoInputView lottoInputView = new LottoInputView();
    LottoModel lottoModel = new LottoModel();
    LottoBuyView lottoBuyView = new LottoBuyView();

    public void runLotto() {
        // 1. 구입 금액 입력
        int price = lottoInputView.purchasePriceInput();
        lottoModel.setInputPrice(price);
        lottoModel.calcPurchasedCount();

        // 2. 로또 구매
        int count = lottoModel.getPurchasedCount();
        List<Lotto> purchasedLotto = lottoModel.getPurchasedLotto(count);
        lottoBuyView.printPurchaseLog(purchasedLotto, count);

        // 3. 당첨 번호 입력
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winNumInput = Console.readLine();
        List<Integer> winNumbers;
        try {
            String[] seps = winNumInput.split(",");
            List<Integer> intList = new ArrayList<>();
            for (String sep : seps) {
                int num = Integer.parseInt(sep);
                if (num > 45 || num < 0) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                if (intList.contains(num)) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
                }
                intList.add(num);
            }
            winNumbers = intList;

            if (winNumbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자로 구성되어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 로또 번호 형식입니다.");
        }

        // 4. 보너스 번호 입력
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();
        int bonus;
        try {
            bonus = Integer.parseInt(bonusInput);
            if (bonus <= 0 || bonus > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (winNumbers.contains(bonus)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 로또 번호 형식입니다.");
        }

        // 5. 당첨 통계
        List<LottoPrize> lottoPrizes = new ArrayList<>();
        int[] prizeLog = new int[6];
        Arrays.fill(prizeLog, 0);
        for (Lotto lotto : purchasedLotto) {
            int matchCount = 0;
            boolean bonusMatch = false;
            for (int lottoNum : lotto.getLotto()) {
                if (winNumbers.contains(lottoNum)) {
                    matchCount += 1;
                }
                if (winNumbers.contains(bonus)) {
                    bonusMatch = true;
                }
            }
            // 등수 판별
            LottoPrize info = getPrizeRankByMatch(matchCount, bonusMatch);
            lottoPrizes.add(info);
            prizeLog[info.getRank()] += 1;
        }
//        System.out.println(Arrays.toString(prizeLog));

        // 5-2. 당첨 통계 출력
        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", prizeLog[5]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", prizeLog[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", prizeLog[3]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", prizeLog[2]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", prizeLog[1]);

        // 6.총 수익률 출력
        long totalPrize = 0;
        for (LottoPrize info : lottoPrizes) {
            totalPrize += info.getPrize();
        }
        double rateOfReturn = (double) totalPrize / price * 100;
//        rateOfReturn = Math.round(rateOfReturn * 100.0) / 100.0;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }
}