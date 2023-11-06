package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int AMOUNT;
    private int COUNT_LOTTO;
    private InputView inputView;
    private OutputView outputView;
    private final List<Lotto> lottos;

    public Game() {
        inputView = new InputView();
        outputView = new OutputView();
        lottos = new ArrayList<>();
    }

    public void run(){
        inputView.purchaseAmountView();
        AMOUNT = purchaseAmountInput(); //로또 구매 금액
        COUNT_LOTTO = countLotto(AMOUNT);   //로또 금액을 개수로 변환

        outputView.purchasesNumberView(COUNT_LOTTO);
        createLotto(COUNT_LOTTO);    //로또 생성
        outputView.lottosView(lottos);  //로또 출력
        inputView.prizeNumber();

        
    }

    public int purchaseAmountInput(){
        //예외 처리 추가해야 함

        return Integer.parseInt(Console.readLine());
    }

    public int countLotto(int AMOUNT){
        return AMOUNT/1000;
    }

    public void createLotto(int AMOUNT){
        for(int i=0; i<AMOUNT; i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
    }

}
