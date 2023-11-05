package lotto.controller;

import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }


    public void play() {
        buyLotto();
        getUserLotto();
        getLottoResult();
        printLottoResult();
    }

    private void buyLotto() {
        String amount = inputView.printAskPurchase();
        //TODO: 구입 금액을 입력받고, 구입 금액/1000 개수만큼 로또를 랜덤하게 생성

        //TODO: view를 통해 로또 정보 출력
    }

    private void getUserLotto() {
        //TODO: 당첨 번호 입력

        //TODO: 보너스 번호 입력

    }

    private void getLottoResult() {
        //TODO: 당첨 통계 계산 및 정보 전달

    }

    private void printLottoResult() {
        //TODO: view를 통해 당첨 개수 & 총 수익률 출력

    }
}
