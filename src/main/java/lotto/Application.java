package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class Application {
    public static final int RANKING = 5;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int paid;

        while(true) {
            try {
                paid = Integer.parseInt(Console.readLine());
                if(paid % 1000 != 0) {
                    throw new IllegalArgumentException();
                }

                break;
            }
            catch(IllegalArgumentException e) {
                System.out.println("[ERROR] 구입금액은 1000의 배수여야 합니다.");
            }
        }

        System.out.println();

        int bought = paid / 1000;
        System.out.println(bought + "개를 구매했습니다.");

        Lotto[] lottoNum = new Lotto[bought];
        for(int i = 0; i < bought; i++) {
            lottoNum[i] = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottoNum[i].getNumbers());
        }

        for(Lotto l : lottoNum) {
            System.out.println(l.getNumbers().toString());
        }

        List<Integer> userNum = new ArrayList<>();
        while(true) {
            System.out.println("당첨 번호를 입력해 주세요.");

            try {
                String[] str = Console.readLine().split(",");
                if (str.length != 6) {
                    throw new IllegalArgumentException("당첨 번호는 6개를 입력해야 합니다.");
                }

                for (String s : str) {
                    int n = Integer.parseInt(s);
                    if (n < 1 || n > 45) {
                        throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
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
                if(bonusNum < 1 || bonusNum > 45) {
                    throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                }

                if (userNum.contains(bonusNum)) {
                    throw new IllegalArgumentException("당첨 번호와 보너스 번호는 서로 중복되지 않아야 합니다.");
                }

                break;
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
        for(Lotto l : lottoNum) {
            int winsCount = 0;
            boolean bonusCount = false;

            for(int n : userNum) {
                if(l.getNumbers().contains(n)) {
                    winsCount++;
                }

                bonusCount = l.getNumbers().contains(bonusNum);
            }

            if(winsCount == Rank.FIRST.getWins()) {
                lottoWinsCount[Rank.FIRST.ordinal()]++;
                earned += Rank.FIRST.getPrize();
                continue;
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

        System.out.print(Rank.FIFTH.getWins() + "개 일치 ");
        System.out.print("(" + String.format("%,d", Rank.FIFTH.getPrize()) + "원) - ");
        System.out.println(lottoWinsCount[Rank.FIFTH.ordinal()] + "개");

        System.out.print(Rank.FOURTH.getWins() + "개 일치 ");
        System.out.print("(" + String.format("%,d", Rank.FOURTH.getPrize()) + "원) - ");
        System.out.println(lottoWinsCount[Rank.FOURTH.ordinal()] + "개");

        System.out.print(Rank.THIRD.getWins() + "개 일치 ");
        System.out.print("(" + String.format("%,d", Rank.THIRD.getPrize()) + "원) - ");
        System.out.println(lottoWinsCount[Rank.THIRD.ordinal()] + "개");

        System.out.print(Rank.SECOND.getWins() + "개 일치, 보너스 볼 일치 ");
        System.out.print("(" + String.format("%,d", Rank.SECOND.getPrize()) + "원) - ");
        System.out.println(lottoWinsCount[Rank.SECOND.ordinal()] + "개");

        System.out.print(Rank.FIRST.getWins() + "개 일치 ");
        System.out.print("(" + String.format("%,d", Rank.FIRST.getPrize()) + "원) - ");
        System.out.println(lottoWinsCount[Rank.FIRST.ordinal()] + "개");

        double profit = (double) earned / paid * 100;
        System.out.println("총 수익률은 " + String.format("%.2f", profit) + "%입니다.");
    }
}

