# 3주차 과제 기능 명세

## 구입 금액 입력
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

## 메인 동작 구현
### void run()
- createLotto()를 호출한다.
- makeWinningNumber()를 호출한다.
- finish()를 호출한다.


## 로또 생성 및 출력
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

## 당첨 번호 및 보너스 번호 입력
### void makeWinningNumber()
- 유효한 입력일 때까지 winningNumber()를 호출한다.
- 유효한 입력일 때까지 bonusNumber()를 호출한다.

### void winningNumber()
- 사용자로부터 당첨 번호를 입력받는다.
- lenCheck()를 호출하여 길이를 검사한다.
- valueCheck()를 호출하여 유효한 값인지 검사한다.
- isDuplicated를 호출하여 중복되는 값이 있는지 검사한다.
- 위의 세 가지 메서드를 호출한 뒤 예외가 발생하지 않았다면 winninng을 true로 변경한다.
- 위의 세 가지 메서드 실행 과정에서 예외가 발생하였다면 예외 문구를 출력한다.

### void bonusNumber()
- 사용자로부터 보너스 번호를 입력받는다.
- lenCheck()를 호출하여 길이를 검사한다.
- valueCheck()를 호출하여 유효한 값인지 검사한다.
- isDuplicated를 호출하여 중복되는 값이 있는지 검사한다.
- 위의 세 가지 메서드를 호출한 뒤 예외가 발생하지 않았다면 bonus을 true로 변경한다.
- 위의 세 가지 메서드 실행 과정에서 예외가 발생하였다면 예외 문구를 출력한다.

### void lenCheck(String[], int)
- 배열의 길이가 인수로 들어온 정수와 다를 경우 예외를 던진다.

### void valueCheck(String[])
- 배열의 길이만큼 반복문을 돌면서 makeInteger(String), isRange(int)를 호출한다.
- num, isError의 값에 따라 예외를 던진다.

### int makeInteger(String)
- String을 정수값으로 바꿀 수 있다면, 바꾼 정수값을 반환한다.
- NumberFormatException가 발생한다면 -1을 반환한다.

### boolean isRange(int)
- 인수로 들어온 정수가 1~45 사이의 수인지를 반환한다.

### void isDuplicated(String[])
- 배열의 길이만큼 반복하며 arrayList(int)를 호출한다.
- arrayList(int) 메서드에서 반환되는 값을 이용하여 중복된 값이 있을 경우 예외를 던진다.

### boolenan arrayListAdd()
- 중복된 값이 있을 경우 true를 반환한다.
- 중복된 값이 없을 경우 해당 값을 당첨번호와 보너스번호를저장하는 arrayList에 저장하고 false를 반환한다.

## 최종 결과 출력 및 종료
### void finish()
- makeResult()를 호출한다.
- printResult()를 호출한다.
- printProfitPercent()를 호출한다.

### void makeResult()
- 로또의 당첨 결과를 저장할 ArrayList를 생성하고 0으로 초기화한다.
- 반복문을 돌면서 resultArr(findResult(ArrayList))를 호출한다.

### Result findResult(ArrayList)
- 인수로 받은 로또에 대한 결과를 구해 enum값으로 반환한다.
- cntWinningNumber(ArrayList), cntBonusNumber(ArrayList)를 호출하고 반환된 값을 이용하여 결과에 해당하는 enum 값을 반환한다.

### int cntWinningNumber(ArrayList)
- 반복문을 이용하여 해당 ArrayList에 포함된 당첨 번호의 개수를 반환한다.
- 이를 위해 isContainedWinning(int)를 호출한다.

### int isContainedWinning(int)
- 인수로 들어온 값이 당첨번호 중 하나라면 1을 반환한다.
- 그렇지 않을 경우 0을 반환한다.

### int cntBonusNumber(ArrayList)
- 해당 ArrayList에 포함된 보너스 번호의 개수를 반환한다.

### void resultArr(Result)
- enum 값을 인수로 받는다.
- 인수로 받은 값의 경우에 따라 rankArr를 업데이트한다.

### void printResult()
- 출력문을 이용하여 로또에 대한 결과를 출력한다.

### void printProfitPercent()
- 수익률을 계산하고, 출력 조건에 맞게 출력한다.
- 이때 사용자의 이익을 구하기 위해 calUserProfit()를 호출한다.

### double calUserProfit()
- 반복문을 둘면서 사용자의 로또 당첨금의 합계를 구해서 반환한다.