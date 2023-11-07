package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.lottoUI.ERRORUI;
import lotto.lottoUI.LottoUI;

public class WinningStatistics {
    private static int bonusNumber;
    private static double totalPrize = 0;
    public static List<Lotto> lottos;

    public WinningStatistics(List<Lotto> lottos) {
        this.lottos = lottos;
        InputBonusNumber();
    }

    public static void InputBonusNumber() {
        while (true) {
            LottoUI.InputBonusNumber();
            try {
                bonusNumber = Integer.parseInt(readLine());
                if (!isDuplication(bonusNumber)) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.err.println(ERRORUI.SameNumberExistError());
            }
        }
        PrintStatistics();
    }

    private static boolean isDuplication(int bonusNumber) {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            if (numbers.contains(bonusNumber)) {
                throw new IllegalArgumentException(ERRORUI.SameNumberExistError());
            }
        }
        return false;
    }

    private static void PrintStatistics() {
        LottoPublisher publishLotto = new LottoPublisher(LottoPublisher.getPublish_num()); // 인스턴스 생성
        List<List<Integer>> lottodemo = publishLotto.getLottoNumbers(); // 인스턴스 메서드 호출
        List<Integer> demo = lottos.get(0).getNumbers();
        List<WinningRank> winningRanks = new ArrayList<>();

        LottoUI.DisplayWinningStatistics();

        for (List<Integer> demoNumbers : lottodemo) {
            int commonNumbersCount = countCommonNumbers(demo, demoNumbers);
            boolean isBonusNumberMatch = isBonusNumberMatch(demoNumbers);
            WinningRank rank = WinningRank.getWinningRank(commonNumbersCount, isBonusNumberMatch);
            winningRanks.add(rank);
        }

        printWinningRanks(winningRanks);
    }

    private static int countCommonNumbers(List<Integer> demo, List<Integer> demoNumbers) {
        int count = 0;
        for (Integer number : demo) {
            if (demoNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isBonusNumberMatch(List<Integer> demoNumbers) {
        return demoNumbers.contains(bonusNumber);
    }

    private static void printWinningRanks(List<WinningRank> winningRanks) {
        for (WinningRank rank : WinningRank.values()) {
            int count = countMatchingRanks(winningRanks, rank);
            int prize = rank.calculatePrize(count, rank == WinningRank.SECOND);
            if (rank != WinningRank.NON) {
                totalPrize += prize;
                LottoUI.DisplayNumberOfMatches(rank.getDescription(),count);
            }
        }
        PrintRateOfReturn();
    }

    private static void PrintRateOfReturn() {
        double totalSpent = (double) LottoPurchase.GetPurchase_amount();
        double earningRate = (totalPrize / totalSpent) * 100;
        LottoUI.DisplayRateOfReturn(earningRate);
    }

    private static int countMatchingRanks(List<WinningRank> winningRanks, WinningRank rank) {
        return (int) winningRanks.stream().filter(r -> r == rank).count();
    }
}