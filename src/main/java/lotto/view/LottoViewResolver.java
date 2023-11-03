package lotto.view;

import lotto.Lotto;
import lotto.dto.LottoDto;

public class LottoViewResolver {

    public String parseLottosDetail(LottoDto.Information lottos) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lottos.getLottos()) {
            stringBuilder.append(lotto.getInformation());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
