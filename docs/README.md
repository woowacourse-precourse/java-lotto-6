# 로또 게임 

## 1. 미션 진행 계획
### 1) 패키지 구성 
- 크게 도메인 로직을 담고 있는 `domain`패키지, UI 로직을 담고 있는 `ui`패키지,
  도메인 로직과 UI 로직을 적절하게 제어하는 `controller`패키지로 나눈다.
- `domain` &rarr; `ui` &rarr; `controller` 순으로 구현한다.
- 어떤 코드가 도메인 로직인지 아닌지 애매하다면, 그 코드가 '로또'라는 비즈니스 문제에 대해서 
  의미있는 결정을 하고 있는지를 파악하자. 이 외의 다른 것들은 해당 결정을 해석하거나
  결정을 내리는 데 필요한 입출력과 관련되어 있다.
  - 참고자료
  - [비즈니스 로직, 도메인 로직이 도대체 뭐지?](https://velog.io/@eddy_song/domain-logic)
  - [What is domain logic?](https://enterprisecraftsmanship.com/posts/what-is-domain-logic/)

### 2) 테스트 코드 작성
- 테스트 코드는 도메인 로직이 완성된 뒤 작성한다. 도메인 로직을 작성하다가
  변경사항이 생길수도 있기 때문이다.
- 도메인 로직 위주로 단위 테스트를 구현한다.

### 3) 입력값 처리
1. Controller 부분에 do while문으로 UI 관련 메서드 호출
2. do while 조건문에서 값이 올바른지 확인하는 메서드 호출(이 메서드 역시 Controller 부분)
3. 이 메서드는 try catch로 구현해 try 부분에서 입력값을 저장 또는 처리하는 기능을 하는 domain 관련 메서드 호출
   1. 정상적으로 처리되면 controller의 다음 부분으로 이동
   2. 처리하다가 예외가 발생하면 catch 부분에서 에러 관련 UI 메서드를 호출하고 false 반환
       - do while문의 조건문에서 false를 받음
       - 1번으로 이동

### 4) 검증 로직의 적절한 위치
- 검증 로직을 꼭 한 계층에 몰아넣을 필요는 없다.
- 여러가지 검증 로직 중에, 도메인 부분에서 검증하면 좋을 내용과
  컨트롤러 부분에서 검증하면 좋을 내용을 잘 고민해서 분류한다.
- 참고자료
    - [[10분 테코톡] 해리&션의 MVC 패턴](https://www.youtube.com/watch?v=uoVNJkyXX0I&t=175s)
    - [MVC 패턴 (feat: 우아한테코톡)](https://velog.io/@jhp1115/MVC-%ED%8C%A8%ED%84%B4-feat-%EC%9A%B0%EC%95%84%ED%95%9C%ED%85%8C%EC%BD%94%ED%86%A1)

## 2. 구현할 기능 목록
### 1) 도메인 로직
- [x] 한 개의 로또는 1~45 중 중복되지 않은 6개의 숫자를 가진다. `new Lotto()`
  - 👿 번호가 1~45 이내의 값이 아니면 에외처리
  - 👿 번호가 총 6개가 아니면 예외처리
  - 👿 번호 중 중복이 있으면 예외처리
- [x] 로또 번호를 자동으로 생성해준다.(자동 발행) `generateLottoNumber()`
- [x] 구입 금액에 해당하는 만큼 로또를 발행한다. `buyLotteries()`
  - 👿 금액이 1,000 미만이면 예외처리 
  - 👿 금액이 1,000으로 나누어 떨어지지 않으면 예외처리
  - *Comment: 금액이 1,000 미만이면 로또를 한 장도 살 수 없기 때문에 해당 예외 상황을 추가했다.*<br>
    *물론 1,000으로 나누어 떨어지는지만 검증하면 자연스럽게 1,000미만의 금액인지도 검증이 되는 셈이다*<br>
    *그러나 에러 메시지의 목적은 사용자에게 왜 에러가 났는지 되도록 자세한 정보를 전달하는 것이라 생각하기 때문에, 이 두 가지 경우를 분리해 예외처리하였다.* 
- [x] 당첨 번호+보너스 번호를 생성한다. `new Lotto()` + `new Bonus()` &rarr; `new Winning()`, `generateWinning()`
  - 👿 번호가 1~45 이내의 값이 아니면 에외처리
  - 👿 번호가 총 6+1개가 아니면 예외처리
  - 👿 번호 중 중복이 있으면 예외처리
- [x] 발행된 로또와 당첨 번호+보너스 번호를 비교하여 등수를 매긴다. `rank()`
- [x] 등수를 바탕으로 수익률을 계산한다. `calculateReturn()`

### 2) UI 로직
- [x] 로또 구입 금액을 입력받는다. `printMessage(PURCHASE_REQUEST)` &rarr; `input()`
- [x] 당첨 번호를 입력받는다. `printMessage(WINNING_MAIN_REQUEST)` &rarr; `input()`
- [x] 보너스 번호를 입력받는다. `printMessage(WINNING_BONUS_REQUEST)` &rarr; `input()` 

- [x] 발행한 로또 수량 및 번호(오름차순)를 출력한다. `printAmountNotice()` &rarr; `printLotto()`
- [x] 당첨 내역을 출력한다. `printMessage(WINNING_DETAILS_NOTICE)` &rarr; `printWinningDetail()`
- [x] 수익률을 출력한다. `printRateOfReturn()`

- [x] 예외 상황 시 에러 문구를 출력한다. `printMessage()`*로 처리*

### 3) Controller 로직
- [x] 입력받은 로또 구입 금액을 로또 발행 도메인 로직으로 넘긴다. `purchaseLotteries()`
  - [x] 금액을 int 타입 정수로 변환한다. `makeInt()`
  - 👿 금액을 int 타입 정수로 변환할 수 없으면 예외처리
- [x] 자동 발행한 모든 로또 번호를 사용자에게 보여준다. `provideLotteriesDetails()`
- [x] 입력받은 당첨 번호를 당첨 번호 생성 도메인 로직으로 넘긴다. `processWinningOngoing()`
  - [x] 각 번호를 int 타입 정수로 변환한다. `makeIntegerList()`
  - 👿 번호를 int 타입 정수로 변환할 수 없으면 예외처리
- [x] 입력받은 보너스 번호를 보너스 번호 생성 도메인 로직으로 넘긴다.`processWinningComplete()`
  - [x] 번호를 int 타입 정수로 변환한다. `makeInt()`
  - 👿 번호를 int 타입 정수로 변환할 수 없으면 예외처리
- [x] 당첨 번호+보너스 번호를 합쳐서 저장한다. `setUpWinning()`
- [x] 당첨 통계 내역 전체를 사용자에게 보여준다. `provideWinningDetails()`
- [x] 수익률을 소수점 둘째 자리에서 반올림한다. `provideRateOfReturn()`

- [x] 예외 상황이 생기면 해당 부분부터 다시 입력받는다. `LottoHandler`, `WinningHandler`
  - [미션 진행 계획-입력값 처리](#3-입력값-처리) 참고
