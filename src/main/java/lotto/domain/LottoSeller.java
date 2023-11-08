package lotto.domain;

import lotto.Constant;
import lotto.Util;

import java.util.*;

public class LottoSeller {

    private final Lotto winningLotto;
    private final int bonusNumber;
    private final EnumMap<Rank, Integer> matchedResult = new EnumMap<>(Rank.class);

    private static final String INVALID_LOTTO_PICK_NUMBER = "입력된 숫자를 다시 확인하세요.";
    private static final String INVALID_BONUS_NUMBER = "입력가능한 보너스 숫자 범위를 초과했습니다.";
    private static final String OVERLAP_NUMBER = "중복된 로또번호입니다.";

    public LottoSeller(String winningNumber, String bonusNumber) {
        this.winningLotto = new Lotto(validWinningNumber(winningNumber));
        this.bonusNumber = validBonusNumber(bonusNumber);
        initMatchResult();
    }

    public EnumMap<Rank, Integer> getMatchedResult() {
        return matchedResult;
    }

    private void initMatchResult() {
        for (Rank rank : Rank.values()) {
            this.matchedResult.put(rank, 0);
        }
    }

    private List<Integer> validWinningNumber(String input) {
        String[] winningNumber = input.split(",");

        Set<Integer> output = new HashSet<>();
        for (String number : winningNumber) {
            output.add(Util.toInteger(number));
        }

        if (output.size() != Constant.LOTTO_PICK_NUMBER) {
            throw new IllegalArgumentException(Constant.ERROR_PREFIX + INVALID_LOTTO_PICK_NUMBER);
        }

        return output.stream().sorted().toList();
    }

    private int validBonusNumber(String input) {
        int bonusNumber = Util.toInteger(input);

        if (bonusNumber < Constant.LOTTO_MIN_NUMBER || bonusNumber > Constant.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(Constant.ERROR_PREFIX + INVALID_BONUS_NUMBER);
        }

        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(Constant.ERROR_PREFIX + OVERLAP_NUMBER);
        }

        return bonusNumber;
    }

    public Rank getMatchedRank(int matchedCount, boolean isBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() == matchedCount && rank.isBonus() == isBonus) {
                return rank;
            }
        }

        return Rank.NONE;
    }

    public void contrastWithWinningNumber(LottoBuyer lottoBuyer) {
        for (Lotto lotto : lottoBuyer.getLottos()) {
            int size = winningLotto.matchedNumberCount(lotto);
            boolean isBonus = winningLotto.getNumbers().contains(bonusNumber);
            Rank matchedRank = getMatchedRank(size, isBonus);
            matchedResult.put(matchedRank, matchedResult.get(matchedRank) + 1);
        }
    }

    public double calculateRateOfReturn(LottoBuyer lottoBuyer, Map<Rank, Integer> result) {
        double totalAmount = lottoBuyer.getPurchaseNumber() * Constant.LOTTO_PRICE_UNIT;
        double sum = 0;
        for (Rank rank : result.keySet()) {
            sum += rank.getPrize() * result.get(rank);
        }

        return sum / totalAmount * 100;
    }
}
