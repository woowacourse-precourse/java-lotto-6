package lotto.view.outputview;

import lotto.domain.LottoRankInfo;
import lotto.dto.DTO;
import lotto.dto.LottoResultDTO;
import lotto.view.OutputView;

import java.util.Map;

import static lotto.view.ParameterConfig.LOTTO_RESULT;

public final class LottoResultOutputView implements OutputView {
    @Override
    public void view(Map<String, ? extends DTO.Output> model) {
        LottoResultDTO dto = (LottoResultDTO) model.get(LOTTO_RESULT);

        viewInitText();
        viewAllLottoRank(dto);
        viewReturnRatio(dto);
    }

    private void viewInitText() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private void viewAllLottoRank(LottoResultDTO dto) {
        Map<LottoRankInfo, Integer> ranks = dto.getRanks();
        ranks.forEach(this::printEachRank);
    }

    private void printEachRank(LottoRankInfo key, int value) {
        System.out.printf("%s (%s원) - %d개\n",
                key.getDescription(), key.getRewardPrice(), value);
    }

    private void viewReturnRatio(LottoResultDTO dto) {
        System.out.printf("총 수익률은 %s 입니다.\n", dto.getReturnRatio());
    }
}
