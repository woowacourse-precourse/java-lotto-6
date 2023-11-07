## 기능 구현 목록

- [ ] <<0.게임 실행>> GameController
  - [x] 구입 금액 입력
  - [x] 발행 로또 출력
  - [ ] 당첨 번호 입력
  - [ ] 보너스 번호 입력
  - [ ] 당첨 통계 계산
  - [ ] 당첨 통계 출력

- [ ] <<1.구입 금액 입력>>
  - [x] 입력 요청 메시지 출력 InputView
  - [x] 구입 금액 입력 InputView
    - [ ] 1,000원 단위인지 확인 Validator
    - [ ] 숫자인지 확인 Validator


- [x] <<2.발행 로또 출력>>
  - [x] 구입 금액으로 구매 개수 계산 AmountCalculator. calculateNumberOfLottoPurchasedByAmount
  - [x] 구매 개수 출력 AmountCalculator.getNumberOfLottoPurchased
  - [x] 구매 개수 화면 출력 OutputView
  - [x] 로또 발행 LottoMachine
  - [x] 구매 개수만큼 발행한 로또 번호 출력 GameController.generateLottos
  - [x] 구매 개수만큼 발행한 로또 번호 화면 출력 OutputView
    - 오름차순으로


- [ ] <<3.당첨 번호 입력>>
  - [x] 입력 요청 메시지 출력 InputView
  - [x] 쉼표로 구분하여 번호 6개 저장 Lotto
    - [ ] 중복되지 않는지 확인 Validator
    - [ ] 숫자인지 확인 Validator
    - [ ] 1 ~ 45 사이의 숫자인지 확인 Validator


- [ ] <<4.보너스 번호 입력>>
  - [x] 입력 요청 메시지 출력 InputView
  - [x] 숫자 하나 저장 Lotto
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