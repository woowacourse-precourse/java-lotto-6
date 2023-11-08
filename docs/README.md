# 미션 - 로또

## 😄 프로그램 흐름
- 로또 구입 금액을 입력한다.
- 로또를 발행한다.
- 당첨 번호를 입력받는다.
- 보너스 번호를 입력받는다.
- 당첨 내역을 출력한다.
- 수익률을 출력한다. (끝)

## 😄 구현 클래스
```
src/main/java/lotto
├─constants
│     ├─Constants.java
│     └─WinningPrize.java
├─control
│     ├─Input.java
│     ├─LottoGame.java      
│     └─Output.java
├─lottoMaker
│     ├─Lotto.java      
│     └─LottoGenerator.java
├─validator
│     ├─BonusNumberValidator.java
│     ├─PurchaseAmountValidator.java      
│     └─WinningNumberValidator.java
└─Application.java
```
- constants 패키지 : 프로그램 내에서 사용되는 스트링 상수, Enum 타입 
- control 패키지 : 로또 동작 구현 클래스, 입력 클래스, 출력 클래스 
- lottoMaker 패키지 : 로또 클래스, 로또 생성 클래스
- validator 패키지 : 프로그램 실행 중 입력 받는 값에 대한 유효성 체크 클래스
- 어플리케이션 클래스 : 프로그램 시작점, LottoGame 인스턴스 생성

## 😄 기능 목록
```startInput()```
-[x] 로또 구입 금액을 입력한다.     ```inputPurchaseAmount()```
  -[x] 숫자 인지
  -[x] 양수 인지
  -[x] 1000 단위 인지
-[x] 로또를 발행한다.    ```genLottos()```
  -[x] 각 로또의 번호 오름차순 정렬
-[x] 당첨 번호를 입력받는다.     ```inputWinningNum()```
  -[x] 올바른 형식인지
  -[x] 모두 숫자가 맞는지
  -[x] 범위 내 숫자들인지
  -[x] 중복된 숫자가 있는지 
-[x] 보너스 번호를 입력받는다.     ```inputBonusNum()```
  -[x] 숫자 인지
  -[x] 범위 내 숫자인지
  
```printOutput()```
-[x] 발행한 로또에 대해 맞은 개수를 카운트한다.     ```calculateMatchCount()```
-[x] 수익률을 계산한다.     ```roundedProfitRate()```
-[x] 결과를 출력한다.     ```printResult()```

```Others```
-[x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생
  -[x] "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 다시 입력
  -[x] `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리



