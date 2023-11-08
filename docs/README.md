# 로또

**규칙 참고**

* 하나의 함수는 하나의 기능, 변수 이름에 자료형X, 값을 하드코딩X, 컨벤션 지키기
* **15라인 이내 함수, else 사용금지, Java Enum 적용, 도메인 로직에 단위 테스트 구현**
  * Enum 어디에 적용 해야할지 모르겠네ㅜㅜ

<br><br>

## 기능 목록

### 1. 입력 기능

* [x] 로또 구입 금액을 입력 - InputLotto#purchaseMoney(), readMoney()
  * [x] 사용자가 잘못된 값을 입력하면 예외 발생 - IllegalArgumentException
* [x] 당첨 번호를 입력 - InputLotto#answerNumber(), readAnswer()
  * [x] 사용자가 잘못된 값을 입력하면 예외 발생 - IllegalArgumentException
  * [x] 숫자 범위 예외 처리용 함수 - InputLotto#exceptNumberRange()
* [x] 보너스 번호를 입력 - InputLotto#bonusNumber(), readBonus()
  * [x] 사용자가 잘못된 값을 입력하면 예외 발생 - IllegalArgumentException
  * [x] 숫자 범위 예외 처리용 함수 - InputLotto#exceptNumberRange()

<br>

### 2. 로또 기능

* [x] 1개의 로또 발행 - LottoGenerator#createLotto()
  * [x] X개의 로또 기록 - LottoGenerator#createLottos()
* [x] 사용자 로또 번호와 당첨 번호 비교 - Referee#compareToLottos(), compareToLotto()
  * [x] 수익률 계산 - Referee#calculateIncome()
* [x] 기존 로또 클래스에 getter 추가 - Lotto#getNumbers()

<br>

### 3. 출력 기능

* [x] 로또 수량 출력 - OutputLotto#counts()
* [x] 로또 번호 출력(오름차순) - OutputLotto#numbers()
* [x] 당첨 내역 출력 - OutputLotto#winningHistory()
* [x] 수익률 출력 - OutputLotto#incomeRate()

<br>

### 4. 추가 예외 처리

* [x] 숫자 범위 예외 처리용 함수 - InputLotto#exceptNumberRange()
* [x] 로또 숫자 중복 검증 함수 - Lotto#validateDuplication()

<br><br>

## 요구사항 분석

### 1. 입출력 요구 사항

#### 1-1. 입력

* **로또 구입 금액 입력**
  * 구입 금액은 **1000원 단위**
  * 1000원으로 나누어 떨어지지 않으면 **예외 처리**
* **당첨 번호를 입력**
  * 번호는 **쉼표(,)**를 기준으로 **구분**
* **보너스 번호를 입력**

<br>

#### 1-2. 출력

* **로또 수량과 번호를 출력**
  * 번호는 오름차순 정렬
* **당첨 내역을 출력**
  * 쉼표(,)로 1,000원 단위 구분 : `3개 일치 (5,000원) - 1개`
  * 보너스 볼 일치할 경우 : `5개 일치, 보너스 볼 일치 (30,000,000원) - 0개`
* **수익률을 출력**
  * 소수점 둘째 자리에서 반올림 : `총 수익률은 62.5%입니다.`
* **예외 상황 에러 문구 출력**
  * "[ERROR]" 로 시작 : `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`

<br>

### 2. 로또 기능 분석

* **1개의 로또 발행** 
  * 중복되지 않는 6개의 숫자
  * 범위 : 1~45
  * 가격 : 1000원
* **사용자 로또 번호와 당첨 번호를 비교**
  * 당첨 내역
  * 수익률
* 잘못된 값 입력시 `IllegalArgumentException` 에러 발생 후 다시 입력 받기
  * "[ERROR]" 로 시작하는 에러메시지 출력 필수

<br>

### 3. 테스트 예제

* **입력**

  * `구입금액을 입력해 주세요.`
  * 로또 구입 금액 : `14000`
    * 14000 / 1000 을 통해 14개의 로또가 발행되어야 함
    * 만약 14001 이라면? 예외 발생
  * 담청 번호 : `1,2,3,4,5,6`
  * 보너스 번호 : `7`

* **출력**

  * 구매수량 출력 : `8개를 구매했습니다.`

  * 로또 번호 출력(오름차순)

    * `[8, 21, 23, 41, 42, 43]`
    * `[3, 5, 11, 16, 32, 38]`
    * 등등... 8개..

  * 당첨 내역을 출력

    * `3개 일치 (5,000원) - 1개`
    * `4개 일치 (50,000원) - 0개`
    * `5개 일치 (1,500,000원) - 0개`
    * `5개 일치, 보너스 볼 일치 (30,000,000원) - 0개`
    * `6개 일치 (2,000,000,000원) - 0개`

  * 수익률 출력(소수점 둘째 자리 반올림) : `총 수익률은 62.5%입니다.`

  * 예외 상황 : `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`

    