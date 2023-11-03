# 우아한테크코스 Precourse 3주차

---

## 패키지 구조

### view

- InputView
- OutputView

__constants__
- ConstantMessage

### exception

- EmptyValue
- NotNumericValue
- InvalidLottoNumberFormat
- InvalidLottoNumberRange
- NotMultipleOfThousand

__exception_message__
- ExceptionMessage : `enum`
- ExceptionMessageBuilder 

### domain
#### lotto
- Lotto
- LottoController

#### lotto_winning_policy
- LottoWinningPolicy : `interface`
- FixedLottoWinningPolicy

### controller

- Game

### validator

- InputValidator

__constants__
- ValidationPatterns

### util

- Formatter
- Parser


---

## 기능 명세

### 입력

- 로또 구입 금액 입력
- 당첨 번호 입력
- 보너스 번호 입력

### 출력

- 발행한 로또 수량 출력
- 발행한 로또 번호 출력
- 당첨 내역 출력
- 총 수익률 출력
- 당첨 통계 출력

- 에러 문구 출력
- 공백 라인 출력

### 로또

- 발행 로또 번호 정렬
- 당첨 내역 계산
    - 로또 번호 일치 여부 계산
    - 보너스볼 일치 여부 계산
- 당첨 금액 계산
- 수익률 계산

### 예외

- 공백 입력
- 숫자가 아닌 값 입력
- 로또 번호 입력의 포맷이 잘못됨 (숫자와 `,`로만 구성되지 않음)
- 로또 구입 금액이 1,000원 단위로 구성되지 않음
- 로또 번호의 범위(1~45)애 포함되지 않는 수가 입력됨

### 검증

- 로또 구입 금액 입력 검증
    - 빈 값이 아닌지
    - 숫자 입력이 맞는지
    - 1,000원 단위로 이루어진 입력인지


- 당첨 번호 입력 검증
    - 빈 값이 아닌지
    - `,`와 숫자로만 이루어져 있는지
    - 수의 범위가 1~45에 해당하는지


- 보너스 번호 입력 검증
    - 빈 값이 아닌지
    - 숫자 입력이 맞는지
    - 수의 범위가 1~45에 해당하는지

---


