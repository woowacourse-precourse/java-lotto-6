package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.LottoWinningRank;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbersGenerator;

public class LottoGameService {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final Map<LottoWinningRank, Integer> lottoWinningRankMap = new HashMap<>();
    private final List<List<Integer>> purchaseLottoNumbers = new ArrayList<>();

    public LottoGameService() {
        initLottoWinningRankMap();
    }

    private void initLottoWinningRankMap() {
        lottoWinningRankMap.put(LottoWinningRank.FIRST, LottoConstants.LOTTO_WINNING_RANK_MAP_INIT_VALUE.getValue());
        lottoWinningRankMap.put(LottoWinningRank.SECOND, LottoConstants.LOTTO_WINNING_RANK_MAP_INIT_VALUE.getValue());
        lottoWinningRankMap.put(LottoWinningRank.THIRD, LottoConstants.LOTTO_WINNING_RANK_MAP_INIT_VALUE.getValue());
        lottoWinningRankMap.put(LottoWinningRank.FOURTH, LottoConstants.LOTTO_WINNING_RANK_MAP_INIT_VALUE.getValue());
        lottoWinningRankMap.put(LottoWinningRank.FIFTH, LottoConstants.LOTTO_WINNING_RANK_MAP_INIT_VALUE.getValue());
    }

    public void addLottoNumberToLottoNumbers() {
        Lotto lotto = new Lotto(LottoNumbersGenerator.generateLottoNumbers());
        purchaseLottoNumbers.add(lotto.getNumbers());
    }

    public int getLottoIssueCount(String lottoPurchaseAmount) {
        validateLottoIssueCount(lottoPurchaseAmount);
        return Integer.parseInt(lottoPurchaseAmount) / LottoConstants.A_LOTTO_PRICE.getValue();
    }

    public void validateLottoIssueCount(String lottoPurchaseAmount) {
        if (LottoValidator.isLottoPurchaseAmountNotDigit(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE_PREFIX + ErrorMessage.LOTTO_PURCHASE_AMOUNT_NOT_DIGIT_EXCEPTION_MESSAGE.getMessage());
        }
        if (LottoValidator.isRestOfLottoPurchaseAmountDivideBy1000NotZero(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE_PREFIX
                            + ErrorMessage.LOTTO_PURCHASE_AMOUNT_DIVIDE_REST_EXCEPTION_MESSAGE.getMessage());
        }
    }

    public void validateLottoWinningNumbers(String inputLottoWinningNumber) {
        if (LottoValidator.isLottoWinningNumbersWrongType(inputLottoWinningNumber)) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE_PREFIX + ErrorMessage.LOTTO_WINNING_NUMBERS_TYPE_EXCEPTION_MESSAGE.getMessage());
        }

        List<Integer> convertedLottoWinningNumbers = inputWinningNumberConvertToCollection(inputLottoWinningNumber);
        if (LottoValidator.isLottoWinningNumbersSizeNotSix(convertedLottoWinningNumbers)) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE_PREFIX + ErrorMessage.LOTTO_WINNING_NUMBERS_SIZE_EXCEPTION_MESSAGE.getMessage());
        }
        if (LottoValidator.isLottoWinningNumbersDuplicate(convertedLottoWinningNumbers)) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE_PREFIX + ErrorMessage.LOTTO_WINNING_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE.getMessage());
        }
        if (LottoValidator.isLottoWinningNumbersWrongRange(convertedLottoWinningNumbers)) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE_PREFIX + ErrorMessage.LOTTO_WINNING_NUMBERS_RANGE_EXCEPTION_MESSAGE.getMessage());
        }
    }

    public void validateBonusNumber(String lottoWinningNumbers, String bonusNumber) {
        if (LottoValidator.isBonusNumberNotDigit(bonusNumber)) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE_PREFIX + ErrorMessage.BONUS_NUMBER_NOT_DIGIT_EXCEPTION_MESSAGE.getMessage());
        }
        if (LottoValidator.isBonusNumberWrongRange(bonusNumber)) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE_PREFIX + ErrorMessage.BONUS_NUMBER_RANGE_EXCEPTION_MESSAGE.getMessage());
        }
        if (LottoValidator.isBonusNumberDuplicateWinningNumbers(lottoWinningNumbers, bonusNumber)) {
            throw new IllegalArgumentException(
                    ERROR_MESSAGE_PREFIX
                            + ErrorMessage.BONUS_NUMBER_WINNING_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE.getMessage());
        }
    }

    public long getPurchaseNumbersMatchWinningNumbersCount(List<Integer> purchaseLottoNumbers,
                                                           List<Integer> lottoWinningNumbers) {
        return lottoWinningNumbers.stream()
                .filter(purchaseLottoNumbers::contains)
                .count();
    }

    public boolean isPurchaseNumbersMatchBonusNumber(List<Integer> purchaseLottoNumbers, int bonusNumber) {
        return purchaseLottoNumbers.contains(bonusNumber);
    }

    public List<Integer> inputWinningNumberConvertToCollection(String lottoWinningNumber) {
        List<String> strLottoWinningNumbers = Stream.of(lottoWinningNumber.split(","))
                .collect(Collectors.toList());

        return strLottoWinningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void updateWinningRankMap(LottoWinningRank lottoWinningRank) {
        if (lottoWinningRank != LottoWinningRank.NO_RANK) {
            lottoWinningRankMap.put(lottoWinningRank, lottoWinningRankMap.get(lottoWinningRank) + 1);
        }
    }

    public LottoWinningRank decideWinningRank(List<Integer> purchaseLottoNumbers,
                                              String lottoWinningNumbers,
                                              String bonusNumber) {
        List<Integer> collectedLottoWinningNumbers = Arrays.stream(lottoWinningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int convertedBonusNumber = Integer.parseInt(bonusNumber);
        long purchaseNumbersMatchWinningNumbersCount =
                getPurchaseNumbersMatchWinningNumbersCount(purchaseLottoNumbers, collectedLottoWinningNumbers);
        return LottoWinningRank.decideLottoWinningRank(purchaseNumbersMatchWinningNumbersCount,
                isPurchaseNumbersMatchBonusNumber(purchaseLottoNumbers, convertedBonusNumber));
    }

    public String getEarningsRatio(String lottoPurchaseAmount) {
        double sumLottoWinningMoney = 0;
        List<LottoWinningRank> lottoWinningRanks = lottoWinningRankMap.entrySet().stream()
                .filter(lottoWinningRank -> lottoWinningRank.getValue() != 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        for (LottoWinningRank lottoWinningRank : lottoWinningRanks) {
            String commaRemovedWinningMoney = removeWinningMoneyComma(lottoWinningRank);
            int convertedWinningMoney = Integer.parseInt(commaRemovedWinningMoney);
            sumLottoWinningMoney += convertedWinningMoney;
        }
        double convertedLottoPurchaseAmount = Double.parseDouble(lottoPurchaseAmount);

        double earningsRatio = (sumLottoWinningMoney / convertedLottoPurchaseAmount) * 100;
        return String.format("%,.1f", earningsRatio) + "%";
    }

    public String removeWinningMoneyComma(LottoWinningRank lottoWinningRank) {
        String originalWinningMoney = lottoWinningRank.getWinningMoney();
        return originalWinningMoney.replace(",", "");
    }

    public List<List<Integer>> getPurchaseLottoNumbers() {
        return purchaseLottoNumbers;
    }

    public Map<LottoWinningRank, Integer> getLottoWinningRankMap() {
        return lottoWinningRankMap;
    }
}
