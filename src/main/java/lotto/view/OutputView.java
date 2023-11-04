package lotto.view;

import java.util.List;
import lotto.constant.PrintMessage;
import lotto.domain.Lotto;

public class OutputView {
    public void printPaymentRequest() {
        System.out.println(PrintMessage.PAYMENT_REQUEST.getMessage());
    }

    // TODO: view에서 도메인을 get하는게 맞는가? 아니면 도메인에서 view를 호출하는게 맞는가? 아니면 컨트롤러에서 정제된 정보를 주는게 맞는가?
    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.printf("\n%d%s\n", lottos.size(), PrintMessage.AMOUT_LOTTO.getMessage());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
