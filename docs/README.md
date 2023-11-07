기능 요구 사항 목록
=============
***
## 1. view 패키지
### 1.1. InputView
- [X] 구입 금액을 입력 받는다.
- [X] 당첨 번호를 입력 받는다.
- [X] 보너스 번호를 입력 받는다.
### 1.2. OutputView
- [X] 발행한 로또 수량 출력한다.
- [X] 로또 번호를 출력한다.
- [X] 당첨 통계를 출력한다.
- [X] 수익률을 출력한다.

### 입출력 요구사항
- 구입 금액이 1000원 단위로 나누어 떨어지지 않는 경우 예외 처리한다.
- 번호는 쉼표(,)를 기준으로 구분한다.
- 하나의 숫자만 입력 받는다.
- 로또 번호는 오름차순으로 정렬하여 보여준다.
- 수익률은 소수점 둘째 자리까지 출력한다.

***

## 2. domain 패키지
### 2.1. Lotto 
- [X] validate() 메서드를 통해 입력받은 로또 개수가 유효한지 확인

### 2.2.LottoNumbers
- [X] createPlayerLotto() 메서드를 통해 로또 번호를 생성 (오름차순)

### 2.3. BonusNumber
- [X] validate() 메서드를 통해 입력받은 보너스 번호가 유효한지 확인

### 2.4. Price
- [X] validate() 메서드를 통해 입력받은 구입 금액이 유효한지 확인

***

## 3. service 패키지
### 3.1. LottoResult
- [X] statisticsLotto() 메서드를 통해 로또 당첨 통계를 생성
- [X] rateOfReturn() 메서드를 통해 로또 수익률을 계산
- [X] compareLotto() 메서드를 통해 로또 당첨 번호와 로또 구매 번호를 비교
### 3.2. LottoType Enum Class
- [X] LottoType enum class를 통해 로또 등수를 정의
- [X] getPrize() 메서드를 통해 로또 등수에 따른 상금을 반환
- [X] getMatchCount() 메서드를 통해 로또 등수에 따른 일치 개수를 반환
- [X] getBonus() 메서드를 통해 로또 등수에 따른 보너스 여부를 반환
- [X] getLottoType() 메서드를 통해 로또 등수를 반환
### 3.3. Error Enum Class
- [X] Error enum class를 통해 예외 메시지를 정의

### 3.4. LottoValidator Class
- [X] validateDuplicate() 메서드를 통해 입력받은 로또 번호가 중복되지 않는지 확인
- [X] validateRange() 메서드를 통해 입력받은 로또 번호가 1~45 사이의 숫자인지 확인
- [X] validateBonus() 메서드를 통해 입력받은 보너스 번호가 1~45 사이의 숫자인지 확인
- [X] validateBonusOverlap() 메서드를 통해 입력받은 로또 번호와 보너스 번호가 중복되지 않는지 확인
- [X] validate() 메서드를 통해 입력받은 로또 개수가 유효한지 확인

### 3.5 Price Validator Class
- [X] validate() 메서드를 통해 입력받은 구입 금액이 유효한지 확인
- [X] validateNumber() 메서드를 통해 입력받은 구입 금액이 숫자인지 확인
- [X] validateMinPrice() 메서드를 통해 입력받은 구입 금액 1000원 이상인지 확인
- [X] validateUnitPrice() 메서드를 통해 입력받은 구입 금액이 1000원 단위인지 확인

### 3.6. LottoValidator Class
- [X] validateDuplicate() 메서드를 통해 입력받은 로또 번호가 중복되지 않는지 확인
- [X] validateRange() 메서드를 통해 입력받은 로또 번호가 1~45 사이의 숫자인지 확인
- [X] validateBonus() 메서드를 통해 입력받은 보너스 번호가 1~45 사이의 숫자인지 확인
- [X] validateBonusOverlap() 메서드를 통해 입력받은 로또 번호와 보너스 번호가 중복되지 않는지 확인

***
## 3. controller 패키지
### 3.1. LottoController
- [X] run() 메서드를 통해 로또 게임을 실행
- [X] inputPrice() 메서드를 통해 로또를 구매
- [X] inputWinningLotto() 메서드를 통해 로또 당첨 번호를 입력
- [X] inputBonusNumber() 메서드를 통해 로또 보너스 번호를 입력
- [X] printLottoStatistics() 메서드를 통해 로또 당첨 통계를 출력
- [X] matchLotto() 메서드를 통해 로또 당첨 번호와 로또 구매 번호를 비교
- [X] createLotto() 메서드를 통해 로또 번호를 생성
- [X] createPlayerLotto() 메서드를 통해 로또 번호를 생성

