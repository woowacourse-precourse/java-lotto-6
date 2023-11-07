# 클래스별 메서드 정리

## 클래스 Lotto
### 변수
- List<Integer> numbers : 로또 번호 6개

### Lotto(List<Integer> numbers)
- 생성자
- 받은 숫자가 유효한지 확인한다
- 인스턴스 변수에 저장

### boolean validateNumbers(List<Integer> numbers)
- 당첨 로또 번호가 6개인지 확인
- 로또번호가 1부터 45 사이의 번호인지 확인

### int countMatchNumbers(Lotto winningLotto)
- 당첨 번호와 일치하는 로또 번호 개수를 센다

### boolean isBonusMatched(int bonusNumber)
- 보너스 번호가 포함되어있는지 확인

### List<Integer> getNumbers
- 클래스 외부에서 로또 번호 get하기

---

## 클래스 Application

### main
- 구입금액에 따라 lotto 개수 실행
- 당첨 로또 번호 입력받기
- 당첨

---
### int inputPurchaseAmount()
- 구입금액 입력받음
- 구입금액이 형식에 맞는지 확인

### void validPurchaseAmount(int purchaseAmount)
- 구입금액이 형식에 맞지 않으면 에러 처리

### List<Lotto> generateLottos(int count)
- 로또 개수에 맞게 생성
- 랜덤 생성 숫자 6개 객체에 저장

### List<Integer> generateRandomNumbers()
- 1부터 45까지 숫자 중 랜덤하게 6개 숫자 선택하여 반환

### List<Integer> inputWinningNumbers()
- 당첨 번호 입력받아서 반환

### int inputBonusNumber()
- 보너스 번호 입력 받아 반환

---
### enum winningPrize
- 결과에 따른 수익 저장

### calculateResult(List<Lotto> lottos, WinningLotto winningLotto)
- 당첨 결과를 계산하는 메서드
### getPrizeMoney(Map<Integer, Integer> resultMap)
- 당첨된 금액의 총합을 반환하는 메서드
### calculateEarningsRate(int purchaseAmount, int totalPrizeMoney)
- 수익률 계산하는 메서드

---

### void printResult(List<Lotto> lottos, Lotto winningLotto, int purchaseAmout)
- 당첨 내역 & 수익률 출력

### printLottoTickets(List<LottoTicket> lottoTickets)
- 구매한 로또 티켓들 출력하는 메서드
### printLottoResult(LottoResult lottoResult)
- 로또 당첨 결과를 출력하는 메서드
### printEarningsRate(double earningsRate)
- 수익률 출력 메서드