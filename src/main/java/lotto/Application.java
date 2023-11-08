package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = readPurchaseAmount();
        List<Lotto> lottos = generateLottos(purchaseAmount);
        List<Integer> winningNumbers = readWinningNumbers();
        int bonusNumber = readBonusNumber();

        LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber);
        printLottoResult(lottos, lottoResult);
    }

    private static int readPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int purchaseAmount = Console.readInt();
        if (purchaseAmount < Lotto.LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 최소 " + Lotto.LOTTO_PRICE + "원 이상이어야 합니다.");
        }
        return purchaseAmount;
    }

    private static List<Lotto> generateLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / Lotto.LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    private static List<Integer> readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine();
        return Arrays.asList(winningNumbersInput.split(","))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int readBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Console.readInt();
    }

    private static void printLottoResult(List<Lotto> lottos, LottoResult lottoResult) {
        int totalWinningAmount = lottoResult.calculateTotalWinningAmount(lottos);
        double earningRate = (double) totalWinningAmount / (lottos.size() * Lotto.LOTTO_PRICE) * 100;

        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println("당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            int matchCount = rank.getMatchCount(lottoResult);
            if (rank == Rank.SECOND && matchCount > 0) {
                System.out.println(rank.getPrize() + " - " + matchCount + "개, 보너스 볼 일치");
            } else if (matchCount > 0) {
                System.out.println(rank.getPrize() + " - " + matchCount + "개");
            }
        }

        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}
