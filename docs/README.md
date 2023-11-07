# 지켜야할 규칙
### ```1. 한 클래스가 하나의 책임을 지게 하기.```
### ```2. 메서드는 한 가지 일만 하게 하기.```
### ```3. 커밋 메시지 컨벤션 지키기```
### ```4. 코드 간결하게 작성하기```
### ```5. else 예약어 사용하지 않기```
### ```6. indent depth 최대한 1까지만 허용하기```
### ```7. Stream 사용해보기```
### ```8. TDD 사이클 지키기```

# 구현 순서
## 1. 기능 구현
1. 지불 금액 입력 받기
2. 지불 금액 액수 만큼 로또 발행하기
3. 당첨 번호 입력 받기
4. 보너스 번호 입력 받기
5. 당첨 번호와 로또 번호 비교하기
6. 당첨 결과 출력하기
7. 수익률 계산하기
8. 수익률 출력하기
## 2. 패턴 분할
### 1. Model
- LottoModel
### 2. View
- LottoView
- InputView
### 3. Controller
- LottoController
- InputManger
### 4. Utils
- Messages
- LottoRank
## 3. 리팩토링

### 1. 데이터 비즈니스 및 로직 관련 함수 LottoModel클래스로 옮기기
- calculateCountOfLotto()
- generateLottoTickets()
- checkWinningStatistics()
- checkLottoNumber
- createLotto()
- updateWinningLottoNumbers
- addBonusNumber

### 2. View 관련 함수 LottoView 클래스로 옮기기

- printMessage(String message)
- displayPurchasedLottoTickets(int countOfLotto, List<Lotto> lottoNumbers)
- formatLottoNumbers(List<Integer> lottoNumbers)
- printWinningStatistics(Map<LottoRank, Integer> statistics)
- printTotalEarnings(String earningsRateText)

### 3. Input 관련 함수 InputManger 클래스로 옮기기

- promptForPayment(String message)
- getValidPayment(String message)
- displayMessage(String message)
- validatePayment(int payment)

### 4. 문자열 상수 Messages 클래스로 옮기기

- INPUT_MONEY = "구입금액을 입력해 주세요."
- INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
- INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
- WINNING_STATISTICS = "당첨 통계"
- SIX_MATCHES = "6개 일치 (2,000,000,000원)"
- FIVE_BONUS_MATCHES = "5개 일치, 보너스 볼 일치 (30,000,000원)"
- FIVE_MATCHES = "5개 일치 (1,500,000원)"
- FOUR_MATCHES = "4개 일치 (50,000원)"
- THREE_MATCHES = "3개 일치 (5,000원)"
- UNDER_BAR = "---"
- NumberInputError = "[ERROR] 숫자를 입력해야 합니다."
- NonPositiveAmountException = "[ERROR] 금액은 0 이상이어야 합니다."
- NonMultipleOfThousandException = "[ERROR] 금액은 1000원 단위여야 합니다."
- NonUniqueLottoNumberException = "[ERROR] 로또 번호는 중복될 수 없습니다."
- LottoNumberOutOfRangeException = "[ERROR] 로또 번호는 1~45 사이여야 합니다."

### 5. LottoRank enum 클래스 생성

- FIRST(6, 2_000_000_000)
- SECOND(5, 30_000_000)
- THIRD(5, 1_500_000)
- FOURTH(4, 50_000)
- FIFTH(3, 5_000)
- NONE(0, 0)
- valueOf(int matchCount, boolean bonusMatch)

### 6. MessagePrinter 인터페이스 생성

- printMessage(String message)

### 7. LottoTest 클래스 수정

#### 1. 테스트 추가
- "중복된 숫자가 있을 때 예외를 발생시킨다"
- "숫자 범위가 유효하지 않을 때 예외를 발생시킨다"

### 8. LottoModelTest 클래스 생성

#### 1. 테스트 추가

- "당첨 번호를 업데이트 한다"
- "보너스 번호를 추가한다"
- "당첨 통계를 검사한다"

### 9. InputManagerTest 클래스 생성

#### 1. 테스트 추가

- "결제 금액이 음수이면 IllegalArgumentException을 던진다"
- "결제 금액이 1000원의 배수가 아니면 IllegalArgumentException을 던진다"
- "유효한 결제 금액이면 예외를 던지지 않는다"
- "보너스 번호가 유효한지 검사한다"




