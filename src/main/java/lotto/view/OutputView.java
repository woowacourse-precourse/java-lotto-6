package lotto.view;


import java.util.Collections;
import java.util.List;
import lotto.domain.dto.LottoDto;
import lotto.domain.dto.LottosDto;
import lotto.domain.dto.PurchaseAmountDto;

public class OutputView {
    public static final String LOTTO_PURCHASE_RESULT_MESSAGE = "%d개를 구매했습니다.\n";

    public void printPurchaseQuantityLottos(final PurchaseAmountDto purchaseAmountDto) {
        System.out.printf("\n" + LOTTO_PURCHASE_RESULT_MESSAGE, purchaseAmountDto.purchaseQuantityLottos());
    }

    public void printIssuedPurchaseResult(final LottosDto lottosDto) {
        List<LottoDto> lottos = lottosDto.lottos();

        for (LottoDto lotto : lottos) {
            sort(lotto);
            String convertedLotto = convertFrom(lotto);
            System.out.println(convertedLotto);
        }
    }

    private void sort(final LottoDto lottoDto) {
        Collections.sort(lottoDto.numbers());
    }

    private String convertFrom(final LottoDto lottoDto) {
        return String.join(", ", String.valueOf(lottoDto.numbers()));
    }
}
