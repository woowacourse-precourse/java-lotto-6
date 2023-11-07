package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.view.InputPurchaseView;
import lotto.view.OutputPurchaseView;

/**
 * 게임의 전체적인 흐름을 관리
 */
public class GameController {
    private final InputPurchaseView inputPurchaseView = new InputPurchaseView();
    private final OutputPurchaseView outputPurchaseView = new OutputPurchaseView();
    private final Lottos lottos = new Lottos();

    /**
     * 게임 시작하는 메서드
     */
    public void start(){
        init();
    }

    /**
     * 게임을 시작하기전에 구매할 금액에 따라 로또를 생성하고 출력하는 메서드
     */
    private void init(){
        Price price =  new Price(inputPurchaseView.printPurchasePrice()); //구입 금액 입력받기
        lottos.generateLotto(price.getAmount());// 입력받은 구입금액 만큼 lotto 생성
        outputPurchaseView.printPurchaseLotto(price.getAmount(), lottos);//구입한 로또들을 출력
    }

}
