package lotto.view;

import lotto.constant.GameMessage;
import lotto.dto.LottoMatchResultDto;
import lotto.dto.LottoNumberDto;
import java.util.List;


public class OutputView {
    public void displayLottos(List<LottoNumberDto> lottoNumberDtos) {
        printBlank();
        System.out.printf("%d개를 구매했습니다.%n", lottoNumberDtos.size());

        lottoNumberDtos.forEach(lottoNumberDto -> {
            System.out.println(lottoNumberDto.getLottoNumbers().stream().sorted().toList());
        });
        printBlank();
    }

    public void displayLottoResult(List<LottoMatchResultDto> matchResultDtos) {
        printBlank();
        System.out.println(GameMessage.GAME_RESULT);

        StringBuilder stringBuilder = new StringBuilder();

        for (LottoMatchResultDto dto : matchResultDtos) {
            String result;

            if (dto.isIsBonusMatch()) {
                result = String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", dto.getMatchCount(), dto.getWinningAmount(), dto.getCount());
                stringBuilder.append(result);
                continue;
            }
            result = String.format("%d개 일치 (%,d원) - %d개%n", dto.getMatchCount(), dto.getWinningAmount(), dto.getCount());
            stringBuilder.append(result);
        }
        System.out.print(stringBuilder);
    }

    public void displayProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    public void printBlank() {
        System.out.println();
    }
}
