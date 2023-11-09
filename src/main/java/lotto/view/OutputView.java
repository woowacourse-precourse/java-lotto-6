package lotto.view;

import java.util.List;
import lotto.controller.dto.ResultDto;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class OutputView {

    public static final String PROFITRATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    public static final String ERROR_MESSAGE = "[ERROR] %s";

    public static void renderingPurchaseHistory(List<Lotto> list) {
        print(String.format("%d개를 구매했습니다.", list.size()));
        for (Lotto lotto : list) {
            List<LottoNumber> lottoNumbers = lotto.toList();
            print(lottoNumbers.stream().map(LottoNumber::getNumber).sorted().toList().toString());
        }
    }

    public static void renderingResult(ResultDto resultDto) {
        print("당첨 통계");
        print("---");
        List<RankOutputTemplate> rankOutputTemplates = RankOutputTemplate.toList();
        for (RankOutputTemplate template : rankOutputTemplates) {
            print(template.format(resultDto.findCount(template)));
        }
        print(String.format(PROFITRATE_MESSAGE, resultDto.getProfitRate()));
    }

    public static void renderingError(String message) {
        print(String.format(ERROR_MESSAGE,message));
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
