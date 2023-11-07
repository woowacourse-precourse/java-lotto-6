
# 소개

금액과 로또 번호를 입력하고, 자동 생성된 로또들을 검사해서 결과와 수익을 출력하는 프로그램

# 피드백

- 상수 하드코딩하지 않기
- 정리한 기능 목록이 정상 동작함을 확인하기
- 테스트 작성 이유를 본인 경험을 토대로 정리하기

# 요구사항

## 🚀 기능 요구 사항

로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.

```
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

### 입출력 요구 사항

#### 입력

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

```
14000
```

- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.

```
1,2,3,4,5,6
```

- 보너스 번호를 입력 받는다.

```
7
```

#### 출력

- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.

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

- 당첨 내역을 출력한다.

```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

```
총 수익률은 62.5%입니다.
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

#### 실행 결과 예시

```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

---

## 🎯 프로그래밍 요구 사항

- JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

### 추가된 요구 사항

- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- Java Enum을 적용한다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
  - 단위 테스트 작성이 익숙하지 않다면 `test/java/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console`
  API를 사용하여 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시

```java
List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
```

### Lotto 클래스

- 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
- `numbers`의 접근 제어자인 private을 변경할 수 없다.
- `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
- `Lotto`의 패키지 변경은 가능하다.

```java
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
```

---

## ✏️ 과제 진행 요구 사항

- 미션은 [java-lotto-6](https://github.com/woowacourse-precourse/java-lotto-6) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
  - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.


# 절차

- 올바른 값을 입력받을 때까지
  - 구입 금액을 입력받는다.
  - 금액이 1000원 단위가 아니라면 잘못된 값으로 간주한다.
  - 금액이 0 이하라면 잘못된 값으로 간주한다.
  - 잘못된 값을 입력받았을 경우, 오류 문자열을 출력한다.
- 로또를 발행한다.
- 로또를 출력한다.
  - 로또는 오름차순으로 출력한다.
- 올바른 값을 입력받을 때까지
  - 당첨 번호를 입력받는다.
  - 번호가 자연수가 아니라면 잘못된 값으로 간주한다.
  - 번호 범위가 1~45가 아니라면 잘못된 값으로 간주한다.
  - 잘못된 값을 입력받았을 경우, 오류 문자열을 출력한다.
- 올바른 값을 입력받을 때까지
  - 보너스 번호를 입력받는다.
  - 당첨 번호와 동일한 조건으로 검사를 진행한다.
- 결과를 계산한다.
- 결과를 출력한다.

# 객체

## 도메인
- 구입 금액(돈)
- 로또
  - 로또 팩
- 당첨 번호
  - 당첨 번호들
  - 보너스 번호
- 결과

## 뷰
- 인풋 뷰
- 아웃풋 뷰

## 상수 데이터
- 출력 메시지
- 예외 메시지
- 로또 옵션
  - 숫자 범위
  - 로또 가격
  - 로또 길이
  - 상금
  - 기타 매직 넘버

## 유틸리티
- 숫자 생성기
- 스캐너
- 프린터

# 기능 분배

## 도메인

- [Money](../src/main/java/lotto/domain/Money.java)
  - count

- [Lotto](../src/main/java/lotto/domain/Lotto.java)
  - calculate
  - toString

- [LottoPack](../src/main/java/lotto/domain/LottoPack.java)
  - calculate
  - toString

- [WinningNumber](../src/main/java/lotto/domain/WinningNumber.java)
  - is

- [WinningNumbers](../src/main/java/lotto/domain/WinningNumbers.java)
  - contains

- [BonusNumber](../src/main/java/lotto/domain/BonusNumber.java)
  - is

- [Result](../src/main/java/lotto/domain/Result.java)
  - winningNumbersContain
  - bonusNumberIs

- [LottoStatistics](../src/main/java/lotto/domain/Result.java)
  - toString

- [IncomeRate](../src/main/java/lotto/domain/IncomeRate.java)
  - getPercentageIncomeRate

- [InputView](../src/main/java/lotto/view/InputView.java)
  - getNumber
  - getNumbers

- [OutputView](../src/main/java/lotto/view/OutputView.java)
  - printGetMoney
  - printLottoPack
  - printGetWinningNumbers
  - printGetBonusNumber
  - printResult
  - printException
  - newline

## 상수 데이터

- [LottoConfig](../src/main/java/lotto/constant/LottoConfig.java)
  - LOTTO_PRICE
  - LOTTO_NUMBER_FROM
  - LOTTO_NUMBER_TO
  - LOTTO_LENGTH

- [LottoRank](../src/main/java/lotto/constant/LottoRank.java)
  - THREE
  - FOUR
  - FIVE
  - FIVE_BONUS
  - SIX
  - findRank
  - getPrize
  - toString

- [ExceptionMessage](../src/main/java/lotto/constant/ExceptionMessage.java)
  - NOT_NUMBER_MESSAGE
  - OUT_OF_LOTTO_RANGE_MESSAGE
  - LENGTH_ERROR_MESSAGE
  - DUPLICATION_MESSAGE
  - NOT_POSITIVE_MESSAGE
  - NOT_UNIT_NUMBER_MESSAGE
  - BONUS_NUMBER_OVERLAPPED_MESSAGE

- [OutputMessage](../src/main/java/lotto/constant/OutputMessage.java)
  - GET_MONEY_MESSAGE_MESSAGE
  - BOUGHT_LOTTO_PACK_MESSAGE
  - GET_WINNING_NUMBERS_MESSAGE
  - GET_BONUS_NUMBER_MESSAGE
  - LOTTO_RESULT_MESSAGE
  - INCOME_RATE_MESSAGE

## 유틸리티

- [NumberGenerator](../src/main/java/lotto/util/NumberGenerator/INumberGenerator.java)
  - generateNumbers

- [Scanner](../src/main/java/lotto/util/Scanner/Scanner.java)
  - readLine

- [Printer](../src/main/java/lotto/util/Printer/Printer.java)
  - println