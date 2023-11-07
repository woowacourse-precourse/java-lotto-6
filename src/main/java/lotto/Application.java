package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

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
