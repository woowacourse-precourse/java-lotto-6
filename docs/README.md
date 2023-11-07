## 2주차 레이싱 게임 리뷰
- enum
  이것은 자바에서 상수를 다룰 때 주로 사용되는 클래스 타입이라고 한다. 이전에는 상수를 사용할 클래스 상단에
  상수를 선언해서 사용했지만, 이러면 관리가 어려워지기 때문에, 모아서 사용해야 할 필요가 있겠다고 생각했었는데,
  이번에 enum 클래스 타입에 대해 공부를 해서 사용해볼 계획이다. 
- unmodifiableList
  자바 Collection에서 리스트에 데이터를 추가한 뒤 이 리스트의 변경을 막기 위한 클래스 타입이다.
  나도 Car 객체를 선언한 뒤, 컨트롤러에서 Cars 리스트를 사용했었는데 이것을 좀 더 안전하게 사용할 수 있는 방법같다.
  이번에도 로또 과제에서 여러 로또 리스트를 다뤄야 할 일이 있을 것 같으므로 이 unmodifiableList를 사용해볼 예정이다.

## 유저 시나리오
출력 : 구입금액을 입력해 주세요.  
입력 : 8000   
출력 : 개행  

출력 : {8}개를 구매했습니다  
출력 : 발행 로또번호 출력  
출력 : 개행  

출력 : 당첨 번호를 입력해 주세요.  
입력 : 숫자 6개 입력  
출력 : 개행  
출력 : 보너스 번호를 입력해 주세요.  
입력 : 숫자 1개 입력  
출력 : 개행  
 
출력 : 당첨 통계  
출력 : ---  
출력 : 3개~6개 일치 개수  
출력 : 총 수익률  

## 클래스 분류
1. view - InputView, OutputView  
2. domain - Winning, Lotto, Lottos, Amount
3. controller - Controller 
4. utilities - Parse
5. validation - StringValidation, AmountValidation, WinningValidation
6. system - SystemMessage, ExceptionMessage, Constant
7. dto - AmountDto, LottoDto, LottosDto, WinningDto

## 기능 정리
Controller
- 1. 구입 금액 입력 - InputAmount()  
       - 입력 메시지 - OutputView  
       - 1000 단위 숫자 입력 받기 - InputView  
       - 1000원 단위인지, 숫자인지 검증 - amountValidation
       - 구입 금액 Amount 도메인에 저장 - Amount
          
- 2. 발행 로또 번호 출력 - outputLottoTicket()
       - 구입 금액 1000으로 나눠서 발행 개수 구하기 - Amount (getAvailableQuantity())
       - 발행 개수 출력 - OutputView
       - 발행 개수만큼 for문 돌면서 중복되지 않는 랜덤 넘버 6개 발행 - Lottos generateLotto
       - 발행 로또 저장 - Lotto
       - 발행 로또를 티켓 리스트에 저장 - Lottos
       - 발행 로또들 출력 - OutputView
    
- 3. 당첨 번호 입력 - inputWinning()
       - 입력 메시지 - OutputView
       - 당첨번호 6개 + 보너스 1개 입력 받기 - InputView
       - 1~45인지, 숫자인지 검증 - WinningValidation
        
- 4. 당첨 통계 출력 - outputResult()
       - 로또가 당첨번호랑 맞는지 확인 - Winning getRankCount
       - 당첨 개수 출력 - OutputView
       - 총 수익률 출력
