package lotto.view;

import lotto.dto.LottoDto;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printPurchaseLotto(List<LottoDto> lottoDto) {
        System.out.println(lottoDto.size() + "개를 구매했습니다.");
        lottoDto.stream()
                .forEach(OutputView::printLottoDto);
    }

    private static void printLottoDto(LottoDto lottoDto) {
        String result = lottoDto.getNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
    }
}
