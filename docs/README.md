# 🎰 로또 

## 🚀 기능 목록

### 입력
- [x] 로또 구입 금액을 입력 받는다.
  - 예외 처리
    - [x] 정수 입력이 아닌 경우 `IllegalArgumentException` 을 발생시킨다.
- [x] 당첨 번호를 입력 받는다.
  - 당첨 번호는 쉼표를 기준으로 구분한다.
  - 예외 처리
    - [x] ',' 와 숫자를 제외한 입력이 있는 경우 `IllegalArgumentException` 을 발생시킨다.
- [x] 보너스 번호 입력를 입력받는다.
  - 예외 처리
    - [x] 정수 입력이 아닌 경우 `IllegalArgumentException` 을 발생시킨다.

### 출력
- [x] 발행한 로또 수량을 출력한다.
- [x] 발행한 로또 번호를 출력한다.
  - [x] 로또 번호는 오름차순이다.
- [x] 당첨 통계를 출력한다.
  - [x] 당첨 내역을 출력한다.
    - "#개 일치 (###원) - #개"
    - [x] 등수가 낮은 순으로 출력한다.
  - [x] 총 수익률을 출력한다.
    - "총 수익률은 ###%입니다."
    - 총 수익률은 `당첨금 / 구매금액 * 100` 이다.
    - [x] 총 수익률은 소수점 둘째 자리에서 반올림한다.

- [x] 예외 상황 시 에러 문구를 출력한다.

### 로또 발행
- [x] 구입 금액에 따라 로또를 발행한다.
  - [x] 로또 금액은 한 장당 1000원이다.
  - 예외 발생
    - [x] 0이하의 금액인 경우 `IllegalArgumentException` 을 발생시킨다.
    - [x] 1,000원으로 나누어 떨어지지 않는 경우 `IllegalArgumentException` 을 발생시킨다.
- [x] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.

### 로또 추첨
- [x] 입력으로부터 당첨 번호를 구한다.
  - 예외 처리
    - [x] 당첨 번호가 6개가 아닌 경우 `IllegalArgumentException` 을 발생시킨다.
    - [x] 당첨 번호가 1 ~ 45 의 범위를 벗어나는 경우 `IllegalArgumentException` 을 발생시킨다.
    - [x] 당첨 번호에 중복이 있는 경우 `IllegalArgumentException` 을 발생시킨다.
- [x] 입력으로부터 보너스 번호를 구한다.
  - 예외 처리
    - [x] 보너스 번호가 1~45 의 범위를 벗어나는 경우 `IllegalArgumentException` 을 발생시킨다.
    - [x] 보너스 번호가 당첨 번호에 이미 있는 번호인 경우 `IllegalArgumentException` 을 발생시킨다.

### 당첨
- [x] 발행된 로또와 겹치는 당첨번호의 개수를 구한다.
- [x] 발행된 로또에 보너스 번호가 있는지 구한다.
- [x] 당첨은 1등부터 5등까지 있다
  - [x] 그 외는 낙첨이다.
- [x] 당첨 통계를 구한다.
  - [x] 당첨 기준에 따른 등수를 구한다.
  - [x] 총 수익금을 구한다.


### 공통 예외 처리
- [x] 사용자가 잘못된 값을 입력할 경우 'IllegalArgumentException' 을 발생시킨다.
- [x] 예외가 발생한 경우 관련된 메세지를 출력하고 그 부분부터 바로 다시 입력을 받는다.
- [x] 에러 메세지는 "[ERROR]"로 시작해야한다.
- [x] 'Exception'이 아닌 명확한 유형을 처리한다. 


## 🚀 주요 클래스와 메서드 

### 📁 Domain

#### Lotto : 발행된 로또 모델
* `validate` : Lotto 생성 시 숫자가 6개 & 중복없음을 만족하는 지 검증한다.
* `countMatchingMainNumbers` : 6개 숫자 중 당첨번호와 일치하는 숫자의 개수를 구한다.
* `hasBonusNumber` : 6개의 숫자 중 보너스 번호와 일치하는 번호가 있는지 구한다.

#### WinningNumbers : 당첨 번호 모델
- #### MainNumbers :  당첨 번호 중 6개의 주요 번호를 다루는 모델
  - 당첨 번호가 주어진 조건을 만족할 때만 생성 가능하다.
  - `isMainNumber` : 파라미터로 들어온 값이 당첨 번호 중에 존재하는지 참/거짓 값을 반환한다.
- #### BonusNumber : 당첨 번호 중 보너스 번호를 다루는 모델
  - 보너스 번호가 주어진 조건을 만족할 때만 생성 가능하다.
  - `isBonusNumber` : 파라미터로 들어온 값이 보너스 번호와 같은를 반환한다.
#### Payment : 로또 구매 금액 모델
  - 로또 구매가 가능한 금액일 때만 생성 가능하다.
  - `getLottoCount` : 로또 단가에 따라 구입한 로또 티켓 수를 반환한다.
#### Ranking : 등수, 당첨 조건 모델
 - `findFrom` : 6개 메인 번호 중 일치한 개수와 보너스 번호 일치 여부에 따라 해당되는 등수를 구한다.
#### RankingCounter : 발행된 로또 중에서 몇 장이 몇 등으로 당첨됐는지 다루는 모델
 - `addCount` : 1~5등 안에 들었으면 해 당 카운트 값을 증가시킨다.  
 - `getPrizeMoney` : 당첨 결과에 따라 총 당첨 금액을 구한다.

### 📁 Service
#### LottoService : 티켓 발행과 정보를 다루는 서비스
 - `buyTickets` : 구매 금액에 따라 로또 티켓을 발행한다.  
 - `tickets` : 발행된 로또 정보를 컨트롤러에 `LottoTicket` dto로 반환한다.
 - `play` : 발행된 로또 마다 RankingService::savePlayResult() 를 호출해 각 티켓의 당첨 정보가 생성되게한다. 
#### RankingService : 티켓 당첨 결과를 다루는 서비스
 - `savePlayResult` : 로또의 당첨 결과를 카운터에 저장한다.
 - `getRankingResult` : 당첨 결과를 컨트롤러에 `StatisticsResult` dto로 반환한다. 

### 📁 Validator
#### Validator : 검증 관련 메서드들 선언
- `validateNumeric` : 들어온 입력이 양의 정수인 지 검증한다.
- `validateMainNumbersInput` : 입력한 당첨 결과가 '숫자,숫자,...,숫자'의 형식인지 검증한다.
- `validatePayment` : 구매 금액이 자연수이면서 1000원 단위의 금액인지 검증한다.
- `validateMainNumbers` : 당첨 번호가 6개, 중복 없음, 1~45내의 숫자인지 검증한다.
- `validateBonusNumber` : 보너스 번호가 당첨 번호와 중복 없고 1~45 내의 숫자인지 검증한다.

### 📁 그 외
#### Prize : 당첨 등수에 따른 금액과 출력에 대한 정보를 갖는 Enum
