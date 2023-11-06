# 3주차 과제 기능 명세

## 시작
### void start()
- 구입 금액을 사용자가 입력할 수 있도록 출력문을 출력한다.
- isCorrectInput(int) 반환값이 true일 때까지 inputMoney()를 호출한다.
- 유효한 금액일 경우 사용자가 구매한 로또의 개수를 구하고 이를 출력한다.
- lotto 값들을 저장할 ArrayList를 생성한다.
- 본격적으로 로또 숫자를 생성하기 위해 run()을 호출한다.

### void inputMoney()
- 구입금액을 입력받는다.
- try catch문을 이용하여 isCorrectMoney()를 호출한다.
- 예외가 발생하였을 경우 예외문을 출력한다.
- 예외가 발생하지 않았을 경우 메서드를 종료한다.

### void isCorrectMoney(int)
- 구입 금액이 1000원 단위인지 검사한다.
- 1000원 단위라면 isCorrectMoney의 값을 true로 변경하고 메서드를 종료한다.
- 1000원 단위가 아닐 경우 IllegalArgumentException를 던진다.