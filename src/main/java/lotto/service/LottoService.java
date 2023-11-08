package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LotteryRankConstant;
import lotto.constant.LottoConstant;
import lotto.domain.BonusNumber;
import lotto.domain.LotteryResult;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.UserLottoRanks;
import lotto.domain.UserMoney;
import lotto.domain.WinningLottoNumbers;
import lotto.domain.constant.NumberConstant;
import lotto.dto.UserLottoGameResult;
import lotto.service.util.LottoGenerator;

public class LottoService {
    public UserMoney initUserMoney(final long userMoney) {
        return UserMoney.from(userMoney);
    }

    public Lottos createUserLottos(final long userMoney) {
        List<Lotto> lottos = new ArrayList<>();
        for (long i = 0; i < calculateNumberOfLottos(userMoney); i++) {
            lottos.add(LottoGenerator.generateLotto());
        }
        return Lottos.from(lottos);
    }

    private long calculateNumberOfLottos(final long userMoney) {
        return userMoney / LottoConstant.LOTTO_PRICE.getValue();
    }

    public WinningLottoNumbers initWinningLottoNumbers(final List<Integer> winningLottoNumbers) {
        return WinningLottoNumbers.from(new Lotto(winningLottoNumbers));
    }

    public BonusNumber initBonusNumber(final WinningLottoNumbers winningLottoNumbers, final int bonusNumber) {
        return BonusNumber.of(bonusNumber, winningLottoNumbers.getWinningLottoNumbers());
    }

    public LotteryResult generateLotteryResult(final WinningLottoNumbers winningLottoNumbers,
                                               final BonusNumber bonusNumber) {
        return LotteryResult.of(winningLottoNumbers, bonusNumber);
    }

    public UserLottoGameResult generateUserLottoGameResult(final LotteryResult lotteryResult, final Lottos lottos) {
        UserLottoRanks userLottoRanks = UserLottoRanks.from(new HashMap<>());
        for (Lotto lotto : lottos.getLottos()) {
            recordUserLottoRank(userLottoRanks, lotteryResult, lotto);
        }
        double rateOfReturn = calculateRateOfReturn(lottos.getNumberOfLottos(), userLottoRanks);
        return UserLottoGameResult.of(userLottoRanks, rateOfReturn);
    }

    private void recordUserLottoRank(final UserLottoRanks userLottoRanks,
                                     final LotteryResult lotteryResult, final Lotto lotto) {
        LotteryRankConstant lotteryRankConstant = lotteryResult.judgeRank(lotto);
        Map<LotteryRankConstant, Integer> userLottoRankHolder = userLottoRanks.getUserLottoRanks();
        userLottoRankHolder
                .put(lotteryRankConstant,
                        userLottoRankHolder.getOrDefault(lotteryRankConstant, NumberConstant.ZERO.getNumber())
                                + NumberConstant.ONE.getNumber());
    }

    private double calculateRateOfReturn(final long numberOfUserLottos,
                                         final UserLottoRanks userLottoRanks) {
        long winningAmount = userLottoRanks.calculateWinningAmount();
        long userMoney = numberOfUserLottos * LottoConstant.LOTTO_PRICE.getValue();
        return calculateRateOfReturnToFirstDecimalPlace(winningAmount, userMoney);
    }

    private double calculateRateOfReturnToFirstDecimalPlace(final long winningAmount, final long userMoney) {
        double rateOfReturn = (winningAmount * NumberConstant.HUNDRED.getNumber() / (double) userMoney);
        return Math.round(rateOfReturn * NumberConstant.TEN.getNumber())
                / (double) NumberConstant.TEN.getNumber();
    }
}