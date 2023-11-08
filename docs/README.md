# [구현 기능 목록]
## *3주차 목표: 클래스 분리 & 도메인 로직 단위 테스트* 


##  유저입력 Class - `UserInput`
  - 구입금액 입력하기 (getPurchaseAmount())
    - 1000원 단위로 나누어 떨어지지 않는 경우, 예외처리 (validatePurchaseAmount()) [V] 
      1. 명확한 에러 유형 처리 [V]
      2. 예외 상황 시  에러문구 "[ERROR]" 출력 [V]
      3. 오류 부분부터 다시 입력값 받기 [V]
  - 당첨번호 입력하기 + 예외처리 (getWinningNumbers()) [V]
    - 쉼표 기준으로 구분팅 (splittedWinningNumbersInput) [V]
    - 오름차순으로 정렬 (sortWinningNumbers()) [V]
    - 중복되지 않는 (validateDuplicates()) [V]
    - 6개 숫자 (validateWinningNumbers())[V]
  - 보너스 번호 입력하기 + 예외처리 (getBonusNumber())[V]
    - 당첨번호 6개와 중복되지 않는 숫자 (validateBonusNumber(), checkOverlapWithWinningNumber()) [V]

## 로또 객체 `Lotto` Class - *Lotto 클래스 활용!*
  - 로또 번호가 6개인지 검증 (validate()) [V]
  - 생성된 로또의 번호 가져오기(getLottoNumbers()) [V]

## 입력값으로 계산 및 처리 Class - `Process`
  - 구입금액에서 로또 개수 계산하기 (countLottos()) [V]
  - 로또 개수만큼 로또 번호 발행하기 (generateLottoNumbers()) [V]
    - 각 로또 당 중복되지 않는 6개 숫자 (Randoms.pickUniqueNumbersInRange()) [V]
  - 구입 개수만큼 생성된 로또 저장하기 (saveLottos()) [V]
    - 오름차순으로 번호 정렬 (sortLottoNumbers()) [V]
  - 당첨 내역 처리
    - 로또 당첨 내역 기록 (recordWins()) [V]
      - 로또 번호와 당첨 번호 비교 (compareLottos()) [V]
  - 수익률 계산하기 (calculateRateOfReturn()) [V]
    - 소수점 둘째 자리에서 반올림 (.1f) [V]

## 처리값 출력하기 Class - `Print`
  - 로또 구매 개수 출력하기 (printLottoCount())[V]
  - 구매한 로또 번호 출력하기 (오름차순 정렬) (printLottos()) [V]
    - 로또 개수만큼 반복 [V]
  - 당첨 통계 출력하기 (printWinStatistic()) [V]
  - 총 수익률 출력하기 (printRateOfReturn()) [V]

## 로또 열거형 enum `WinningRankPrize` => 일치 개수 번호 & 상금 쌍 열거?
  - 각 등수를 열거형 객체로 [V]
    - 등수 [V]
    - 당첨 횟수 [V]
    - 번호 일치 개수 [V]
    - 등수별 상금 [V]


<hr/> 

### *요구 사항*
**(추가요구사항)**
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- Java Enum을 적용한다.

**(기존 요구사항)**
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다. 
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다. 
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

<hr/> 

### *라이브러리*
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.




