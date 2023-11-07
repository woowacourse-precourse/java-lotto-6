package lotto.controller;

import lotto.global.SingletonRegistry;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static LottoController getInstance(InputView inputView, OutputView outputView){
        String key = "LottoController";
        if (SingletonRegistry.getInstance(key) == null) {
            SingletonRegistry.register(key, new LottoController(inputView, outputView));
        }
        return (LottoController) SingletonRegistry.getInstance(key);
    }
    public void run(){
        Lottos lottos = buyLotto();
        setGoal(lottos);
    }

    private Lottos buyLotto(){
        outputView.outputPayment();
        int payment = inputView.inputPayment();
        System.out.println();

        Lottos lottos = new Lottos();
        lottos.buyMultipleAllRandom(payment);
        outputView.outputBuy(lottos);
        System.out.println();

        return lottos;
    }

    private void setGoal(Lottos lottos){
        outputView.outputGoal();
        lottos.setGoal(inputView.inputNumbers());
        System.out.println();

        outputView.outputBonus();
        lottos.setBonus(inputView.inputNumber());
        System.out.println();
    }
}