package lotto.domain;

import lotto.domain.number.NumberStrategy;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

// 로또 추첨 알고리즘
public class LottoDraw {
    private final List<Lotto> lottoTickets;

    public LottoDraw(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    // 각 result에 맞게 카운팅하는 변수
    private static final Map<LottoResult, Integer> resultCounts = new EnumMap<>(LottoResult.class);

    public Map<LottoResult, Integer> extractResult(NumberStrategy winningLotto, int bonusNumber) {
        //결과맵 초기화
        for (LottoResult result : LottoResult.values()) {
            resultCounts.put(result, 0);
        }

        calculateResult(winningLotto.generateNumber(), bonusNumber); // 결과 계산

        return resultCounts;
    }

    // stream API로 수정
    private void calculateResult(Lotto winningLotto, int bonusNumber) {
        lottoTickets.forEach(lottoTicket -> {
            int matchingCount = compareLotto(winningLotto, lottoTicket.getNumbers());
            boolean bonusMatch = compareBonus(bonusNumber, lottoTicket.getNumbers());
            setMatchingResult(matchingCount, bonusMatch);
        });
    }

    // 일치 개수 리턴
    private int compareLotto(Lotto winningLotto, List<Integer> lottoNumbers) {
        // 복사본 만들어야 원본값에서 retainAll()을 통한 갱신 안됨
        List<Integer> copiedLottoNumbers = new ArrayList<>(lottoNumbers);
        copiedLottoNumbers.retainAll(winningLotto.getNumbers());
        return copiedLottoNumbers.size();
    }

    // 개별 당첨결과 세팅
    private void setMatchingResult(int matchingCount, boolean bonusMatch) {
        //모든 LottoResult의 MATCH값과 대조
        for (LottoResult result : LottoResult.values()) {
            // MATCH_5인데 bonus==true면 넘어가기
            if (result.isBonusMatch(bonusMatch)) {
                continue;
            }
            if (matchingCount == result.getMatchedNumbers()) {
                resultCounts.put(result, resultCounts.get(result) + 1);
                return;
            }
        }
    }

    // 보너스 포함 여부
    private boolean compareBonus(int bonusNumber, List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
