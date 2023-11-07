# 로또 - 기능 목록
- - -
### 1. 사용자 입력 처리 - `view\InputView`
- [x] 로또 구입 금액 입력받기 - `inputPurchasePrice()`
  - [x] 테스트: 입력 후 int로 반환 확인
- [x] 당첨 번호 입력받기 - `inputWinningNumbers()`
  - [x] 테스트: 입력 후 List로 반환 확인
- [x] 보너스 번호 입력 받기 - `inputBonusNumber()`
  - [x] 테스트: 입력 후 int로 반환 확인

### 2. 로또 객체 - `domain\Lotto`
- [x] 로또 번호를 가진다. `List<Integer> numbers`

### 2-1. 당첨 등수 및 당첨 금액 enum 객체 - `domain\Prize`

### 2-2. 로또 발행하기 - `service\LottoService`
- [x] 발행 수량 구하기 - `getLotteryTicketCount()`
  - [x] 테스트: 1,000원으로 나눈 수량 확인
- [x] 발행하기 - `issueLotteryTicket()`
  - [x] 테스트: 발행 후 나온 6자리 숫자가 오름차순인지 확인
- [x] 모든 수량을 발행하기 - `issueLotteryTicketAll()`
  - [x] 테스트: 구입한 만큼 발행되었는지 확인

### 2-3. 당첨 번호와 비교하기 - `service\LottoService`
- [x] 일치한 개수 구하기 - `getMatchingNumbers()`
  - [x] 테스트: 일치한 개수 확인
- [x] 보너스 숫자 일치 여부 구하기 - `isMatchingBonusNumber()`
  - [x] 테스트: 보너스 숫자 일치 여부 확인
- [x] 당첨 등수와 당첨금 구하기 - `getPrize()`
  - [x] 테스트: 번호와 보너스 번호 일치에 따른 당첨 등수와 당청금 확인
- [x] 총 수익률 구하기 - `getRateOfReturn()`
  - [x] 테스트: 구입 금액 대비 당첨 금액 확인

### 3. 출력하기 - `view\OutputView`
1. 구입 금액 - `printInputPurchasePriceSentence()`
   - [x] 구입금액 입력 안내 문구 출력하기
2. 로또 발행 - `printIssuingLotteryTicket()`
   - [x] 수량 출력하기
   - [x] 번호 출력하기
4. 당첨 번호
   - [x] 당첨 번호 입력 안내 문구 출력하기 - `printInputWinningNumbersSentence()`
5. 보너스 번호 - `outputBonusNumber()`
   - [x] 보너스 번호 입력 안내 문구 출력하기
6. 당첨 통계 - `outputResult()`
   - [x] 당첨 통계 안내 문구 출력하기
   - [x] 당첨 내역 출력하기
   - [x] 수익률 출력하기

### 4. 예외 처리 - `validation\LottoValidation`
1. 로또 금액 - `validatePurchasePrice()`
   - [x] 1,000원 단위로 입력 받으며, 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
     - [x] 테스트: [ERROR] 천원 단위로 입력해 주세요.
   - [x] 숫자가 아닐 경우 예외 처리한다.
     - [x] 테스트: [ERROR] 숫자만 입력해 주세요.
2. 로또 번호 - `validateLottoNumbers()`
   - [x] 1부터 45 사이의 숫자여야 하며, 아닐 경우 예외 처리 한다.
     - [x] 테스트: [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
   - [x] 6자리를 받으며, 아닐 경우 예외 처리한다.
     - [x] 테스트: [ERROR] 로또 숫자는 6자리여야 합니다.
3. 당첨 번호 - ``
   - [ ] 쉼표(,)를 기준으로 구분하며, 쉼표가 아닐 경우 예외 처리한다.
4. 보너스 번호
   - [ ] 숫자 하나만 받으며, 아닐 경우 예외 처리한다.