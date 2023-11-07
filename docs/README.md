## 기능 목록

---

#### 비즈니스 기능

- [x] 금액에 맞는 로또를 발행하는 기능 - Store#sellLottos
    - [x] 가격이 나누어 떨어지는 지 판단하는 기능 - Store#validateDividedByPrice


- [x] 로또 추첨을 받는 기능 - BroadCastingStation#drawLotto
    - 중복되지 않는 숫자 6개와 보너스 번호 1개여야 한다. - BroadCastingStation#validateDuplicate


- [x] 당첨 결과를 확인하는 기능 - Calculator#checkWinning


- [x] 수익률을 계산하는 기능 - Calculator#returnRate


- [x] 로또 번호가 6개 인지 판단하는 기능 - Lotto#validateSixNumbers
- [x] 로또 번호가 중복되지 않는지 판단하는 기능 - Lotto#validateDuplicate
- [x] 로또 번호 입력이 숫자 1~45인지 판단하는 기능 - Lotto#validateRange

---

#### UI 기능

- [x] 구입 금액을 입력받는다. - UI#inputMoney
    - [x] 자연수가 아니라면 예외 발생
- [x] 구매 내역을 보여준다. - UI#printPurchases
- [x] 당첨 번호를 입력받는다. - UI#inputWinningNumbers
    - [x] , 문자 사이사이에 숫자를 입력하지 않으면 예외 발생
- [x] 보너스 번호를 입력받는다. - UI#inputBonusNumber
    - [x] 자연수가 아니라면 예외 발생
- [x] 당첨 통계를 보여준다. - UI#printWinningStats
    - [x] 당첨 번호 빈도를 보여준다. - UI#printWinningFrequency
    - [x] 수익률을 보여준다. - UI#printReturnRate
        - 소수점 둘째 자리에서 반올림 되어야 한다.
- [x] 틀린 입력인 이유를 알려준다.

---

#### Program 기능

- [x] 해당 프로그램의 구입 금액을 입력받고 내역을 보여준다. - Program#purchaseLottos
    - [x] 사용자는 잘못 입력 했을 경우 다시 입력이 가능하다.


- [x] 해당 프로그램의 당첨 번호를 입력받는다. - Program#insertWinningNumbers
    - [x] 사용자는 잘못 입력 했을 경우 다시 입력이 가능하다.


- [x] 해당 프로그램의 보너스 번호를 입력받는다. - Program#insertBonusNumber
    - [x] 사용자는 잘못 입력 했을 경우 다시 입력이 가능하다.


- [x] 해당 프로그램의 당첨 통계를 보여준다. - Program#showResult