# 🎰 우테코 프리코스 3주차 - 로또

우테코 프리코스 3주차 미션인 **로또** 는 사용자에게 `금액` `당첨 번호` `보너스 번호`를 입력받아 랜덤으로 뽑힌 로또 전체의 결과를 계산해주는 프로젝트 입니다.

구현한 기능 목록 부터 실행 방법 및 예시를 보여드리고, 이번 주차 프로젝트를 통해 배울 수 있었던 것을 기록해 보았습니다.

---

## 🔍 목차

- ⚙️ 구현 기능 목록
- 📋 프로젝트 구조
- 🚀 실행 방법 및 예시
- ✨ 이번 주차에 배운 것

---

## ⚙️ 구현 기능 목록

### 1️⃣ 로또 구입 금액 입력

**✔️ 정상 동작**

- [X] `1000` 의 배수를 문자열로 입력 받고 정수로 변환

**⚠️ 예외 상황**

- [X] 숫자가 아닐 경우
- [X] 구입 금액이 음수일 경우
- [X] 잔돈이 발생할 경우

### 2️⃣ 로또 수량 출력

**✔️ 정상 동작**

- [X] `8개를 구매했습니다.` 와 같이 구입 금액에 따라 로또 개수를 출력

### 3️⃣ 로또 번호 출력

**✔️ 정상 동작**

- [X] `[8, 21, 23, 41, 42, 43]` 와 같이 로또 번호 범위 `1 ~ 45` 내의 서로 다른 숫자들을 한 라인으로 로또 수량 만큼 라인으로 출력

**⚠️ 예외 상황**

- [X] 개수 `6` 개가 아닐 경우
- [X] 중복된 숫자가 존재할 경우
- [X] 범위 밖의 숫자가 있을 경우
- [X] 오름차순 정렬되지 않은 경우

### 4️⃣ 당첨 번호 입력

**✔️ 정상 동작**

- [X] 입력받은 문자열을 구분 기호 기준으로 분리
- [X] 분리된 문자열들을 정수로 변환

**⚠️ 예외 상황**

- [X] 분리된 문자열이 정수로 변환할 수 없는 문자열일 경우
- [X] 분리된 값의 개수가 지정된 로또 번호 개수 `6` 와 다를 경우
- [X] 변환된 값이 로또 번호 범위 내의 값이 아닐 경우

### 5️⃣ 보너스 번호 입력

**✔️ 정상 동작**

- [X] 번호 범위 `1 ~ 45` 내의 수를 문자열로 입력 받고 정수로 변환

**⚠️ 예외 상황**

- [X] 정수로 변환할 수 없는 문자열일 경우
- [X] 범위 밖의 숫자일 경우
- [X] 당첨 번호와 중복될 경우

### 6️⃣ 당첨 통계 출력

**✔️ 정상 동작**

- [X] `당첨 통계` 와 `---` 문구 출력
- [X] 아래와 같이 일치 개수에 따른 금액(천 단위로 구분)과 당첨된 로또의 개수를 출력
    - `3개 일치 (5,000원) - 1개`
    - `4개 일치 (50,000원) - 0개`
    - `5개 일치 (1,500,000원) - 0개`
    - `5개 일치, 보너스 볼 일치 (30,000,000원) - 0개`
    - `6개 일치 (2,000,000,000원) - 0개`

### 7️⃣ 수익률 출력

**✔️ 정상 동작**

- [X] `총 수익률은 62.5%입니다.` 와 같이 소수점 둘째 자리에서 반올림 하여 출력

---

## 📋 프로젝트 구조

### 📦 패키지

