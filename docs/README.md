# 기능별 클래스와 메서드 정리

## 1. LottoMachine
- 로또 구입하고 발행하는 기능
- 사용자로부터 로또 구입 금액 입력받고, 해당 금액에 맞게 로또 발행
### 1.1. purchaseLottoTickets(int purchaseAmount)
- 구입 금액 입력받아 해당 금액에 맞게 로또 발행하고 반환
### 1.2. generateRandomNumbers()
- 1부터 45까지 숫자 중 랜덤하게 6개 숫자 선택하여 반환

---

## 2. LottoTicket
- 하나의 로또 티켓을 나타낸다. 6개의 로또 번호를 가진다
### 2.1. LottoTicket(List<Integer> numbers)
- 생성자
- 6개의 로또 번호를 입력 받아 LottoTicket 객체 생성
### 2.2. getNumbers()
- 로또 티켓 번호 반환
### 2.3. contains(int number)
- 특정 번호가 로또 티켓에 포함되어 있는지 확인하는 메서드

---

## 3. WinningLotto
- 당첨 로또. 6개의 당첨 번호와 1개의 보너스 번호가 있다. 그 번호를 입력받는다
### 3.1. WinningLotto(List<Integer> numbers, int bonusNumber)
- 생성자
- 6개의 당첨 번호와 1개의 보너스 번호를 입력받아 객체 생성
### 3.2. getMatchCount(LottoTicket lottoTicket)
- 당첨 번호와 로또 티켓의 번호 중 몇 개 일치하는지 확인 메서드
### 3.3. isBonusMatched(LottoTicket lottoTicket)
- 보너스 번호가 로또 티켓의 번호 중에 있는지 확인 메서드

---

## 4. LottoResult
- 로또 당첨 결과를 계산하고 저장하는 기능
- WinningLotto와 사용자의 LottoTicket들을 비교하여 당첨 결과 계산
### 4.1. calculateResult(List<LottoTicket> lottoTickets, WinningLoto winningLotto)
- 당첨 결과를 계산하는 메서드
### 4.2. getPrizeMoney()
- 당첨된 금액의 총합을 반환하는 메서드
### 4.3. getEarningsRate(int purchaseAmount)
- 수익률 계산하는 메서드

## 5. InputMachine
- 사용자로부터 입력받는 기능
### 5.1. inputPurchaseAmount()
- 로또 구입 금액 입력받는 메서드
### 5.2. inputWinningNumbers()
- 당첨 번호 입력받는 메서드
### 5.3. inputBonusNumber()
- 보너스 번호 입력받는 메서드
### 5.4. validateNumbers(List<Integer> numbers)
- 로또 번호가 1~45 사이 번호인지 확인하는 메서드
- 그 이외의 번호이면 에러 메시지 출력

---

## 6. OutputMachine
- 결과 출력하는 기능
### 6.1. printLottoTickets(List<LottoTicket> lottoTickets)
- 구매한 로또 티켓들 출력하는 메서드
### 6.2. printLottoResult(LottoResult lottoResult)
- 로또 당첨 결과를 출력하는 메서드
### 6.3. printEarningsRate(double earningsRate)
- 수익률 출력 메서드