## 기능 목록 정리
### 🎲 생성
- 랜덤 숫자 생성
    - 1~45의 중복되지 않는 6개의 숫자, 보너스 번호 1개
    - 규칙 : 무작위 값이 4 이상일 경우 전진, 미만일 경우 멈춤
    - 당첨 기준 및 금액
      - 1등: 6개 번호 일치 / 2,000,000,000원
      - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
      - 3등: 5개 번호 일치 / 1,500,000원
      - 4등: 4개 번호 일치 / 50,000원
      - 5등: 3개 번호 일치 / 5,000원

### 📝 입력
- 로또 구입 금액
    - 1장에 1,000원
    - 1,000원 단위. 1000원으로 나누어 떨어지지 않는 경우 예외 처리
    - 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생시키고 "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
      - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
- 당첨 번호
    - 쉼표(,)를 기준으로 구분
    - 숫자만 입력 가능(다른 값 입력할 경우 `IllegalArgumentException` 발생시키고 종료)
- 보너스 번호
  - 숫자만 입력 가능

### 🧾 출력
- 발행한 로또 수량 및 번호 출력
  - 로또 번호는 오름차순으로 정렬하여 보여줌
- 당첨 내역 출력
- 수익률의 경우 소수점 둘쨰 자리에서 반올림
- 에외 사항 시 에러 문구 출력. 단, 에러 문구는 "[ERROR]"로 시작해야 함

## 라이브러리

- JDK에서 제공하는 Random 및 Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

- 사용 예시
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
