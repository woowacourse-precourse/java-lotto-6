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

public class LottoController {

    public void testRun() {
        // 구입 금액 입력
        Amount amount = promptForAmount();

        // 로또 구매 개수 계산
        LottoQuantity lottoQuantity = new LottoQuantity(amount.getAmount());
        System.out.println(lottoQuantity.getQuantity() + "개를 구매했습니다.");

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
        statistics.evaluateTotalProfit();
    }

    private Amount promptForAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
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
                System.out.println("당첨 번호를 입력해 주세요.");
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
                System.out.println("보너스 번호를 입력해 주세요.");
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
        System.out.println("구매한 로또 번호:");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers()); // 각 로또의 번호를 출력
        }
        System.out.println();
    }

    private List<MatchResult> calculateMatchResults(List<Lotto> lottos,
        InputLottoNumber inputNumber, InputBonusNumber inputBonusNumber) {
        List<MatchResult> matchResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            matchResults.add(new Match(inputNumber, inputBonusNumber, lotto).calculate());
        }
        return matchResults;
    }

    public void run() {
        // 구입 금액 입력

        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        System.out.println(purchaseAmount);
        System.out.println();

        // 로또 구매 개수
        Amount amount = new Amount(purchaseAmount);

        // 구매 개수에 따른 로또 발행 및 확인
        LottoQuantity lottoQuantity = new LottoQuantity(amount.getAmount());
        System.out.println(lottoQuantity.getQuantity() + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoQuantity.getQuantity(); i++) {
            List<Integer> randomNumber = new RandomNumber().getRandomNumber();
            Lotto lotto = new Lotto(randomNumber);
            lottos.add(lotto);
        }
        System.out.println();

        // 당첨 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLottoNumber = Console.readLine();
        InputLottoNumber inputNumber = new InputLottoNumber(inputLottoNumber);
        System.out.println();

        // 보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber1 = Console.readLine();
        InputBonusNumber inputBonusNumber = new InputBonusNumber(inputBonusNumber1);

        List<MatchResult> matchResults = new ArrayList<MatchResult>();
        for (Lotto lotto : lottos) {
            Match match = new Match(inputNumber, inputBonusNumber, lotto);
            MatchResult matchResult = match.calculate();
            matchResults.add(matchResult);
        }
        Statistics statistics = new Statistics(amount.getAmount(), matchResults);
        statistics.evaluateTotalProfit();
    }
}
