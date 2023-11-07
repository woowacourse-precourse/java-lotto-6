# 기능 목록

--- 

### 입력 기능
- [x] 로또 구입 금액을 사용자로부터 입력 받는다. - enterLottoPurchaseAmount()
- [x] 당첨 번호를 사용자로부터 입력 받는다. - enterWinningNumbers()
- [x] 보너스 번호를 사용자로부터 입력 받는다. - enterBonusNumber()

---

### 출력 기능
- [ ] 사용자가 구매한 로또 번호와 당첨 번호 비교하여 당첨 내역 및 수익률을 출력 후 종료 -  printCompareUserLottoNumbersAndWinning()
- [x] 발행한 로또 수량 및 번호를 오르차순으로 출력한다. - printIssuedLottoNumbersInAscendingOrder()
- [ ] 당첨 내역을 출력한다. - printWinningDetails()
- [ ] 수익률을 출력한다. - printReturnOnInvestment()

---

### 로또 플레이 기능
- [ ] 당첨 내역의 총 수익률은 소수점 둘째 자리에서 반올림하여 계산한다. - calculateRateReturn()
- [ ] 당첨된 로또의 내역을 확인한다. - checkWinningDetails()

---

## 도메인 모델

### Lotto - 로또 번호를 관리하는 역할
 - [x] 로또 번호는 1~45 범위 내의 숫자만 가능한지 체크하는 함수 - validateLottoNumberRange()
 - [x] 로또 발행 시, 중복되지 않는 6개의 숫자를 체크하는 함수 - validateLottoNumbersDuplication()
 - [x] 로또 번호의 개수가 6개가 넘어가면 예외가 발생하는 함수 - validate()
 - [x] 로또 번호 출력 함수 - toString()

### ReadPurchaseAmount - 구매 금액을 관리하는 역할
 - [x] 로또 구입 금액의 입력 받은 값이 빈 값인지 체크하는 함수 - nullCheckPurchaseAmount()
 - [x] 로또 구입 금액이 1,000원 단위가 아닐 경우 예외를 처리하는 함수 - invalidLottoPurchaseAmount()

### LottoRamdomNumbers - 랜덤 로또 번호 관리하는 역할
 - [x] 구입금액에 따른 로또 번호를 랜덤으로 생성하는 함수 - generateRandomLottoNumbers()

### LottoWinningNumber - 로또 당첨 번호 관리 역할
 - [x] 로또 당첨 번호는 숫자와 콤마 형식을 체크하는 함수 - validateNumberAndCommaFormat()
 - [x] 당첨 번호 문자열을 로또 형식으로 변환하는 함수 - convertStringToLottoFormat()

### LottoBonusNumber - 로또 보너스 번호 관리 역할
 - [x] 보너스 번호 빈값 체크 - validateBonusNumberNullCheck()
 - [x] 보너스 번호 1~45 범위 내의 숫자만 가능한지 체크 - validateBonusNumberRange()
 - [x] 로또 숫자 6개와 추가로 1개의 보너스 번호 중복 체크를 한다. - validateWinningNumbersAndBonusNumber()
 - [x] 보너스 번호 문자열을 숫자로 변경하는 함수 - convertStringToIntegerFormat()