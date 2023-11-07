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
        Lottos lottos = lottoManager.createLottos(payment);
        showPaidLottos(lottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        WinningLotto winningLotto = lottoManager.createWinningLotto(winningNumbers, bonusNumber);
        LottoRankings winningRankings = lottoManager.createWinningRankings(lottos, winningLotto);

        showResult(winningRankings);
        showProfit(payment, winningRankings);
    }

    private void showPaidLottos(Lottos lottos) {
        writer.write(lottoViewResolver.parsePaidLottoLog(lottos.size()));
        writer.write(lottoViewResolver.parseLottosDetail(LottoDto.Information.from(lottos)));
    }

    private void showProfit(Payment payment, LottoRankings winningRankings) {
        long totalPrize = winningRankings.calculateTotalPrize();
        double profitPercentage = payment.calculateProfitPercentage(totalPrize);
        writer.write(lottoViewResolver.parseProfit(profitPercentage));
    }

    private void showResult(LottoRankings winningRankings) {
        writer.write(lottoViewResolver.parseLottoResult(LottoDto.Result.from(winningRankings)));
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
