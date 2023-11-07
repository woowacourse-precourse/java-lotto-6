package lotto.controller;

import static lotto.view.OutputView.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.service.LottoService;

public class LottoController {

    private LottoService lottoService;
    private List<Integer> matchingLotto;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void start() {
        requestAmount();
        requestMyLotto();
        requestLotto();
        requestBonus();
        matchLotto();
        result();
        rateOfReturn();
    }

    // 금액 입력 및 검증
    private void requestAmount() {
        printAmount();
        try {
            lottoService.setAmount(Console.readLine());
        } catch (IllegalArgumentException e) {
            requestAmount();
        }
    }

    // 로또 번호 입력 및 검증
    private void requestLotto() {
        printNumbers();
        try {
            lottoService.setLotto(Console.readLine());
        } catch (IllegalArgumentException e) {
            requestLotto();
        }
    }

    // 보너스 번호 입력
    private void requestBonus() {
        printBonus();
        try {
            lottoService.setBonus(Console.readLine());
        } catch (IllegalArgumentException e) {
            requestBonus();
        }
    }

    // 내 로또 번호 설정
    private void requestMyLotto() {
        printBuy(lottoService.numberOfPurchase());
        lottoService.setMyLotto();
    }

    // 5등부터 1등까지 한 횟수 저장
    private void matchLotto() {
        matchingLotto = lottoService.resultLotto();
    }

    // 결과 출력
    private void result() {
        printStats();
        printDash();
        eachResult(matchingLotto);
    }

    // 총 수익률 출력
    private void rateOfReturn() {
        printResult(lottoService.rateReturn());
    }


}
