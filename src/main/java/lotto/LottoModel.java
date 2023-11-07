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
    private static int lottoPrice;
    private static Lotto winningLotto;
    private static List<Lotto> boughtLottos;
    private static int bonusNumber;
    private static final int[] lottoRank = new int[5];
    private static int profit = 0;

    public static void setLottoPrice(int price) {
        lottoPrice = price;
    }

    public static int getLottoPrice() {
        return lottoPrice;
    }

    public static void setWinningLotto(Lotto lotto) {
        winningLotto = lotto;
    }

    public static Lotto getWinningLotto() {
        return winningLotto;
    }

    public static void setBoughtLottos(int price) {
        boughtLottos = generateLottos(price);
    }

    public static List<Lotto> getBoughtLottos() {
        return boughtLottos;
    }

    public static void setBonusNumber(int number) {
        bonusNumber = number;
    }

    public static int[] getLottoRank() {
        return lottoRank;
    }

    public static int getBonusNumber() {
        return bonusNumber;
    }

    public static int getProfit() {
        return profit;
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

    public static void checkLottoRank(List<Lotto> boughtLottos, Lotto winningLotto, int bonusNumber) {
        for (Lotto boughtLotto : boughtLottos) {
            calcProfit(checkWonNumber(boughtLotto, winningLotto), boughtLotto, bonusNumber);
        }
    }

    public static int checkWonNumber(Lotto boughtLotto, Lotto winningLotto) {
        int wonNumber = 0;
        for (int number : boughtLotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                wonNumber++;
            }
        }
        return wonNumber;
    }

    private static void calcProfit(int wonNumber, Lotto boughtLotto, int bonusNumber) {
        if (checkBonusNumber(boughtLotto, bonusNumber) && wonNumber == 5) {
            lottoRank[3]++;
            profit += wonInfo.getPrize(3);
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (wonNumber == wonInfo.getMatchingNumbers(i)) {
                lottoRank[i]++;
                profit += wonInfo.getPrize(i);
            }
        }
    }

    private static boolean checkBonusNumber(Lotto boughtLotto, int bonusNumber) {
        return boughtLotto.getNumbers().contains(bonusNumber);
    }

    public static double calcProfitPercentage(int profit, int lottoPrice) {
        return Math.round((double) profit / (double) lottoPrice * 1000) / 10.0;
    }
}

