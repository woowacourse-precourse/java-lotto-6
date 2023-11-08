package lotto.component;

import static lotto.utils.LottoConstant.PURCHASE_AMOUNT_UNIT;

import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.Winning;
import lotto.dto.LottoArgumentDTO;
import lotto.service.LottoGenerator;
import lotto.service.LottoMessagePrinter;
import lotto.validation.LottoValidator;
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

    public LottoArgumentDTO resolve() {
        int lottoSize = readLottoSize();

        List<Lotto> lottos = generateLottos(lottoSize);

        List<Integer> winNumbers = readWinNumbers();

        int bonusNumber = readBonusNumber(winNumbers);

        Winning winning = Winning.of(winNumbers, bonusNumber);

        return LottoArgumentDTO.of(lottoSize, lottos, winning);
    }

    private int readLottoSize() {
        printer.printPurchaseAmountInputMessage();

        int purchaseAmount;

        while (true) {
            try {
                String purchaseAmountInput = reader.readLine();
                ensurePurchaseAmountIsValid(purchaseAmountInput);
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

    private List<Integer> readWinNumbers() {
        printer.printLottoWinNumbersInputMessage();

        while (true) {
            try {
                String winNumbersInput = reader.readLine();
                ensureWinNumbersIsValid(winNumbersInput);

                return Arrays.stream(winNumbersInput.split(","))
                        .map(it -> Integer.parseInt(it.trim()))
                        .sorted()
                        .toList();

            } catch (IllegalArgumentException ex) {
                printer.printExceptionMessage(ex.getMessage());
            }
        }
    }

    private int readBonusNumber(List<Integer> winNumbers) {
        printer.printLottoBonusNumberInputMessage();

        while (true) {
            try {
                String bonusNumberInput = reader.readLine();
                ensureBonusNumberIsValid(winNumbers, bonusNumberInput);

                return Integer.parseInt(bonusNumberInput);

            } catch (IllegalArgumentException ex) {
                printer.printExceptionMessage(ex.getMessage());
            }
        }
    }

    private List<Lotto> generateLottos(int lottoSize) {
        LottoGenerator generator = LottoGenerator.of(lottoSize);
        List<Lotto> lottos = generator.generate();

        printer.printAllLotto(lottos);

        return lottos;
    }

    private void ensureBonusNumberIsValid(List<Integer> winNumbers, String bonusNumberInput) {
        validator.verifyBonusNumber(winNumbers, bonusNumberInput);
    }

    private void ensureWinNumbersIsValid(String winNumbersInput) {
        validator.verifyWinNumbers(winNumbersInput);
    }

    private void ensurePurchaseAmountIsValid(String purchaseAmountInput) {
        validator.verifyPurchaseAmount(purchaseAmountInput);
    }
}
