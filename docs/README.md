## 기능 목록



### Store.class

* [ ] 로또 구입 금액을 입력 받는다. - inputMoney()
  * [x] 1000원 단위로 받으며 1000으로 나누어 떨어지지 않는 경우 예외 처리한다. - validateMoney()
  * [x] 구입 금액에 해당하는 만큼 로또를 발행한다. 로또 1장의 가격은 1000원이다. - giveLotto()
  * [x] 로또 번호로 1~45까지 범위 중 중복되지 않은 숫자 6개를 발행한다. - makeLottoNumber()
  * [ ] 당첨 번호와 보너스 번호를 입력 받는다. - inputWinningLotto()
  * [ ] 예외 상황 시 에러 문구를 출력한다. 에러 문구는 [ERROR]로 시작해야 한다. 

### Lotto.class

* [x] 로또 번호의 숫자 범위는 1~45까지이다. - validateNumberRange()
* [x] 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다. - validate()
* [x] 로또 번호를 오름차순으로 정렬한다. - sortNumbers()
* [x] 발행한 로또 수량 및 번호를 출력한다. - printLotto()

### WinningLotto.class  

* [x] 당첨 번호와 숫자 범위는 1~45까지이다. - validateNumberRange()
* [x] 번호의 숫자 범위가 1~45인지 확인한다. - checkNumberRange()
* [x] 당첨 번호는 6개의 숫자를 뽑고 보너스 번호는 1개의 숫자를 뽑는다. - validateSize()
* [x] 당첨 번호, 보너스 번호는 중복되지 않아야 한다. - validateDuplicated()

### Grader.class

* [ ] 사용자가 구매한 로또들의 번호와 당첨 번호를 비교하여 통계와 수익률을 계산한다. - compareLottoWinningLotto()
* [ ] 로또 번호와 당첨 번호를 비교하여 결과를 반환한다. - compareNumber()
* [ ] 당첨 내역을 출력한다. - printResult()
* [ ] 수익률을 출력한다. 소수점 둘째 자리에서 반올림한다. - printEarningRate()

  



