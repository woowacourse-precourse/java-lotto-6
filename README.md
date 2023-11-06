# 미션 - 로또


## 🚀 기능 목록

- ✅ 사용자가 로또 구입 금액을 입력한다.
    - 로또 금액을 기입하면 구입한 금액만큼 로또를 발행해야 한다
    - 구입 금액은 1000으로 나눠 떨어져야 한다(만일 1000으로 나눠 떨어지지 않을 경우 예외처리한다)
    - 사용자가 잘못된 금액을 기입하면 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.
- ✅ 구입 금액의 1000을 나눈 값만큼 로또 수가 발행된다
- ✅ 한번 로또가 발행될 때 중복되지 않는 6개의 숫자를 뽑는다
- ✅ 사용자가 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다(숫자는 ,를 기준으로 구분한다)
- ✅ 발행된 로또가 출력된다(View#SystemOutput)
- ✅ 발행된 로또에서 사용자가 뽑은 숫자 6개와 보너스 숫자 1개를 비교하여 판단한다(Calculator)
    - 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
        - 1등: 6개 번호 일치 / 2,000,000,000원
        - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - 3등: 5개 번호 일치 / 1,500,000원
        - 4등: 4개 번호 일치 / 50,000원
        - 5등: 3개 번호 일치 / 5,000원
- ✅ 당첨 기준을 가지고 비교한다(입력한 금액 대비 받는 금액을 통해 수익률을 구한다/이때 소수점 2째자리에서 반올림한다(Calculator)
- ✅ 테스트 코드가 돌아가야 한다
- ✅ 터미널에 `./gradlew clean test` 명령을 실행하고, `BUILD SUCCESSFUL in 0s`를 출력받아야 된다
- ✅ JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- ✅ Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
    - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- ✅ 작은 단위에서 테스트를 실행시켜야 한다(단위 테스트 작성이 익숙하지 않다면 `test/java/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.)
- ✅ 한 메서드의 줄이 15줄 이상 넘어가지 않는다
- ✅ if 구문을 쓰고 난 후 바로 return을 사용해서 else구문을 쓰지 않는다
- ✅ Java Enum을 사용한다
- ✅  도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.(뷰 패키지 만들어야 한다 UserInput, UserOutput)
- ✅ 일급 컬렉션을 만든다
- ✅ 여러 코드가 반복된다면 함수로 분리한 후 사용한다
- ✅ 객체를 분리하는 연습을 한다

## 클래스 계획:

- View # SystemOutput # SystemInput
- Validator # Validate
- domain # Lotto # Rank(Enum) # WinningLotto # UserLotto # Calculator # LottoGenerator
- Controller # LottoController

## 기능 목록 구현 순서

- 1. 전체척인 코드의 뼈대를 구성한다(패키지-MVC 적용)
- 2. java Enum 클래스 설정(Rank)
- 3. 사용자한테 입력받을 수 있는 것을 입력받는다.(금액, 로또 번호, 보너스 번호)
- 4. 사용가 입력한 로또 금액의 1000을 나눈 값이 게임 수가 된다
- 5. 게임 수에 맞게 서로 다른 당첨 번호 6개를 무작위로 생성하고 별도의 클래스에 저장한다
- 6. lotto Generator 클래스가 잘 나오는 지 확인한다
- 6. 사용자가 입력한 로또 번호와 보너스 번호를 별도의 클래스에 저장한다
- 7. 로또 클래스 길이 및 중복 여부 검사
- ️8.  Rank의 조건에 따라 rank 값이 출력될 수 있도록 한다
- 9. 사용자가 입력한 로또 번호와 게임 갯수만큼 발행된 로또 번호 사이에 겹치는 갯수를 구한다
- ️10.  겹치는 갯수가 어떤 조건에 부합하는 지 확인한다
- 11. 부합하는 갯수와 가격을 구한 후 비율을 구한다
- 12. 구한 비율을 출력한다
- 13. 예외 처리가 발생시 [ERROR]를 출력한다


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

### 추가된 요구 사항

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


