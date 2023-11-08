package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.util.MatchType;

public interface LottoService {

    /**
     * 구입 금액 입력 받는 함수
     *
     * @return : 구입 금액
     */
    int inputPurchaseAmount();

    /**
     * 로또 개수 반환하는 함수
     *
     * @return : 로또 구입 개수
     */
    int calculatePurchaseCount(int purchaseAmount);

    /**
     * 랜덤 로또 값 생성해서 반환
     *
     * @return : 새로운 Lotto 클래스
     */
    List<Lotto> generateLottos(int lottoCount);

    /**
     * 사용자로부터 당첨 번호 입력 받고 반환 1~45 예외 처리 필요
     *
     * @return : 당첨 번호
     */
    List<Integer> inputWinningNumbers();

    /**
     * 사용자로부터 보너스 번호 입력 받고 반환 1~45 예외 처리 필요
     *
     * @return : 보너스 번호
     */
    int inputBonusNumber(List<Integer> winningNumbers);

    /**
     * 당첨 통계 계산하기
     *
     * @param lottoNumbers : 로또값 배열
     * @return : 당첨 통계
     */
    Map<MatchType, Integer> calculateWinningStatistics(List<Lotto> lottoNumbers,
                                                       List<Integer> winningNumbers,
                                                       int bonusNumber);

    /**
     * 수익 계산하는 함수
     *
     * @param winningStatistics : 당첨 통계
     * @return : 수익
     */
    int calculateEarnings(Map<MatchType, Integer> winningStatistics);

    /**
     * 수익률 계산하기
     *
     * @param earnings : 수익
     * @return : 수익률
     */
    double calculateReturnRate(int purchaseAmount, int earnings);
}
