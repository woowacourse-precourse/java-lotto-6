package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

/*
- [ ] 로또 구입 금액을 입력받는 기능
    - [v] "구입금액을 입력해 주세요." 메시지를 출력하는 기능
- [ ] 랜덤 메서드를 이용해서 중복되지 않는 숫자를 뽑는 기능
- [ ] 뽑은 숫자를 저장하는 기능
- [ ] 로또를 발행하는 기능
- [ ] 당첨 번호를 입력받는 기능
    - [ ] 당첨 번호를 입력해 주세요. 메시지를 출력하는 기능
- [ ] 보너스 번호를 입력받는 기능
    - [ ] 보너스 번호를 입력해 주세요. 메시지를 출력하는 기능
- [ ] 당첨 여부와 등수를 계산하는 기능
- [ ] 수익률을 계산 하는 기능
- [ ] 당첨 통계를 출력하는 기능
    - [ ] 수익률을 출력하는 기능
- [ ] 예외가 발생했을 때 에러 메시지를 처리 하는 기능
- [ ] 예외가 발생한 다음 다시 입력을 받는 기능 */
// 이 컨트롤러에서는 로또 구입 금액 입력, 로또 발행(데이터 전달)을 구현
// 로또 구입 금액이 로또 클래스에 필요할까? ㄴㄴ, 로또 구입 금액은 로또컨트롤러에서만 필요
public class LottoController {
    final static int LOTTO_COUNTS = 6;
    final static int BONUS_COUNTS = 1;
    final static int MOD_VALUE = 1000;
    final static int MAX_LOTTO_PRICES = 2147483000;
    final static int MIN_LOTTO_PRICES = 1000;

    public String printLottoPrices() {
        return "구입금액을 입력해 주세요.";
    }
    public int inputLottoPrices() {
        String confirmString = "";
        int lottoPrices = isInteger(confirmString);
        if(!isPriceBiggerThanMax(lottoPrices)) {
            throw new IllegalArgumentException("최대 구입 가능 금액은 " + MAX_LOTTO_PRICES + "원 입니다.");
        }
        if(!isPositiveNumber(lottoPrices)) {
            throw new IllegalArgumentException("최소 구입 가능 금액은 " + MIN_LOTTO_PRICES + "원 입니다.");
        }
        if(!isPriceModZero(lottoPrices)) {
            throw new IllegalArgumentException("구입 금액은 " + MOD_VALUE + "원 단위 여야 합니다.");
        }
        return lottoPrices;
    }
    public int isInteger(String confirmString) {
        try {
            return Integer.parseInt(confirmString);
        } catch (NumberFormatException numberFormatException) {
        throw new IllegalArgumentException("숫자만 입력하실 수 있습니다");
        }

    }
    public boolean isPriceBiggerThanMax(int confirmInteger) {
        return confirmInteger > MAX_LOTTO_PRICES;
    }
    public boolean isPositiveNumber(int confirmInteger) {
        return confirmInteger > 0;
    }
    public boolean isPriceModZero(int confirmInteger) {
        return confirmInteger % MOD_VALUE == 0;
    }

    // 순서 - 상수, 클래스 변수
    // 인스턴스 변수
    // 생성자
    // 메서드
}
