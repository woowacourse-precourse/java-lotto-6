package lotto.view;

import java.util.List;
import lotto.util.converter.ListConverter;
import lotto.view.dto.LottosResponseDto;

public class OutputView {
    private static final String OUTPUT_LOTTO_COUNT_FORMAT_MESSAGE = "%d개를 구매했습니다.";

    public void printLottosIssued(LottosResponseDto lottosResponseDto) {
        showLottoCount(lottosResponseDto.lottoCount());
        for (List<Integer> numbers : lottosResponseDto.lottos()) {
            System.out.println(makeLottoNumberFormat(ListConverter.convertToStringList(numbers)));
        }
    }

    private void showLottoCount(int lottoCount) {
        System.out.println();
        System.out.printf(OUTPUT_LOTTO_COUNT_FORMAT_MESSAGE, lottoCount);
        System.out.println();
    }

    private String makeLottoNumberFormat(List<String> numbers) {
        return "[" + String.join(", ", numbers) + "]";
    }
}