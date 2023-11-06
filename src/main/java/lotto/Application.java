package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.config.Message;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.RandomLottoMachine;
import lotto.domain.WinningLotto;
import lotto.exception.BelowMinimumPurchasePriceException;
import lotto.exception.InvalidLottoException;
import lotto.exception.InvalidPurchasePriceFormatException;
import lotto.exception.NonMultipleOfPriceUnitException;
import lotto.util.WinningLottoConverter;
import lotto.util.WinningLottoValidator;

public class Application {

    private static final int PURCHASE_PRICE_UNIT = 1000;
    private static final int EMPTY = 0;


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        int lottoCount = application.calculateLottoPurchaseCount();
        List<Lotto> lottos = application.generateLottos(lottoCount);
        application.printPurchasedLottos(lottos);
        WinningLotto winningLotto = application.getWinningLottoWithBonusNumber();
    }

    private WinningLotto getWinningLottoWithBonusNumber() {
        WinningLotto winningLotto = getWinningLotto();
        return null;
    }

    private WinningLotto getWinningLotto() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningLottoNumbers = Console.readLine();
                System.out.println();
                WinningLottoValidator.validate(winningLottoNumbers);
                return WinningLottoConverter.convertToWinningLotto(winningLottoNumbers);
            } catch (InvalidLottoException invalidLottoException) {
                printErrorMessage(invalidLottoException);
            }
        }
    }

    private void printPurchasedLottos(List<Lotto> lottos) {
        LottoResult lottoResult = LottoResult.from(lottos);
        printLottoPurchaseCount(lottos.size());
        printLottoResult(lottoResult);
    }

    private List<Lotto> generateLottos(int lottoCount) {
        LottoMachine lottoMachine = new RandomLottoMachine();
        return lottoMachine.generateLottos(lottoCount);
    }

    private int calculateLottoPurchaseCount() {
        int purchasePrice = getValidPurchasePrice();
        return purchasePrice / PURCHASE_PRICE_UNIT;
    }

    private int getValidPurchasePrice() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String purchasePrice = Console.readLine();
                System.out.println();
                checkValidPurchasePrice(purchasePrice);

                return Integer.parseInt(purchasePrice);
            } catch (IllegalArgumentException exception) {
                printErrorMessage(exception);
            }
        }
    }

    private void checkValidPurchasePrice(String input) {
        long purchasePrice;
        try {
            purchasePrice = Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidPurchasePriceFormatException(input);
        }
        if (purchasePrice < PURCHASE_PRICE_UNIT) {
            throw new BelowMinimumPurchasePriceException(purchasePrice);
        }
        if (purchasePrice % PURCHASE_PRICE_UNIT != EMPTY) {
            throw new NonMultipleOfPriceUnitException(purchasePrice);
        }
    }

    private void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(Message.ERROR_PREFIX + exception.getMessage());
    }

    private void printLottoPurchaseCount(long lottoCount) {
        System.out.printf("%d개를 구매했습니다." + Message.NEW_LINE, lottoCount);
    }

    private void printLottoResult(LottoResult lottoResult) {
        System.out.println(lottoResult.getLottoResult() + Message.NEW_LINE);
    }
}
