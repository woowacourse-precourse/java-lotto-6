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

    private static EnumMap<LottoRank, Integer> lottoRanks;

    public LottoMachine() {
        initLottoRanks();
    }

    private void initLottoRanks() {
        lottoRanks = new EnumMap<>(LottoRank.class);
        for(LottoRank lottoRank : LottoRank.values()) {
            lottoRanks.put(lottoRank, MATCHED_LOTTO_DEFAULT_VALUE);
        }
    }

    public List<Lotto> generateLottos(int purchaseLottoCount) {
        Validator.validationLottoCount(purchaseLottoCount);

        final List<Lotto> lottos = new ArrayList<>();
        for(int count = 0; count < purchaseLottoCount; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_SIZE);
            lottos.add(new Lotto(numbers));
        }

        return Collections.unmodifiableList(lottos);
    }

    public List<Integer> registerWinningNumber(String winningNumber) {
        List<String> convertedWinningNumbers = Validator.getWinningNumberListString(winningNumber);
        List<Integer> winningNumbers = Validator.getWinningNumbersListInteger(convertedWinningNumbers);

        return Collections.unmodifiableList(winningNumbers);
    }

    public Integer registerBonusNumber(String bonusNumber) {
        Validator.validationBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }


    public Map<LottoRank, Integer> computedLottoRanking(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        boolean containBonusNumber = Validator.isContainBonusNumber(lottos, bonusNumber);
        return Validator.getLottoRanks(lottos, winningNumbers, containBonusNumber);
    }


    public double computedYieldRate(int purchaseAmount, Map<LottoRank, Integer> lottoRanks) {
        int totalPrizeMoney = Validator.getTotalPrizeMoney(lottoRanks);
        double yieldRate = Validator.getYieldRate(purchaseAmount, totalPrizeMoney);

        return Math.round(yieldRate * ROUNDING_VALUE) / ROUNDING_DOUBLE_VALUE;
    }


    private static class Validator {
        private static void validationLottoCount(int purchaseLottoCount) {
            LottoMachineValidationHandler.validationMinGenerateLottoCount(purchaseLottoCount);
        }

        private static List<Integer> getWinningNumbersListInteger(List<String> winningNumbers) {
            List<Integer> convertedWinningNumbers = StringUtils.convertStringListToIntegerList(winningNumbers);
            validationWinningNumbers(convertedWinningNumbers);

            return convertedWinningNumbers;
        }

        private static List<String> getWinningNumberListString(String winningNumber) {
            List<String> convertedWinningNumbers = StringUtils.splitCommaToListString(winningNumber);
            LottoMachineValidationHandler.validationAllNumeric(convertedWinningNumbers);

            return convertedWinningNumbers;
        }

        private static void validationWinningNumbers(List<Integer> winningNumbers) {
            LottoValidationHandler.validationNumbersSize(winningNumbers);
            LottoValidationHandler.validateDuplicatedNumbers(winningNumbers);
            LottoValidationHandler.validationNumbersRange(winningNumbers);
        }

        private static void validationBonusNumber(String bonusNumber) {
            LottoMachineValidationHandler.validationNumeric(bonusNumber);
            LottoMachineValidationHandler.validationNumbersRange(Integer.parseInt(bonusNumber));
        }

        private static Map<LottoRank, Integer> getLottoRanks(List<Lotto> lottos, List<Integer> winningNumbers,
                                                             boolean containBonusNumber) {
            for(Lotto lotto : lottos) {
                int matchLottoNumber = getMatchLottoNumber(winningNumbers, lotto);
                LottoRank lottoRank = LottoRank.getLottoRank(matchLottoNumber, containBonusNumber);
                lottoRanks.put(lottoRank, lottoRanks.getOrDefault(lottoRank,
                        MATCHED_LOTTO_DEFAULT_VALUE) + MATCHED_LOTTO_INCREASE_VALUE);
            }

            return Collections.unmodifiableMap(lottoRanks);
        }

        private static int getMatchLottoNumber(List<Integer> winningNumbers, Lotto lotto) {
            return (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
        }

        private static boolean isContainBonusNumber(List<Lotto> lottos, Integer bonusNumber) {
            return lottos.stream()
                    .anyMatch(lotto -> lotto.getNumbers().stream()
                            .anyMatch(number -> number.equals(bonusNumber))
                    );
        }

        private static double getYieldRate(int purchaseAmount, int totalPrizeMoney) {
            return PERCENTAGE * totalPrizeMoney / purchaseAmount;
        }

        private static int getTotalPrizeMoney(Map<LottoRank, Integer> lottoRanks) {
            int totalPrizeMoney = 0;
            for(LottoRank lottoRank : LottoRank.values()) {
                if(lottoRanks.containsKey(lottoRank)) {
                    totalPrizeMoney += lottoRank.getPrizeMoney() * lottoRanks.get(lottoRank);
                }
            }

            return totalPrizeMoney;
        }
    }
}
