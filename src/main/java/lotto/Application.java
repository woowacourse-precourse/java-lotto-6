package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_COUNT = 6;
    private static final int RANKING = 5;

    private static int paid;
    private static int bought;
    private static long earned;
    private static int bonusNum;

    private static final int[] lottoWinsCount = new int[RANKING];
    private static final Rank[] ranks = Rank.values();
    private static final List<Integer> userNum = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        readPaid();
        setBought();

        Lotto[] lottoNum = createLottoNums();
        printLottoNums(lottoNum);

        readUserNum();
        readBonusNum();

        System.out.println("\n당첨 통계\n---");
        setResult(lottoNum);
        printResult();
        printProfit();
    }

    private static void setResult(Lotto[] lottoNum) {
        for(Lotto l : lottoNum) {
            int winsCount = 0;
            boolean bonusCount = false;

            for(int n : userNum) {
                if(l.getNumbers().contains(n)) {
                    winsCount++;
                }

                bonusCount = l.getNumbers().contains(bonusNum);
            }

            Rank rank = getRank(winsCount, bonusCount);
            addResult(rank);
        }
    }

    private static void addResult(Rank rank) {
        if(rank != null) {
            lottoWinsCount[rank.ordinal()]++;
            earned += rank.getPrize();
        }
    }

    private static void readPaid() {
        System.out.println("구입금액을 입력해 주세요.");
        while(true) {
            try {
                paid = Integer.parseInt(Console.readLine());
                if(paid % LOTTO_PRICE != 0) throw new IllegalArgumentException("[ERROR] 구입금액은 " + LOTTO_PRICE + "의 배수여야 합니다.");
                System.out.println();
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            }
            catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void setBought() {
        bought = paid / LOTTO_PRICE;
        System.out.println(bought + "개를 구매했습니다.");
    }

    private static Lotto[] createLottoNums() {
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

    private static void readUserNum() {
        while(true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            try {
                String[] str = Console.readLine().split(",");
                checkUserNums(str);
                addUserNums(str);
                checkDuplicate();
                System.out.println();
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static void checkUserNums(String[] str) {
        if (str.length != LOTTO_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 " + LOTTO_COUNT + "개를 입력해야 합니다.");
        }
    }

    private static void addUserNums(String[] str) {
        for (String s : str) {
            int n = Integer.parseInt(s);
            if (n < LOTTO_MIN || n > LOTTO_MAX) {
                userNum.clear();
                throw new IllegalArgumentException("당첨 번호는 " + LOTTO_MIN + "부터 " + LOTTO_MAX + " 사이의 숫자여야 합니다.");
            }
            userNum.add(n);
        }
    }

    private static void checkDuplicate() {
        Set<Integer> userSet = new HashSet<>(Application.userNum);
        if (Application.userNum.size() != userSet.size()) {
            Application.userNum.clear();
            throw new IllegalArgumentException("당첨 번호는 서로 중복되지 않아야 합니다.");
        }
    }

    private static void readBonusNum() {
        while(true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                bonusNum = Integer.parseInt(Console.readLine());
                checkBonusNumRange();
                checkBonusNumDuplicate();
                break;
            }
            catch(IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static void checkBonusNumRange() {
        if(bonusNum < LOTTO_MIN || bonusNum > LOTTO_MAX) {
            throw new IllegalArgumentException("보너스 번호는 " + LOTTO_MIN + "부터 " + LOTTO_MAX + " 사이의 숫자여야 합니다.");
        }
    }

    private static void checkBonusNumDuplicate() {
        if (userNum.contains(bonusNum)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 서로 중복되지 않아야 합니다.");
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

    private static void printResult() {
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

    private static void printProfit() {
        double profit = (double)earned / paid * 100.0;
        System.out.println("총 수익률은 " + String.format("%.2f", profit) + "%입니다.");
    }
}

