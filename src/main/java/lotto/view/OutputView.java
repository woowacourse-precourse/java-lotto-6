package lotto.view;

import lotto.consts.MachineMessage;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.utils.LottoCompare;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void displayPurchaseList(Lottos lottos) {
        System.out.println();
        System.out.println(lottos.getLottos().size() + MachineMessage.MACHINE_MESSAGE_PURCHASE_LIST.getMessage());
        for (Lotto lotto: lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void displayLottoCompareResult(List<LottoCompare> lottoCompares) {
        System.out.println(MachineMessage.MACHINE_MESSAGE_LOTTO_RESULT.getMessage());
        System.out.println(LottoCompare.FIFTH.getLabel() + MachineMessage.MACHINE_MESSAGE_DASH.getMessage() + Collections.frequency(lottoCompares, LottoCompare.FIFTH) + MachineMessage.MACHINE_MESSAGE_COUNT.getMessage());
        System.out.println(LottoCompare.FOURTH.getLabel() + MachineMessage.MACHINE_MESSAGE_DASH.getMessage() + Collections.frequency(lottoCompares, LottoCompare.FOURTH) + MachineMessage.MACHINE_MESSAGE_COUNT.getMessage());
        System.out.println(LottoCompare.THIRD.getLabel() + MachineMessage.MACHINE_MESSAGE_DASH.getMessage() + Collections.frequency(lottoCompares, LottoCompare.THIRD) + MachineMessage.MACHINE_MESSAGE_COUNT.getMessage());
        System.out.println(LottoCompare.SECOND.getLabel() +MachineMessage.MACHINE_MESSAGE_DASH.getMessage()+ Collections.frequency(lottoCompares, LottoCompare.SECOND) + MachineMessage.MACHINE_MESSAGE_COUNT.getMessage());
        System.out.println(LottoCompare.FIRST.getLabel() + MachineMessage.MACHINE_MESSAGE_DASH.getMessage() + Collections.frequency(lottoCompares, LottoCompare.FIRST) + MachineMessage.MACHINE_MESSAGE_COUNT.getMessage());
    }
}
