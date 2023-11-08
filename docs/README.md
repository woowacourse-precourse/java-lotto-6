## 프로젝트명

---
### 로또

## 프로젝트 설명

---

사용자가 입력한 금액만큼 로또 구매 후 수익률을 출력하는 프로그램

## 프로젝트 설치 및 실행 방법

---
~~~
git clone https://github.com/Controllls/java-lotto-6.git
IDE에서 실행
~~~

## 프로젝트 사용 방법

---
1. 로또 구매 금액 입력
   1. 구입 금액은 1,000원 단위로 입력
2. 당첨 번호 입력
   1. 쉼표(,)를 기준으로 6자리 입력
3. 보너스 번호 입력
   1. 숫자 1개 입력


## 기능 목록

---
1. 로또 번호 정하기
   1. 로또 번호 정하기
      1. 1~45사이의 숫자
      2. 중복 값 없음
      3. 6개
2. 당첨 확인
   1. 등수 판별 
   2. 당첨금 합계
3. 로또 구매
   1. 금액 확인
      1. 1000단위의 숫자
4. 당첨번호 정하기
   1. 담청번호 받기
      1. 1~45 사이의 숫자
      2. 6개
      3. ","로 구분
      4. 중복 값 없음
   2. 보너스 번호 받기
      1. 1~45 사이의 숫자
      2. 1개
      3. 중복 값 없음


---
## 프로젝트 구조

```bash
├── domain
├── LottoProcess.java
│   ├── vendingMachine
│   │   ├── LottoVendingMachine.java
│   │   ├── cash
│   │   │   ├── CashManager.java
│   │   │   ├── LottoCashManager.java 
│   │   ├── lotto
│   │       ├── Lotto.java
│   │       ├── AutoLottoGenerator.java
│   │       ├── LottoGenerator.java
│   │     
│   ├── inputOutput
│   │   ├──  input
│   │   │   ├──  inputDataAdapter.java
│   │   │   ├──  inputLotto.java
│   │   │   ├──  inputLottoDraw.java
│   │   ├──  output
│   │       ├──  LottoOutput.java
│   │       ├──  WinningOutput.java
│   │     
│   ├── lottoDrawMachine
│   │   ├── LottoDrawMachine.java
│   │   ├──  lottoDraw
│   │       ├──  LottoDraw.java
│   │       ├──  LottoDrawGenerator.java
│   │     
│   ├── winningManager
│       ├── WinningManager.java
│       ├── WinningCheck.java
│       ├── RateOfReturn.java
│        
├── constants
    ├── InputOutputConstants.java
    ├── LottoDrawConstants.java
    └── LottoConstants.java
``` 