<table>
    <tr>
        <th>Package</th>
        <th>Class</th>
        <th>Description</th>
    </tr>
    <tr>
        <td rowspan="4">
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/constants.svg?sanitize=true"/>
            <b> constant</b>
        </td>
        <td><b>Config</b></td>
        <td>프로그램 진행에 필요한 정적 값, 변경 시 유연한 확장 가능</td>
    </tr>
    <tr>
        <td><b>ErrorMessage</b></td>
        <td>예외 상황에 사용 되는 정적 메세지</td>
    </tr>
    <tr>
        <td><b>GeneralMessage</b></td>
        <td>일반 적인 입력 요청 또는 결과 알림에 사용 되는 메세지</td>
    </tr>
    <tr>
        <td><b>RankMessage</b></td>
        <td>로또 당첨 내역들에 대한 메세지</td>
    </tr>
    <tr>
        <td rowspan="2">
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/controllers.svg?sanitize=true"/>
            <b> controller</b>
        </td>
        <td><b>RankMachine</b></td>
        <td>랜덤 로또 티켓들을 검사하여 당첨 결과를 얻을 수 있는 컨트롤러</td>
    </tr>
    <tr>
        <td><b>SlotMachine</b></td>
        <td>전체적인 로또 프로그램의 동작을 담당해주는 메인 컨트롤러</td>
    </tr>
    <tr>
        <td rowspan="6">
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/home.svg?sanitize=true"/>
            <b> domain</b>
        </td>
        <td><b>BonusNumber</b></td>
        <td><code>LottoNumber</code> 와 동일하지만 당첨 번호와의 중복을 피하는 도메인</td>
    </tr>
    <tr>
        <td><b>BuyPrice</b></td>
        <td>구입 금액을 담당하고 몇개를 살 수 있는지를 알려주는 도메인</td>
    </tr>
    <tr>
        <td><b>Lotto</b></td>
        <td><code>LottoNumber</code> 를 요소로 하는 일급 컬렉션, 랜덤으로 로또 번호를 생성하며 다른 <code>Lotto</code> 객체와 비교하여 동일한 번호의 개수를 구할 수 있는 도메인</td>
    </tr>
    <tr>
        <td><b>LottoNumber</b></td>
        <td>로또 번호 내의 범위 값인지 검증 하여 <code>Integer</code> 하나를 가지는 도메인</td>
    </tr>
    <tr>
        <td><b>Rank</b></td>
        <td>당첨 조건과 보상 및 메세지를 의미하는 도메인</td>
    </tr>
    <tr>
        <td><b>Tickets</b></td>
        <td><code>Lotto</code> 도메인을 요소로 하는 일급 컬렉션, 티켓 장수 만큼 여러 티켓들을 생성하는 도메인</td>
    </tr>
    <tr>
        <td rowspan="2">
            <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/views.svg?sanitize=true"/>
            <b> view</b>
        </td>
        <td><b>InputView</b></td>
        <td>사용자에게 질문을 하고 입력을 받아주는 뷰</td>
    </tr>
    <tr>
        <td><b>OutputView</b></td>
        <td>사용자에게 일반적인 메세지 와 결과 및 에외 메세지를 출력해주는 뷰</td>
    </tr>
</table>

### 🔥 동작 과정

