package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Amount;
import lotto.model.InputBonusNumber;
import lotto.model.InputLottoNumber;
import lotto.model.Lotto;
import lotto.model.LottoQuantity;
import lotto.model.Match;
import lotto.model.MatchResult;
import lotto.model.RandomNumber;
import lotto.model.Statistics;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView lottoView;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void testRun() {
        // 구입 금액 입력
        Amount amount = promptForAmount();

        // 로또 구매 개수 계산
        LottoQuantity lottoQuantity = new LottoQuantity(amount.getAmount());
        lottoView.printQuantityLotto(lottoQuantity.toString());

        // 로또 발행
        List<Lotto> lottos = generateLottos(lottoQuantity);
        printLottos(lottos);

        // 당첨 번호 입력
        InputLottoNumber inputNumber = promptForWinningNumber();

        // 보너스 번호 입력
        InputBonusNumber inputBonusNumber = promptForBonusNumber();

        // 결과 계산
        List<MatchResult> matchResults = calculateMatchResults(lottos, inputNumber,
            inputBonusNumber);

        // 통계 계산 및 결과 출력
        Statistics statistics = new Statistics(amount.getAmount(), matchResults);
        float totalProfit = statistics.evaluateTotalProfit();
        String convertedTotalProfit = String.valueOf(totalProfit);
        lottoView.printTotalProfitRate(convertedTotalProfit);
    }

    private Amount promptForAmount() {
        while (true) {
            try {
                lottoView.printAskInputAmount();
                String purchaseAmount = Console.readLine();
                return new Amount(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private InputLottoNumber promptForWinningNumber() {
        while (true) {
            try {
                lottoView.printAskInputWinningNumber();
                String winningNumbers = Console.readLine();
                return new InputLottoNumber(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private InputBonusNumber promptForBonusNumber() {
        while (true) {
            try {
                lottoView.printAskInputBonusNumber();
                String bonusNumber = Console.readLine();
                return new InputBonusNumber(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> generateLottos(LottoQuantity lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoQuantity.getQuantity(); i++) {
            lottos.add(new Lotto(new RandomNumber().getRandomNumber()));
        }
        return lottos;
    }

    private void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lottoView.printLottoNumber(lotto.toString());
            lottoView.printEmptyLine();
        }
        lottoView.printEmptyLine();
    }

    private List<MatchResult> calculateMatchResults(List<Lotto> lottos,
        InputLottoNumber inputNumber, InputBonusNumber inputBonusNumber) {
        List<MatchResult> matchResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            matchResults.add(new Match(inputNumber, inputBonusNumber, lotto).calculate());
        }
        return matchResults;
    }
}
