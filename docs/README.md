# 🎲 java-lotto


## 🖥️ 프로그래밍 요구 사항

- JDK 17 버전
- Java 코드 컨벤션 가이드
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현
- 3항 연산자 사용 X
- 함수가 한 가지 일만 하도록 (SRP 원칙)
- JUnit 5와 AssertJ를 이용하여 테스트 코드

### ➕ 추가된 요구 사항

- 함수의 길이가 15라인을 넘어가지 않도록 구현
- else 예약어 사용 X
    - switch/case 사용 X
- Java Enum
- 도메인 로직에 단위 테스트를 구현
    - 단, UI(System.out, System.in, Scanner) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해서 구현

### 📖 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

### 📕 주어진 조건: Lotto 클래스

- 제공된 `Lotto` 클래스를 활용해 구현
- `numbers`의 접근 제어자인 private을 변경 불가
- `Lotto`에 필드(인스턴스 변수) 추가 불가
- `Lotto`의 패키지 변경 가능

---

## 🔘 요구사항

#### 👨🏻 입력 요구사항

- 로또 구입 금액을 입력한다.
- 당첨 번호를 입력한다.
- 보너스 번호를 입력한다.

#### 🔎 검증 요구사항

##### 공통

- 입력값이 숫자인지 검증한다.

##### 로또 구입 금액

- 금액이 1000원으로 나누어 떨어지는지 검증한다.

##### 당첨 번호

- 당첨 번호가 1 ~ 45 사이의 수인지 검증한다.
- 당첨 번호의 개수가 맞는지 검증한다.
- 당첨 번호가 중복이 없는지 검증한다.

##### 보너스 번호

- 보너스 번호가 1 ~ 45 사이의 수인지 검증한다.
- 보너스 번호가 당첨 번호와 중복이 없는지 검증한다.

#### 🚀 기능 요구사항
- 입력받은 값을 int형으로 변환한다.
- 입력받은 금액을 티켓 금액`1000`으로 나누어 로또 티켓 수를 구한다.
- 티켓의 수만큼 로또를 발행한다.
  - 로또는 랜덤으로 중복없이 생성된다.
  - 발행한 로또를 오름차순 정렬한다.
<br><br>
- 입력받은 당첨번호를 "," 기준으로 분리한다.
- 각각의 당첨번호를 int형으로 변환한다.
  <br><br>
- 입력받은 보너스번호를 int형으로 변환한다.
  <br><br>
- 발행한 로또 티켓들을 계산한다.
  - 발행한 로또번호와 당첨번호를 비교한다.
  - 일치하는 번호의 개수에 따라 등수를 정한다.
  - 등수마다 뽑힌 횟수를 저장한다.
  - 뽑힌 횟수를 이용하여 수익률을 구한다.

#### 🖨️ 출력 요구사항

- 발행한 로또 수량 및 번호를 출력한다.
- 당첨 내역을 출력한다.
- 총 수익률을 출력한다.
- 예외 상황 시 에러 문구를 출력한다.

---

## 🌳 디렉토리 구조

```agsl
├─main
│  └─java
│      └─lotto
│          │  Application.java
│          │
│          ├─config
│          │      Config.java
│          │      LottoRank.java
│          │
│          ├─controller
│          │      LottoController.java
│          │
│          ├─model
│          │      Lotto.java
│          │      User.java
│          │
│          ├─service
│          │      LottoService.java
│          │      RankService.java
│          │
│          ├─util
│          │      RandomUtil.java
│          │      Validator.java
│          │
│          └─view
│                  ErrorView.java
│                  PrintView.java
│
└─test
    └─java
        └─lotto
                ApplicationTest.java
                LottoTest.java

```

