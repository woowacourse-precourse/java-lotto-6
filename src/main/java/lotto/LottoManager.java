package lotto;

import lotto.exception.ExceptionInfo;
import lotto.generator.LottoNumberGenerator;
import lotto.lotto.Lotto;
import lotto.printer.ConsoleLottoPrinter;
import lotto.printer.LottoPrinter;
import lotto.receiver.ConsoleLottoReceiver;
import lotto.receiver.LottoReceiver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoManager {
    private static final int LOTTO_MINIMUM_PRICE = 1000;
    private static final int ZERO_CHANGE = 0;
    private static final int LOOP_START_NUMBER = 0;
    private static final String SEPARATOR = ",";

    private final LottoPrinter lottoPrinter = new ConsoleLottoPrinter();
    private final LottoReceiver lottoReceiver = new ConsoleLottoReceiver();
    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    private int purchasePrice;
    private int lottoCount;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void run() {
        receivePurchasePrice();

        List<Lotto> lottos = purchaseLottos();
        // 당첨 번호 입력
        receiveWiningNumber();
        // 보너스 번호 입력
        receiveBonusNumber();
        // 계산
        // 출력

    }

    private void receivePurchasePrice() {
        boolean isReceived = Boolean.FALSE;

        lottoPrinter.askInputPurchasePrice();

        while (!isReceived) {
            try {
                isReceived = validatePurchasePrice(lottoReceiver.receive());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        calculateLottoCount();
    }

    private boolean validatePurchasePrice(String purchasePrice) {
        int validatedPurchasePrice = validatePurchasePriceIsIntegerType(purchasePrice);

        this.purchasePrice = validatePurchasePriceIsRightPrice(validatedPurchasePrice);

        return true;
    }

    private int validatePurchasePriceIsIntegerType(String purchasePrice) {
        try {
            return Integer.parseInt(purchasePrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionInfo.PURCHASE_PRICE_IS_NOT_INTEGER.getMessage());
        }
    }

    private int validatePurchasePriceIsRightPrice(int purchasePrice) {
        if (purchasePrice % LOTTO_MINIMUM_PRICE != ZERO_CHANGE) {
            throw new IllegalArgumentException(ExceptionInfo.PURCHASE_PRICE_IS_NOT_RIGHT_PRICE.getMessage());
        }

        return purchasePrice;
    }

    private void calculateLottoCount() {
        this.lottoCount = this.purchasePrice / LOTTO_MINIMUM_PRICE;
    }

    private List<Lotto> purchaseLottos() {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = LOOP_START_NUMBER; i < lottoCount; i++) {
            lottos.add(new Lotto(lottoNumberGenerator.generateLottoNumber()));
        }

        lottoPrinter.noticePurchaseLotto(lottos);

        return lottos;
    }

    private void receiveWiningNumber() {
        boolean isReceived = Boolean.FALSE;

        lottoPrinter.askWinningNumber();

        while(!isReceived) {
            try {
                isReceived = validateWinningNumber(lottoReceiver.receive());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean validateWinningNumber(String winningNumbers) {
        ArrayList<Integer> validWinningNumber = new ArrayList<>();
        try {
            int[] separatedWinningNumber = Arrays.stream(winningNumbers.split(SEPARATOR)).mapToInt(Integer::parseInt)
                    .toArray();
            for (int i = LOOP_START_NUMBER; i < separatedWinningNumber.length; i++) {
                validWinningNumber.add(separatedWinningNumber[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionInfo.WINNING_NUMBERS_ARE_NOT_INTEGER.getMessage());
        }

        this.winningNumbers = validWinningNumber;

        return true;
    }

    private void receiveBonusNumber() {
        boolean isReceived = Boolean.FALSE;

        lottoPrinter.askBonusNumber();

        while(!isReceived) {
            try {
                isReceived = validateBonusNumber(lottoReceiver.receive());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean validateBonusNumber(String bonusNumber) {
        int validBonusNumber;
        try {
            validBonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionInfo.BONUS_NUMBER_IS_NOT_INTEGER.getMessage());
        }

        this.bonusNumber = validBonusNumber;

        return true;
    }

}