![](https://velog.velcdn.com/images/chch1213/post/3c62637a-91e7-4937-8d24-59fb82d96e5d/image.png)

---

## 🚀 실행 방법 및 예시

1. 먼저 `☕ Java 17` 버전과 `IntelliJ, VSCode, Gradle` 중 하나를 통해 `Application.java`를 `📟 Console`로 실행해주세요!
2. 구입금액 질문이 보이신다면 `1000` 원 단위의 금액을 입력해주세요. 예시: `8000`
3. 입력하신 금액 만큼 구매한 로또 개수와 로또 티켓들의 번호가 출력되었는지 확인합니다.
4. 로또 추첨을 위해 `6` 개의 중복되지 않는 당첨 번호 숫자를 공백 없이 `,`로 구분하여 입력합니다. 예시: `1,2,3,4,5,6`
5. 보너스 번호 또한 당첨 번호와 중복되지 않는 숫자로 입력합니다. 예시: `7`
6. 당첨통계로 순위에 따른 금액과 당첨 개수 및 수익률을 확인합니다.

```
구입금액을 입력해 주세요.
12000

12개를 구매했습니다.
[3, 13, 26, 30, 42, 44]
[5, 12, 18, 24, 30, 35]
[18, 28, 30, 32, 44, 45]
[18, 22, 41, 42, 44, 45]
[6, 17, 22, 23, 37, 44]
[15, 20, 22, 28, 44, 45]
[8, 11, 24, 28, 32, 37]
[7, 25, 26, 27, 30, 32]
[6, 10, 26, 32, 36, 38]
[2, 12, 15, 20, 21, 32]
[3, 16, 22, 25, 32, 45]
[6, 10, 15, 20, 25, 40]

당첨 번호를 입력해 주세요.
18,22,30,42,44,45

보너스 번호를 입력해 주세요.
18

[ERROR] 보너스 번호는 당첨 번호에 포함 되어있지 않아야 합니다.
보너스 번호를 입력해 주세요.
41

당첨 통계
---

3개 일치 (5,000원) - 2개
4개 일치 (50,000원) - 1개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 250,500.0%입니다.
```

---

## ✨ 이번 주차에 배운 것

### 💡 MVC 패턴

- 2주차에 처음 사용해본 MVC 패턴에서 `Controller` 를 1개만 사용했었습니다.
- `Model` 에서 최대한 모든 것을 처리 하려고 하니 더욱 복잡해져서 아에 `Controller` 를 하나 더 만들고 `Rank` 모델을 사용하도록 하니 메인 컨트롤러가 부담하는 일을 줄이며 모듈화를 효율적으로
  할 수 있었습니다.
- 요구사항이 많아지며 프로젝트가 복잡해짐에 따라 연결 관계가 더욱 깊어지는데 도메인 로직의 경계선을 잘 유지하며 `Controller` 나 `Model` 을 만드는 것이 중요하다는 것을 알게 되었습니다.
- `Java 14` 버전부터 도입된 `record` 는 `final class` 를 대신하여 코드를 줄이고 `DTO` 역할을 할 수 있다는 것을 알게되었고, 이를 도메인 위치에서 총 `3` 개의 `record` 를
  만들었습니다.
- `record` 를 통해 중복 구조의 코드들 `boilerplate code` 를 최소화 하며 새로운 불변 데이터가 있을 때 반복하는 작업을 줄일 수 있었습니다.
  ``` java
  public record LottoNumber(int number) {
      public LottoNumber {
          validateInRange(number);
      }
  
      ...

      private static void validateInRange(int number) {
          if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
              throw new IllegalArgumentException(LOTTO_NOT_IN_RANGE);
          }
      }
  }
  ```

### 💡 TDD - 테스트 주도 개발

- 2주차 공통 피드백에서 `처음부터 큰 단위의 테스트를 만들지 않는다` 에 초점을 두어 `Model` 이 하나 생성되며 생기는 검증 함수들 마다의 테스트를 하도록 구성하였습니다.
- 솔직한 마음으로 2주차의 테스트 코드 작성 때에도 도메인 객체의 자료구조를 바꾸는 작업 외에는 큰 이점을 누리지 못했습니다.
- 3주차 과제를 진행할 때에는 생각보다 오류가 많이 생겨 테스트 코드의 이점을 확실히 느낄 수 있었습니다.
- 예외 메세지를 잘못 사용하는 사소한 실수에서 부터 함수형 인터페이스를 인자로 받는 함수 작성과 같이 깊이 있는 코드를 사용할 때에 `실행 > 입력 > 결과 확인` 과 같은 진행 방도를 `버튼 클릭` 으로 확인할
  수 있어서 시간 절약에 굉장히 큰 기여를 하였습니다.
- 개발이 끝나고 폴더를 우클릭하여 모든 테스트를 실행시켜 전체 통과하는 그 짜릿함은 코딩을 더욱 재밌게 해주는 요소인 것 같습니다.
- 중간에 값의 변화를 체크할 때 디버깅도 좋은 방안이지만 코드 중간에 콘솔 출력으로 값의 변화를 기록하며 확인할 수 있다는 것이 실제 코드를 수정하지 않고도 가능하다는 것이 굉장히 매력적이었습니다.
  ``` java
    @Test
    @DisplayName("5개의 랭크에 대해 정상 출력 되는지")
    void getWinningStatistics() {
        RankMachine rankMachine = createRankMachine();
        applySampleTickets(rankMachine);

        System.out.println(rankMachine.getRankStatistics());
        assertThat(rankMachine.getRankStatistics())
                .contains(
                        "3개 일치 (5,000원) - 7개",
                        "4개 일치 (50,000원) - 4개",
                        "5개 일치 (1,500,000원) - 2개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 3개",
                        "6개 일치 (2,000,000,000원) - 1개"
                );
    }
  ```

### 💡 함수형 인터페이스

- 로또 당첨 조건을 어떻게 처리할 것인지에 대해 고민을 정말 많이 했었습니다.
- `Model` 내부에서 `if` 문 또는 `switch` 문을 써서 여러개로 처리할 쪽으로만 생각 했었는데 더 좋은 방법이 있을 것 같아 얕게 알고 있던 `함수를 변수 처럼 써서 인자로 넘기는 법` 에 대해 더욱
  공부하여 사용해 보려고 노력했습니다.
- `Test` 코드 작성시에도 예외가 생기는지 체크하는 `assertThatThrownBy` 를 `assertThat` 과는 다르게 함수를 인자로 넘겨 실행 결과에서 `Exception` 이 생기는지 체크하는
  것이였습니다.
- 이를 생각해보며 어떠한 객체가 여러개의 당첨들을 판별해주는 조건 함수를 가지고 있다가 로또 번호가 들어오면 비교해서 몇등인지 알려주는 것을 생각했습니다.
- 아래는 체크할 로또 번호와 당첨 로또 번호 및 보너스 번호를 가지고 `Ture` or `False` 를 알려주는 `TriFunction<Lotto, Lotto, BonusNumber, Boolean>` 함수와
  메세지 및 상금을 지니고 있는 `Rank` 레코드를 의미합니다.
  ``` java
  /**
  * @param message          String to be formatted
  * @param reward           Amount of award
  * @param winningPredicate First Lotto: Checking ticket,
  *                         Second Lotto: Winning ticket,
  *                         BonusNumber: Bonus number
  */
  public record Rank(
              RankMessage message,
              long reward,
              TriFunction<Lotto, Lotto, BonusNumber, Boolean> winningPredicate) {
      public Rank {
          validatePositiveReward(reward);
      }
  
      private static void validatePositiveReward(long reward) {
          if (reward < 0) {
              throw new IllegalArgumentException(PRICE_NEGATIVE);
          }
      }
  }
  ```
- 이 레코드를 `SlotMachine` 컨트롤러에서 `Rank` 들을 아래와 같이 생성하여 `RankMachine` 에 담아 두고 결과 반환에 사용합니다.
  ``` java
  public class SlotMachine {

      ...
  
      private static RankMachine createRankMachine() {
          return new RankMachine(List.of(
                  new Rank(RANK_FIFTH, REWARD_FIFTH, (ticket, winningTicket, bonusNumber) ->
                          ticket.countMatched(winningTicket) == 3),
                  new Rank(RANK_FOURTH, REWARD_FOURTH, (ticket, winningTicket, bonusNumber) ->
                          ticket.countMatched(winningTicket) == 4),
                  new Rank(RANK_THIRD, REWARD_THIRD, (ticket, winningTicket, bonusNumber) ->
                          ticket.countMatched(winningTicket) == 5 && !ticket.hasNumber(bonusNumber.getLottoNumber())),
                  new Rank(RANK_SECOND, REWARD_SECOND, (ticket, winningTicket, bonusNumber) ->
                          ticket.countMatched(winningTicket) == 5 && ticket.hasNumber(bonusNumber.getLottoNumber())),
                  new Rank(RANK_FIRST, REWARD_FIRST, (ticket, winningTicket, bonusNumber) ->
                          ticket.countMatched(winningTicket) == 6)
        ));
    }
  }
  ```
- 함수를 넘겨 인자로 사용하며 `Callback` 을 효율적으로 사용한다는 것을 더욱 심화하여 학습할 수 있었고, 실제 프로세스에 적용되어 어떤 식으로 효율적으로 동작할 수 있는지 느낄 수 있었습니다.
- 처음 떠올렸던 `Model` 내에서 `if` 문 여러 개로 당첨을 판별하는 것 보다 훨씬 효율적으로 동작할 수 있게 되었습니다.

### 💡 문서화의 중요성

- 항상 다음 날이 되면 어디까지 개발 하였는지 까먹고 이를 해결하기 위해 `// TODO: ~` 를 작성하고 다음 날에 체크하곤 했었습니다.
- `IntelliJ` 의 기능에 `TODO` 를 전부 볼 수 있는 기능이 있어 좋았지만 여전히 다음 개발 방향이 어디인지는 헷갈렸었습니다.
- 사실 이번 주차에서 처음으로 `구현할 기능 목록` 을 죽은 문서로 두지 않기 위해 하나의 기능을 만들고 테스트 까지 끝났을 때 체크 표시를 하며 진행했었습니다.
- 이를 통해 다음 개발 방향이 어느 곳인지 명확히 알 수 있었으며 새로운 하루가 시작되어도 `IntelliJ` 를 켜고 두뇌의 일정시간 동안 `deadlock` 에 빠지지 않고 빠르게 현황을 파악하여 개발을 진행할
  수 있었습니다.
- 또 하나 크게 느낀 중요성으로는 빠진 부분을 찾을 수 있다는 것이었습니다.
- 공통 피드백에도 적혀 있었듯이 `기능 목록을 업데이트한다` 라는 부분에서 시작할 때 모든 기능을 완벽하게 정리할 수 없음을 표현하고 있었습니다.
- 최대한 필요한 기능을 다 적었지만 해당 기능을 개발하다 보면 빠뜨리는 것이 튀어나오게 되는 것을 보고 해당 에외 상황 처리를 추가하여 더욱 완벽한 프로그램을 작성할 수 있었습니다.

### 💡 UncheckedException vs CheckException [참고](https://devlog-wjdrbs96.tistory.com/351)

- 이번 주차에서 부터는 사용자의 입력을 받는 중 예외 상황이 생기면 `Catch` 후 에러 메세지를 출력하고 입력을 다시 받는 것이 추가되었습니다.
- 이를 위해 함수 이름 선언 끝나고 `{` 를 열기 전에 `throws ~~Exception` 을 추가했었는데 이 함수를 호출하는 곳에 빨간줄이 안떠서 이상했었습니다.
- 대학생 때 공부했던 내용을 기억하면 입출력 같은 것을 사용할 때 `try ~ catch ~` 문으로 감싸야 하는 것으로 기억했었습니다.
- 이는 제목고 같이 체크예외와 언체크예외의 차이였고 실행하기 전에 예외가 발생하는지 판단할 수 없는 `IllegalArgumentException` 과같이 언체크예외의 경우에는 `RuntimeException` 을
  상속받아 구현되어 있습니다.
- 언체크예외는 `throws` 함수가 필요없었고 함수를 호출하는 상위 부분에서 `try ~ catch ~` 를 해주면 되는데 `Model` 의 `validate` 과정 중 생기는 오류를 잡아 `View` 에 입력을
  다시 요청해야 하기 떄문에 `Controller` 에서 작성하기로 판단했습니다.

<table>
  <tr>
    <th>👍 정상적인 UncheckedException 코드</th>
    <th>😱 만약 UncheckedException 의 예외 처리를 강제화 했더라면</th>
  </tr>
  <tr>
    <td>
      <pre>
public class ArrayTest {
    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5};
        System.out.println(list[0]);
    }
}
      </pre>
    </td>
    <td>
      <pre>
