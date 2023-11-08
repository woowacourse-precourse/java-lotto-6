## 기능목록
### 로또 당첨 번호 생성 
  - [X] 당첨 로또번호 생성
  - [X] 당첨 로또의 번호 중복을 확인
  - [X] 당첨 로또의 번호가 6개인지 확인 
  - [X] 6개의 번호가 확정된 로또를 오름차순으로 정렬
### 로또 번호 당첨 여부 확인
  - [X] 당첨 번호와 사용자 번호가 몇개 일치하는지 확인
  - [X] 일치하는 개수에 해당하는 등수를 해당 로또에 저장 
  - [X] 5개가 일치하는지 확인
  - [X] 5개가 일치할 경우에 실행, 보너스 번호와 일치하는 번호있는지 확인
- [X] 로또 번호 자동 생성 
- [X] 구매한 로또의 갯수 확인 
- [X] 당첨금 합계 구하는 기능 
- [X] 수익률 계산하는 기능 
- [X] 둘째 자리에서 반올림하는 기능 

--- 
### 예외 발생 시 
#### 입력
  - [X] 입력에 숫자가 아닌 값을 입력했을 경우 예외 처리
  - [X] 입력에 아무런 값을 입력하지 않았을 경우 예외 처리 
#### 금액 
  - [X] 구입 금액이 1,000원 단위로 나누어 떨어지지 않은 경우 예외 처리
  - [X] 구입 금액이 2,100,000,000원 초과하여 구매한 경우 예외 처리
#### 로또 번호 입력 
  - [X] 당첨 번호,보너스 번호 입력 시, 1 ~ 45 외의 숫자를 입력했을 경우 예외 처리  
  - [X] 당첨 번호 입력 숫자가 6개가 아닌 경우 예외 처리 
  - [X] 당첨 번호,보너스 번호 입력 시, 이미 입력한 숫자가 존재할 경우 예외 처리

---
## 🗂️️ 프로젝트 구조 
    src
    ┣ main
    ┃ ┗ java
    ┃ ┃ ┗ lotto
    ┃ ┃ ┃ ┣ constant
    ┃ ┃ ┃ ┃ ┣ ConstantInteger.java
    ┃ ┃ ┃ ┃ ┗ ConstantString.java
    ┃ ┃ ┃ ┣ controller
    ┃ ┃ ┃ ┃ ┗ LottoController.java
    ┃ ┃ ┃ ┣ domain
    ┃ ┃ ┃ ┃ ┣ number
    ┃ ┃ ┃ ┃ ┃ ┣ AutoNumberGenerator.java
    ┃ ┃ ┃ ┃ ┃ ┗ LottoNumberGenerator.java
    ┃ ┃ ┃ ┃ ┣ Lotto.java
    ┃ ┃ ┃ ┃ ┣ LottoTicketManager.java
    ┃ ┃ ┃ ┃ ┣ LottoTickets.java
    ┃ ┃ ┃ ┃ ┗ Rank.java
    ┃ ┃ ┃ ┣ exception
    ┃ ┃ ┃ ┃ ┣ ExceptionMessage.java
    ┃ ┃ ┃ ┃ ┗ LottoApplicationException.java
    ┃ ┃ ┃ ┣ validator
    ┃ ┃ ┃ ┃ ┗ InputValidator.java
    ┃ ┃ ┃ ┣ view
    ┃ ┃ ┃ ┃ ┣ InputView.java
    ┃ ┃ ┃ ┃ ┗ OutputView.java
    ┃ ┃ ┃ ┣ Application.java
    ┃ ┃ ┃ ┗ LottoGame.java
    ┗ test
    ┃ ┗ java
    ┃ ┃ ┗ lotto
    ┃ ┃ ┃ ┣ domain
    ┃ ┃ ┃ ┃ ┗ LottoTicketManagerTest.java
    ┃ ┃ ┃ ┣ input
    ┃ ┃ ┃ ┃ ┗ InputTest.java
    ┃ ┃ ┃ ┣ ApplicationTest.java
    ┃ ┃ ┃ ┗ LottoTest.java
