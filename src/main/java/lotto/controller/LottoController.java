package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.model.Amount;
import lotto.model.Lotto;
import lotto.model.LottoNumbersGenerator;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    Lottos lottos;

    public void run() {
        Amount amount = getValidInput(() -> new Amount(InputView.requestAmount()));
        createLottos(amount);
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

    // 입력 받은 금액에 해당하는 로또 생성
    private void createLottos(Amount amount) {
        List<Lotto> autoLottos = generateAutoLottos(amount);
        lottos = new Lottos(autoLottos);
        OutputView.printLottos(lottos);
    }

    private List<Lotto> generateAutoLottos(Amount amount) {
        int count = amount.calculateCount();
        OutputView.printCount(count);
        return new LottoNumbersGenerator().generateLottos(count);
    }
}