public class ArrayTest {
    public static void main(String[] args) {
        try {
            int[] list = {1, 2, 3, 4, 5};
            System.out.println(list[0]);
        } catch (ArrayIndexOutOfBoundsException e) { // Unreachable section
            e.printStackTrace();
        }
    }
}
      </pre>
    </td>
  </tr>
</table>

### 💡 Java 자체의 함수들

- 리스트들을 `stream` 을 통해 관리하는데 `메서드 체이닝 (Method Chaining)` 의 재미를 톡톡히 볼 수 있었고 불필요한 `indent` 를 제거할 수 있었습니다.
  ``` java
  public class Lotto {
  
          ...
  
          public static Lotto from(String numbers) {
              return new Lotto(
                      Arrays
                              .stream(numbers.split(LOTTO_DELIMITER))
                              .map(LottoNumber::from)
                              .map(LottoNumber::number)
                              .toList()
              );
          }

          public static Lotto generate() {
              return new Lotto(
                      pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_COUNT)
                              .stream()
                              .sorted()
                              .toList()
              );
          }

          ...

          public int countMatched(Lotto lotto) {
              return (int) numbers
                      .stream()
                      .filter(lotto::hasNumber)
                      .count();
          }
  
          ...
  }
  ```

### 💡 NumberFormat vs DecimalFormat [참고](https://docs.oracle.com/javase/7/docs/api/java/text/NumberFormat.html)

