package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.manager.LottoManager;
import lotto.dto.LottoDto;
import lotto.view.*;

import java.util.Arrays;
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

    public void run() {
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

        double profit = lottoResult.calculateProfit(money.getMoney());
        writer.write(lottoViewResolver.parseProfit(profit));
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        writer.write(LottoGuideMessage.INPUT_BONUS_NUMBER.getMessage());
        return reader.input(() -> {
            int bonusNumber = Integer.parseInt(Console.readLine());
            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException(LottoErrorMessage.BONUS_NUMBER_NOT_IN_WINNING_NUMBERS.getMessage());
            }
            return bonusNumber;
        });
    }

    private List<Integer> getWinningNumbers() {
        writer.write(LottoGuideMessage.INPUT_WINNING_NUMBERS.getMessage());
        return reader.input(() -> {
            String inputWinningNumbers = Console.readLine();
            String[] split = inputWinningNumbers.split(",");
            if (split.length != Lotto.LOTTO_NUMBER_SIZE) {
                throw new IllegalArgumentException(LottoErrorMessage.INVALID_LOTTO_NUMBER_SIZE.getMessage());
            }
            return Arrays.stream(split).map(Integer::parseInt).toList();
        });
    }

    private Money getMoney() {
        writer.write(LottoGuideMessage.INPUT_MONEY.getMessage());
        return reader.input(() -> new Money(Integer.parseInt(Console.readLine())));
    }
}
