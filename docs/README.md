# 💸로또 게임

## 기능 목록

### ✏️ 기능 구현 설계

**Domain**

1. LottoMoney

- [x] LottoMoney 생성자 생성
- validate()
  - [x] 로또 구매 금액이 숫자인지 확인
  - [x] 로또 구매 금액이 1,000단위인지 확인
  - [x] 로또 구매 금액이 0인지 확인
- [x] get메서드 생성
- lottoMoney: 로또 금액 저장
- lottoTiket: 로또 개수 저장
- [x] 에러 메시지 Java Enum 적용

2. Lotto

- numbers: 당첨 로또 번호 저장

- validate()
  - 각 경우에 따라 데이터 유효성 검사 수행 및 예외처리
  - "[ERROR]"로 시작하는 예외 문구 출력
  - isSameLength()
    - [x] 로또 번호가 6개인지 확인
  - isWithinValidRange()
    - isCheckRange()
      - [x] 로또 번호가 1부터 45까지 숫자인지 확인
  - isDifferentLottoNumber()
    - [x] 로또 번호가 중복되지 않는 숫자인지 확인
  - [x] get 메서드 생성
  - [x] 에러 메시지 Java Enum 적용

3. LuckeyLotto

- [x] LuckeyLotto 생성자 생성
- luckyBonusNumbers: 보너스 당첨 로또 번호 저장
- luckyNumbers: 당첨 로또 번호(보너스 로또 번호 포함) 저장

- validate()
  - [x] 보너스 로또 번호가 숫자 타입인지 확인
  - [x] 보너스 로또 번호 중복여부 판단
  - [x] 보너스 로또 번호 1부터 45범위인지 확인
- [x] get 메서드 생성
- [x] 에러 메시지 Java Enum 적용

**View**

1. InputView

- enterLottoMoney()
  - [x] 로또 구매 금액 입력
- enterLottoNumber()
  - [x] 로또 당첨 번호 입력 받는다.
- enterBonusLottoNumber()
  - [x] 보너스 당청 번호 입력 받는다.

2. OutputView

- printLottoTicketMessage()
  - [x] 발행한 로또 수량 및 안내 메시지 출력
- printLottoNumber()
  - [x] 발행한 로또 수량 및 번호 출력
- printLottoResultMessage()
  - [x] 로또 당첨 내역 안내 메시지 출력
- printLottoResult()
  - [x] 로또 당첨 내역 출력
    - 6등부터 1등 순서로 일치개수, 상금, 당첨자 명수로 출력
- printRevenuePercentage()
  - [x] 수익률 출력
  - [x] 소수점 둘째 자리에서 반올림

**Controller**

1. GameController

   - 로또 게임 시작
   - startGame()
     - saveLottoMoney()
       - [x] 로또 구매 금액 입력 받는 함수 호출
       - [x] 로또 구매 금액 객체 선언 및 데이터 유효성 검사
     - [x] 로또 티켓 개수 안내 메시지 출력
     - saveRandomLottoNumbers()
       - [x] 1부터 45사이의 6가지 랜덤 수 출력 함수 호출
       - [x] 발행된 로또 번호 출력 함수 호출
       - [x] 로또 개수만큼 로또 발행하여 변수(lottoNumbers)에 저장
     - saveLuckeyNumbers()
       - [x] 로또 당첨 번호 입력받는 함수 호출
       - deleteWhiteSpace()
         - [x] 입력한 로또 당첨 번호 공백 제거 후 저장
       - convertStringToStringList()
         - [x] 쉼표(,)를 기준으로 분리하여 List형으로 반환
       - [x] 로또 객체(lotto) 선언 및 데이터 유효성 검사
     - saveBonusLottoNumber()
       - [x] 보너스 로또 당첨 번호 입력받는 함수 호출
       - [x] 보너스 로또 객체(LuckeyLotto)선언 및 데이터 유효성 검사
     - [x] 본격적인 로또 검사 함수 호출

2. LottoController
   - 로또 당첨자 및 수익률 확인 기능
   - playGame()
     - [x] 로또 결과 시작 출력 메시지 호출
     - dicideLottoWinner()
       - getLottoWinnerCount()
         - [x] 발행된 로또 번호와 당첨 로또 번호 비교하여 포함 개수 반환
       - increaseLottoWinnerCount()
         - [x] 당첨번호 개수가 5개이면서 보너스 번호가 포함된 경우 보너스 당첨자 수 증가
         - [x] 보너스 번호 당첨 아니면서 당첨번호 개수가 2개이상이면 당첨자수 증가
     - infoLottoWinner()
       - isBonusMessage()
         - [x] 보너스 번호 당첨 순서이면 보너스 볼 일치 문자열을 추가한다.
       - isBoounusMatchNumber()
         - [x] 보너스 번호 당첨 순서이면 로또 일치 개수를 하나 줄인다.(5인 경우이므로)
       - [x] 로또 당첨 내역 출력 함수 호출
       - checkBonusLottoTime()
         - [x] 보너스 번호 당첨 순서이면서 한 번도 보너스 번호 당첨 순서가 안온 경우인지 확인
       - [x] 상금 배열 인덱스 증가
     - decideRevenuePercentage()
       - getInvestRevenue()
         - [x] 순투자 수익 계산
       - [x] 수익률 계산하여 반환
3. RandomUtility

- generateRandomLottoNumbers()
  - [x] 1부터 45사이의 서로 다른 6가지 난수 생성
  - sortRandomLottoNumbers()
    - [x] 생성된 난수 오름차순 정렬

## 🚀 기능 요구사항

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
