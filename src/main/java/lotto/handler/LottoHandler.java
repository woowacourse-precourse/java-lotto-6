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
        Payment payment = getPayment();
        Lottos lottos = generateLottos(payment);

        WinningLotto winningLotto = generateWinningLotto();
        LottoResult lottoResult = lottoManager.calculateResult(lottos, winningLotto);

        showResult(lottoResult);
        showProfit(payment, lottoResult);
    }

    private void showProfit(Payment payment, LottoResult lottoResult) {
        double profit = lottoResult.calculateProfit(payment.getPayment());
        writer.write(lottoViewResolver.parseProfit(profit));
    }

    private void showResult(LottoResult lottoResult) {
        LottoDto.Result result = LottoDto.Result.from(lottoResult);
        writer.write(lottoViewResolver.parseLottoResult(result));
    }

    private WinningLotto generateWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        WinningLotto winningLotto = lottoManager.createWinningLotto(winningNumbers, bonusNumber);
        return winningLotto;
    }

    private Lottos generateLottos(Payment payment) {
        Lottos lottos = lottoManager.createLottos(payment.getPayment());

        LottoDto.Information lottoInformation = LottoDto.Information.from(lottos);

        writer.write(lottos.size() + LottoGuideMessage.BOUGHT_LOG.getMessage());
        writer.write(lottoViewResolver.parseLottosDetail(lottoInformation));
        return lottos;
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        writer.write(LottoGuideMessage.INPUT_BONUS_NUMBER.getMessage());
        return reader.read(() -> {
            String inputBonusNumber = Console.readLine();
            LottoReaderValidator.validateBonusNumber(inputBonusNumber);
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            LottoReaderValidator.validateDuplicationWithWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

            return bonusNumber;
        });
    }

    private List<Integer> getWinningNumbers() {
        writer.write(LottoGuideMessage.INPUT_WINNING_NUMBERS.getMessage());
        return reader.read(() -> {
            String inputWinningNumbers = Console.readLine();
            LottoReaderValidator.validateWinningNumbers(inputWinningNumbers);
            return Arrays.stream(inputWinningNumbers.split(",")).map(Integer::parseInt).toList();
        });
    }

    private Payment getPayment() {
        writer.write(LottoGuideMessage.INPUT_MONEY.getMessage());
        return reader.read(() -> {
            String inputMoney = Console.readLine();
            LottoReaderValidator.validateMoney(inputMoney);
            return new Payment(Integer.parseInt(inputMoney));
        });
    }
}
