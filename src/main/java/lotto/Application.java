package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_COUNT = 6;
    private static final int RANKING = 5;

    public static final Rank[] ranks = Rank.values();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int paid = getPaid();
        int bought = paid / LOTTO_PRICE;
        System.out.println(bought + "개를 구매했습니다.");

        Lotto[] lottos = getLottos(bought);
        showLottos(lottos);

        List<Integer> userNum = new ArrayList<>();
        while(true) {
            System.out.println("당첨 번호를 입력해 주세요.");

            try {
                String[] str = getUserNum();

                for (String s : str) {
                    int n = Integer.parseInt(s);
                    checkLottoRange(n);
                    userNum.add(n);
                }

                Set<Integer> userSet = new HashSet<>(userNum);
                if (userNum.size() != userSet.size()) {
                    throw new IllegalArgumentException("당첨 번호는 서로 중복되지 않아야 합니다.");
                }

                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        System.out.println();
        int bonusNum;

        while(true) {
            System.out.println("보너스 번호를 입력해 주세요.");

            try {
                bonusNum = Integer.parseInt(Console.readLine());
                if(bonusNum < LOTTO_MIN || bonusNum > LOTTO_MAX) {
                    throw new IllegalArgumentException("보너스 번호는 " + LOTTO_MIN + "부터 " + LOTTO_MAX + " 사이의 숫자여야 합니다.");
                }

                if (userNum.contains(bonusNum)) {
                    throw new IllegalArgumentException("당첨 번호와 보너스 번호는 서로 중복되지 않아야 합니다.");
                }

                break;
            }
            catch(NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력하세요.");
            }
            catch(IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        long earned = 0;
        int[] lottoWinsCount = new int[RANKING];
        for(Lotto l : lottos) {
            int winsCount = 0;
            boolean bonusCount = false;

            for(int n : userNum) {
                if(l.getNumbers().contains(n)) {
                    winsCount++;
                }

                bonusCount = l.getNumbers().contains(bonusNum);
            }

            if(winsCount == Rank.SECOND.getWins() && bonusCount) {
                lottoWinsCount[Rank.SECOND.ordinal()]++;
                earned += Rank.SECOND.getPrize();
                continue;
            }

            if(winsCount == Rank.THIRD.getWins()) {
                lottoWinsCount[Rank.THIRD.ordinal()]++;
                earned += Rank.THIRD.getPrize();
                continue;
            }

            if(winsCount == Rank.FOURTH.getWins()) {
                lottoWinsCount[Rank.FOURTH.ordinal()]++;
                earned += Rank.FOURTH.getPrize();
                continue;
            }

            if(winsCount == Rank.FIFTH.getWins()) {
                lottoWinsCount[Rank.FIFTH.ordinal()]++;
                earned += Rank.FIFTH.getPrize();
            }
        }

        for (int i = RANKING - 1; i >= 0; i--)  {
            Rank rank = ranks[i];
            System.out.print(rank.getWins() + "개 일치");
            if (i == Rank.SECOND.ordinal()){
                System.out.print(", 보너스 볼 일치");
            }
            System.out.print(" (" + String.format("%,d", rank.getPrize()) + "원) - ");
            System.out.println(lottoWinsCount[rank.ordinal()] + "개");
        }

        double profit = getProfit((double) earned, paid);
        System.out.println("총 수익률은 " + String.format("%.2f", profit) + "%입니다.");
    }

    private static double getProfit(double earned, long paid) {
        return earned / paid * 100.0;
    }
}

