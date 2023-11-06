package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    public static final int LOTTO_PRICE_UNIT = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static void main(String[] args) {
        PurchasePrice purchasePrice = InputView.inputPurchasePrice();
        int purchaseCount = purchasePrice.getPurchaseCount();
        OutputView.printPurchaseCount(purchaseCount);

        List<Lotto> lottos = getLottos(purchaseCount);
        OutputView.printLottos(lottos);

        WinningNumber winningNumber = InputView.inputWinningNumber();

        int earnMoney = 0;
        int RANK_1_cnt = 0;
        int RANK_2_cnt = 0;
        int RANK_3_cnt = 0;
        int RANK_4_cnt = 0;
        int RANK_5_cnt = 0;
        int RANK_none_cnt = 0;
        for (Lotto lotto : lottos) {
            Rank rank = calculate(lotto, winningNumber);
            if (rank == Rank.RANK_1) {
                RANK_1_cnt++;
                earnMoney += Rank.RANK_1.getPrice();
            }
            if (rank == Rank.RANK_2) {
                RANK_2_cnt++;
                earnMoney += Rank.RANK_2.getPrice();
            }
            if (rank == Rank.RANK_3) {
                RANK_3_cnt++;
                earnMoney += Rank.RANK_3.getPrice();
            }
            if (rank == Rank.RANK_4) {
                RANK_4_cnt++;
                earnMoney += Rank.RANK_4.getPrice();
            }
            if (rank == Rank.RANK_5) {
                RANK_5_cnt++;
                earnMoney += Rank.RANK_5.getPrice();
            }
            if (rank == Rank.RANK_NONE) {
                RANK_none_cnt++;
            }
        }

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("3개 일치 (" + df.format(Rank.RANK_5.getPrice()) + "원)" + " - " + RANK_5_cnt + "개");
        System.out.println("4개 일치 (" + df.format(Rank.RANK_4.getPrice()) + "원)" + " - " + RANK_4_cnt + "개");
        System.out.println("5개 일치 (" + df.format(Rank.RANK_3.getPrice()) + "원)" + " - " + RANK_3_cnt + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + df.format(Rank.RANK_2.getPrice()) + "원)" + " - " + RANK_2_cnt + "개");
        System.out.println("6개 일치 (" + df.format(Rank.RANK_1.getPrice()) + "원)" + " - " + RANK_1_cnt + "개");
        System.out.println("총 수익률은 "+ purchasePrice.calculateProfit(earnMoney) + "%입니다.");
    }

    public static Rank calculate(Lotto lotto, WinningNumber winningNumber) {
        List<Integer> lottos = lotto.getNumbersValue();
        List<Integer> winningNumbers = winningNumber.getNumbersValue();
        int bonusNumber = winningNumber.getBonusNumberValue();

        int sameCount = 0;
        for (Integer number : lottos) {
            if (winningNumbers.contains(number)) {
                sameCount++;
            }
        }

        boolean isBonus = lottos.contains(bonusNumber);
        if (sameCount == 6) {
            return Rank.RANK_1;
        }
        if (sameCount == 5 && isBonus) {
            return Rank.RANK_2;
        }
        if (sameCount == 5) {
            return Rank.RANK_3;
        }
        if (sameCount == 4) {
            return Rank.RANK_4;
        }
        if (sameCount == 3) {
            return Rank.RANK_5;
        }
        return Rank.RANK_NONE;
    }

    private static List<Lotto> getLottos(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = getRandomLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private static Lotto getRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int randomNumber : randomNumbers) {
            LottoNumber lottoNumber = new LottoNumber(randomNumber);
            lottoNumbers.add(lottoNumber);
        }
        return new Lotto(lottoNumbers);
    }
}