package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import lotto.dto.LottoResultDto;

/**
 * 로또 당첨 결과를 저장하는 클래스 당첨 등수와 그에 해당하는 개수를 저장
 */
public class WinningResult {
    private Map<WinningType, Integer> winningResult;

    private WinningResult(final Map<WinningType, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    private WinningResult(final Lottos lottos, final DrawnNumbers drawnNumbers) {
        this.winningResult = new EnumMap<>(WinningType.class);
        initializeWinningResult();
        generateWinningResult(lottos, drawnNumbers);
    }

    /**
     * 당첨 결과를 외부에서 받아와 저장하는 테스트용 메서드
     *
     * @param winningResult 당첨 결과
     * @return 당첨 등수와 그에 해당하는 로또 개수
     */
    public static WinningResult from(final Map<WinningType, Integer> winningResult) {
        return new WinningResult(winningResult);
    }

    /**
     * 당첨 내역 객체를 생성하는 메서드
     *
     * @param lottos       발행한 로또들의 숫자들
     * @param drawnNumbers 당첨 번호들과 보너스 번호
     * @return 당첨 등수와 그에 해당하는 로또 개수
     */
    public static WinningResult of(final Lottos lottos, final DrawnNumbers drawnNumbers) {
        return new WinningResult(lottos, drawnNumbers);
    }

    private void initializeWinningResult() {
        Arrays.stream(WinningType.values())
                .forEach(winning -> winningResult.put(winning, 0));
    }

    private void generateWinningResult(final Lottos lottos, final DrawnNumbers drawnNumbers) {
        for (Lotto lotto : lottos.getLottos()) {
            LottoResultDto lottoResultDto = drawnNumbers.compare(lotto);
            WinningType winningType = WinningType.findWinningType(
                    lottoResultDto.getWinningCount(),
                    lottoResultDto.hasBonusNumber());
            countWinningType(winningType);
        }
    }

    private void countWinningType(final WinningType winningType) {
        winningResult.put(winningType, winningResult.get(winningType) + 1);
    }

    /**
     * 당첨 등수에 해당하는 로또의 개수를 반환하는 메서드
     *
     * @param winningType 당첨 등수
     * @return 당첨 등수에 해당하는 로또의 개수
     */
    public Integer getValue(final WinningType winningType) {
        return winningResult.get(winningType);
    }

    /**
     * 당첨 내역으로부터 수익률을 계산하는 메서드
     *
     * @param cost 로또를 구매한 총 비용
     * @return 총 수익에서 비용을 나눈 수익률
     */
    public double calculateEarningsRate(final Cost cost) {
        return cost.divided(getEarnings()) * 100;
    }

    private double getEarnings() {
        int earnings = (int) winningResult.entrySet()
                .stream()
                .mapToDouble(entry -> calculateWinningPrice(entry))
                .sum();
        return earnings;
    }

    private int calculateWinningPrice(final Entry<WinningType, Integer> entry) {
        return entry.getKey().getPrice() * entry.getValue();
    }
}
