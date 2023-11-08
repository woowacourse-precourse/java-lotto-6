# 미션 - 로또

## 구현 기능(Test 코드 포함)
- 정상적인 값을 입력받아 로또 구매 기능 
- 구매 개수를 받아 개수 만큼 무작위 로또 생성 기능 
- 입력 값을 통해 당첨번호와 보너스 번호를 생성하는 기능 
- 로또 통계를 출력하는 기능 

### Lotto 클래스
- 6개의 로또 번호가 생겼을 때 중복 값이 있는지 검증하는 메소드 : duplicate() 
- 로또 번호가 하나라도 1~45 범위를 넘는게 있는지 검증하는 메소드 : outOfRange()

### Application 클래스
- 로또 현황을 Map에 담아 출력하는 메소드 : lottoStatistics()

### BuyLotto 클래스 
- 구매 금액을 입력 받아 1000으로 나누어 떨어 지지 않거나 잘못된 값을 입력 받으면 각각의 에러메시지를 
출력하고 다시 입력 받도록 하는 메소드 : buyLotto()

### CreateNumber 클래스
- 정상적인 무작위 로또 1개를 생성하는 메소드 : createLottoNumber()
- 구매한 개수 만큼 오름차순의 로또 리스트를 생성하여 출력하는 메소드 : createLottoNumbers()

### ValidateInputNumber 클래스
- 입력 값이 숫자로 이루어진 문자열이면 int값으로, 아니면 예외를 발생시키는 메소드 : inputNumber(String);
- 당첨 번호가 (,)기준으로 숫자로 이루어진 문자열들이면 List<Integer>에 담아 반환하고, 
아니면 예외를 발생 시키는 메소드 : validateWinNumber(String)

### CreateWinNumber 클래스
- 검증을 마친 리스트를 static 당첨 번호 List 필드에 담는 메소드 : winNumber();
- 보너스 번호 값을 입력 받아 static int 필드에 저장하는 메소드 : bonusNumber();

### LottoWinMap 클래스
- 구매한 로또 리스트를 받아 Map에 당첨된 로또 목록을 저장하는 메소드 : howManyEquals()

### MoneyFormatUS 클래스
- 숫자 표기를 세자리마다 ,가 생기는 Format 제공 메소드 : moneyFormat()

### LottoStatisticsGenerator 클래스 
- 당첨 현황을 표시 하는 메소드 : statusEqualsCount()
- 수익률을 계산해서 반환하는 메소드 : returnRate()

### ErrorMessage 클래스
- 모든 에러 메시지는 **[ERROR]**로 시작하기 때문에 상수 에러 메시지를 관리하는 클래스  