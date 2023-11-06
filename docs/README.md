### 객체 간의 협력관계 파악하기
<img src="./collaborative-relationship.png" >

### 프로그래밍 요구사항

- [ ✅ ] JDK 17 버전에서 실행 가능해야 한다.
- [  ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [  ] 3항 연산자를 쓰지 않는다.
- [  ] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

### 추가 요구사항

- [ ] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [ ] else 예약어를 쓰지 않는다.
- [ ] Java Enum을 적용한다.
- [ ] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
- [ ✅ ] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
  - [ ✅ ] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
  - [ ✅ ] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- [ ✅ ] 주어진 로또 클래스를 사용한다.
  - [ ✅ ] 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
  - [ ✅ ] `numbers`의 접근 제어자인 private을 변경할 수 없다.
  - [ ✅ ] `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
  - [ ✅ ] `Lotto`의 패키지 변경은 가능하다.

MVC패턴으로 작성한다.

### View

- **InputView (입력화면)**
  - [ ✅ ] `public` 구매 금액을 입력받는다.
  - [ ✅ ] `public` 당첨번호를 입력받는다.
  - [ ✅ ] `public` 보너스번호를 입력받는다.
- **OutView (출력화면)**
  - [ ✅ ] `public` 구매 금액에 맞는 로또 개수를 출력한다.
  - [ ✅ ] `public` 구매 금액에 맞는 로또 목록을 출력한다.
  - [  ] `public` 수익률을 출력한다.

### Model

- **PurchaseAmount** **(구매금액과 로또갯수를 저장하기 위한 객체)**
  - [ ✅ ] `private` 사용자가 구매금액을 올바르게 입력했는지 검증한다.
    - 사용자가 잘못 입력한 경우 `IllegalArgumentException` 예외를 발생시킨다.
      - [ ✅ ] `private` 빈값으로 입력한 경우
      - [ ✅ ] `private` 문자가 포함된 경우
      - [ ✅ ] `private` 0이하의 값을 입력한 경우
      - [ ✅ ] `private` 1000원 단위가 아닌 경우
  - [ ✅ ] `private` 사용자가 입력한 구매금액에 따라 생성할 수 있는 로또 갯수를 저장한다.

- **PurchaseLottos** **(로또갯수에 따른 로또 목록을 저장하기 위한 객체)**
  - [ ✅ ] `private` 로또갯수에 따른 로또 목록을 생성한다.
- **LottoOneSet (하나의 로또를 저장하기 위한 객체)**
  - [ ✅ ] `private` 1부터 45까지의 랜덤한 6개의 수를 생성하되, 6개 모두 중복되지 않도록 해야한다.
  - [ ✅ ] `private` 생성된 로또를 오름차순 정렬한다.
- **Lotto (당첨번호를 저장하기 위한 객체)**
  - [ ✅ ] `private` 당첨번호가 올바르게 입력되었는지 검증한다.
    - 사용자가 잘못 입력한 경우 `IllegalArgumentException` 예외를 발생시킨다.
      - [ ✅ ] `private` 빈값으로 입력한 경우
      - [ ✅ ] `private` 문자가 포함된 경우
      - [ ✅ ] `private` 6개의 숫자로 입력하지 않은 경우
      - [ ✅ ] `private` 1과 45사이의 숫자가 아닌경우
      - [ ✅ ] `private` 중복된 숫자가 있는 경우
- **BonusNumber (보너스 번호를 저장하기 위한 객체)**
  - [ ✅ ] `private` 보너스번호가 올바르게 입력되었는지 검증한다.
    - 사용자가 잘못 입력한 경우 `IllegalArgumentException` 예외를 발생시킨다.
      - [ ✅ ] `private` 빈값으로 입력한 경우
      - [ ✅ ] `private` 콤마나 스페이스가 포함된 경우
      - [ ✅ ] `private` 문자를 입력한 경우
      - [ ✅ ] `private` 1과 45사이의 숫자가 아닌 경우
      - [ ✅ ] `private` 당첨번호에 숫자가 있는 경우