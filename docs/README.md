## 1. 피드백 정리
> 2주차 목표
>- 함수 분리와 함수별로 테스트를 작성

>3주 차 목표
>- 클래스(객체)를 분리하는 연습
>- 도메인 로직에 대한 단위 테스트를 작성하는 연습

> 3주차 피드백
>- 기능 목록을 재검토
>  - 너무 세세한 부분까지 정리하기보다 구현해야 할 기능 목록을 정리하는 데 집중한다.
   >  - 정상적인 경우도 중요하지만, 예외적인 상황도 기능 목록에 정리한다.
>  - 특히 예외 상황은 시작 단계에서 모두 찾기 힘들기 때문에 기능을 구현하면서 계속해서 추가해 나간다.
>***
>- 값을 하드 코딩하지 않는다
>  - 상수(static final)를 만들고 이름을 부여해 이 변수의 역할이 무엇인지 의도를 드러내라.
>***
>-  클래스는 상수, 멤버 변수, 생성자, 메서드 순으로 작성
>***
> - 변수 이름에 자료형은 사용하지 않는다
>***
> - 한 함수가 한 가지 기능만 담당하게 한다
>   - 함수에서 안내 문구 출력, 사용자 입력, 유효값 검증 등 여러 일을 하고 있다면 이를 적절하게 분리한다.
> ***
> - 만약 여러 함수에서 중복되어 사용되는 코드가 있다면 함수 분리를 고민해 본다. 또한, 함수의 길이를 15라인을 넘어가지 않도록 구현하며 함수를 분리하는 의식적인 연습을 할 수 있다.
> ***
> - 처음부터 큰 단위의 테스트를 만들지 않는다
>   - 문제를 작게 나누고, 그 중 핵심 기능에 가까운 부분부터 작게 테스트를 만들어 나간다.



## 2. 요구 사항 정리
>- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
>- 로또 1장의 가격은 1,000원이다.
>- 당첨 번호와 보너스 번호를 입력받는다.
>- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
>- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
>- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
>- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
>- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

>- 추가된 요구 사항
>- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
>- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
>- else 예약어를 쓰지 않는다.
>  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
>  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
>- Java Enum을 적용한다.
>- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
>  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
>    - 단위 테스트 작성이 익숙하지 않다면 test/java/lotto/LottoTest를 참고하여 학습한 후 테스트를 구현한다.

>- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
>  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.
>    - 사용예시
>    - List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
>  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

>- Lotto 클래스
>  - 제공된 Lotto 클래스를 활용해 구현해야 한다.
>  - numbers의 접근 제어자인 private을 변경할 수 없다.
>  - Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
>  - Lotto의 패키지 변경은 가능하다.


## 3. 3주차 프리코스 목표
>- 살아있는 문서를 만들자
>- 깃 커밋을 기능단위로 하는 습관을 들이자
>- 테스트 코드를 공부하고 사용하자
>- Enum을 공부해서 적용시키자


## 4. 기능 흐름도
>1. 구매금액 입력 (***+ 예외처리***)
>2. 금액에 따른 로또번호 생성 (6자리, 오름차순) (***+ 예외처리***)
>3. 당첨번호 입력 (***+ 예외처리***)
>4. 보너스 번호 입력 (***+ 예외처리***)
>5. 당첨 통계
>   1. 3개 일치 갯수
>   2. 4개 일치 갯수
>   3. 5개 일치 갯수
>   4. 5개 일치 + 보너스번호 일치 갯수
>   5. 6개 일치 갯수
>   6. 총 수익률 계산


## 5. 기능 목록 정리
>- [ ] 구매 금액 입력받기 Lotto #inputPurchaseAmount
>- [ ] 로또번호 생성 Numbers #createLottoNumbers
>- [ ] 당첨번호 입력 Numbers #inputLuckyNumbers
>- [ ] 보너스번호 입력 Numbers #inputBonusNumber
>- [ ] 갯수 찾기 Calculator #countCorrectLuckyNumbers
>- [ ] 수익률 계산 Calculator #rateOfReturn
>- [ ] 유효성 검사 (`IllegalArgumentException`를 발생 / `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`) Lotto #validate
>- [ ] Lotto 작동 Lotto #run

## 6. 기능에 따른 클래스 구조
>- Numbers
>  - `createLottoNumbers`
>  - `inputLuckyNumbers`
>  - `inputBonusNumber`
>- Calculator
>  - `countCorrectLuckyNumbers`
>  - `rateOfReturn`
>- Purchase
>  - `inputPurchaseAmount`
>  - `validateInputPurchaseAmount`
>  - `calculateRound`
>- Lotto
>  - `run`
>  - `validate`


## 7. 테스트 코드 설계


