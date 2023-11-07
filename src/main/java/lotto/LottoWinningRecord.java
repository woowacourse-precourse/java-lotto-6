package lotto;

import java.util.List;

public class LottoWinningRecord {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoWinningRecord(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int calculatePrize(List<Integer> ticketNumbers) {
        int matchedNumbers = countMatchedNumbers(ticketNumbers);
        boolean hasBonusNumber = ticketNumbers.contains(bonusNumber);

        int prize = 0;

        if (matchedNumbers == 3) {
            prize = 5000;
        } else if (matchedNumbers == 4) {
            prize = 50000;
        } else if (matchedNumbers == 5) {
            if (hasBonusNumber) {
                prize = 30000000;
            } else {
                prize = 1500000;
            }
        } else if (matchedNumbers == 6) {
            prize = 2000000000;
        }

        return prize;
    }


    private int countMatchedNumbers(List<Integer> ticketNumbers) {
        int count = 0;
        for (int number : ticketNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void calculateAndPrintStatistics(List<List<Integer>> ticketList, int purchaseAmount) {
        int totalPrize = 0;
        int[] prizes = new int[5]; // 3개 일치, 4개 일치, 5개 일치, 5개 일치 + 보너스 볼 일치, 6개 일치

        for (List<Integer> ticketNumbers : ticketList) {
            int prize = calculatePrize(ticketNumbers);

            if (prize > 0) {
                totalPrize += prize;
                if (prize == 5000) {
                    prizes[0]++;
                } else if (prize == 50000) {
                    prizes[1]++;
                } else if (prize == 1500000) {
                    if (ticketNumbers.contains(bonusNumber)) {
                        prizes[3]++;
                    } else {
                        prizes[2]++;
                    }
                } else if (prize == 2000000000) {
                    prizes[4]++;
                }

            }
        }

        printStatistics(prizes, totalPrize, purchaseAmount);
    }

    public void printStatistics(int[] prizes, int totalPrize, int purchaseAmount) {
        printLottoWinning(prizes);
        printTotalProfitRate(totalPrize, purchaseAmount);
    }

    public void printLottoWinning(int[] prizes) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + prizes[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + prizes[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizes[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizes[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizes[4] + "개");
    }

    public void printTotalProfitRate(int totalPrize, int purchaseAmount) {
        double totalProfitRate = ((double) totalPrize / purchaseAmount) * 100;
        double roundedProfitRate = Math.round(totalProfitRate * 100.0) / 100.0;
        System.out.println("총 수익률은 " + roundedProfitRate + "%입니다.");
    }

}
