# 입력값 검증 받는 기능
## 로또 금액받기
### setAmountOfLotto
+ 로또 금액을 받고 유효할때까지 반복시키는 메서드
### parseAmount
+ 로또 금액을 setAmountOfLotto에서 입력 유효성 검사를 위한 trycatch문작성
### validateInput
+ 로또 금액 유효성 검사 1000으로 나눴을때 안나누어지면 예외처리

### setWinningNumber
+ null인 winningNumber 배열을 가지고 반복문 시작

+ 사용자로부터 입력을 받아 validateWinningNumbers 메소드를 호출

### validateWinningNumbers
+ 입력이 유효하지 않은 경우, 즉 6개의 숫자가 아니거나 숫자가 아닌 값이 포함된 경우 IllegalArgumentException을 발생.

### setWinningNumber
+ try-catch 블록에서 이 예외를 잡아내고, 사용자에게 오류 메시지를 출력한 후 다시 입력을 요청합니다.

### setBonusNumber
+ 보너스 숫자 입력받는 메서드로 isValidWinningNumbers로 검사하면서 예외발생시 다시 입력을 요청합니다.

### isDuplicateNumber
+ 중복된 숫자가 잇으면 예외처리를 합니다.

### isValidWinningNumbers
+ 입력값이 숫자가 아니거나 1미만 45이상이면 예외처리