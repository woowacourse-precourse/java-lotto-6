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
* [x] 금액 입력 기능
  *  (유효성 검사)
* [x] 금액에 따라 로또 발급 기능
  * 로또 한 개 발급 기능
    * 중복 없는 랜덤 숫자 생성 기능
      * (유효성 검사)
    * 랜덤 숫자 6개로 로또 리스트 생성 기능
      * (유효성 검사)
      * 리스트를 오름차순으로 정렬하는 기능
### 위닝콤비네이션(당첨 번호 및 보너스 번호) 입력 기능
* [x] 당첨 번호 입력 기능
  * 6개의 숫자를 입력
  * 입력된 문자열을 숫자로 이루어진 리스트로 변환
  * (유효성 검사)
* [x] 보너스 번호 입력 기능
  * 보너스 번호 입력
  * (유효성 검사)
### 통계 기능
* [x] 당첨된 로또가 등수에 따라 몇 개인지 측정하는 기능
  * 구매한 각 로또마다 위닝콤비네이션과 비교하여 등수 측정
  * 당첨 기준에 따라 각 등수별 개수 누적
* [x] 각 등수별 개수를 리스트 형태로 반환하는 기능
### 수익률 기능
* [x] 구매한 금액과 당첨된 금액을 통해 수익률 계산하는 기능
* [x] 소수점 둘째자리에서 반올림하여 수익률을 저장 및 반환하는 기능
### 입출력 기능
* [x] 실행 결과를 사용자에게 출력하는 기능
  * 정해져있는 문구 출력하는 기능
  * 뽑은 모든 로또들을 출력하는 기능
  * 통계 및 수익률을 출력하는 기능
* [x] 요청 질문 출력 및 사용자 입력 기능
  * 정해져있는 요청 질문을 출력한다.
  * 금액을 입력 받는다.
  * 당첨 번호를 입력 받는다
  * 보너스 번호를 입력 받는다.
  * (입력 유효성 검사)
### 유효성 검사 기능
* [x] 입력이 알맞지 않을 경우 예외처리하는 기능
  * [x] 사용자 입력 부분 예외처리
    * 숫자가 아닌 경우 
    * 형식이 맞지 않는 경우 
  * [x] 시스템 규칙 부분 예외처리
    * 금액 부분
      * 숫자가 1000 미만일 경우
    * 보너스 번호 부분
      * 범위 벗어나는 경우
    * 당첨 번호 부분
      * 중복일 경우
      * 범위를 벗어나는 경우
    * 위닝콤비네이션(당첨 번호+보너스 번호) 입력 부분
      * 중복일 경우
    * 로또 부분
      * 중복일 경우
      * 범위를 벗어나는 경우

---
## ▶ 주요 클래스 목록
### LottoSystem
* 로또 시스템을 위와 같은 순서로 진행한다.
### OutputView
* 시스템이 실행되는 동안 사용자에게 실행 결과 및 과정 출력
### InputView
* 시스템이 실행되는 동안 사용자로부터 입력 값을 받음
### LottosGenerator
* 로또를 사용자가 입력한 금액에 따라 로또를 뽑는다.
### StatisticCalculator
* 당첨 통계를 계산한다.
### ProfitCalculator
* 수익률을 계산한다.
### vaildator패키지 속 클래스들
* 사용자 입력이 조건에 맞는지 유효성 검사를 한다.

## ▶ 도메인 목록
### Budget
* 구매할 금액
### Lottos
* Lotto들로 구성되어있다.
* 구매한 로또만큼 가지고 있다.
### Lotto
* 6개의 로또숫자로 구성되어있다.
### WinningNumbers
* 입력된 당첨 숫자들로 구성
### BonusNumber
* 입력된 보너스 숫자 
### WinningCombination
* WinningNumbers + BonusNumber

---
## ▶ 패키지 개요
### controller
* LottosGenerator
* LottoSystem
* ProfitCalculator
* StatisticsGenerator
### domain
* BonusNumber
* Budget
* Lotto
* Lottos
* WinningCombination
* WinningLottoNumbers
### validator
* **input**
  * InputValidator
* **system**
  * SystemValidator
  * **domain**
    * BonusNumberValidator
    * BudgetValidator
    * LottoValidator
    * WinningCombinationValidator
    * WinningLottoNumbersValidator
### view
* **InputView**
* **OutputView**
* **message**
  * **ViewMessage**
      * **ProcessMessage**
      * **ResultMessage**
  * **ExceptionMessage**
      * **BudgetInputErrorMessage**
      * **WinningNumbersInputErrorMessage**
      * **LottoGenerateErrorMessage**
### test
* controller
  * ProfitCalculator
  * StatisticsGenerator
* domain
  * BonusNumber
  * Budget
  * Lotto
  * WinningCombination
  * WinningLottoNumbers
* view
  * BonusNumber
  * Budget
  * WinningLottoNumbers

---
## ▶ 시스템 기능 흐름
1. LottoSystemController 실행
2. 금액을 입력 받고 Budget 객체 생성(InputView)
   * 유효성 검사(BudgetInputVaildator)
3. Lotto들을 입력 받고(LottoGenerator) Lottos를 생성(InputView)
   * 유효성 검사(LottoVaildator)
4. 당첨 번호와 보너스 번호 입력 받기(InputView)
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
  * comma와 수만 작성했어도 형식에 맞게 입력했는가\
    * 컴마 사이가 값이 없는가 (ex) 1,2,3,,4)
    * 시작과 끝이 컴마인가 (ex) ,1,2,3 / 1,2,3,)
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
* 위닝 콤비네이션(당첨 번호 + 보너스 번호)
  * 당첨 번호의 오류가 없는가
  * 보너스 번호가 범위를 벗어나는가
  * 보너스 번호와 당첨 번호가 중복이 되지 않는가

### 시스템 실행 테스트
* 통계가 올바르게 되었는가
* 수익률 측정이 올바르게 되었는가

---
## ▶ 요구 사항 목록
- [x] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록
- [x] else 예약어를 쓰지 않는다
  - if 조건절에서 값을 return하는 방식 
  - [x] switch/case도 허용하지 않는다.
- [x] Java Enum
- [x] 도메인 로직에 단위 테스트
  - 단, UI(System.out, System.in, Scanner) 로직은 제외
- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현
  - while문 안에 if문이 있으면 들여쓰기는 2이다.
## ▶ 보완할 사항 목록
- [x] 직관적인 변수명 사용
- [x] 패키지마다 정확한 목적
- [x] 객체 분리
- [x] InputView와 OutputView의 역할을 확실히 하기
- [x] List로 추상화하기
- [x] Console.close() 까먹지 말기
- [x] 구현 순서 준수
- [x] 하드 코딩 X
- [x] private public protected 확인