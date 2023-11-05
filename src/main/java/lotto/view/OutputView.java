package lotto.view;

import lotto.dto.LottoDto;

import java.util.List;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String NEWLINE = System.lineSeparator();

    public void printLottos(List<LottoDto> lottos) {
        printNumberOfLottos(lottos.size());
        printLottoNumbers(lottos);
    }

    private void printNumberOfLottos(int size) {
        System.out.printf(NUMBER_OF_LOTTOS_MESSAGE_FORMAT, size);
    }

    private void printLottoNumbers(List<LottoDto> lottos) {
        StringBuilder numbersMessageBuilder = new StringBuilder();

        for (LottoDto lotto : lottos) {
            numbersMessageBuilder.append(lotto.getNumbers())
                    .append(NEWLINE);
        }

        System.out.println(numbersMessageBuilder);
    }
}
