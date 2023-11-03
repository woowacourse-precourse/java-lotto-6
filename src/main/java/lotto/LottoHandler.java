package lotto;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
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
        Money money = getMoney();
        Lottos lottos = lottoManager.createLottos(money.getMoney());

        LottoDto.Information lottoInformation = LottoDto.Information.from(lottos);

        writer.write(lottos.size() + LottoGuideMessage.BOUGHT_LOG.getMessage());
        writer.write(lottoViewResolver.parseLottosDetail(lottoInformation));


        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        WinningLotto winningLotto = lottoManager.createWinningLotto(winningNumbers, bonusNumber);


        LottoResult lottoResult = lottoManager.calculateResult(lottos, winningLotto);

        LottoDto.Result result = LottoDto.Result.from(lottoResult);
        writer.write(lottoViewResolver.parseLottoResult(result));

        writer.write(lottoViewResolver.parseProfit(lottoResult.calculateProfit(money.getMoney())));
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        writer.write(LottoGuideMessage.INPUT_BONUS_NUMBER.getMessage());
        return reader.inputBonusNumbers(winningNumbers);
    }

    private List<Integer> getWinningNumbers() {
        writer.write(LottoGuideMessage.INPUT_WINNING_NUMBERS.getMessage());
        return reader.inputWinningNumbers();
    }

    private Money getMoney() {
        writer.write(LottoGuideMessage.INPUT_MONEY.getMessage());
        return reader.inputMoney();
    }
}
