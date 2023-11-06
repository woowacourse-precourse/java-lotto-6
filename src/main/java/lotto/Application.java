package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import domain.LottoProfitCalculator;
import domain.LottoWinChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount; // 로또 구입 금액
        int numberOfLottos; // 구입한 로또 개수
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                purchaseAmount = Integer.parseInt(readLine());
                numberOfLottos = purchaseAmount / 1000;
                if (purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지지 않습니다.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자가 아닙니다.");
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        System.out.println();
        System.out.println(numberOfLottos + "개를 구매했습니다.");
        for (int i = 0; i < numberOfLottos; i++) {
            System.out.println(lottos.get(i).getNumbers());
        }

        List<Integer> winningNumbers;

        System.out.println('\n' + "당첨 번호를 입력해 주세요.");
        String winningNumberInput = readLine();
        winningNumbers = Arrays.stream(winningNumberInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println('\n' + "보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(readLine());
        winningNumbers.add(bonusNumber);

        LottoWinChecker winChecker;
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            winChecker = new LottoWinChecker(lotto, winningNumbers);
        }

        System.out.println('\n' + "당첨 통계");
        System.out.println('\n' + "---");
        LottoProfitCalculator lottoProfitCalculator = new LottoProfitCalculator(purchaseAmount, lottos);
        lottoProfitCalculator.rankPrinter();
        System.out.println("총 수익률은 " + lottoProfitCalculator.getProfitRate() + "%입니다.");
    }
}
