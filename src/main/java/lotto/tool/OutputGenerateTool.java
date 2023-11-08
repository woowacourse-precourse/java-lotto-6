package lotto.tool;

import lotto.entity.Lotto;
import lotto.entity.LottoResult;
import lotto.entity.mapper.FiledMapper;
import lotto.property.OutputProperty;

public class OutputGenerateTool {
    private static final StringBuilder lottosFormat = new StringBuilder();
    private static final StringBuilder lottoResultFormat = new StringBuilder();

    public void generateLottoList(Lotto lotto) {
        lottosFormat.append(lotto.getNumbers()).append("\n");
    }

    public void generateLottoResult(LottoResult lottoResult, Integer resultScore) {
        lottoResultFormat.append(lottoResult.hitCount)
                .append(" ")
                .append(lottoResult.prize)
                .append(OutputProperty.LOTTO_RESULT_SCORE)
                .append(resultScore + "개\n");
    }

    public String getLottosFormat(String methodProperty) {
        return FiledMapper.getFieldValue(this, methodProperty).toString();
    }
}
