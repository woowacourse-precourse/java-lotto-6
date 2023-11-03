package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.manager.LottoManager;
import lotto.dto.LottoDto;
import lotto.view.LottoGuideMessage;
import lotto.view.LottoReader;
import lotto.view.LottoViewResolver;
import lotto.view.LottoWriter;

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
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다. 다시 입력해 주세요.");
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
                throw new IllegalArgumentException("[ERROR] 로또 숫자는 6개만 입력이 가능합니다. 다시 입력해 주세요.");
            }
            return Arrays.stream(split).map(Integer::parseInt).toList();
        });
    }

    private Money getMoney() {
        writer.write(LottoGuideMessage.INPUT_MONEY.getMessage());
        return reader.input(() -> new Money(Integer.parseInt(Console.readLine())));
    }
}
