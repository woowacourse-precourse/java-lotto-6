package lotto.domain;

import static lotto.domain.constant.LottoConstant.LOTTO_SIZE;
import static lotto.domain.constant.LottoConstant.MAX_RANGE;
import static lotto.domain.constant.LottoConstant.MIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.validation.LottoMachineValidationHandler;
import lotto.domain.validation.LottoValidationHandler;
import lotto.util.StringUtils;

public class LottoMachine {
    private static final int ROUNDING_VALUE = 100;
    private static final double ROUNDING_DOUBLE_VALUE = 100.0;
    private static final double PERCENTAGE = 100.0;
    private static final int MATCHED_LOTTO_DEFAULT_VALUE = 0;
    private static final int MATCHED_LOTTO_INCREASE_VALUE = 1;

    private EnumMap<LottoRank, Integer> lottoRanks = new EnumMap<>(LottoRank.class);

    public LottoMachine() {
        initLottoRanks();
    }

    private void initLottoRanks() {
        for(LottoRank lottoRank : LottoRank.values()) {
            lottoRanks.put(lottoRank, MATCHED_LOTTO_DEFAULT_VALUE);
        }
    }

    public List<Lotto> generateLottos(int purchaseLottoCount) {
        validationLottoCount(purchaseLottoCount);
        final List<Lotto> lottos = new ArrayList<>();
        for(int count = 0; count < purchaseLottoCount; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_SIZE);
            lottos.add(new Lotto(numbers));
        }

        return Collections.unmodifiableList(lottos);
    }

    private void validationLottoCount(int purchaseLottoCount) {
        LottoMachineValidationHandler.validationMinGenerateLottoCount(purchaseLottoCount);
    }

    public List<Integer> registerWinningNumber(String winningNumber) {
        List<String> convertedWinningNumbers = getWinningNumberListString(winningNumber);
        List<Integer> winningNumbers = getWinningNumbersListInteger(convertedWinningNumbers);

        return Collections.unmodifiableList(winningNumbers);
    }

    private List<Integer> getWinningNumbersListInteger(List<String> winningNumbers) {
        List<Integer> convertedWinningNumbers = StringUtils.convertStringListToIntegerList(winningNumbers);
        validationWinningNumbers(convertedWinningNumbers);

        return convertedWinningNumbers;
    }

    private List<String> getWinningNumberListString(String winningNumber) {
        List<String> convertedWinningNumbers = StringUtils.splitCommaToListString(winningNumber);
        LottoMachineValidationHandler.validationAllNumeric(convertedWinningNumbers);

        return convertedWinningNumbers;
    }

    private void validationWinningNumbers(List<Integer> winningNumbers) {
        LottoValidationHandler.validationNumbersSize(winningNumbers);
        LottoValidationHandler.validateDuplicatedNumbers(winningNumbers);
        LottoValidationHandler.validationNumbersRange(winningNumbers);
    }

    public Integer registerBonusNumber(String bonusNumber) {
        validationBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private void validationBonusNumber(String bonusNumber) {
        LottoMachineValidationHandler.validationNumeric(bonusNumber);
        LottoMachineValidationHandler.validationNumbersRange(Integer.parseInt(bonusNumber));
    }

    public Map<LottoRank, Integer> computedLottoRanking(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        boolean containBonusNumber = isContainBonusNumber(lottos, bonusNumber);
        return getLottoRanks(lottos, winningNumbers, containBonusNumber);
    }

    private Map<LottoRank, Integer> getLottoRanks(List<Lotto> lottos, List<Integer> winningNumbers, boolean containBonusNumber) {
        for(Lotto lotto : lottos) {
            int matchLottoNumber = getMatchLottoNumber(winningNumbers, lotto);
            LottoRank lottoRank = LottoRank.getLottoRank(matchLottoNumber, containBonusNumber);
            lottoRanks.put(lottoRank, lottoRanks.getOrDefault(lottoRank,
                    MATCHED_LOTTO_DEFAULT_VALUE) + MATCHED_LOTTO_INCREASE_VALUE);
        }

        return Collections.unmodifiableMap(lottoRanks);
    }

    private int getMatchLottoNumber(List<Integer> winningNumbers, Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isContainBonusNumber(List<Lotto> lottos, Integer bonusNumber) {
        return lottos.stream()
                .anyMatch(lotto -> lotto.getNumbers().stream()
                        .anyMatch(number -> number.equals(bonusNumber))
                );
    }

    public double computedYieldRate(int purchaseAmount, Map<LottoRank, Integer> lottoRanks) {
        int totalPrizeMoney = getTotalPrizeMoney(lottoRanks);
        double yieldRate = getYieldRate(purchaseAmount, totalPrizeMoney);
        return Math.round(yieldRate * ROUNDING_VALUE) / ROUNDING_DOUBLE_VALUE;
    }

    private static double getYieldRate(int purchaseAmount, int totalPrizeMoney) {
        return PERCENTAGE * totalPrizeMoney / purchaseAmount;
    }

    private int getTotalPrizeMoney(Map<LottoRank, Integer> lottoRanks) {
        int totalPrizeMoney = 0;
        for(LottoRank lottoRank : LottoRank.values()) {
            if(lottoRanks.containsKey(lottoRank)) {
                totalPrizeMoney += lottoRank.getPrizeMoney() * lottoRanks.get(lottoRank);
            }
        }

        return totalPrizeMoney;
    }
}
