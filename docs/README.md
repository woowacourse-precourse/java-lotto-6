# [Lotto System]

---
## ▶ Lotto System 프로그램

1. 금액을 준비한다.
2. 금액에 해당하는 만큼 로또를 발행(구입)한다
   * 랜덤으로 중복없는 6개의 숫자를 추출
3. 당첨 번호를 사용자로부터 입력받는다.
   * 랜덤으로 중복없는 6개의 숫자와 보너스 번호 1개 추출
4. 당첨 등수 확인
   - 1등: 6개 번호 일치 / 2,000,000,000원
   - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
   - 3등: 5개 번호 일치 / 1,500,000원
   - 4등: 4개 번호 일치 / 50,000원
   - 5등: 3개 번호 일치 / 5,000원
   - 1등부터 5등까지 확인
5. 당첨 내역을 출력한다.
6. 수익률을 계산하여 출력한다.
7. 에러 상황에서는 에러 문구를 출력한다.

---
## ▶ 기능 목록

### LottoSystemController
* 로또 시스템을 위와 같은 순서로 진행한다.
### OutputView
* 시스템이 실행되는 동안 사용자에게 실행 결과 및 과정 출력
### InputView
* 시스템이 실행되는 동안 사용자로부터 입력 값을 받음
### LottoPurchaseManager
* 로또를 사용자가 입력한 금액에 따라 로또를 뽑는다.
  * **MoneyInputManager**
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
### BudgetMoney
* 구매할 금액
* (유효성 검사)
### LottoTicket
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
### Message
* **ViewMessage**
    * **ProcessMessage**
        * 로또 시스템이 시행되는 동안 사용자에게 보여줄 메세지
    * **StatisticsMessage**
        * 당첨 통계를 보여줄 메세지
  * **ExceptionMessage**
    * [Error]로 시작해야한다.
    * **MoneyInputErrorMessage**
      * LESS_THAN_1000
      * NOT_NUMBER
    * **WinningNumbersInputErrorMessage**
      * NOT_NUMBER
      * OUT_OF_RANGE_NUMBER
      * DUPLICATED_NUMBER
    * **LottoGenerateErrorMessage**
      * DUPLICATED_NUMBER

---
## ▶ 계층 개요
### Message
* **ViewMessage**
    * **ProcessMessage**
    * **StatisticsMessage**
    * **ExceptionMessage**
        * **MoneyInputErrorMessage**
            * LESS_THAN_1000
            * NOT_NUMBER
        * **WinningNumbersInputErrorMessage**
            * NOT_NUMBER
            * OUT_OF_RANGE_NUMBER
            * DUPLICATED_NUMBER
        * **LottoGenerateErrorMessage**
            * DUPLICATED_NUMBER

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