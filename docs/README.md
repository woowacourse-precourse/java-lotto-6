# 로또

## 개요

1. 로또 구입 (금액 입력)
   1. 구입 즉시 구입한 수량만큼의 로또를 발행 후 출력
      - "\_개를 구매했습니다."
      - "[\_, \_, \_, \_, \_, \_]"
      - ...
2. 당첨 번호 입력
3. 보너스 번호 입력
4. 당첨 통계 출력
   1. 당첨 정보
      - "\_개 일치 (\__,\___원) - \_개"
   2. 수익률
      - 총 수익률은 \__.\_% 입니다.

## 구성

### Model

#### `class Lotto` 
**로또 한 장의 정보를 담는 객체**
- 로또 숫자 6개를 담은 `List`
- 기능 
  - 당첨 확인
    - 정답과 비교해 일치하는 숫자를 확인한다.

#### `class LottoAnswer extends Lotto`
**정답 로또 정보를 담는 객체**
- 보너스 숫자

#### `enum Result`
**당첨 결과를 담는 객체**
- 당첨 금액
- 기능
  - 결과 생성
    - 일치하는 숫자의 개수를 확인해 결과 정보를 반환

### Controller

#### `class LottoController`
**전체 로또 게임을 총괄하는 객체**

### Util

#### `interface LottoGenerator`
**로또를 생성해 주는 인터페이스**
- 기능
  - 로또 생성

#### `class RandomLottoGenerator`
**랜덤 값을 사용해 로또를 생성해 주는 객체**

### UI

#### `class Reader`
**사용자의 입력 값을 처리하는 객체**

#### `class Printer`
**프로그램의 결과를 출력하는 객체**
- 기능
  - 결과 출력
  - 예외 출력
    - 에러 문구는 "[ERROR]"로 시작해야 한다.

### ETC
#### `interface ExceptionHandler`
**예외 발생시 처리 방법을 구현할 객체**

#### `class RetryExceptionHandler`
**예외 발생시 다시 로직을 시도하는 `ExceptionHandler`**

## 참고

입력을 받은 후, 사용자 편의를 위해 공백 처리