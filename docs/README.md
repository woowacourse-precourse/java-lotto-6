## 기능 구현 목록


- [ ] <<1.구입 금액 입력>>
  - [ ] 입력 요청 메시지 출력 InputView
  - [ ] 구입 금액 입력
    - [ ] 1,000원 단위인지 확인 Validator
    - [ ] 숫자인지 확인 Validator


- [ ] <<2.발행 로또 출력>>
  - [ ] 구입 금액으로 구매 개수 계산 AmountCalculator
  - [ ] 구매 개수 출력 AmountCalculator
  - [ ] 구매한 개수만큼 로또 발행 LottoMachine
  - [ ] 발행한 로또 번호 출력 OutputView
    - 오름차순으로


- [ ] <<3.당첨 번호 입력>>
  - [ ] 입력 요청 메시지 출력 InputView
  - [ ] 쉼표로 구분하여 번호 6개 저장 Lotto
    - [ ] 중복되지 않는지 확인 Validator
    - [ ] 숫자인지 확인 Validator
    - [ ] 1 ~ 45 사이의 숫자인지 확인 Validator


- [ ] <<4.보너스 번호 입력>>
  - [ ] 입력 요청 메시지 출력 InputView
  - [ ] 숫자 하나 저장 InputView
    - [ ] 당첨 번호와 중복되지 않는지 확인 Validator
    - [ ] 숫자인지 확인 Validator
    - [ ] 1 ~ 45 사이의 숫자인지 확인 Validator


- [ ] <<5.당첨 통계 출력>>
  - [ ] 일치 번호 개수 계산 LottoCalculator
  - [ ] 당첨 금액 계산 LottoCalculator
  - [ ] 수익률 계산 LottoCalculator
    - 수소점 둘째 자리에서 반올림


- [ ] <<6.당첨 통계 출력>>
  - [ ] 당첨 내역 출력 OutputView
  - [ ] 총 수익률 출력 OutputView