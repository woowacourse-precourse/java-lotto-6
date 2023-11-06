# 미션 - 로또

### 로또 게임은 아래와 같은 규칙으로 진행된다.

```
- 로또 1장의 가격은 1,000원이다.
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```

### 예외

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

## 기능 목록

- [x] 금액에 해당하는 만큼 로또를 발행 - LottoMachine#issue()
- [x] 로또 번호에 당첨 번호가 몇개가 있는지 계산 - Lotto#equalsNumberCount()
- [x] 로또 번호에 지정한 숫자가 포함되어 있는지 확인 - Lotto#contains()
- [x] 당첨 번호 갯수와 보너스 번호 포함 여부에 따라 등수 계산 - Rank#getRank()
- [x] 총 당첨금이 얼마인지 계산 - LottoMachine#combineWinnings()

### 예외처리

- [x] 번호가 1~45 사이의 숫자가 아닌 경우 - InputValidation#checkRange()
- [x] 로또 번호가 중복되는 경우 - Lotto#checkOverlap()
- [x] 입력받은 문자열이 숫자가 아닌 경우 - InputValidation#validateNumber()
- [x] 구매금액이 1000원으로 나누어 떨어지지 않는 경우 - InputValidation#checkDivisible()
- [x] 구매금액이 부족한 경우 - InputValidation#checkSufficient()
- [x] 당첨 번호가 쉼표(,)를 기준으로 구분되어 있지 않는 경우 -InputValidation#checkDelimiter()
- [x] 보너스 번호가 당첨 번호랑 중복되는 경우 - InputValidation#checkOverlap()

## 입출력 요구 사항

### 입력

- [x] 로또 구매 금액 입력 받기 - Input#readAmount()
- [x] 당첨 번호 입력 받기 - Input#readWinningNumber()
- [x] 보너스 번호를 입력 받기 - Input#readBonus()

### 출력

- [x] 메시지 출력 - Output#printMessage()
- [x] 발행한 로또 수량및 번호 출력(번호는 오름차순으로 정렬) - Output#printLottos()
- [x] 당첨 결과를 출력 - Output#printResult();
- [ ] 수익률 출력