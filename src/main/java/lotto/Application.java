package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // 구입 금액 입력 받기
        int purchaseAmount = InputView.getPurchaseAmount();
        OutputView.printEmptyLine();

        // 로또 발행 및 출력
        List<Lotto> lottos = LottoGenerator.generateLottos(purchaseAmount / LottoGenerator.LOTTO_PRICE);
        OutputView.printLottoNumbers(lottos.size(), lottos);
        OutputView.printEmptyLine();

        // 당첨 번호 및 보너스 번호 입력 받기
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        OutputView.printEmptyLine();

        Set<Integer> winningNumbersSet = new HashSet<>(winningNumbers);
        int bonusNumber = InputView.getBonusNumber(winningNumbersSet);
        OutputView.printEmptyLine();

        // 당첨 결과 계산 및 출력
        LottoResult lottoResult = calculateWinningResult(lottos, winningNumbers, bonusNumber);
        OutputView.printResult(lottoResult);

        // 수익률 계산 및 출력
        double winningRate = lottoResult.calculateWinningRate(purchaseAmount);
        OutputView.printWinningRate(winningRate);
    }

    private static LottoResult calculateWinningResult(List<Lotto> lottos, List<Integer> winningNumbers,
                                                      int bonusNumber) {
        WinningNumbers winningNumbersObject = new WinningNumbers(winningNumbers, bonusNumber);
        LottoResult lottoResult = new LottoResult(winningNumbersObject);
        for (Lotto lotto : lottos) {
            int matchCount = winningNumbersObject.countMatchNumbers(lotto);
            boolean hasBonusNumber = winningNumbersObject.hasBonusNumber(lotto);
            lottoResult.addResult(matchCount, hasBonusNumber);
        }
        return lottoResult;
    }
}