> `NumberFormat` is the abstract base class for all number formats.<br>
> `NumberFormat` helps you to format and parse numbers for any locale.

- 참고 링크인 `Java 7 API Docs` 를 살펴보면 `NumberFormat` 은 좀 더 추상적이고 `locale` 기반으로 문자열을 숫자형식으로 파싱하거나 반대로 문자열화 시켜주는 것입니다.
- 반면 `DecimalFormat` 은 `NumberFormat` 의 구현 클래스로써 `DateTime` 을 `toString` 하여 시간 표현을 정하듯 아래와 같이 구분자나 소수점을 쉽게 표현할 수 있습니다.
  <table>
    <tr>
        <th>코드</th>
        <th>출력</th>
    </tr>
    <tr>
        <td>
            <pre>
  DecimalFormat formatter = new DecimalFormat("#,###");
  formatter.format(1234500000);
            </pre>
        </td>
        <td>
            <pre>
  1,234,500,000
            </pre>
        </td>
    </tr>
    <tr>
        <td>
            <pre>
  DecimalFormat formatter = new DecimalFormat("#,###.0");
  formatter.format(123456.789);
  formatter.format(0);
            </pre>
        </td>
        <td>
            <pre>
  123,456.7
  .0
            </pre>
        </td>
    </tr>
    <tr>
        <td>
            <pre>
  DecimalFormat formatter = new DecimalFormat("#,##0.0");
  formatter.format(123456.789);
  formatter.format(0);
            </pre>
        </td>
        <td>
            <pre>
  123,456.7
  0.0
            </pre>
        </td>
    </tr>
  </table>