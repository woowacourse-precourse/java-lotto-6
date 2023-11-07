package lotto.UI;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Prize;
import lotto.domain.WinningNumbers;
import lotto.service.LottoPurchaseService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUI {
    public int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int purchaseAmount = Integer.parseInt(Console.readLine().trim());
                validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
            }
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % LottoPurchaseService.getLottoPrice() != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");
        }
    }
    public WinningNumbers inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String line = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(line.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine().trim());

        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public void displayPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void displayResults(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NONE) {
                continue;
            }
            String prizeMessage = prize.getMatchCount() + "개 일치";
            if (prize == Prize.SECOND) {
                prizeMessage += ", 보너스 볼 일치";
            }
            prizeMessage += " (" + String.format("%,d", prize.getReward()) + "원) - "
                    + lottoResult.getPrizeCounts().getOrDefault(prize, 0) + "개";
            System.out.println(prizeMessage);
        }
        System.out.println("총 수익률은 " + lottoResult.getReturnRate() + "%입니다.");
    }
}
