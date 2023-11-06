package lotto;

import domain.LottoNumberGenerator;
import domain.LottoProfitCalculator;
import domain.LottoWinChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(readLine()); // 로또 구입 금액
        int numberOfLottos = purchaseAmount / 1000; // 구입한 로또 개수

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(new LottoNumberGenerator().getLottoNumbers()));
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
