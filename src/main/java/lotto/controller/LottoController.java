package lotto.controller;

import lotto.global.SingletonRegistry;
import lotto.model.Lottos;
import lotto.model.Result;
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
        int money = inputPayment();
        Lottos lottos = buyLotto(money);
        setGoal(lottos);
        setBonus(lottos);
        showResult(lottos,money);
    }

    private int inputPayment(){
        while(true) {
            try {
                outputView.outputPayment();
                int payment = inputView.inputPayment();
                System.out.println();
                return payment;
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }
    private Lottos buyLotto(int payment){
        while(true) {
            try {
                Lottos lottos = new Lottos();
                lottos.buyMultipleAllRandom(payment);
                outputView.outputBuy(lottos);
                System.out.println();
                return lottos;
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private void setGoal(Lottos lottos){
        while(true) {
            try {
                outputView.outputGoal();
                lottos.setGoal(inputView.inputNumbers());
                System.out.println();
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }
    private void setBonus(Lottos lottos){
        while(true) {
            try {
                outputView.outputBonus();
                lottos.setBonus(inputView.inputNumber());
                System.out.println();
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }
    private void showResult(Lottos lottos,int money){
        Result result = lottos.match();
        outputView.outputResult(result,money);
    }
}