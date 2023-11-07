package lotto.controller;

import java.util.function.Supplier;
import lotto.model.Amount;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        Amount amount = getValidInput(() -> new Amount(InputView.requestAmount()));
    }

    // IllegalArgumentException 발생 시 해당 메소드 반복
    private <T> T getValidInput(Supplier<T> method) {
        while (true) {
            try {
                return method.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}