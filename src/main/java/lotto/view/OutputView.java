package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;

import java.util.List;
import java.util.Map;

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
            numbersMessageBuilder.append(lotto.numbers())
                    .append(NEWLINE);
        }

        System.out.println(numbersMessageBuilder);
    }

    public void printWinningStatistics(LottoResultDto lottoResultDto) {
        System.out.println("당첨 통계" + NEWLINE + "---");

        Map<String, Integer> result = lottoResultDto.getResult();
        System.out.println("3개 일치 (5,000원) - " + result.getOrDefault("FIFTH", 0));
        System.out.println("4개 일치 (50,000원) - " + result.getOrDefault("FOURTH", 0));
        System.out.println("5개 일치 (1,500,000원) - " + result.getOrDefault("THIRD", 0));
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getOrDefault("SECOND", 0));
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getOrDefault("FIRST", 0));
    }
}
