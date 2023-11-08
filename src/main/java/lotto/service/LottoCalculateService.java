package lotto.service;

import static lotto.model.LottoRule.BONUS_CONDITIONS;
import static lotto.model.LottoRule.LOTTO_PRICE;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.dto.LottosCalculateResult;
import lotto.exception.NonVariableException;
import lotto.model.Lotto;
import lotto.model.LottoBonusNumber;
import lotto.model.LottoRank;
import lotto.model.LottoWallet;
import lotto.model.LottoWinningNumbers;
import lotto.repository.LottoWinningRepository;
import lotto.repository.UserLottoRepository;

public class LottoCalculateService {

    private UserLottoRepository userLottoRepository;
    private LottoWinningRepository lottoWinningRepository;

    public LottoCalculateService(UserLottoRepository userLottoRepository,
                                 LottoWinningRepository lottoWinningRepository) {
        this.userLottoRepository = userLottoRepository;
        this.lottoWinningRepository = lottoWinningRepository;
    }

    public void saveRecentWinningNumbers(LottoWinningNumbers winningNumbers, LottoBonusNumber bonusNumber) {
        lottoWinningRepository.saveLottoWinningNumbers(winningNumbers);
        lottoWinningRepository.saveLottoBonusNumber(bonusNumber);
    }

    /**
     * 당첨 통계를 반환한다.
     */
    public LottosCalculateResult winningStatistics() {
        readyCheck();

        Map<LottoRank, Integer> ranks = runAllCompare();
        double rateOfReturn = rateOfReturnCalculation(ranks);

        return new LottosCalculateResult(ranks, rateOfReturn); // 받아온 정보 담아서 반환
    }

    private double rateOfReturnCalculation(Map<LottoRank, Integer> result) {
        int count = 0;
        int revenue = 0;
        for (Entry<LottoRank, Integer> entry :
                result.entrySet()) {
            count += entry.getValue(); // 구매한 수량만큼 추가
            if (entry.getKey() == LottoRank.RANK_NO) {
                continue; // 0등은 끝
            }
            LottoRank rank = entry.getKey();
            revenue += rank.getPrice() * entry.getValue(); // 가격 가져와서 더하기
        }

        double roi = ((double) revenue / (count * LOTTO_PRICE)) * 100.0;

        return Math.round(roi * 10) / 10.0;
    }


    /**
     * 지갑의 로또로 등수를 확인한다.
     */
    private Map<LottoRank, Integer> runAllCompare() {
        Map<LottoRank, Integer> ranks = LottoRank.createRankMap();
        LottoWallet lottoWallet = userLottoRepository.getLottoWallet();
        LottoWinningNumbers winningNumbers = lottoWinningRepository.getLottoWinningNumbers();
        LottoBonusNumber bonusNumber = lottoWinningRepository.getLottoBonusNumber();

        for (Lotto lotto :
                lottoWallet.getLottos()) {
            LottoRank rank = lottoCompare(winningNumbers, bonusNumber, lotto);
            increaseRank(ranks, rank); // 랭킹 결과로 카운트를 올린다.
        }

        return ranks;
    }

    /**
     * 랭킹 카운트를 올린다.
     *
     * @param rank
     */
    private void increaseRank(Map<LottoRank, Integer> ranks, LottoRank rank) {
        int tempNumber = ranks.get(rank);
        ranks.put(rank, tempNumber + 1);
    }

    /**
     * 로또 등수 규정에 맞게 계산하여 랭킹을 반환한다.
     *
     * @param winningLotto     1등 로또
     * @param lottoBonusNumber 보너스 번호
     * @param userLotto        검증할 사용자 로또
     * @return LottoRank
     */
    private LottoRank lottoCompare(LottoWinningNumbers winningLotto, LottoBonusNumber lottoBonusNumber,
                                   Lotto userLotto) {
        double sameValue = 0;
        List<Integer> userNumbers = userLotto.getNumbers();

        for (int number : // 로또 번호 하나씩 비교해본다.
                winningLotto.getLottoNumbers()) {
            if (userNumbers.contains(number)) {
                sameValue++;
            }
        }

        int bonusNumber = lottoBonusNumber.getBonusNumber();
        if (sameValue == BONUS_CONDITIONS && userNumbers.contains(bonusNumber)) {
            sameValue += 0.5; // 5개를 맞추고, 보너스도 맞추면 0.5점 증가
        }

        return LottoRank.parseLottoRank(sameValue); // 랭크로 변환 후 반환
    }

    /**
     * 로또 통계 계산에 필요한 데이터가 있는지 확인한다.
     */
    private void readyCheck() {
        if (userLottoRepository.getLottoWallet() == null) {
            throw new NonVariableException("lottoWallet");
        }
        if (lottoWinningRepository.getLottoWinningNumbers() == null) {
            throw new NonVariableException("winningNumbers");
        }
        if (lottoWinningRepository.getLottoBonusNumber() == null) {
            throw new NonVariableException("bonusNumber");
        }
    }

}
