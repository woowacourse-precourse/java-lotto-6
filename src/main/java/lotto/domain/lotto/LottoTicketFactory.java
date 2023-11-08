package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketFactory {

    static RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();

    public static LottoTicket generateTicket(int purchaseCount) {
        validateOverZero(purchaseCount);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(createSingleAutoLotto());
        }
        return LottoTicket.of(lottos);
    }

    private static Lotto createSingleAutoLotto() {
        return new Lotto(randomNumbersGenerator.generate());
    }

    private static void validateOverZero(int purchaseCount){
        if(purchaseCount <= 0){
            throw new IllegalArgumentException("[ERROR] 1개 이상 구입해야 합니다");
        }
    }

}
