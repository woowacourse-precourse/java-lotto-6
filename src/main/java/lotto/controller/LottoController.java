package lotto.controller;

import static lotto.utils.LottoConstant.PURCHASE_AMOUNT_UNIT;

import java.util.List;
import lotto.domain.number.Lotto;
import lotto.domain.number.Winning;
import lotto.domain.result.Result;
import lotto.service.LottoInputReader;
import lotto.service.LottoOutputWriter;
import lotto.service.MultiLottoGenerator;

public class LottoController {

    private final LottoInputReader reader;
    private final LottoOutputWriter writer;

    public static LottoController of(LottoInputReader reader, LottoOutputWriter writer) {
        return new LottoController(reader, writer);
    }

    private LottoController(LottoInputReader reader, LottoOutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void handle() {
        int lottoSize = createLottoSize();

        List<Lotto> lottos = createLottos(lottoSize);

        Winning winning = createWinning();

        Result result = Result.of(winning, lottos);

        result.print(writer);
    }

    private int createLottoSize() {
        int purchaseAmount = reader.readPurchaseAmount();
        return purchaseAmount / PURCHASE_AMOUNT_UNIT;
    }

    private List<Lotto> createLottos(int lottoSize) {
        writer.showPurchaseLottoSize(lottoSize);

        MultiLottoGenerator generator = MultiLottoGenerator.of(lottoSize);

        List<Lotto> lottos = generator.generate();

        writer.showLottos(lottos);

        return lottos;
    }

    private Winning createWinning() {
        List<Integer> winNumbers = reader.readWinNumbers();
        int bonusNumber = reader.readBonusNumber(winNumbers);

        return Winning.of(winNumbers, bonusNumber);
    }
}
