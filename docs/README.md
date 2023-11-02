# 로또

로또 구입 금액을 입력받아 개수만큼 구매합니다.
당첨 번호와 보너스 번호를 입력하면 구입한 로또들과 비교하여 총 당첨액을 알려주는 프로그램입니다.

# 주요 연습 키워드

> 클래스(객체)를 분리하는 연습
> 도메인 로직에 대한 단위 테스트를 작성하는 연습

# 기능 목록

### 게임 세팅

- [ ] 로또 개수 입력
- [ ] 로또 구입 금액 1000으로 나누어 떨어지지 않을 경우 예외 처리 및 재입력
- [ ] 1000으로 나눈 개수만큼 Lotto 객체 발행
- [ ] 발행한 Lotto의 개수와 번호 출력

### 당첨 번호와 보너스 번호 입력

- [ ] 당첨 번호 입력 받기
- [ ] 잘못된 값 입력시 예외 처리 및 재입력
- [ ] 보너스 번호 입력 받기
- [ ] 잘못된 값 입력시 예외 처리 및 재입력
- [ ] 당첨 번호와 보너스 번호 합쳐 당첨 번호 불변 객체로 저장

### 계산

- [ ] 발행한 모든 Lotto 객체들을 당첨 번호 객체와 비교
- [ ] Enum 활용해서 결과를 전달

### 결과 출력

- [ ] 받은 결과 출력
- [ ] 총 수익률 출력

# 패키지 및 객체 목록

## View

### InputView

- 로또 개수 입력
- 당첨 번호 입력
- 보너스 번호 입력
- Console.readline() 호출하고 기본적인 검증 진행 하는 Util 클래스
  - 문자열 입력
  - 자연수 입력

### OutputView

## Domain

### 로또
### 당첨번호

## Exception
 


# 코드 작성 규칙

작은 기능부터 테스트를 작성 (도메인 로직만 단위 테스트 해도 된다. ui는 안해도됨)
함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
Java Enum을 적용한다.

### Lotto 클래스 정의

- numbers의 접근 제어자인 private을 변경할 수 없다.
- Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
- Lotto의 패키지 변경은 가능하다.

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
