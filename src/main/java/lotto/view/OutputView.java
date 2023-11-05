package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String NEWLINE = System.lineSeparator();

    private static final String NUMBER_OF_LOTTOS_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    public void printLottos(List<LottoDto> lottos) {
        newLine();
        printLottoCount(lottos.size());
        printLottoNumbers(lottos);
    }

    private void newLine() {
        System.out.println();
    }

    private void printLottoCount(int size) {
        System.out.println(String.format(NUMBER_OF_LOTTOS_MESSAGE_FORMAT, size));
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
        newLine();
        System.out.println("당첨 통계" + NEWLINE + "---");

        Map<String, Integer> result = lottoResultDto.getResult();
        System.out.println("3개 일치 (5,000원) - " + result.getOrDefault("FIFTH", 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getOrDefault("FOURTH", 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getOrDefault("THIRD", 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getOrDefault("SECOND", 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getOrDefault("FIRST", 0) + "개");
    }

    public void printRateOfResult(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, errorMessage));
    }
}
