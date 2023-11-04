package lotto.io;

import lotto.constants.ProgressMessage;
import lotto.dto.LottoResultDto;

public class OutputView {

    public void printErrorMessage(String error) {
        System.out.println(error);
    }

    public void printLottoPurchasePriceMessage() {
        System.out.println(ProgressMessage.INPUT_LOTTO_PURCHASE_PRICE_MESSAGE);
    }

    public void printLottoResult(LottoResultDto lottoResultDto) {
        System.out.println(lottoResultDto.toResultLottoMessage());
    }
}
