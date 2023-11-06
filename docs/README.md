# 로또 - 기능 목록
- - -
### 1. 사용자 입력 처리 - `view\InputView`
- [x] 로또 구입 금액 입력받기 - `inputPurchaseAmount()`
  - [x] 테스트: 입력 후 int로 반환 확인
- [x] 당첨 번호 입력받기 - `inputWinningNumbers()`
  - [x] 테스트: 입력 후 List로 반환 확인
- [x] 보너스 번호 입력 받기 - `inputBonusNumber()`
  - [x] 테스트: 입력 후 int로 반환 확인

### 2. 로또 객체 - `domain\Lotto`
- [ ] 로또 번호를 가진다. `List<Integer> numbers`

### 2-1. 로또 발행하기 - `service\LottoService`
- [ ] 발행 수량 구하기 - `getPurchaseAmount()`
- [ ] 발행하기 - `issueLotteryTicket()`

### 2-2. 당첨 번호와 비교하기 - `service\LottoService`
- [ ] 일치한 개수 구하기 - `getMatchingNumbers()`
- [ ] 총 수익률 구하기 - `getRateOfReturn()`

### 3. 출력하기 - `view\OutputView`
1. 구입 금액 - `outputPurchaseAmount()`
   - [ ] 구입금액 입력 안내 문구 출력하기
   - [ ] 구입 금액 출력하기
2. 로또 발행 - `outputIssuingLotteryTicket()`
   - [ ] 수량 출력하기
   - [ ] 번호 출력하기
4. 당첨 번호 - `outputWinningNumbers()`
   - [ ] 당첨 번호 입력 안내 문구 출력하기
   - [ ] 당첨 번호 출력하기
5. 보너스 번호 - `outputBonusNumber()`
   - [ ] 보너스 번호 입력 안내 문구 출력하기
   - [ ] 보너스 번호 출력하기
6. 당첨 통계 - `outputResult()`
   - [ ] 당첨 통계 안내 문구 출력하기
   - [ ] 당첨 내역 출력하기
   - [ ] 수익률 출력하기

### 4. 예외 처리
1. 로또 금액
   - [ ] 1,000원 단위로 입력 받으며, 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
   - [ ] 숫자가 아닐 경우 예외 처리한다.
2. 로또 번호
   - [ ] 1부터 45 사이의 숫자여야 하며, 아닐 경우 예외 처리 한다.
   - [ ] 6자리를 받으며, 아닐 경우 예외 처리한다.
3. 당첨 번호
   - [ ] 쉼표(,)를 기준으로 구분하며, 쉼표가 아닐 경우 예외 처리한다.
4. 보너스 번호
   - [ ] 숫자 하나만 받으며, 아닐 경우 예외 처리한다.