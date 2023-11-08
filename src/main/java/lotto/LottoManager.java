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
    private static final int BONUS_NUMBER_START_NUMBER = 1;
    private static final int BONUS_NUMBER_END_NUMBER = 45;
    private static final int RESULT_INITIAL_NUMBER = 5;
    private static final String SEPARATOR = ",";
    private static final int FIFTH_PLACE_MATCH_COUNT = 3;
    private static final int FOURTH_PLACE_MATCH_COUNT = 4;
    private static final int THIRD_PLACE_MATCH_COUNT = 5;
    private static final int SECOND_PLACE_MATCH_COUNT = 5;
    private static final int FIRST_PLACE_MATCH_COUNT = 6;
    private static final int FIFTH_PLACE_INDEX = 0;
    private static final int FOURTH_PLACE_INDEX = 1;
    private static final int THIRD_PLACE_INDEX = 2;
    private static final int SECOND_PLACE_INDEX = 3;
    private static final int FIRST_PLACE_INDEX = 4;
    private static final int FIFTH_PLACE_PRICE = 5000;
    private static final int FOURTH_PLACE_PRICE = 50000;
    private static final int THIRD_PLACE_PRICE = 1500000;
    private static final int SECOND_PLACE_PRICE = 30000000;
    private static final int FIRST_PLACE_PRICE = 2000000000;

    private final LottoPrinter lottoPrinter = new ConsoleLottoPrinter();
    private final LottoReceiver lottoReceiver = new ConsoleLottoReceiver();
    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    private int purchasePrice;
    private int lottoCount;
    private Lotto winningNumbers;
    private int bonusNumber;
    private int[] result = new int[RESULT_INITIAL_NUMBER];
    private int returnPrice;
    private double returnRate;

    public void run() {
        receivePurchasePrice();

        List<Lotto> lottos = purchaseLottos();
        // 당첨 번호 입력
        receiveWiningNumber();
        // 보너스 번호 입력
        receiveBonusNumber();
        // 계산
        calculateResult(lottos);
        calculateReturnRate();
        // 출력
        lottoPrinter.noticeResult(result, returnRate);
    }

    private void calculateReturnRate() {
        this.returnRate = Math.round((returnPrice - purchasePrice) * 100.0 / purchasePrice);
    }

    private void calculateResult(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchCount = calculateMatchCount(lotto);
            isFifthPlace(matchCount);
            isFourthPlace(matchCount);
            isThirdPlaceOrSecondPlace(matchCount, lotto);
            isFirstPlace(matchCount);
        }
    }

    private void isFifthPlace(int matchCount) {
        if (matchCount == FIFTH_PLACE_MATCH_COUNT) {
            result[FIFTH_PLACE_INDEX]++;
            returnPrice += FIFTH_PLACE_PRICE;
        }
    }

    private void isFourthPlace(int matchCount) {
        if (matchCount == FOURTH_PLACE_MATCH_COUNT) {
            result[FOURTH_PLACE_INDEX]++;
            returnPrice += FOURTH_PLACE_PRICE;
        }
    }

    private void isThirdPlaceOrSecondPlace(int matchCount, Lotto lotto) {
        if (lotto.getNumbers().contains(bonusNumber) && matchCount == SECOND_PLACE_MATCH_COUNT) {
            result[SECOND_PLACE_INDEX]++;
            returnPrice += SECOND_PLACE_PRICE;
            return;
        }
        if (matchCount == THIRD_PLACE_MATCH_COUNT) {
            result[THIRD_PLACE_INDEX]++;
            returnPrice += THIRD_PLACE_PRICE;
        }
    }

    private void isFirstPlace(int matchCount) {
        if (matchCount == FIRST_PLACE_MATCH_COUNT) {
            result[FIRST_PLACE_INDEX]++;
            returnPrice += FIRST_PLACE_PRICE;
        }
    }

    private int calculateMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private void receivePurchasePrice() {
        boolean isReceived = Boolean.FALSE;

        lottoPrinter.askInputPurchasePrice();

        while (!isReceived) {
            try {
                isReceived = validatePurchasePrice(lottoReceiver.receive());
            } catch (IllegalArgumentException e) {
                lottoPrinter.printException(e.getMessage());
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
                lottoPrinter.printException(e.getMessage());
            }
        }
    }

    private boolean validateWinningNumber(String winningNumbers) {
        ArrayList<Integer> validWinningNumber = new ArrayList<>();
        try {
            int[] separatedWinningNumber = Arrays.stream(winningNumbers.split(SEPARATOR)).mapToInt(Integer::parseInt)
                    .toArray();
            for (int i : separatedWinningNumber) {
                validWinningNumber.add(i);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionInfo.WINNING_NUMBERS_ARE_NOT_INTEGER.getMessage());
        }

        this.winningNumbers = new Lotto(validWinningNumber);

        return true;
    }

    private void receiveBonusNumber() {
        boolean isReceived = Boolean.FALSE;

        lottoPrinter.askBonusNumber();

        while(!isReceived) {
            try {
                isReceived = validateBonusNumber(lottoReceiver.receive());
            } catch (IllegalArgumentException e) {
                lottoPrinter.printException(e.getMessage());
            }
        }
    }

    private boolean validateBonusNumber(String bonusNumber) {
        int validBonusNumber = validateBonusIsIntegerType(bonusNumber);
        validateBonusNumberIsInRange(validBonusNumber);
        validateDuplicatedBonusNumber(validBonusNumber);

        this.bonusNumber = validBonusNumber;

        return true;
    }

    private int validateBonusIsIntegerType(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionInfo.BONUS_NUMBER_IS_NOT_INTEGER.getMessage());
        }
    }

    private void validateBonusNumberIsInRange(int bonusNumber) {
        if (bonusNumber < BONUS_NUMBER_START_NUMBER || BONUS_NUMBER_END_NUMBER < bonusNumber) {
            throw new IllegalArgumentException(ExceptionInfo.OUT_OF_RANGE_BONUS_NUMBER.getMessage());
        }
    }

    private void validateDuplicatedBonusNumber(int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionInfo.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

}
