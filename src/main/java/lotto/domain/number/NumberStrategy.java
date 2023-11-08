package lotto.domain.number;

import lotto.domain.Lotto;

// 로또넘버 생성 전략
// 1. 랜덤넘버 생성
// 2. 수동넘버 생성 - 당첨번호 & 테스트
public interface NumberStrategy {

    // List<Integer> / Lotto 어떤 리턴타입이 좋을까?
    Lotto generateNumber();
}
