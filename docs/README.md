## 로또 게임 규칙
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원


## 기능 목록
# domain
- [x] 로또 번호 생성하기 - NumberGenerator#createRandomNumbers()
  - [x] 1~45 중복되지 않는 6개의 숫자 채번

- [x] 로또 구매하기 - Buy#getGames()
  - [x] 로또 구매 금액은 1장당 1,000원
  - [x] 구매 금액은 1,000원 단위로 입력
  - [x] 1,000원 단위로 떨어지지 않는 경우 예외 처리 후 다시 입력

- [x] 로또 발행하기 - Buy#createGames()
  - [x] 구매 금액에 해당하는만큼 로또 발행

- [x] 당첨 번호 입력하기 - Draw#winningNumbers()
  - [x] 6개의 중복되지 않는 당첨 번호 입력
  - [x] 번호는 쉼표를 기준으로 구분
  - [x] 1 개의 중복되지 않는 보너스 번호 입력
  - [x] 중복되는 숫자일 경우 예외 처리 후 다시 입력

- [x] 로또 번호 비교하기 - Judgement#correctNumbers()
  - [x] 몇 개의 숫자가 같은지 판단 - Judgement#correctCount()
  - [x] 6개 번호 일치하면 1등
  - [x] 5개 번호와 보너스 번호가 일치하면 2등
  - [x] 5개 번호 일치하면 3등
  - [x] 4개 번호 일치하면 4등
  - [x] 3개 번호 일치하면 5등

- [x] 총 수익 계산하기 - Judgement#resultAmount()

# Exception
- [x] 예외 처리
  - [x] String to int 변환 체크 - Exception#checkInt
  - [x] 1000 단위 체크 - Exception#checkAmount
  - [x] 숫자 중복 여부 체크 - Exception#checkNumbers
  - [x] 6자리 숫자 여부 체크 - Exception#checkLength
  - [x] 보너스 숫자 중복 여부 체크 - Exception#checkBonus

# view
- [x] 구매 로또 출력하기 - PrintGames#purchaseHistory()
  - [x] 발행한 로또 수량, 번호 출력
  - [x] 로또 번호는 쉼표를 기준으로 구분
  - [x] 로또 번호는 오름차순으로 정렬

- [x] 당첨 내역 출력하기 - PrintGames#finalResults()
  - [x] 등수에 따른 금액과 당첨 개수 출력 - PrintGames#resultMessage()

- [x] 수익률 출력하기 - PrintGames#returnRate()
  - [x] 소수점 둘째 자리에서 반올림하여 출력