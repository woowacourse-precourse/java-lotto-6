Lotto Game Program
==========
----

## i) 기능 목록
###  입력기능
```
1. 사용자에게 로또 구입 금액을 입력받는다.
2. 사용자에게 당첨 번호를 입력받는다.
```

### 로또처리기능
```
1. 사용자가 구매한 로또의 갯수에 맞게 로또 번호를 랜덤하게 뽑는다(중복 X, 범위 : 1 ~ 45사이의 수)
2. 사용자가 입력한 당첨 번호와 구매한 로또의 로또번호를 배교하여 당첨여부를 확인한다.
3. 당첨여부에 따른 상금으로 수익률을 계산한다.
```
### 예외처리기능
```
1. 사용자가 입력한 로또 구매 금액의 예외 처리(1000으로 나누어 떨어져야 함)
2. 예외 상황 시 에러문구는 [ERROR]로 시작하며 뒤에 에러문구를 출력한다.
```
### 출력기능
```
1. 발행한 로또 수량 및 번호를 출력한다.(로또 번호는 오름차순으로 정렬)
2. 발행한 로또 중 당첨 내역을 출력한다.
- 당첨 내역 : 수익률, 일치갯수에 따른 당첨 로또 갯수
```
------

## ii) 클래스 및 메소드
- ### *Model*
    **Lottos Class** // 발행된 로또의 목록
    ```agsl
    - getLottos     // 발행된 로또 번호들을 반환한다.
    - addLotto      // 발행된 로또를 list에 추가한다.
    ```
  
    **Lotto Class**// 로또 하나의 클래스
    ```agsl
    - getNumbers        // 로또의 번호들을 반환받는다.
    - validate          // 로또 발급 번호의 유효성 검사
    - duplicationCheck  // 유효성 체크를 위한 로또번호의 중복체크
    - getNumbers        // 로또번호들을 List형태로 반환
    ```
  
    **UserLotto Class** // 사용자가 입력한 로또 번호 및 보너스 번호까지 저장하는 클래스
    ```agsl

    ```

- ### *View*
    **PrintView Class** //프로그램 출력을 위한 클래스
    ```agsl
    - inputMoneyPrint       // 구입금액 입력을 위한 출력 메시지
    - generatedLottosPrint       // 발행한 로또 수량 및 번호들을 출력한다.
    - inputNumbersPrint     // 사용자의 당첨번호 입력을 위한 출력메시지
    - inputBonusNumberPrint     // 사용자의 보너스 번호입력을 위한 출력메시지
    - resultPrint       // 당첨 내역을 출력한다.
    ```

- ### *Controller*
    **InputController Class** // 사용자의 데이터 입력을 위한 클래스
    ```agsl
    - inputMoney        // 사용자로부터 구입 금액을 입력받는다.
    - inputNumbers      // 사용자로부터 당첨번호를 입력받는다.
    - inputBonusNumber      // 사용자로부터 당첨 보너스번호를 입력받는다.
    ```
    **ExceptionController Class** // 입력값에 대한 예외처리를 위한 클래스
    ```agsl
    - moneyException    // 금액 입력에 대한 예외처리
    - numbersException  // 당첨번호 입력에 대한 예외처리
    ```
  
    **LottoGeneratorController Class** // 로또 번호를 생성한다.
    ```agsl
    - lottoGenerate     // 1개의 로또에 대한 로또번호를 생성한다.
    ```
  
    **MainController Class** // 로또의 결과 및 Model과 View를 잇는 main Controller
    ```agsl
    - lottoStart    // 로또 게임 시작
    - lottoCheck    // 몇개의 로또가 맞았는지 체크해주는 메소드
    - getRevenue    // 수익률 계산
    ```

----