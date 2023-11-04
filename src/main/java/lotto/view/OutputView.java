package lotto.view;

import lotto.consts.MachineMessage;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {
    public static void displayPurchaseList(Lottos lottos) {
        System.out.println();
        System.out.println(lottos.getLottos().size() + MachineMessage.MACHINE_MESSAGE_PURCHASE_LIST.getMessage());
        for (Lotto lotto: lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}
