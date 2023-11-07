package lotto;

import java.util.*;

public class Play {
    LottoMachine lottoMachine = new LottoMachine();
    LottoChecker lottoChecker = new LottoChecker();
    InputHandler inputAmount = new InputHandler();
    LottoResultPrinter lottoResultPrinter = new LottoResultPrinter();

    public void play() {
        int lottoAmount = inputAmount.inputAmount(); //로또를 몇개 살지
        List<Lotto> lottos = lottoMachine.createLotto(lottoAmount); //구입한 금액만큼 로또 생성
        lottoMachine.printLotto(lottos); //랜덤으로 생성된 로또 출력
        List<Integer> winnerNumbers = new ArrayList<>(inputAmount.inputSixNumber()); //당첨 번호를 입력 받는다
        int bonusNumber = inputAmount.inputBonusNumber(winnerNumbers); //보너스 번호
        List<LottoResult> lottoResults = lottoChecker.checkLottoNumbers(lottos, winnerNumbers,bonusNumber); //몇개가 일치하는지 체크
        long winningAmount = lottoResultPrinter.lottoResultPrinter(lottoResults); //당첨된 로또 출력
        String result = lottoResultPrinter.calculateLottoProfitRate(winningAmount, lottoAmount); //수익률 결과
        System.out.println(result); //수익률 출력
    }
}