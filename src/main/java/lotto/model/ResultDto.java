package lotto.model;

import java.util.Map;
import lotto.model.LottoResult;

/**
 * 전체 로또의 결과를 저장하는 레코드
 * @param resultMap 로또 결과 {@link LottoResult}에 따른 개수
 * @param yield 소숫점 2번째 자리에서 반올림한 수익률(%)
 */
public record ResultDto(Map<LottoResult, Integer> resultMap, Double yield) {

}
