package lotto;

import lotto.dto.LottoDto;
import lotto.view.LottoGuideMessage;
import lotto.view.LottoReader;
import lotto.view.LottoViewResolver;
import lotto.view.LottoWriter;

import java.util.List;


public class LottoHandler {

    private final LottoManager lottoManager;
    private final LottoReader reader;
    private final LottoWriter writer;
    private final LottoViewResolver lottoViewResolver;

    public LottoHandler(LottoManager lottoManager, LottoReader reader, LottoWriter writer, LottoViewResolver lottoViewResolver) {
        this.lottoManager = lottoManager;
        this.reader = reader;
        this.writer = writer;
        this.lottoViewResolver = lottoViewResolver;
    }

    void run() {
        Lottos lottos = getLottos();
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        LottoDto.Information lottoInformation = LottoDto.Information.from(lottos);

        WinningLotto winningLotto = lottoManager.createWinningLotto(winningNumbers, bonusNumber);

        writer.write(lottos.size() + LottoGuideMessage.BOUGHT_LOG.getMessage());
        writer.write(lottoViewResolver.parseLottosDetail(lottoInformation));

        lottoManager.calculateLottos(lottos, winningLotto);
    }

    private int getBonusNumber() {
        writer.write(LottoGuideMessage.INPUT_BONUS_NUMBER.getMessage());
        return reader.inputBonusNumbers();
    }

    private List<Integer> getWinningNumbers() {
        writer.write(LottoGuideMessage.INPUT_WINNING_NUMBERS.getMessage());
        return reader.inputWinningNumbers();
    }

    private Lottos getLottos() {
        writer.write(LottoGuideMessage.INPUT_MONEY.getMessage());
        return lottoManager.createLottos(reader.inputMoney());
    }
}
