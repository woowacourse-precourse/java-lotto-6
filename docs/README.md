
# 기능 상세 설명

## UML
![java_lotto.png](..%2F..%2F..%2FDocuments%2Fjava_lotto.png)

## 기능 목록
* Reader는 구입 금액을 숫자로 입력 받는다.
  * Reader는 구입금액으로 숫자가 아닌 값이 들어온 경우에 예외를 발생시킨다.
* Reader는 당첨 번호를 콤마로 구분된 숫자로 입력 받는다.
  * Reader는 당첨 번호로 숫자와 콤마가 아닌 값이 들어온 경우에 예외를 발생시킨다.
* Reader는 보너스 번호를 숫자로 입력 받는다.
  * Reader는 보너스 번호로 숫자가 아닌 값이 들어온 경우에 예외를 발생시킨다.
* Printer는 구매한 로또 번호를 오름차순으로 정렬하여 출력한다.
* Printer는 당첨 통계를 출력한다.
* LottoService는 로또 번호를 만든다.
* LottoService는 사용자의 구입 금액만큼 로또를 발급한다.
  * LottoService는 구입 금액이 1000원 단위가 아닐 경우 예외 처리한다.
* LottoService는 사용자의 당첨 번호 중에 실제 당첨 번호와 일치하는 볼의 개수를 계산한다.
* LottoService는 보너스 번호와 실제 당첨 번호 간의 일치 여부를 계산한다.
* LottoService는 당첨 결과를 바탕으로 수익율을 계산한다.
* LottoSystem은 로또를 시작한다.