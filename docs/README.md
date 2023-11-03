## 💸 기능 명세
### 1. 로또 구입 금액을 입력 받는다.
- 로또 금액은 1000원이다. `이는 바뀔 수 있다.`

이 때 입력값에 공백이 있다면 User로 하여금 다시 입력하게 하지 않고 넘어간다. 

다만 아래의 경우 예외를 발생시킨다.

  [**예외상황**]
  - 숫자가 아니다. `IllegalStateException`
  - 0원이다. `IllegalStateException`
  - 최대 구입 가능 금액(50장)을 넘는다. `IllegalArgumentException`
  - 1000원 단위가 아니다. `IllegalArgumentException`
  - null이다. `IllegalStateException`

### 2. 발행한 로또 수량 및 번호를 출력한다.
이 때 로또 번호는 오름차순으로 정렬하여 보여준다. `오름차순은 바뀔 수 있다.`
- 최솟값 1에서 최댓값 45까지의 범위의 수다. `이는 바뀔 수 있다.`

### 3. 당첨 번호를 입력한다.
이 때 입력값에 공백이 있다면 User로 하여금 다시 입력하게 하지 않고 넘어간다. 

다만 아래의 경우 예외를 발생시킨다.

  [**예외상황**]
  - 숫자가 아니다. `IllegalStateException`
  - 최솟값 미만의 수가 포함되어있다. `IllegalArgumentException`
  - 최댓값 초과의 수가 포함되어있다. `IllegalArgumentException`
  - 서로 중복된 숫자가 있다. `IllegalArgumentException`

### 4. 보너스 번호를 입력한다.
이 때 입력값에 공백이 있다면 User로 하여금 다시 입력하게 하지 않고 넘어간다. 

다만 아래의 경우 예외를 발생시킨다.

  [**예외상황**]
  - 숫자가 아니다. `IllegalStateException`
  - 최솟값 미만의 수다. `IllegalArgumentException`
  - 최댓값 초과의 수다. `IllegalArgumentException`
  - 기존 당첨 번호 내에 포함되어있는 수다. `IllegalArgumentException`

### 5. 결과를 출력한다.
  - 당첨 내역을 출력한다.
    - 템플릿에 맞게 출력한다. `이는 바뀔 수 있다.`
  - 수익률을 출력한다.
    - 로또 수익 금액 / 쓴 금액 * 100의 공식을 따른다.
    - 소수점 첫번째 자리까지 출력한다. `이는 바뀔 수 있다.`

## ❌ 예외 상황에 대한 규칙
- 에러 문구는 "**[ERROR]**"로 시작해야 한다.

- 에러 상황시 그를 캐치하여 문제가 생겼던 지점부터 실행해야한다.

### 사용된 예외들
- `IllegalArgumentException`: 값 자체는 가능하지만 원활한 게임을 하기 어려운 경우.
- `IllegalStateException`: 게임 자체가 불가능한 경우. 숫자인데 문자가 포함되었거나, null이거나, 돈이 0원일 경우
