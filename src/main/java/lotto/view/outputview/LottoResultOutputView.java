package lotto.view.outputview;

import lotto.domain.LottoRankInfo;
import lotto.dto.DTO;
import lotto.dto.LottoResultDTO;
import lotto.view.OutputView;

import java.util.Map;

import static lotto.view.ParameterConfig.LOTTO_RESULT;

public final class LottoResultOutputView implements OutputView {
    @Override
    public void view(Map<String, ? super DTO.Output> model) {
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
        ranks.forEach((key, value) -> System.out.println(getEachRank(key, value)));
    }

    private String getEachRank(LottoRankInfo rank, Integer count) {
        return String.format("%s (%s원) - %d개",
                rank.getDescription(), convertToMoneyUnit(rank.getRewardPrice()), count);
    }

    private String convertToMoneyUnit(Long price) {
        return String.format("%,d", price);
    }

    private void viewReturnRatio(LottoResultDTO dto) {
        String text = String.format("총 수익률은 %s입니다.", dto.getReturnRatio());
        System.out.println(text);
    }
}
