# [Lotto System]

---
## ▶ Lotto System 프로그램

1. 금액을 준비한다.
2. 금액에 해당하는 만큼 로또를 발행(구입)한다
3. 당첨 번호를 사용자로부터 입력받는다.
4. 당첨 등수 확인
5. 당첨 내역을 출력한다.
6. 수익률을 계산하여 출력한다.
7. 에러 상황에서는 에러 문구를 출력한다.

---
## ▶ 기능 목록
### 로또 구매 기능
* [ ] 금액 입력 기능
  *  (유효성 검사)
* [ ] 금액에 따라 로또 발급 기능
  * 로또 한 개 발급 기능
    * 중복 없는 랜덤 숫자 생성 기능
      * (유효성 검사)
    * 랜덤 숫자 6개로 로또 리스트 생성 기능
      * (유효성 검사)
      * 리스트를 오름차순으로 정렬하는 기능
### 위닝콤비네이션(당첨 번호 및 보너스 번호) 입력 기능
* [ ] 당첨 번호 입력 기능
  * 6개의 숫자를 입력
  * 입력된 문자열을 숫자로 이루어진 리스트로 변환
  * (유효성 검사)
* [ ] 보너스 번호 입력 기능
  * 보너스 번호 입력
  * (유효성 검사)
### 통계 기능
* [ ] 당첨된 로또가 등수에 따라 몇 개인지 측정하는 기능
  * 구매한 각 로또마다 위닝콤비네이션과 비교하여 등수 측정
  * 당첨 기준에 따라 각 등수별 개수 누적
* [ ] 각 등수별 개수를 리스트 형태로 반환하는 기능
### 수익률 기능
* [ ] 구매한 금액과 당첨된 금액을 통해 수익률 계산하는 기능
* [ ] 소수점 둘째자리에서 반올림하여 수익률을 저장 및 반환하는 기능
### 입출력 기능
* [ ] 실행 결과를 사용자에게 출력하는 기능
  * 정해져있는 문구 출력하는 기능
  * 뽑은 모든 로또들을 출력하는 기능
  * 통계 및 수익률을 출력하는 기능
* [ ] 요청 질문 출력 및 사용자 입력 기능
  * 정해져있는 요청 질문을 출력한다.
  * 금액을 입력 받는다.
  * 당첨 번호를 입력 받는다
  * 보너스 번호를 입력 받는다.
  * (입력 유효성 검사)
### 유효성 검사 기능
* [ ] 입력이 알맞지 않을 경우 예외처리하는 기능
  * [ ] 사용자 입력 부분 예외처리
    * 숫자가 아닌 경우 예외 처리
  * [ ] 시스템 규칙 부분 예외처리
    * 금액 부분
      * 숫자가 1000 미만일 경우
    * 위닝콤비네이션(당첨 번호+보너스 번호) 입력 부분
      * 숫자가 6개가 아닐 경우(당첨 번호 경우에만)
      * 숫자의 범위가 1~45를 벗어날 경우
      * 중복일 경우

## ▶ 클래스 목록
### LottoSystemController
* 로또 시스템을 위와 같은 순서로 진행한다.
### OutputView
* 시스템이 실행되는 동안 사용자에게 실행 결과 및 과정 출력
### InputView
* 시스템이 실행되는 동안 사용자로부터 입력 값을 받음
### LottoPurchaseManager
* 로또를 사용자가 입력한 금액에 따라 로또를 뽑는다.
  * **BudgetInputManager**
    * 사용자의 로또 구입을 위해 금액을 입력받는다.
    * 유효성 검사
      * 최소 1000원 이상
      * 숫자만 입력 
  * **LottoGenerator**
    * 로또 티켓을 금액만큼 만든다.
  * **LottoTicketGenerator**
    * 만든 티켓들을 모아서 LottoTicktes를 만든다.
### WinningNumbersGenerator
* 당첨번호 6개를 입력받는다.
* 보너스 번호 1개를 입력받는다.
* 유효성 검사
  * 숫자만 입력
  * 1~45 범위 확인
  * 중복확인
### StatisticCalculator
* 당첨 통계를 계산한다.
### ProfitCalculator
* 수익률을 계산한다.

### Vaildator
* 사용자 입력이 조건에 맞는지 유효성 검사를 한다.
* **MoneyInputVaildator**
  * 금액 입력 시
    * 최소 1000원 이상
    * 숫자만 입력
