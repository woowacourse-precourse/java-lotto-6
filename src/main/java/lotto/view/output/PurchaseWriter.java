package lotto.view.output;

import lotto.dto.LottoNumberResponse;
import lotto.dto.LottoNumberResponses;

import static lotto.view.constants.PrintMessage.RESPONSE_PURCHASE_COUNT;

public final class PurchaseWriter extends OutputWriter {
    private PurchaseWriter() {
    }

    public static void printPurchaseLottoNumbers(final LottoNumberResponses responses) {
        responses.lottoResponses()
                .stream()
                .map(LottoNumberResponse::numbers)
                .forEach(OutputWriter::println);

        printNewLine();
    }

    public static void printPurchaseCount(final LottoNumberResponses responses) {
        String formattedMessage = String.format(
                RESPONSE_PURCHASE_COUNT.getMessage(), responses.purchaseCount());

        println(formattedMessage);
    }

}
