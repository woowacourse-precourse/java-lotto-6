package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoWinningStatistics {

    private final Map<Integer, Integer> winnings;

    public LottoWinningStatistics() {
        this.winnings = new HashMap<>();
        // 초기 당첨 횟수는 모두 0으로 설정합니다.
        for (int i = 1; i <= 6; i++) {
            winnings.put(i, 0);
        }
    }

    public void recordWin(int matchCount, boolean hasBonus) {
        // 보너스 번호가 있는 경우 2등으로 처리합니다.
        if (matchCount == 5 && hasBonus) {
            int currentCount = winnings.getOrDefault(2, 0);
            winnings.put(2, currentCount + 1);
        } else {
            // 3개 맞추면 5등, 4개 맞추면 4등, 5개 맞추면 3등, 6개 맞추면 1등
            int rank = switch (matchCount) {
                case 3 -> 5;
                case 4 -> 4;
                case 5 -> 3;
                case 6 -> 1;
                default -> 0; // 맞춘 번호가 3개 미만인 경우 등수가 없습니다.
            };
            if (rank > 0) {
                int currentCount = winnings.getOrDefault(rank, 0);
                winnings.put(rank, currentCount + 1);
            }
        }
    }

    public void printStatistics() {
        System.out.println("당첨 통계:");
        for (Map.Entry<Integer, Integer> entry : winnings.entrySet()) {
            System.out.printf("%d등: %d회 당첨\n", entry.getKey(), entry.getValue());
        }
    }

    public double calculateProfitRate(int purchaseAmount) {
        // 당첨금 계산 (예시로 각 등수별 당첨금 설정)
        int[] prizeMoney = {0, 2000000000, 30000000, 1500000, 50000, 5000};

        // 당첨금 총액 계산
        int totalPrize = winnings.entrySet().stream()
                .mapToInt(e -> e.getValue() * prizeMoney[e.getKey()])
                .sum();

        // 수익률 계산
        double profitRate = ((double) totalPrize / purchaseAmount - 1) * 100;

        // 수익률 출력
        System.out.printf("수익률: %.2f%%\n", profitRate);

        return profitRate;
    }

    // 기타 필요한 메소드 추가
}
