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

        long earned = 0;
        setResult(lottoNum, userNum, bonusNum, earned);
        printResult();
        printProfit(paid, earned);
    }

    private static int readPaid() {

        while(true) {
            try {
                int paid = InputUI.inputPaid();
                if(paid % LOTTO_PRICE != 0) throw new IllegalArgumentException("[ERROR] 구입금액은 " + LOTTO_PRICE + "의 배수여야 합니다.");
                System.out.println();
                return paid;
            }
            catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            }
            catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int setBought(int paid) {
        int bought = paid / LOTTO_PRICE;
        System.out.println(bought + "개를 구매했습니다.");
        return bought;
    }

    private static Lotto[] createLottoNums(int bought) {
        Lotto[] lottoNum = new Lotto[bought];
        for(int i = 0; i < bought; i++) {
            lottoNum[i] = new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_COUNT));
            Collections.sort(lottoNum[i].getNumbers());
        }
        return lottoNum;
    }

    private static void printLottoNums(Lotto[] lottoNum) {
        for(Lotto l : lottoNum) {
            System.out.println(l.getNumbers().toString());
        }
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
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
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
            catch(IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static void setResult(Lotto[] lottoNum, Lotto userNum, int bonusNum, long earned) {
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
            addResult(rank, earned);
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

    private static void addResult(Rank rank, long earned) {
        if(rank != null) {
            lottoWinsCount[rank.ordinal()]++;
            earned += rank.getPrize();
        }
    }

    private static void printResult() {
        System.out.println("\n당첨 통계\n---");

        for (int i = RANKING - 1; i >= 0; i--)  {
            Rank rank = ranks[i];
            System.out.print(rank.getWins() + "개 일치");
            if (i == Rank.SECOND.ordinal()){
                System.out.print(", 보너스 볼 일치");
            }
            System.out.print(" (" + String.format("%,d", rank.getPrize()) + "원) - ");
            System.out.println(lottoWinsCount[rank.ordinal()] + "개");
        }
    }

    private static void printProfit(int paid, long earned) {
        double profit = (double)earned / paid * 100.0;
        System.out.println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }
}

