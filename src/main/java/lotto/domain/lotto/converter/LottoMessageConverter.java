package lotto.domain.lotto.converter;

import java.util.List;
import java.util.StringJoiner;
import lotto.domain.lotto.Lotto;

public class LottoMessageConverter {
    private StringJoiner joiner;

    public String convertLottoNumberMessage(List<Lotto> lottos) {
        StringBuilder lottoNumberMessage = new StringBuilder();
        String lottoAmountCheckMessage = String.format("\n%d개를 구매했습니다.\n", lottos.size());
        lottoNumberMessage.append(lottoAmountCheckMessage);

        for (Lotto lotto : lottos) {
            joiner = new StringJoiner(", ", "[", "]\n");
            for (Integer number : lotto.getNumbers()) {
                joiner.add(number.toString());
            }
            lottoNumberMessage.append(joiner);
        }

        return lottoNumberMessage.toString();
    }
}
