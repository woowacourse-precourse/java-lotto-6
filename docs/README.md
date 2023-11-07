# 요구사항 정리

## 1. 기능 요구사항

## 2. 프로그래밍 요구사항

- 메서드 길이가 15라인 넘어가지 않도록 구현
- else 사용 말것
- Enum 적용
- domain logic 단위 테스트 - service, view 분리

# 구현 설계

## 1. 패키지

util
- Validator
  model
- Lotto
- LottoService
  controller
- LottoController
  view
- InputView
- OutputView

## 2. 구현 기능

사용 API : List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

- InputView
    - payLottoPrice() : 로또 구입 금액
    - getWinningLottoNumber() : 당첨번호를 입력 받는다.
    - getBonusNumber() : 보너스 번호를 입력 받는다.

- OutputView
    - getBoughtLotto() : 구입한 로또 수량 및 번호를 받는다.
    - showErrorString() : [ERRROR] 내가 정한 문구

- LottoService
    - giveLottoTicket() : 로또 발행
    - sortLottoNumber() : 로또 번호를 오름차순 정렬한다.
    - getLottoResultHistory() : 당첨 내역을 출력한다.
    - getRateOfReturn() : 수익률 계산 - 소수점 2째자리서 반올림

- LottoController

- Validator
    - payLottoPrice() : 구입금액에 1,000원 단위로 나눠지지 않는다.