package lotto.ui;


import static lotto.contents.ContentStrings.OUTPUT_PURCHASED_LOTTOS;
import static lotto.contents.ContentStrings.OUTPUT_SPACE;

import java.util.List;
import lotto.dto.LottoDto;

public class OutputView {

    public void printLottos(List<LottoDto> lottos) {
        System.out.println(OUTPUT_SPACE.getValue() + lottos.size() + OUTPUT_PURCHASED_LOTTOS.getValue());
        lottos.stream()
                .forEach(this::printLottoNumbers);
    }

    private void printLottoNumbers(LottoDto lotto) {
        List<Integer> sortedNumbers = lotto.getNumbers().stream()
                .sorted()
                .toList();
        System.out.println(sortedNumbers);
    }
}