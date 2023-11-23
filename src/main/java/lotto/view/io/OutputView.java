package lotto.view.io;

import lotto.domain.lotto.entity.Lottos;

public class OutputView {
    private final Printer printer = new Printer();

    public void printPurchasedLotto(Lottos lottos) {
        printer.printMessageUsingFormat("%d개 구입했습니다.", lottos.getSize());

        //todo toString 대신 다른 걸 사용하도록 리팩토링
        lottos.getLottos().forEach(
                lotto -> printer.printMessage(lotto.toString())
        );
    }
}
