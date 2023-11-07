# 우아한 테크코스 프리코스 #3 - 로또
## 기능 목록

### 로또 판매 시스템
- [X] 사용자가 입력한 구입 금액이 숫자인지 검사한다. - LottoSaleSystem#isValidMoney
- [X] 사용자가 입력한 구입 금액이 1000원 단위인지 검사한다. - LottoSaleSystem#isValidMoneyUnit
- [X] 사용자가 입력한 구입 금액에 해당하는 발행 횟수를 계산한다. - LottoSaleSystem#isValidMoney

### 로또 번호
- [X] 1개의 로또를 발행할 때 1-45 사이의 중복되지 않는 6개의 숫자를 뽑는다. - Lotto#generateLottoNumber
- [X] 구입 금액만큼 로또를 발행한다. - LottoController#generateLotto

### 당첨 번호
- [X] 당첨 번호를 6개 입력한다. - LottoController#EnterWinNumber
- [X] 당첨 번호는 1-45 사이의 중복되지 않는 6개의 숫자이어야 한다. - LottoWinnerSystem#isValidWinNumber

### 보너스 번호
- [X] 보너스 번호를 1개 입력한다. - LottoController#EnterBonusNumber
- [X] 보너스 번호는 당첨 번호와 중복되지 않아야 한다. - LottoWinnerSystem#isValidBonusNumber

### 당첨
- [X] 발행한 로또 번호가 당첨 번호와 몇 개 일치하는지 검사한다. - LottoWinnerSystem#getMatchNumberCount
- [X] 일치하는 번호 개수에 따라 당첨 결과를 알려준다. - LottoWinnerSystem#printLottoResult

### 수익률
- [X] 발행한 로또를 통해 얻은 당첨 금액을 계산한다. - LottoWinnerSystem#calculateProfitMoney
- [X] ( 당첨 금액 / 구입 금액 ) * 100 을 통해 수익률을 계산한다. (소수점 둘째 자리에서 반올림 할 것) - LottoSaleSystem#calculateProfit

### 예외 사항
- [X] 사용자가 로또 구입 금액을 1000원 단위로 입력하지 않는 경우 예외 처리한다.
- [X] 당첨 번호를 입력 받을 때 1-45 범위를 벗어나거나 또는 6개의 번호가 아닐 시 예외 처리한다.
- [X] 보너스 번호를 입력 받을 때 1-45 범위를 벗어나거나 또는 1개의 번호가 아니거나 또는 당첨 번호와 중복될 시 예외 처리한다.
- [X] 예외 처리할 때는 "[ERROR]"로 시작하는 에러 문구를 출력해야 하고, 그 부분부터 입력을 다시 받는다.

### 프로그래밍 요구 사항
- [X] 함수의 길이가 15라인을 넘어가지 않도록 구현한다.
- [X] else 예약어를 사용하지 않는다.
- [X] Java Enum을 적용한다.
- [X] UI 로직을 제외한 도메인 로직에 단위 테스트를 구현해야 한다.
  - [X] 핵심 로직과 UI 담당 로직을 분리하여 구현한다.
- [X] Lotto 클래스를 활용해야 한다.
  - [X] numbers의 접근 제어자인 private을 변경하지 않아야 한다.
  - [X] Lotto에 필드를 추가하지 않아야 한다.









