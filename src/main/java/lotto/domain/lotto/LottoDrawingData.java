package lotto.domain.lotto;

import java.util.EnumMap;
import lotto.controller.dto.output.LottosDrawingOutput;
import lotto.domain.money.Money;

/**
 * Lotto 추첨의 중간 결과를 처리 및 저장하기 위한 클래스
 */
public final class LottoDrawingData {

    /**
     * EnumMap은 내부적으로 배열이기 때문에 enum size 만큼 capacity를 잡으며, enum constant 대로 배치하여 순서 보장이 되며, hashing 과정 생략하기 때문에 성능도
     * HashMap, LinkedHashMap보다 우세하다고 함.
     */
    private final EnumMap<LottoPrize, Integer> data;

    /**
     * 수익률을 계산하기 위해 총 구매 금액을 저장. Money는 불변이기 때문에 매 번 재생성 및 재할당 필요. `final` 사용 불가
     */
    private Money totalCost;

    /**
     * 수익률을 계산하기 위해 총 수익 금액을 저장. 역시 불변이라 `final` 미사용
     */
    private Money totalEarning;

    public LottoDrawingData() {
        this.totalCost = Money.zero();
        this.totalEarning = Money.zero();
        this.data = createDataMap();
    }

    /**
     * 로또 구매 결과 통계를 중간 저장하는 EnumMap 초기화 및 반환
     */
    private static EnumMap<LottoPrize, Integer> createDataMap() {
        final EnumMap<LottoPrize, Integer> data = new EnumMap<>(LottoPrize.class);
        for (final LottoPrize lottoPrize : LottoPrize.values()) {
            data.put(lottoPrize, 0);
        }
        return data;
    }

    /**
     * 로또 하나를 추첨할 때마다 결과를 EnumMap에 추가
     */
    public void save(final LottoPrize lottoPrize) {
        final int prevCount = data.get(lottoPrize);
        totalCost = totalCost.increased(LottoStore.LOTTO_PRICE);
        totalEarning = totalEarning.increased(lottoPrize.getPrize());
        this.data.replace(lottoPrize, prevCount + 1);
    }


    /**
     * 중간 결과가 담긴 EnumMap을 최종적으로 DTO로 변환
     */
    public LottosDrawingOutput toLottoDrawingResult() {
        return new LottosDrawingOutput(
                data.get(LottoPrize.FIRST),
                data.get(LottoPrize.SECOND),
                data.get(LottoPrize.THIRD),
                data.get(LottoPrize.FOURTH),
                data.get(LottoPrize.FIFTH),
                calculateReturnOfRate()
        );
    }

    /**
     * 총 수익률 계산(소수점 2번째 자리에서 반올림)
     * <p>
     * Math.round는 소수점 첫째 자리에서 반올림 하기 때문에, 10을 곱하여 둘째 자리를 첫째 자리로 이동시키고 둘째 자리에서 반올림 한 뒤, 다시 10을 나눠서 1의 자리를 첫째 자리로 돌려줌
     */
    public double calculateReturnOfRate() {
        final double avg = totalEarning.toDouble() / totalCost.toDouble() * 100;
        return Math.round(avg * 10.0) / 10.0;
    }

    public int get(final LottoPrize lottoPrize) {
        return data.get(lottoPrize);
    }


}
