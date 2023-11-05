# 미션 - 로또

▼로또 구입

- 로또 금액 입력
  - 1,000원 단위 입력
  - 상수 LOTTO_PRICE = 1000
- 입력 예외처리 (IllegalArgumentException)
  - 공백을 입력한 경우 예외처리
  - 숫자와 콤마를 제외한 입력 예외처리
  - 천원 단위로 나누어떨어지지않는 경우 예외 처리

▼로또 발행

- 로또 구입 금액 만큼 로또 발행
  - 6개의 로또 번호 랜덤 생성
    - 6개의 로또 번호는 서로 중복되지 않아야 함
    - 상수 LOTTO_NUMBER_LENGTH = 6
    - 로또 번호는 오름차순 정렬
- lottoCount

▼로또 추첨

- 당첨 번호(+보너스 번호) 입력
  - 입력 번호는 쉼표 기준으로 구분
  - 당첨번호와 보너스 번호를 따로 입력 받음
  - 상수 LOTTO_NUMBER_LENGTH = 6
  - 상수 LOTTO_BONUS_NUMBER_LENGTH = 1
  - 상수 MIN_LOTTO_NUMBER = 1
  - 상수 MAX_LOTTO_NUMBER = 45
  - 로또 번호는 오름차순 정렬
- 입력 예외처리 (IllegalArgumentException)
  - 숫자와 쉼표가 아닌걸 입력하는 경우 예외 처리
  - 공백을 입력한 경우 예외처리
  - 입력 번호는 6개의 번호를 입력해야함 그렇지 않을 경우 예외 처리
  - 1~45 범위를 벗어난 숫자 입력 시 예외 처리

▼로또 당첨 결과 확인

- 구매 로또 번호와 입력한 당첨 번호 비교
  - 당첨 여부 확인
    - 3개 일치(5,000원) THREE_MATCH = 5000
    - 4개 일치(50,000원) FOUR_MATCH = 50000
    - 5개 일치(1,500,000원) FIVE_MATCH = 1500000
      - 5개 일치, 보너스 볼 일치(30,000,000원) BONUS_MATCH = 30000000
    - 6개 일치(2,000,000,000원) SIX_MATCH = 2000000000


▼ 수익률 확인

- 당첨된 로또의 수익률 계산
  - 당첨된 로또 수익 / 구매한 로또 값 * 100
  - 소수점 둘째 자리에서 반올림


▼ 그 외
- 콤마 찍어주는 메서드
- 







#
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
