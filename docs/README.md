## 기능 목록

<br/>

- 로또 구입 금액을 입력한다.


- 로또 구입 금액을 예외 처리한다.
    - 입력한 값을 정수로 변환할 수 없는 경우
    - 0 이하의 정수인 경우
    - 1000으로 나눠 떨어지지 않는 경우


- 구입한만큼 로또를 생성한다.


- 로또 숫자를 생성한다.


- 생성한 로또 숫자를 예외 처리한다.
    - 입력한 값을 정수로 변환할 수 없는 경우
    - 6개가 아닌 경우
    - 1~45의 숫자가 아닌 경우
    - 중복 숫자가 있는 경우


- 구입한 로또 수량을 출력한다.


- 로또에 찍힌 번호를 출력한다.


- 당첨 번호를 입력한다.


- 당첨 번호 입력값을 정리한다.
    - 구분자가 ,가 아닌 경우


- 당첨 번호를 예외 처리한다.
    - 6개가 아닌 경우
    - 1~45의 숫자가 아닌 경우
    - 중복 숫자가 있는 경우


- 보너스 번호를 입력한다.


- 보너스 번호를 예외 처리한다.
    - 입력한 값을 정수로 변환할 수 없는 경우
    - 당첨 번호와 중복되는 경우
    - 1~45의 범위가 아닌 경우


- 당첨 조사 결과를 출력한다.


- 수익률을 출력한다.

<br/>
<br/>

---

## 메서드 목록

<br/>

### 1. Exception

| 메서드 이름                 | 기능                         |
|------------------------|----------------------------|
| validateLottoNumbers   | 로또 번호 관련 예외 처리 메서드 모음      |
| validateBonusNumber    | 보너스 번호 관련 예외 처리 메서드 모음     |
| validateMoney          | 금액 관련 예외 처리 메서드 모음         |
| validateSeparator      | 구분자 예외 처리                  |
| notParsableNumber      | String 형변환 예외 처리           |
| notSixNumbers          | 번호 개수가 6개가 아니면 예외 발생       |
| numberNotInRange       | 번호가 1~45에 속하는 값이 아니면 예외 발생 |
| duplicateNumber        | 중복 번호가 있으면 예외 발생           |
| notPositiveNumber      | 번호가 음수면 예외 발생              |
| notDividedWithThousand | 1000으로 나눠 떨어지지 않으면 예외 발생   |

<br/>
<br/>

### 2. Lotto

| 메서드 이름                | 기능                      |
|-----------------------|-------------------------|
| lottoPrintFormat      | 로또에 적힌 숫자를 출력 형식에 맞게 배치 |
| compareWithWinNumbers | 로또 당첨 여부 판단             |

<br/>
<br/>

### 3. LottoMachine

| 메서드 이름               | 기능                 |
|----------------------|--------------------|
| lottoMachineInput    | 로또 구입 금액 입력        |
| lottoMachineOutput   | 로또 구입 결과 출력        |
| insertMoney          | 로또 구입 금액 예외 처리와 저장 |
| generateLottoBundle  | 구입 개수만큼 로또 생성      |
| generateLottoNumbers | 로또 번호 생성           |

<br/>
<br/>

### 4. LottoResultChecker

| 메서드 이름                   | 기능               |
|--------------------------|------------------|
| lottoResultCheckerInput  | 당첨 번호와 보너스 번호 입력 |
| lottoResultCheckerOutput | 로또 당첨 결과 출력      |
| winNumbersInput          | 당첨 번호 입력         |
| setWinNumbers            | 당첨 번호 예외 처리와 저장  |
| bonusNumberInput         | 보너스 번호 입력        |
| setBonusNumber           | 보너스 번호 예외 처리와 저장 |
| checkLottoBundle         | 로또 당첨 결과 확인      |
| printResultOfCheck       | 로또 당첨 결과 출력      |
| calculatePortfolio       | 수익률 계산           |
