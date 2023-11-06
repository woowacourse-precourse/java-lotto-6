package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGameService {

    private static final int LOTTO_PRICE = 1000;
    private static final int INITIAL_COUNT = 0;
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String CONTAIN_NON_DIGIT_EXCEPTION = "숫자만 입력할 수 있습니다.";
    private static final String NOT_DIVIDING_BY_LOTTO_PRICE_EXCEPTION = "금액은 1,000원 단위로 입력할 수 있습니다.";
    private static final String NON_DIGIT_REGEX = "\\D+";
    private final List<List<Integer>> purchasedLottoNumbers = new ArrayList<>();
    private final EnumMap<LottoRank, Integer> lottoRakingMap = new EnumMap<>(LottoRank.class);

    public LottoGameService() {
        initLottoRakingMap();
    }

    private void initLottoRakingMap() {
        for (LottoRank rank : LottoRank.values()) {
            lottoRakingMap.put(rank, INITIAL_COUNT);
        }
    }

    public void generateLottoNumbers() {
        Lotto lotto = new Lotto(LottoNumbersGenerator.generateLottoNumbers());
        purchasedLottoNumbers.add(lotto.getNumbers());
    }

    public void validatePurchaseAmount(String lottoPurchaseAmount) {
        if (isStringContainNonDigit(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + CONTAIN_NON_DIGIT_EXCEPTION);
        }
        if (isMultipleOfLottoPrice(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + NOT_DIVIDING_BY_LOTTO_PRICE_EXCEPTION);
        }
    }

    private static boolean isStringContainNonDigit(String lottoPurchaseAmount) {
        return Pattern.compile(NON_DIGIT_REGEX).matcher(lottoPurchaseAmount).find();
    }

    private static boolean isMultipleOfLottoPrice(String lottoPurchaseAmount) {
        return Integer.parseInt(lottoPurchaseAmount) % LOTTO_PRICE != 0;
    }

    public int getLottoTicketCount(String lottoPurchaseAmount) {
        validatePurchaseAmount(lottoPurchaseAmount);
        return Integer.parseInt(lottoPurchaseAmount) / LOTTO_PRICE;
    }

    public List<List<Integer>> getPurchasedLottoNumbers() {
        return purchasedLottoNumbers;
    }

    public List<Integer> convertWinningNumbersToCollection(String lottoWinningNumbers) {
        return Stream.of(lottoWinningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
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
                .sum() / Integer.parseInt(purchaseAmount) * 100;
    }

    public EnumMap<LottoRank, Integer> getLottoRakingMap() {
        return lottoRakingMap;
    }
}
