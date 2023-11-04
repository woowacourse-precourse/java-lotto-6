package lotto.view;

import java.util.List;
import lotto.domain.IssuedLottos;
import lotto.utility.io.Writer;
import lotto.utility.vo.LottoResponse;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS_MESSAGE = "개를 구매했습니다.";
    public void informIssuedLottos(List<LottoResponse> lottos) {
        Writer.print(lottos.size());
        Writer.println(NUMBER_OF_LOTTOS_MESSAGE);
        Writer.println(" ");

        lottos.stream()
            .map(LottoResponse::createMessage)
            .forEach(Writer::println);
    }
}
