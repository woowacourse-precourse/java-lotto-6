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

## 게임 실행
### void run()
- createLotto()를 호출한다.

### void createLotto()
- 반복문을 사용자가 구매한 로또 개수만큼 돌면서 makeNumbers()를 호출한다.
- 반복문이 끝나면 printNumbers()를 호출한다.

### void makeNumbers()
- 6개의 숫자 정보를 저장할 ArrayList를 생성한다.
- 반복문을 돌면서 범위 내의 랜덤값을 생성하고,isContains()를 호출한다.
- 숫자 생성이 종료되면 생성한 ArrayList를 전체 로또 정보를 저장하는 ArrayList에 add한다.

### int isContains(ArrayList<Integer>, int)
- 생성한 번호가 기존의 번호와 중복되는지 확인한다.
- 생성한 번호가 중복될 경우 -1을 리턴한다. (이 경우 makeNumbers() 반복문에서의 i가 -1 + 1로 이전과 같은 값이 되어 반복횟수가 증가하지 않은 상태로 다시 번호를 생성하게 된다.)

### void printNumbers()
- 하나의 로또에 대한 로또 번호들을 줄로 구분하여 사용자가 구매한 전체 로또의 정보를 출력한다.
- 로또 번호들을 정렬한 후 makeStr(ArrayList<Integer>)를 호출하고 반환값을 이용하여 정보를 출력한다.
- 위 과정을 사용자가 구매한 로또 개수만큼 실행한다.

### String makeStr(ArrayList<Integer> lst)
- 로또 번호를 주어진 양식대로 출력하기 위한 문자열을 만든다.
- 이를 위해 ArrayList<String>을 생성하고 lst에 저장된 값들을 String으로 변환하여 삽입한다.
- String.join()을 이용하여 출력 조건을 충족하는 문자열을 만든다.
- 만들어진 문자열을 반환한다.