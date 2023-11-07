
## 기능 목록
### 입력, 출력
**- InputView -**
- **[getBuyAmount]** : 로또 구입 금액을 입력 받고, 숫자인지 확인 후 int로 리턴한다.
- **[getWinningNumber]** : 당첨 번호를 입력 받고, 숫자와 쉼표로만 이뤄져있는지 확인 후 int 배열로 리턴한다.
- **[getBonusNumber]** : 보너스 번호를 입력 받고, 숫자인지 확인 후 int로 리턴한다.

**- OutputView -**
- **[printBuyLottoCount]** : 구매한 로또 수량을 출력한다.
- **[printLottoNumbers]** : 구매한 로또의 번호들을 출력한다.
- **[printWinningResult]** : 로또 당첨 내역을 출력한다.
- **[printYields]** : 수익률을 출력한다.

#### 예외
**- InputValidator -**
  - **[isNumber]** : 입력 값이 숫자라면 true, 아니라면 `IllegalArgumentException`을 호출한다.
  - **[isEmptyRegistry]** : 입력 값이 있다면 false, 비어있다면 `IllegalArgumentException`을 호출한다.
  - **[hasSpace]** : 입력 값에 공백이 없다면 false, 있다면 `IllegalArgumentException`을 호출한다.

**- LottoValidator -**
- **[isValidAmount]** : 로또 구입 금액이 1,000원으로 나누어 떨어진다면 true, 아니라면 `IllegalArgumentException`을 호출한다.
- **[isValidLottoSize]** : 로또 당첨 번호가 6개로 이뤄진 숫자일 경우 true, 아니라면 `IllegalArgumentException`을 호출한다.
- **[isValidNumber]** : 로또의 번호가 0~45로 이뤄진 숫자일 경우 true, 아니라면 `IllegalArgumentException`을 호출한다.