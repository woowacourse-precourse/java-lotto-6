package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController();

        controller.purchaseLotteries(); //구입 금액 입력 및 로또 발행
        controller.provideLotteriesDetails(); //발행한 로또 번호 출력
        controller.setUpWinning(); //당첨 번호와 보너스 번호 입력 및 처리
        controller.provideWinningDetails(); //당첨 통계 계산 후 출력
        controller.provideRateOfReturn(); //수익률 계산 후 출력
    }
}
