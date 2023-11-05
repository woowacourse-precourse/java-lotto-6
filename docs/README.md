# 로또

로또 구입 금액을 입력받아 개수만큼 구매합니다.
당첨 번호와 보너스 번호를 입력하면 구입한 로또들과 비교하여 총 당첨액을 알려주는 프로그램입니다.

# 주요 연습 키워드

> 1. 클래스(객체)를 분리하는 연습
> 2. 도메인 로직에 대한 단위 테스트를 작성하는 연습

# 기능 목록

### 입력

- [x] 로또 구입 금액 입력
  - [x] 로또 구입 금액 입력 예외 처리
- [x] 당첨 번호 입력
  - [x] 당첨 번호 입력 예외 처리
- [x] 보너스 번호 입력
  - [x] 보너스 번호 입력 예외 처리

### 출력

- [x] 발행한 로또 수량 및 번호 출력 (번호 오름차순)
- [x] 당첨 내역 출력
- [x] 수익률 출력 (소수점 첫째 자리 까지)

### 로또 발행

- [x] 로또 구입 금액에 맞는 로또 수량 발행
  - [x] 로또 구입 금액 예외 처리
- [x] 당첨 번호 및 보너스 번호 객체 발행
  - [x] 당첨 번호 및 보너스 번호 예외 처리

### 결과 계산

- [x] 당첨 번호와 로또 객체의 비교 계산
- [x] 비교 계산 종합 해서 총 당첨 내역 반환
- [x] 당첨 내역 으로 수익률 계산

# 객체의 역할

```text
lotto/
├── controller/
│   └── LottoController.java
├── domain/
│   ├── Lotto.java
│   ├── LottoMachine.java
│   └── exceptions/
│       ├── InputException.java
│       └── LottoException.java
│   └── numbergenerator
│       ├── NumberGenerator.java
│       └── RandomNumberGenerator.java

├── service/
│   └── LottoService.java
├── utils/
│   ├── validator/
│   │   ├── Validator.java
│   │   ├── MoneyValidator.java
│   │   └── LottoNumbersValidator.java
│   └── parser/
│       ├── Parser.java
│       ├── MoneyParser.java
│       └── LottoNumbersParser.java
└── view/
    ├── InputView.java
    └── OutputView.java
```

## controller

**모델과 뷰의 메세지 전달을 돕고, 모든 입력값의 검증과 예외처리 (재입력)을 수행한다..**

뷰에서 데이터를 전달받으면, 도메인 에서 사용 가능하도록 검증하고 변환한다.

마찬가지로 도메인에서 데이터를 전달받으면 데이터를 뷰가 사용 가능하도록(정렬) 변환해서 전달한다.

## view

데이터를 화면에 보여주거나 입력받는 역할을 한다.

### - InputView

사용자의 입력을 받는다. 아무런 검증도 진행하지 않는다.

### - OutputView

결과를 받고 알맞은 형식으로 바꿔서 출력한다.

## domain

비즈니스 로직에 대한 모든 책임이 있다.

### - Lotto

로또 하나의 정보를 저장한다.

로또 번호의 유효성 보증 책임이 있다.

### - WinningNumbers

당첨 번호와 보너스 번호를 저장한다.

또한, 로또 객체를 받아서 몇등인지 계산하고 반환해야 한다.

### - LottoMachine

금액을 받아 로또를 발행하고, 결과를 취합하는 역할을 한다.

### Validator

기본적인 검증, 비즈니스 로직 검증 등 모든 검증과정을 책임진다.

### NumberGenerator

숫자 생성 인터페이스

### RandomNumberGenerator

NumberGenerator 구현체, 무작위 숫자 반환

### SettedNumberGenerator

NumberGenerator 구현체, 매개변수로 받은 숫자 반환

### - LottoRank

당첨 등수의 정보를 열거형으로 저장한다.

### - LottoException

발생할 수 있는 예외들의 정보를 열거형으로 저장한다.

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

# 프로그래밍 전략

1. 간단하게 객체의 역할을 나누고 정의한다.
2. 알맞게 빈 클래스와 메소드를 작성한다.
3. 객체와 메소드의 올바른 협력을 기대하며 테스트 코드를 작성한다.
4. 테스트 코드를 작성 완료한 클래스를 구현한다.
5. 테스트 코드가 통과하면 다음 객체의 테스트를 작성한다.
6. 모든 테스트 통과 시 리팩토링을 시작한다.


## 생각정리

이번 과제에서는 특히 예외처리에 신경을 써야했다.

예외가 발생할 경우 재입력을 받기위해 반복문 또는 재귀함수로 구현해야 하는데,

지난 과제 구현처럼 기본적인 입력 검증은 View에서 하고, 비즈니스 로직 검증은 각 객체에서 별도로 수행하면
예외를 잡아서 재입력을 받는 과정이 너무 복잡해졌다.

그래서 모든 검증을 Validator 이라는 도메인 영역 클래스에 작성하고, 컨트롤러에서 호출해 수행하기로 했다.

덕분에 InputView는 매우매우 간단해질 것 같다.

문자열을 사용 가능한 데이터로 변환하는 과정인 파싱도 마찬가지로 따로 클래스로 분리하기로 했다.
