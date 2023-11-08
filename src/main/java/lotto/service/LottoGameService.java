package lotto.service;

import static lotto.enums.Constants.INITIAL_COUNT;
import static lotto.enums.Constants.LOTTO_NUMBER_COUNT;
import static lotto.enums.Constants.LOTTO_PRICE;
import static lotto.enums.Constants.PERCENTAGE_FACTOR;
import static lotto.enums.Constants.ZERO_VALUE;
import static lotto.enums.ExceptionMessage.CONTAIN_NON_DIGIT_EXCEPTION;
import static lotto.enums.ExceptionMessage.INPUT_DUPLICATE_DIGIT_EXCEPTION;
import static lotto.enums.ExceptionMessage.INPUT_WRONG_RANGE_EXCEPTION;
import static lotto.enums.ExceptionMessage.NOT_DIVIDING_BY_LOTTO_PRICE_EXCEPTION;
import static lotto.enums.ExceptionMessage.NOT_SIX_DIGITS_SEPARATED_BY_COMMAS_EXCEPTION;
import static lotto.enums.ExceptionMessage.PURCHASE_AMOUNT_IS_ZERO_EXCEPTION;
import static lotto.enums.ExceptionMessage.WINNING_NUMBERS_CONTAIN_BONUS_NUMBER;
import static lotto.enums.Regex.INPUT_WINNING_NUMBERS_REGEX;
import static lotto.enums.Regex.NON_DIGIT_REGEX;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.enums.LottoRank;
import lotto.util.LottoNumbersGenerator;

public class LottoGameService {
    private final List<List<Integer>> purchasedLottoNumbers = new ArrayList<>();
    private final EnumMap<LottoRank, Integer> lottoRakingMap = new EnumMap<>(LottoRank.class);

    public LottoGameService() {
        initLottoRakingMap();
    }

    private void initLottoRakingMap() {
        for (LottoRank rank : LottoRank.values()) {
            lottoRakingMap.put(rank, INITIAL_COUNT.getNumber());
        }
    }

    public void generateLottoNumbers() {
        Lotto lotto = new Lotto(LottoNumbersGenerator.generateLottoNumbers());
        purchasedLottoNumbers.add(lotto.getNumbers());
    }

    public void validatePurchaseAmount(String lottoPurchaseAmount) {
        if (isStringContainNonDigit(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(CONTAIN_NON_DIGIT_EXCEPTION.getMessage());
        }
        if (isInputZero(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_IS_ZERO_EXCEPTION.getMessage());
        }
        if (isMultipleOfLottoPrice(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(NOT_DIVIDING_BY_LOTTO_PRICE_EXCEPTION.getMessage());
        }
    }

    public boolean isStringContainNonDigit(String lottoPurchaseAmount) {
        return Pattern.compile(NON_DIGIT_REGEX.getRegex()).matcher(lottoPurchaseAmount).find();
    }

    public boolean isInputZero(String lottoPurchaseAmount) {
        return Integer.parseInt(lottoPurchaseAmount) == ZERO_VALUE.getNumber();
    }

    public boolean isMultipleOfLottoPrice(String lottoPurchaseAmount) {
        return Integer.parseInt(lottoPurchaseAmount) % LOTTO_PRICE.getNumber()
                != ZERO_VALUE.getNumber();
    }

    public int getLottoTicketCount(String lottoPurchaseAmount) {
        return Integer.parseInt(lottoPurchaseAmount) / LOTTO_PRICE.getNumber();
    }

    public List<List<Integer>> getPurchasedLottoNumbers() {
        return purchasedLottoNumbers;
    }

    public List<Integer> convertStringToCollection(String inputNumbers) {
        return Stream.of(inputNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void validateInputNumbers(String inputNumbers) {
        if (isLottoNumbersFormat(inputNumbers)) {
            throw new IllegalArgumentException(NOT_SIX_DIGITS_SEPARATED_BY_COMMAS_EXCEPTION.getMessage());
        }
    }

    public boolean isLottoNumbersFormat(String lottoNumbers) {
        return !Pattern.compile(INPUT_WINNING_NUMBERS_REGEX.getRegex()).matcher(lottoNumbers).matches();
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        if (isLottoNumbersWrongRange(winningNumbers)) {
            throw new IllegalArgumentException(INPUT_WRONG_RANGE_EXCEPTION.getMessage());
        }
        if (isContainDuplicateDigits(winningNumbers)) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_DIGIT_EXCEPTION.getMessage());
        }
    }

    public boolean isLottoNumbersWrongRange(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .anyMatch(number -> number < 1 || number > 45);
    }

    public boolean isContainDuplicateDigits(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .distinct()
                .count() != LOTTO_NUMBER_COUNT.getNumber();
    }

    public void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        if (isBonusNumberNonDigit(bonusNumber)) {
            throw new IllegalArgumentException(CONTAIN_NON_DIGIT_EXCEPTION.getMessage());
        }
        if (isBonusNumberWrongRange(bonusNumber)) {
            throw new IllegalArgumentException(INPUT_WRONG_RANGE_EXCEPTION.getMessage());
        }
        if (isWinningNumbersContainBonusNumber(bonusNumber, winningNumbers)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_CONTAIN_BONUS_NUMBER.getMessage());
        }
    }

    public boolean isBonusNumberNonDigit(String bonusNumber) {
        return Pattern.compile(NON_DIGIT_REGEX.getRegex()).matcher(bonusNumber).matches();
    }

    public boolean isBonusNumberWrongRange(String bonusNumber) {
        return Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45;
    }

    public boolean isWinningNumbersContainBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        return winningNumbers.contains(Integer.parseInt(bonusNumber));
    }

    public long getCollectNumberCount(List<Integer> purchasedLotto, List<Integer> winningLotto) {
        return winningLotto.stream()
                .filter(purchasedLotto::contains)
                .count();
    }

    public boolean isContainBonusNumber(List<Integer> purchasedLotto, int bonusNumber) {
        return purchasedLotto.contains(bonusNumber);
    }

    public LottoRank determineWinningRank(List<Integer> purchasedLotto,
                                          List<Integer> winningLotto,
                                          int bonusNumber) {
        return LottoRank.determineRank(getCollectNumberCount(purchasedLotto, winningLotto),
                isContainBonusNumber(purchasedLotto, bonusNumber));
    }

    public void updateWinningCount(LottoRank lottoRank) {
        int currentCount = lottoRakingMap.getOrDefault(lottoRank, 0);
        lottoRakingMap.put(lottoRank, currentCount + 1);
    }

    public double calculateProfitRate(String purchaseAmount, EnumMap<LottoRank, Integer> lottoRakingMap) {
        return (double) lottoRakingMap.keySet().stream()
                .filter(rank -> rank != LottoRank.LAST_PLACE)
                .mapToInt(rank ->
                        rank.getPrizeMoney() * lottoRakingMap.get(rank))
                .sum() / Integer.parseInt(purchaseAmount) * PERCENTAGE_FACTOR.getNumber();
    }

    public EnumMap<LottoRank, Integer> getLottoRakingMap() {
        return lottoRakingMap;
    }
}
