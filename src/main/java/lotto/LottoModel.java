package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum wonInfo {
    THREE(3, 5000, "개 일치 (5,000원) - "),
    FOUR(4, 50000, "개 일치 (50,000원) - "),
    FIVE(5, 1500000, "개 일치 (1,500,000원) - "),
    BONUS(5, 30000000, "개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX(6, 2000000000, "개 일치 (2,000,000,000원) - ");

    private final int WONNUMBER;
    private final int PRIZE;
    private final String PRIZEINFO;

    wonInfo(int WONNUMBER, int PRIZE, String PRIZEINFO) {
        this.WONNUMBER = WONNUMBER;
        this.PRIZE = PRIZE;
        this.PRIZEINFO = PRIZEINFO;
    }

    public static int getMatchingNumbers(int index) {
        return values()[index].WONNUMBER;
    }

    public static int getPrize(int index) {
        return values()[index].PRIZE;
    }

    public static String getPrizeInfo(int index) {
        return values()[index].PRIZEINFO;
    }
}

public class LottoModel {
    private final int LOTTOPRICE;
    private final Lotto WINNINGLOTTO;
    private final List<Lotto> BOUGHTLOTTOS;
    private final int BONUSNUMBER;
    private final int[] LOTTORANK = new int[5];
    private static int profit = 0;

    public LottoModel() {
        LOTTOPRICE = LottoControl.inputLottoPrice();
        BOUGHTLOTTOS = generateLottos(LOTTOPRICE);

        LottoView.printLottoAmount(LOTTOPRICE);
        LottoView.printGeneratedLottos(BOUGHTLOTTOS);

        WINNINGLOTTO = LottoControl.inputWinningNumbers();
        BONUSNUMBER = LottoControl.inputBonusNumber(WINNINGLOTTO);

        checkLottoRank();
        LottoView.printRankInfo(LOTTORANK);
        LottoView.printProfitRate(calcProfitPercentage());
    }

    public static List<Lotto> generateLottos(int lottoPrice) {
        List<Lotto> generatedLottos = new ArrayList<>();

        for (int i = 0; i < lottoPrice / 1000; i++) {
            List<Integer> generatedNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(generatedNumbers);
            generatedLottos.add(new Lotto(generatedNumbers));
        }

        return generatedLottos;
    }

    private void checkLottoRank() {
        for (Lotto boughtLotto : BOUGHTLOTTOS) {
            calcProfit(checkWonNumber(boughtLotto), boughtLotto);
        }
    }

    public int checkWonNumber(Lotto boughtLotto) {
        int wonNumber = 0;
        for (int number : boughtLotto.getNumbers()) {
            if (WINNINGLOTTO.getNumbers().contains(number)) {
                wonNumber++;
            }
        }
        return wonNumber;
    }

    private void calcProfit(int wonNumber, Lotto boughtLotto) {
        if (checkBonusNumber(boughtLotto) && wonNumber == 5) {
            LOTTORANK[3]++;
            profit += wonInfo.getPrize(3);
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (wonNumber == wonInfo.getMatchingNumbers(i)) {
                LOTTORANK[i]++;
                profit += wonInfo.getPrize(i);
            }
        }
    }

    private boolean checkBonusNumber(Lotto boughtLotto) {
        return boughtLotto.getNumbers().contains(BONUSNUMBER);
    }

    private double calcProfitPercentage() {
        return Math.round((double) profit / (double) LOTTOPRICE * 1000) / 10.0;
    }
}

