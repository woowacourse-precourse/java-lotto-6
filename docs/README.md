# 패키지 구조

```
java
└── lotto
    ├── domain
    │   ├── Lotto.java
    │   ├── LottoRepository.java
    │   └── WinningNumber.java
    ├── controller
    │   └── LottoController.java
    ├── service
    │   └── LottoService.java
    ├── view
    │   ├── inputView.java
    │   └── outputView.java
    ├── util
    │   ├── DuplicationNumValidator.java
    │   └── RandomLottoNumGenerator.java
    ├── dto
    │   ├── LottoResultDto.java
    │   └── LottoRepositoryDto.java
    └── exception
        ├── LottoErrorMsg.java
        └── LottoException.java
```

## 구현할 기능 목록

### 사용자 입력

- 로또 구입 금액을 입력 받는다.
    - 문자열과 같은 허용되지 않은 형식에 대한 예외처리
    - 1,000원 단위로 나누워 떨어지지 않는 금액에 대한 예외처리
- 금액에 맞는 로또 n장 생성 및 출력
- 당첨 번호를 입력 받는다.
    - 문자열과 같은 허용되지 않은 형식에 대한 예외처리
    - 중복된 숫자가 있는 경우에 대한 예외처리
    - 범위를 벗어난 숫자에 대한 예외처리
- 보너스 번호를 입력 받는다.
    - 문자열과 같은 허용되지 않은 형식에 대한 예외처리
    - 중복된 숫자가 있는 경우에 대한 예외처리
    - 범위를 벗어난 숫자에 대한 예외처리

### 로또 결과

- 당첨 내역 산출 로직구현
- 수익률 산출 구현
- 당첨내역 산출 출력 및 수익률 출력 구현

---
### 프로그래밍 요구록사항

- JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
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
    - 단위 테스트 작성이 익숙하지 않다면 `test/java/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.