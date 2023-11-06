package lotto.view;

import lotto.constant.InformationMessage;
import lotto.dto.LottoDto;
import lotto.dto.LottoReceiptDto;
import lotto.dto.LottoResultDto;
import java.util.List;

public class OutputView {
    public void printErrorMessage(Exception exception) {
        print(exception.getMessage());
    }

    public void printLottoReceipt(LottoReceiptDto lottoReceipt) {
        print(String.format(
                InformationMessage.PURCHASE_LOTTO_COUNT_FORMAT.getMessage(),
                lottoReceipt.purchaseCount()
        ));
        printLottos(lottoReceipt.lottos());
    }

    private void printLottos(List<LottoDto> lottos) {
        for (LottoDto lotto : lottos) {
            printLotto(lotto);
        }
    }

    private void printLotto(LottoDto lotto) {
        print(lotto.numbers().toString());
    }

    public void printLottoResult(LottoResultDto lottoResultDto) {
    }

    public void printNewLine() {
        print("");
    }

    public void print(String message) {
        System.out.println(message);
    }
}
