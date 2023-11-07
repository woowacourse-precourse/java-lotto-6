package lotto.view;

import java.util.List;
import lotto.dto.LottoDto;

public class OutputView {

    private static final String PRINT_PURCHASED_LOTTO_COUNT = "\n%d개를 구매했습니다.\n";

    public void printLottoCount(final List<LottoDto> lottoStatus) {
        System.out.printf(PRINT_PURCHASED_LOTTO_COUNT, lottoStatus.size());
    }
}
