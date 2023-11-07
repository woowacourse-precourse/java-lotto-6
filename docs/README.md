# 미션 - 로또
## 👽추가 사항
지난 2주 차 미션에서는 함수 분리와 함수별로 테스트를 작성하는 것을 목표로 했는데요. 3주 차 미션에서는 2주 차에서 학습한 것에 2가지 목표를 추가했어요.
- 클래스(객체)를 분리하는 연습</br>
👉도메인 분리를 어떻게 해야 좋을지 계속 고민해보기
- 도메인 로직에 대한 단위 테스트를 작성하는 연습</br>
👉테스트 작업을 할 라이브러리를 학습할 기회!
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.</br>
  👉 그럼 우리는 else문을 사용하지 않고 바로 return을 사용해서 바로 종료하는 것을 연습하자
  - Java Enum을 적용한다.</br>
  👉 해당 클래스를 사용해서 로또 당첨 통계에 사용한다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 
  - 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
  - 단위 테스트 작성이 익숙하지 않다면 test/java/lotto/LottoTest를 참고하여 학습한 후 테스트를 구현한다.
  
## 🚀 기능 요구 사항
### [기능 목록]
- 구매 금액 입력 받기
  - [x] 구매 금액 입력 - LottoInputView#purchasePriceInput()
    - [x] 구매 금액 유효성 검사 - LottoInputInvalidator#
  - [x] 입력 받은 구매 금액 출력 - LottoOutputView#purchasePricePrint()
  - [x] (입력 받은 구매 금액 % 1000)을 1개로 구매 개수 구하기 - Lotto#purchaseAmountCalculator()
  - [x] 구매 개수 출력 - LottoOutputView#purchaseAmountPrint()
- 로또 번호 생성
  - [x] 6개의 랜덤한 수로 로또 번호 생성 - LottoNumbersGenerator#generateLottoNumbers()
  - [x] 로또 구매 개수 만큼 로또 번호 생성 - LottoGame#generateLottoTickets()
  - [x] 개수 만큼 생성한 로또 티켓 가져오기 - LottoGame#getLottoTickets()
  - [x] 생성한 로또 티켓들 번호 출력 - LottoOutputView#lottoTicketsPrint()
- 당첨 번호(winning numbers)
  - [x] 당첨 번호 입력 - LottoInputView#lottoWinningNumbersInput()
    - [x] 번호는 쉼표(,)를 기준으로 구분 - LottoInputValidator#lottoNumbersSplit
    - [x] 1 ~ 45까지의 번호만 허용 - LottoInputValidator#isNumberRangeValidation()
    - [x] 쉼표 기준으로 나눈 문자는 숫자만 허용 - LottoInputValidator#isNumericValidation()
    - [x] 보너스 번호를 포함한 당첨 번호 7개의 중복 확인 - LottoInputValidator#isDuplicationNumber
  - [x] 당첨 번호 출력 - LottoOutputView#winningNumbersPrint()
  - [x] 보너스 번호 입력 - LottoInputView#LottoWinningBonusNumbersInput()
  - [x] 보너스 번호 출력 - LottoOutputView#bonusNumberPrint()
- 당첨 결과 
  - 계산
    - [x] 당첨 번호 개수 계산 - LottoResultCalculator#countMatchedNumbers()
    - [x] 보너스 번호 여부 확인 - LottoResultCalculator#isMatchedBonusNumber()
    - [x] 당첨 번호가 5개일 때 보너스 번호 일치 여부 확인 - LottoController#
    - [x] 당첨률 결과 통계를 위한 데이터 정리 작업 - Lotto#
    - [x] 총 수익률 계산 - LottoResultCalculator#getRateOfReturn()
    - [x] 총 수익률 출력 - LottoOutputView#
  - 출력
    - [x] 당첨 결과 출력 - LottoOutputView#lottoWinningPrizeResultPrint()
    - [x] 당첨 결과 확률 출력 - LottoOutputView#lottoWinningPrizeRatePrint()

## 🔨테스트
### [기능별 테스트]

