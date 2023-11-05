package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int AMOUNT;
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
        AMOUNT = purchaseAmountInput();

        outputView.purchasesNumberView(AMOUNT);
        createLotto(AMOUNT);    //로또 생성
        outputView.lottosView(lottos);  //로또 출력
    }

    public int purchaseAmountInput(){
        //예외 처리 추가해야 함

        return Integer.parseInt(Console.readLine());
    }

    public void createLotto(int AMOUNT){
        for(int i=0; i<AMOUNT; i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
    }

}
