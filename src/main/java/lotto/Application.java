package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_COUNT = 6;
    private static final int RANKING = 5;

    private static final int[] lottoWinsCount = new int[RANKING];
    private static final Rank[] ranks = Rank.values();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int paid = readPaid();
        int bought = setBought(paid);

        Lotto[] lottoNum = createLottoNums(bought);
        printLottoNums(lottoNum);

        Lotto userNum = readUserNum();
        int bonusNum = readBonusNum(userNum);

        setResult(lottoNum, userNum, bonusNum);
        long earned = getEarned();

        printResult();
        printProfit(paid, earned);
    }

    private static int readPaid() {
        while(true) {
            try {
                int paid = InputUI.inputPaid();
                if(paid % LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException("[ERROR] " + ExceptionMessage.notMultipleOfPrice());
                }
                System.out.println();
                return paid;
            }
            catch (NumberFormatException e) {
                System.out.println("[ERROR] " + ExceptionMessage.notInteger());
            }
            catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int setBought(int paid) {
        int bought = paid / LOTTO_PRICE;
        OutputUI.outputBought(bought);
        return bought;
    }

    private static Lotto[] createLottoNums(int bought) {
        Lotto[] lottoNum = new Lotto[bought];
        for(int i = 0; i < bought; i++) {
            lottoNum[i] = new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_COUNT));
        }
        return lottoNum;
    }

    private static void printLottoNums(Lotto[] lottoNum) {
        for(Lotto l : lottoNum) {
            System.out.println(l.getNumbers().toString());
        }
        System.out.println();
    }

    private static Lotto readUserNum() {
        while(true) {
            try {
                List<Integer> nums = InputUI.inputUserNum();
                Lotto userNum = new Lotto(nums);
                System.out.println();
                return userNum;
            }
            catch (NumberFormatException e) {
                System.out.println("[ERROR] " + ExceptionMessage.notInteger());
            }
            catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public static int readBonusNum(Lotto userNum) {
        while(true) {
            try {
                int bonusNum = InputUI.inputBonusNum();
                userNum.validateBonusDuplicate(userNum.getNumbers(), bonusNum);
                return bonusNum;
            }
            catch (NumberFormatException e) {
                System.out.println("[ERROR] " + ExceptionMessage.notInteger());
            }
            catch(IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static void setResult(Lotto[] lottoNum, Lotto userNum, int bonusNum) {
        for(Lotto l : lottoNum) {
            int winsCount = 0;
            boolean bonusCount = false;

            for(int n : userNum.getNumbers()) {
                if(l.getNumbers().contains(n)) {
                    winsCount++;
                }
                bonusCount = l.getNumbers().contains(bonusNum);
            }

            Rank rank = getRank(winsCount, bonusCount);
            addResult(rank);
        }
    }

    public static Rank getRank(int winsCount, boolean bonusCount) {
        for (Rank rank : Rank.values()) {
            if (winsCount == rank.getWins() && (rank != Rank.SECOND || bonusCount)) {
                return rank;
            }
        }
        return null;
    }

    private static void addResult(Rank rank) {
        if(rank != null) {
            lottoWinsCount[rank.ordinal()]++;
        }
    }

    private static long getEarned() {
        long earned = 0;

        for(Rank rank : Rank.values()) {
            earned += (long) rank.getPrize() * lottoWinsCount[rank.ordinal()];
        }

        return earned;
    }

    private static void printResult() {
        OutputUI.outputResultTitle();

        for (int i = RANKING - 1; i >= 0; i--)  {
            Rank rank = ranks[i];
            OutputUI.outputResult(rank, lottoWinsCount);
        }
    }

    private static void printProfit(int paid, long earned) {
        double profit = (double)earned / paid * 100.0;
        OutputUI.outputProfit(profit);
    }
}

