package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.Message;
import lotto.exception.InvalidBonusNumberFormatException;
import lotto.exception.InvalidLottoException;
import lotto.util.PurchasePriceValidator;
import lotto.util.WinningLottoConverter;
import lotto.util.WinningLottoValidator;

public class UserInterfaceImpl implements UserInterface {

    private static final String REQUEST_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_LOTTO = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.\n";
    private static final String LOTTO_WINNING_RESULT_PREFIX = "당첨 통계\n---";
    private static final String WINNING_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    @Override
    public int getValidPurchasePrice() {
        while (true) {
            try {
                System.out.println(REQUEST_PURCHASE_PRICE);
                String purchasePrice = readAndSkipLine();
                PurchasePriceValidator.validate(purchasePrice);
                return Integer.parseInt(purchasePrice);
            } catch (IllegalArgumentException exception) {
                printErrorMessage(exception);
            }
        }
    }

    @Override
    public WinningLotto getWinningLotto() {
        while (true) {
            try {
                System.out.println(REQUEST_WINNING_LOTTO);
                String winningLottoNumbers = readAndSkipLine();
                WinningLottoValidator.validate(winningLottoNumbers);
                return WinningLottoConverter.convertToWinningLotto(winningLottoNumbers);
            } catch (InvalidLottoException invalidLottoException) {
                printErrorMessage(invalidLottoException);
            }
        }
    }

    @Override
    public Integer getBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        String bonusNumberInput = readAndSkipLine();
        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException exception) {
            throw new InvalidBonusNumberFormatException(bonusNumberInput);
        }
    }

    @Override
    public void printWinningResult(LottoWinningResult lottoWinningResult) {
        System.out.println(LOTTO_WINNING_RESULT_PREFIX);
        System.out.print(lottoWinningResult.getLottoRankMessages());
        System.out.printf(WINNING_RATE_FORMAT, lottoWinningResult.calculateWinningRate());
    }

    @Override
    public void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(Message.ERROR_PREFIX + exception.getMessage());
    }

    @Override
    public void printPurchasedResult(long lottoCount, LottoResult lottoResult) {
        System.out.printf(LOTTO_COUNT_FORMAT, lottoCount);
        System.out.println(lottoResult.getLottoResult() + Message.NEW_LINE);
    }

    private String readAndSkipLine() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
