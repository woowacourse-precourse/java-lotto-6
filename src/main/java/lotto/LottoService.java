package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    static final int LOTTO_PRICE = 1000;
    static final int LOTTO_MIN = 1;
    static final int LOTTO_MAX = 45;
    static final int LOTTO_COUNT = 6;
    static final int RANKING = 5;
    static final int[] lottoWinsCount = new int[RANKING];
    static final Rank[] ranks = Rank.values();

    static int winsCount = 0;
    static boolean bonusCount = false;

    int readPaid() {
        while (true) {
            try {
                int paid = InputUI.inputPaid();
                checkMultipleOfPrice(paid);
                System.out.println();
                return paid;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] " + ExceptionMessage.notInteger());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkMultipleOfPrice(int paid) {
        if (paid % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] " + ExceptionMessage.notMultipleOfPrice());
        }
    }

    int setBought(int paid) {
        int bought = paid / LOTTO_PRICE;
        OutputUI.outputBought(bought);
        return bought;
    }

    Lotto[] createLottoNums(int bought) {
        Lotto[] lottoNum = new Lotto[bought];
        for (int i = 0; i < bought; i++) {
            lottoNum[i] = new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_COUNT).stream()
                    .sorted().collect(Collectors.toList()));
        }
        return lottoNum;
    }

    void printLottoNums(Lotto[] lottoNum) {
        for (Lotto l : lottoNum) {
            System.out.println(l.getNumbers().toString());
        }
        System.out.println();
    }

    Lotto readUserNum() {
        while (true) {
            try {
                List<Integer> nums = InputUI.inputUserNum();
                Lotto userNum = new Lotto(nums);
                System.out.println();
                return userNum;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] " + ExceptionMessage.notInteger());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    int readBonusNum(Lotto userNum) {
        while (true) {
            try {
                int bonusNum = InputUI.inputBonusNum();
                userNum.validateBonusDuplicate(userNum.getNumbers(), bonusNum);
                return bonusNum;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] " + ExceptionMessage.notInteger());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    void setResult(Lotto[] lottoNum, Lotto userNum, int bonusNum) {
        for (Lotto lotto : lottoNum) {
            winsCount = 0;
            bonusCount = false;

            checkLottoMatched(userNum, bonusNum, lotto);

            Rank rank = getRank(winsCount, bonusCount);
            addResult(rank);
        }
    }

    private void checkLottoMatched(Lotto userNum, int bonusNum, Lotto lotto) {
        for (int n : userNum.getNumbers()) {
            if (lotto.getNumbers().contains(n)) {
                winsCount++;
            }
            bonusCount = lotto.getNumbers().contains(bonusNum);
        }
    }

    private Rank getRank(int winsCount, boolean bonusCount) {
        for (Rank rank : Rank.values()) {
            if (winsCount == rank.getWins() && (rank != Rank.SECOND || bonusCount)) {
                return rank;
            }
        }
        return null;
    }

    private void addResult(Rank rank) {
        if (rank != null) {
            lottoWinsCount[rank.ordinal()]++;
        }
    }

    long getEarned() {
        long earned = 0;

        for (Rank rank : Rank.values()) {
            earned += (long) rank.getPrize() * lottoWinsCount[rank.ordinal()];
        }

        return earned;
    }

    void printResult() {
        OutputUI.outputResultTitle();

        for (int i = RANKING - 1; i >= 0; i--) {
            Rank rank = ranks[i];
            OutputUI.outputResult(rank, lottoWinsCount);
        }
    }

    void printProfit(int paid, long earned) {
        double profit = (double) earned / paid * 100.0;
        OutputUI.outputProfit(profit);
    }
}
