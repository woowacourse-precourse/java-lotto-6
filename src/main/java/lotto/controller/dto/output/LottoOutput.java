package lotto.controller.dto.output;

import java.util.List;

/**
 * 구매한 로또 각 장의 데이터를 담은 Dto입니다.
 */
public record LottoOutput(List<Integer> numbers) {
}
