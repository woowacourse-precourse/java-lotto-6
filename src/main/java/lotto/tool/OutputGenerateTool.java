package lotto.tool;

import lotto.entity.Lotto;
import lotto.entity.mapper.FiledMapper;

import static lotto.property.MethodProperty.LOTTOS_FORMAT;

public class OutputGenerateTool {
    private static final StringBuilder lottosFormat = new StringBuilder();

    public void generateLottoList(Lotto lotto) {
        lottosFormat.append(lotto.getNumbers()).append("\n");
    }

    public String getLottosFormat() {
        return FiledMapper.getFieldValue(this, LOTTOS_FORMAT).toString();
    }
}
