package lotto.component;

import static lotto.utils.LottoConstant.PURCHASE_AMOUNT_UNIT;

import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.Winning;
import lotto.dto.LottoArgument;
import lotto.service.LottoGenerator;
import lotto.service.LottoMessagePrinter;
import lotto.view.read.InputView;

public class LottoArgumentResolver {

    private final InputView reader;
    private final LottoMessagePrinter printer;
    private final LottoValidator validator;

    public static LottoArgumentResolver of(InputView reader, LottoMessagePrinter printer, LottoValidator validator) {
        return new LottoArgumentResolver(reader, printer, validator);
    }

    private LottoArgumentResolver(InputView reader, LottoMessagePrinter printer, LottoValidator validator) {
        this.reader = reader;
        this.printer = printer;
        this.validator = validator;
    }

    public LottoArgument resolve() {
        int lottoSize = readLottoSize();

        List<Lotto> lottos = generateLottos(lottoSize);

        List<Integer> winNumbers = readWinNumbers();

        int bonusNumber = readBonusNumber(winNumbers);

        Winning winning = Winning.of(winNumbers, bonusNumber);

        return LottoArgument.of(lottos, winning);
    }

    protected int readLottoSize() {
        printer.printPurchaseAmountInputMessage();

        int purchaseAmount;

        while (true) {
            try {
                String purchaseAmountInput = reader.readLine();
                validator.verifyPurchaseAmount(purchaseAmountInput);
                purchaseAmount = Integer.parseInt(purchaseAmountInput);
                break;

            } catch (IllegalArgumentException ex) {
                printer.printExceptionMessage(ex.getMessage());
            }
        }

        int lottoSize = purchaseAmount / PURCHASE_AMOUNT_UNIT;
        printer.printPurchaseLottoSize(lottoSize);

        return lottoSize;
    }

    protected List<Integer> readWinNumbers() {
        printer.printLottoWinNumbersInputMessage();

        while (true) {
            try {
                String winNumbersInput = reader.readLine();
                validator.verifyWinNumbers(winNumbersInput);

                return Arrays.stream(winNumbersInput.split(","))
                        .map(it -> Integer.parseInt(it.trim()))
                        .sorted()
                        .toList();

            } catch (IllegalArgumentException ex) {
                printer.printExceptionMessage(ex.getMessage());
            }
        }
    }

    protected int readBonusNumber(List<Integer> winNumbers) {
        printer.printLottoBonusNumberInputMessage();

        while (true) {
            try {
                String bonusNumberInput = reader.readLine();
                validator.verifyBonusNumber(winNumbers, bonusNumberInput);

                return Integer.parseInt(bonusNumberInput);

            } catch (IllegalArgumentException ex) {
                printer.printExceptionMessage(ex.getMessage());
            }
        }
    }

    protected List<Lotto> generateLottos(int lottoSize) {
        LottoGenerator generator = LottoGenerator.of(lottoSize);
        List<Lotto> lottos = generator.generate();

        printer.printAllLotto(lottos);

        return lottos;
    }
}
