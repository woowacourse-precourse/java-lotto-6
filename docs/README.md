# 구현 기능 목록

- - -

## 입력 기능

- [ ] 로또 구입 금액

  로또 구입 금액은 1,000원 단위의 양의 정수여야 한다.

- [ ] 당첨 번호

  당첨번호는 (1~45)숫자+쉼표로 이루어지고 6개여야 한다.

- [ ] 보너스 번호

  보너스 번호는 (1~45)숫자 1개다.

- - -

## 출력 기능

- [x] 구입 금액 요청 메시지

  구입금액을 입력해 주세요.

- [x] 구입한 로또 수량

  n개를 구매했습니다.

- [x] 로또 발행 번호(오름차순, 중복되지 않음)

  [8, 21, 23, 41, 42, 43]
  [3, 5, 11, 16, 32, 38]
  [7, 11, 16, 35, 36, 44]
  [1, 8, 11, 31, 41, 42]
  [13, 14, 16, 38, 42, 45]
  [7, 11, 30, 40, 42, 43]
  [2, 13, 22, 32, 38, 45]
  [1, 3, 5, 14, 22, 45]

- [x] 당첨 번호 요청 메시지

  당첨 번호를 입력해 주세요.

- [x] 보너스 번호 요청 메시지

  보너스 번호를 입력해 주세요.

- [x] 당첨 통계 메시지

  당첨 통계

- [x] 당첨 결과

    ---
  3개 일치 (5,000원) - 1개
  4개 일치 (50,000원) - 0개
  5개 일치 (1,500,000원) - 0개
  5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
  6개 일치 (2,000,000,000원) - 0개

- [x] 수익률 결과

  총 수익률은 62.5%입니다.

- - -

## 동작 기능

| Package             | Rule   | Class                 | Rule        |
|---------------------|--------|-----------------------|-------------|
| lotto               | 로또게임   | Application           | 게임시작        |
| game                | 게임진행   | LottoGame             | 로또게임 진행     |
| lottoTicketPurchase | 로또티켓구매 | LottoTicketPurchase   | 로또티켓구매      |
|                     | ㄴ      | LottoTicketQuantity   | 로또티켓수량 계산   |
|                     | ㄴ      | UserLottoNumbers      | 사용자 로또번호 생성 |
| lottoWinningNumber  | 로또당첨번호 | BonusNumberInput      | 보너스번호 입력    |
|                     | ㄴ      | Lotto                 | 당첨번호 검증     |
|                     | ㄴ      | WinningNumberInput    | 당첨번호 입력     |
| lottoResult         | 로또결과   | LottoResultCalculator | 로또결과 계산     |
|                     | ㄴ      | LottoResultDisplay    | 로또결과 출력     |
| lottoProfit         | 로또수익   | ProfitResultDisplay   | 로또수익 출력     |
|                     | ㄴ      | ProfitCalculator      | 수익 계산       |
| base                | 기초     | Converter             | 변환 기능       |
| constant            | 상수     | ErrorMessage          | 에러메시지 모음    |
|                     | ㄴ      | GeneralMessage        | 일반메시지 모음    |
|                     | ㄴ      | Number                | 숫자 모음       |
|                     | ㄴ      | RequestMessage        | 요청메시지       |
|

- - -

## 예외 발생 케이스

### 1. 로또 구입 금액을 입력할 때

- [x] 1000원으로 나누어 떨어지지 않을 때

  // IllegalArgumentException 발생
  [ERROR] 구입 금액은 1000원 단위여야 합니다. 다시 입력하세요.
  // '로또 구입 금액 입력'으로 돌아가기

- [ ] 양의 정수가 아닐 때

  // IllegalArgumentException 발생
  [ERROR] 1000원 이상만 구매 가능합니다. 다시 입력하세요.
  // '로또 구입 금액 입력'으로 돌아가기

### 2. 당첨 번호를 입력할 때

- [ ] 숫자가 아닐 때

  // IllegalArgumentException 발생
  [ERROR] 숫자만 가능합니다. 다시 입력하세요.
  // '보너스 번호 입력'으로 돌아가기

- [ ] 값이 null값이거나 공백이 포함되어 있을 때

  // IllegalArgumentException 발생
  [ERROR] 당첨번호는 숫자와 쉼표로만 입력이 가능합니다. 다시 입력하세요.
  // '당첨 번호 입력'으로 돌아가기

- [ ] 숫자가 맞지만, 번호가 1~45 범위가 아닐 때

  // IllegalArgumentException 발생
  [ERROR] 1부터 45 사이의 숫자만 가능합니다. 다시 입력하세요.
  // '당첨 번호 입력'으로 돌아가기

- [X] 숫자가 맞지만, 당첨 번호가 6개가 아닐 때

  // IllegalArgumentException 발생
  [ERROR] 입력된 번호가 6개가 아닙니다. 다시 입력하세요.
  // '당첨 번호 입력'으로 돌아가기

- [ ] 숫자가 맞지만, 중복되는 숫자가 있을 때

  // IllegalArgumentException 발생
  [ERROR] 중복되는 번호가 있습니다. 다시 입력하세요.
  // '당첨 번호 입력'으로 돌아가기

### 3. 보너스 번호를 입력받을 때

- [ ] ‘당첨 번호’와 숫자가 중복될 때

  // IllegalArgumentException 발생
  [ERROR] 당첨 번호와 중복됩니다. 다시 입력하세요.
  // '보너스 번호 입력'으로 돌아가기

- [ ] 숫자가 맞지만, 번호가 1~45 범위가 아닐 때

  // IllegalArgumentException 발생
  [ERROR] 1부터 45 사이의 숫자만 가능합니다. 다시 입력하세요.
  // '보너스 번호 입력'으로 돌아가기

- [ ] 숫자가 아닐 때

  // IllegalArgumentException 발생
  [ERROR] 숫자만 가능합니다. 다시 입력하세요.
  // '보너스 번호 입력'으로 돌아가기

- - -

## 과제 체크리스트

### 🅾️ 해야 한다! 🅾️

- [x] 기능을 구현 하기 전에 기능 목록을 만들었는가?
- [x] 기능 단위로 커밋 했는가?
- [x] Java 버전이 17인가?
- [x] Java 코드 컨벤션 가이드를 준수했는가?
- [ ] 함수/메서드가 한 가지 일만 하는가?
- [ ] JUnit 5와 AssertJ를 이용 하여 테스트 코드를 통해 기능 동작을 하였는가?
- [x] Java Enum을 적용했는가?
- [ ] 도메인 로직에 단위 테스트를 구현했는가? (UI: System.out, System.in, Scanner)는 제외
- [ ] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현하였는가?
- [x] Random값 추출은 `camp.nextstep.edu.missionutils.Randoms`의`pickUniqueNumbersInRange()`를 활용 했는가?
- [x] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의`readLine()`을 활용 했는가?
- [x] 제공된 Lotto 클래스를 활용해 구현했는가?

### ❎ 하면 안된다! ❎

- [ ] indent depth를 3이상 쓰지 않았는가?
- [x] 3항 연산자를 쓰지 않았는가?
- [ ] 함수/메서드가 15라인을 넘지 않는가?
- [x] else 예약어를 쓰지 않았는가?
- [x] switch/case 를 쓰지 않았는가?
- [x] Lotto에 필드(인스턴스 변수)를 추가하지 않았는가?
- [x] Lotto의 `numbers` 접근제어자인 private를 변경하지 않았는가?