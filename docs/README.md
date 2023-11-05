## 기능 목록

```
1. 사용자에게 구입 금액을 입력 받는다. - InputView#money()

2. 입력한 금액에 맞게 로또 수량을 출력한다. - OutputView#LottoTicketCount()
   - 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.
      - 0원 입력일 경우 예외가 발생한다. 
   - 숫자가 아닌 경우 예외가 발생한다.
   - 앞, 뒤 공백은 제거된다.
   
3. 발행한 로또들의 번호를 출력한다. - Lotto#printNumbers()
   - 로또 번호는 오름차순으로 정렬해서 보여준다.
   - 대괄호([])와 쉼표를 기준으로 각 숫자를 나눈다.
   
4. 사용자에게 당첨 번호 6개를 입력 받는다. - InputView#winningNumbers()
   - 쉼표를 기준으로 번호를 입력 받는다.
   - 공백이 있을 시 공백을 제거한다.
   - 입력 번호가 6개가 아닐 시 예외가 발생한다.
   - 입력 숫자가 1에서 45사이가 아니면 예외가 발생한다..
   - 숫자가 아닌 경우 예외 처리한다.
   - 중복된 숫자가 있으면 예외가 발생한다.
   
5. 사용자에게 보너스 번호를 입력 받는다. - InputView#bonusNumber()
   - 입력 숫자가 1에서 45사이가 아니면 예외가 발생한다.
   - 숫자가 아닌 경우 예외 처리한다.
   - 당첨 번호와 중복된 숫자가 있으면 예외가 발생한다.
   
6. 당첨 통계를 출력한다. - OutputView#resultStart()
   - 3개, 4개, 5개, 6개 일치 유무에 대한 결과를 출력한다. - OutputView#printStatistics()
   - 각 경우에 해당하는 로또 수를 출력한다.
   
7. 총 수익률을 출력한다. - OutputView#printRateOfReturn()
   - 당첨 통계에서 얻은 수익과 로또 구입 금액을 비교하여 수익률을 출력한다.
   - 수익률은 소수점 둘째 자리에서 반올림한다.
```

***

## 예외 처리

```
- 로또 구입 금액
  - 숫자가 아닌 문자가 있을 경우 예외 발생 - MoneyValidator#isNumeric()
  - 입력한 금액이 1,000원으로 나누어 떨어지지 않을 경우 예외 발생 - MoneyValidator#isThousandUnit()
    - 0원 입력일 경우 예외 발생 - MoneyValidator#isZero()
    
- 당첨 번호
  - 숫자가 아닌 문자가 있을 경우 예외 발생 - LottoValidator#isNumeric()
  - 당첨 번호가 6개가 아닌면 예외 발생 - LottoValidator#size()
  - 번호가 1에서 45 사이가 아니면 예외 발생 - LottoValidator#inRange()
  - 번호가 중복될 경우 예외 발생 - LottoValidator#duplicate()
  
- 보너스 번호
  - 숫자가 아닌 문자가 있을 경우 예외 발생 - BonusNumberValidator#isNumeric()
  - 보너스 번호가 1에서 45 사이가 아니면 예외 발생 - BonusNumberValidator#inRange()
  - 보너스 번호가 당첨 번호와 중복될 경우 예외 발생 - BonusNumberValidator#duplicate()
```

- 각 예외 상황 시 그에 맞는 에러 문구를 출력한다.
- 에러 문구는 [ERROR]로 시작한다.
- 이후 예외가 발생한 지점부터 다시 입력을 받는다.