* **WinningNumbersInputVaildator**
  * 당첨 번호 입력 시
    * 숫자만 입력
    * 1~45 범위 확인
    * 중복 확인
    * 개수 확인
* **LottoVaildator**
  * 로또 티켓 생성 시
    * 중복 확인
    * 개수 확인

## ▶ 도메인 목록
### Budget
* 구매할 금액
* (유효성 검사)
### LottoTickets
* Lotto들로 구성되어있다.
* 구매한 로또만큼 가지고 있다.
### Lotto
* 6개의 로또숫자로 구성되어있다.
* (유효성 검사)
### LottoNumber
* 범위 1~45 수 중의 하나 
* 랜덤수가 선정된다.
### WinningNumbers
* 입력된 당첨 숫자들로 구성되어있다.
    * 6개의 당첨 숫자
    * 1개의 보너스 숫자
* (유효성 검사)
### WinningCombination
* WinningNumbers + LottoNumber

---
## ▶ 패키지 개요
### view
* **InputView**
  * InputBudget
  * InputWinningNumbers
  * InputBonusNumber
* **OutputView**
* **message**
  * **ViewMessage**
      * **ProcessMessage**
      * **ResultMessage**
  * **ExceptionMessage**
      * **MoneyInputErrorMessage**
      * **WinningNumbersInputErrorMessage**
      * **LottoGenerateErrorMessage**

---
## ▶ 시스템 기능 흐름
1. LottoSystemController 실행
2. MoneyInputManager로 입력 받고 BudgetMoney 객체 생성(InputView)
   * 유효성 검사(MoneyInputVaildator)
3. Lotto들을 입력 받고(LottoGenerator) LottoTicket를 생성(InputView)
   * 유효성 검사(LottoVaildator)
4. WinningNumbersGenerator로 당첨 번호와 보너스 번호 입력 받기(InputView)
   * 유효성 검사(WinningNumbersInputVaildator)
5. StatisticCalculator로 당첨 통계를 계산한 뒤 화면에 표시(OutputView)
6. ProfitCalculator로 수익률을 계산한 뒤 화면에 표시(OutputView)
7. 각 유효성 검사마다 유효하지 않은 입력일 시 예외 사항 발생 및 출력(ExceptionMessage)

---
## ▶ 테스트 목록
### 사용자 입력 단계에서 테스트
* 금액 입력 시 테스트
  * 수를 입력했는가
* 당첨번호 입력 시 테스트
  * comma(,)와 수만 입력했는가
* 보너스 번호 입력 시 테스트
  * 수를 입력했는가

### 시스템 실행 단계에서 도메인 테스트
* 금액
  * 1000원 이상인가
  * 1000원 단위로 입력을 했는가
* 로또 번호
  * 로또 번호가 중복이 되지 않는가
  * 로또 번호가 범위를 벗어나는가
  * 로또 번호의 개수가 6개인가
  * 로또 번호가 오름차순으로 정렬되어있는가
* 당첨 번호
  * 당첨 번호가 중복이 되지 않는가
  * 당첨 번호가 범위를 벗어나는가
  * 당첨 번호의 개수가 6개인가
  * 컴마 사이가 값이 없는가 (ex) 1,2,3,,4)
  * 시작과 끝이 컴마인가 (ex) ,1,2,3 / 1,2,3,)
* 위닝 콤비네이션(당첨 번호 + 보너스 번호)
  * 당첨 번호의 오류가 없는가
  * 보너스 번호가 범위를 벗어나는가
  * 보너스 번호와 당첨 번호가 중복이 되지 않는가

### 시스템 실행 테스트
* 통계가 올바르게 되었는가
* 수익률 측정이 올바르게 되었는가

---
## ▶ 요구 사항 목록
- [ ] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록
- [ ] else 예약어를 쓰지 않는다
  - if 조건절에서 값을 return하는 방식 
  - [ ] switch/case도 허용하지 않는다.
- [ ] Java Enum
- [ ] 도메인 로직에 단위 테스트
  - 단, UI(System.out, System.in, Scanner) 로직은 제외
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현
  - while문 안에 if문이 있으면 들여쓰기는 2이다.
## ▶ 보완할 사항 목록
- [ ] 패키지 분리
- [ ] 객체 따로 생성
- [ ] InputView와 OutputView의 역할을 확실히 하기
- [ ] List로 추상화하기
- [ ] Console.close() 까먹지말기