# 미션 - 로또
---

#### 입력

사용자 입력 :
- 로또 구입 금액
  ```
  구입금액을 입력해 주세요.
  ```
  - 에러 : 1,000원으로 나누어 떨어지지 않는 경우, 문자열을 입력한경우, 아무것도 입력하지 않은경우

- 당첨 번호 (쉼표 기준으로 구분)
  ```
  당첨 번호를 입력해 주세요.
  ```
  - 에러 : 아무것도 입력하지 않았을 경우, 문자열을 입력했을 경우, 쉼표로 구분하지 않았을 경우, 6자미만으로 입력했을 경우, 6자를 초과했을 경우, 로또 번호의 숫자범위를 벗어났을 경우

- 보너스 번호 입력
  ```
  보너스 번호를 입력해 주세요.
  ```
  - 에러 : 아무것도 입력하지 않았을 경우, 문자열을 입력했을 경우, 로또 번호의 숫자범위를 벗어났을 경우, 당첨번호랑 중복되는 경우


#### 결과

- 로또 수량 및 번호 출력 (로또 번호는 오름차순 정렬) / 중복 안 됨

```
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
```

- 당첨 내역을 출력

```
 당첨 통계
 ---
 3개 일치 (5,000원) - 1개
 4개 일치 (50,000원) - 0개
 5개 일치 (1,500,000원) - 0개
 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
 6개 일치 (2,000,000,000원) - 0개
```

- 수익률 출력 (소수점 둘째자리에서 반올림)

```
총 수익률은 62.5%입니다.
```

#### 에러 처리 :
에러 문구는 "[ERROR]"로 시작

```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```
---
## 🚀 클래스별 기능정리

### UserHandler : 사용자의 입력부분을 처리하는 클래스
- getAmountFromUser() : 사용자 구매입력을 받는 메서드
- validateUserInput(String userInput) : 에러 처리 후 구매입력을 반환하는 메서드
  - checkStartWithZero(String userInput) : 0으로 시작하는 숫자의 에러를 처리하는 메서드
  - checkNumericString(String userInput) : 문자열의 에러를 처리하는 메서드
  - checkUnitAmount(int amount) : 1000원 단위인지 검사 후 에러를 처리하는 메서드

- 사용자의 구매입력 가격을 계산후(에러처리후) LottoGameController 클래스에 몇개 구매했는지 반환
  
- getWinningNumberFromUser() : 사용자로 부터 당첨 번호를 받는 메서드
- 에러 처리 메서드 : 아무것도 입력하지 않았을 경우, 문자열을 입력했을 경우, 쉼표로 구분하지 않았을 경우, 6자가아닌경우, 로또 번호의 숫자범위를 벗어났을 경우
- 당첨 번호들을
- getBonusNumberFromUser() : 사용자로부터 보너스 번호를 받는 메서드
- validateBonusNumberInput(String BonusNumberInput) : 보너스 번호의 입력을 받는 부분의 에러처리 후 보너스 넘버를 리턴하는 메서드
- 에러 처리 메서드: 아무것도 입력하지 않았을 경우, 문자열을 입력했을 경우, 로또 번호의 숫자범위를 벗어났을 경우, 1자가 아닌경우
  
### ResultView : 결과 출력 클래스
- printLottoCount(int lottoCount) : 로또 개수 반환받아서 사용자의 로또 구매 개수를 출력하는 메서드
- printLottoNumber(List<Integer> numbers) : 생성된 로또 숫자를 출력하는 메서드
- printNewLine() : 출력시 필요한 줄바꿈 메서드

### Lotto : 로또난수 생성하는 클래스
- validate(List<Integer> numbers) : 6자가 아닌 경우 에러 반환
- Lotto(List<Integer> numbers) : 로또번호 6자를 생성하는 생성자
- getNumbers() : numbers 필드의 값을 반환
- 3개 일치하는 경우 출력 메서드
- 4개 일치하는 경우 출력 메서드
- 5개 일치하는 경우 출력 메서드
- 5개 + 보너스 출력 메서드
- 6개 출력 메서드
- UserHandler클래스에서 반환된 개수 * 일치하는 메서드 = 총수익률 출력 메서드
  
### LottoGameController : 로또번호의 메인 로직을 담당하는 클래스
- UserHandler클래스에서 반환된 개수로 로또 개수만큼 무작위 생성후 ResultView 클래스로 던져 결과출력
- buyLottos() : 사용자가 구매할 로또의 개수(lottoCount)만큼 로또를 생성하는 기능
- lottoGenerate() : 1부터 45까지의 범위에서 무작위 숫자 리스트로 만들고, 이 리스트를 Lotto 클래스의 생성자에 전달하여 Lotto 객체를 생성
- 무작위로 로또 생성한 뒤 getWinningNumberFromUser()의 당첨번호들이 3개가 있는지 검사하는 로직 (일치하면 개수를 ResultView로 반환)
- 무작위로 로또 생성한 뒤 getWinningNumberFromUser()의 당첨번호들이 4개가 있는지 검사하는 로직 (일치하면 개수를 ResultView로 반환)
- 무작위로 로또 생성한 뒤 getWinningNumberFromUser()의 당첨번호들이 5개가 있는지 검사하는 로직 (일치하면 개수를 ResultView로 반환)
- 무작위로 로또 생성한 뒤 getWinningNumberFromUser()의 당첨번호들이 5개 + 보너스 볼이 일치하는지 검사하는 로직 (일치하면 개수를 ResultView로 반환)
- 무작위로 로또 생성한 뒤 getWinningNumberFromUser()의 당첨번호들이 6개가 일치하는지 검사하는 로직

### Rank : 로또의 당첨 등수와 그에 따른 상금을 정의하는 클래스
- FIRST, SECOND, THIRD, FOURTH, FIFTH: 각 등수를 나타내며, 각 등수는 일치하는 번호의 개수와 상금을 가지고 있음
- getMatchCount(): 이 enum 상수가 가지고 있는 일치하는 번호의 개수를 반환 
- getWinningMoney(): 이 enum 상수가 가지고 있는 상금을 반환
- valueOf(int MatchCount, boolean matchBonus): 주어진 일치하는 번호의 개수와 보너스 번호의 일치 여부를 기반으로 적절한 등수를 반환 
- determineRank(int MatchCount, boolean matchBonus): 주어진 일치하는 번호의 개수와 보너스 번호의 일치 여부를 기반으로 적절한 등수를 반환 
- getRankForFiveMatches(boolean matchBonus): 보너스 번호가 일치하면 SECOND를, 일치하지 않으면 THIRD를 반환

---

## 🎯 프로그래밍 요구 사항
- Java 코드 컨벤션 가이드 준수
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용
- 3항 연산자를 쓰지 않음
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인

- else 예약어를 쓰지 않음
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현
- Java Enum을 적용한다.
- 도메인 로직에 단위 테스트를 구현


### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console`
  API를 사용하여 구현해야 한다.
    - Random 값 추출
    ```java
    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    ```
    - 사용자가 입력하는 값
    ```java
    `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
    ```

---

