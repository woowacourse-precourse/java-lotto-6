# 로또

---

# 🚨 기능 요구 사항

로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.

- 로또 번호의 숫자 범위는 `1~45`까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 `6개의 숫자`를 뽑는다.
- 당첨 번호 추첨 시 `중복되지 않는 숫자 6개`와 `보너스 번호 1`개를 뽑는다.
- 당첨은 `1등부터 5등까지` 있다. 당첨 기준과 금액은 아래와 같다.
  - 1등: 6개 번호 일치 / `2,000,000,000원`
  - 2등: 5개 번호 + 보너스 번호 일치 / `30,000,000원`
  - 3등: 5개 번호 일치 / `1,500,000원`
  - 4등: 4개 번호 일치 / `50,000원`
  - 5등: 3개 번호 일치 / `5,000원`
 - 로또 구입 금액을 입력하면 `구입 금액에 해당하는 만큼 로또를 발행`해야 한다.
 - 로또 1장의 가격은 `1,000원`이다.
 - `당첨 번호와 보너스 번호를 입력`받는다.
 - 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
 - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, `[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
 - `Exception`이 아닌 `IllegalArgumentException, IllegalStateException` 등과 같은 명확한 유형을 처리한다.

---

# 📮 입출력 요구 사항

---

## 입력

- [X] 로또 구입 금액 입력
    - `1,000원 단위로 입력`
    - `1,000원으로 나누어 떨어지지 않는경우 예외처리`
    - `문자일 경우 예외처리`
- [X] 당첨 번호를 입력 받는다.
    - `번호는 쉼표(,)를 기준으로 구분`
    - `문자일 경우 예외처리`
- [X] 보너스 번호를 입력 받는다.

---

## 출력

- [X] 발행한 로또 수량 및 번호를 출력한다.
    - `오름차순으로 정렬`
- [X] 당첨 내역을 출력한다.
- [x] 수익률을 출력한다.
    - `소수점 둘째 자리에서 반올림 (ex. 100.0%, 51.5%, 1,000,000.0%`)
- [X] 예외 상황 시 에러 문구를 출력해야 한다.
    - `[ERROR]`로 시작

## 그외

- [x] 패키지 분류
- [x] Enum 당첨상금 클래스
    - 패키지변경
- [x] Lotto 클래스 활용
- [x] 구매결과 컨트롤러 추가
- [X] 당첨결과 번호 String > int 변환
- [X] 금액만큼 로또 생성
- [X] Start 컨트롤러 구현
- [X] 구매금액 > 로또 갯수로 변환 메서드 구현
- [X] ComparingLotto.java 로또번호 비교 클래스
- [x] Lotto.java 클래스 활용 및 테스트
- [x] Lotto 클래스 활용
- [x] 테스트 케이스 추가

---

# 🎯 프로그래밍 요구 사항

- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

# 🚀 추가된 요구 사항

- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- Java Enum을 적용한다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
  - 단위 테스트 작성이 익숙하지 않다면 `test/java/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.

# 🔍 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console`
  API를 사용하여 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

## 사용 예시

```java
List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
```

## Lotto 클래스

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

# 과제 진행 요구 사항
- [x] 미션은 java-lotto-6 저장소를 Fork & Clone해 시작한다.
- [x] 기능을 구현하기 전 docs/README.md에 구현할 기능 목록을 정리해 추가한다.
- [x] Git의 커밋 단위는 앞 단계에서 docs/README.md에 정리한 기능 목록 단위로 추가한다.
- [x] 커밋 메시지 컨벤션 가이드를 참고해 커밋 메시지를 작성한다.
- [x] 과제 진행 및 제출 방법은 프리코스 과제 제출 문서를 참고한다.
