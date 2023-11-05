package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.RandomLottoNumbers;
import lotto.domain.WinningRank;
import lotto.view.OutputView;

public class GameMachine {

    private final LottoNumbers lottoNumbers;
    private final OutputView outputView;

    public GameMachine() {
        this.lottoNumbers = new RandomLottoNumbers();
        this.outputView = new OutputView();
    }

    public void start() {
        // 사용자가 구입 금액 입력 , 1000으로 나눈다.
        System.out.println("구입금액을 입력해 주세요.");
        int inputPrice = Integer.parseInt(Console.readLine());
        int count = inputPrice / 1000;

        outputView.lottoPurchaseCountMessage(count);
        Lottos lottos = new Lottos(count, lottoNumbers);
        outputView.lottoNumbersMessage(lottos);

        // 사용자가 당첨 번호 6자리를 입력.
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> inputWinningNumbers = List.of(Console.readLine().split(","));
        // 당첨 번호 int형 list로 변환
        List<Integer> winningNumbers = inputWinningNumbers.stream()
                .map(Integer::parseInt)
                .toList();

        // 보너스 번호 입력
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int inputBonusNumber = Integer.parseInt(Console.readLine());

        // 사용자와 번호 비교 -> Lottos에 들어갈 예정
        for (Lotto lotto : lottos.getLottos()) {
            long matchCount = winningNumbers.stream()
                    .filter(lotto.getNumbers()::contains)
                    .count();

            boolean bonusMatch = lotto.getNumbers().contains(inputBonusNumber);

            for (WinningRank rank : WinningRank.values()) {
                if (rank.isMatch(matchCount, bonusMatch)) {
                    rank.addWinCount();
                    break;
                }
            }
        }

        outputView.winningHistoryMessage();
        outputView.TotalReturnRateMessage(inputPrice);
    }

}