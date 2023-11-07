package lotto.controller.dto.output;

/**
 * 로또 추첨 결과 데이터를 담은 Dto입니다.
 */
public record LottosDrawingOutput(
        int firstCount,
        int secondCount,
        int thirdCount,
        int fourthCount,
        int fifthCount,
        double returnOfRate
) {
}
