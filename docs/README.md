# 🎲 [로또] 구현할 기능 목록

![image](https://story.baemin.com/wp-content/uploads/2023/10/%EB%B0%B0%EB%AF%BC%EB%8B%A4%EC%9B%80_1920x710.png)![badge-name](https://img.shields.io/badge/woowacouase-precourse-blue.svg) ![badge-name](https://img.shields.io/badge/Java-lotto-red.svg) ![badge-name](https://img.shields.io/badge/week-3-green.svg)

---
## ✅ 기능 목록

- [x] **구입할 금액을 입력 받음.** 
  - 예외처리(음의 수) -> `InvalidNumberScopeException`
  - 예외처리(1,000원으로 나누어 떨어지지 않는 경우) -> `DivideByLottoPriceException`
  - 예외처리(숫자가 아닌 경우) -> `InvalidNumberFormatException`


- [x] **구입 금액에 해당하는 만큼 로또를 발행.** 
  - 로또 숫자의 범위는 1~45
  - 중복되지 않는 6개의 숫자를 뽑아야 함.


- [x] **당첨 번호 및 보너스 번호 입력 받음.**
  - 예외처리(로또 입력 형식 벗어남) -> `InvalidNumberFormatException`
  - 예외처리(번호가 6개 이상) -> `InvalidLottoFormatException67===`
  - 예외처리(중복된 값) -> `DuplicateNumbersLottoException`


- [x] **로또 당첨 계산 및 출력**
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원


- [x] **수익률 계산**

---
## 📦 Package 구조
### 📁 Controller

- `LottoGame`: 게임의 전반적인 흐름을 제어

### 📁  Domain (model)

- `Lotto`: 로또의 데이터 저장
- `LottoTicket`: `Lotto`에 대한 일급 컬렉션, 발급된 로또들을 관리
- `LottoFactory`: 로또 및 로또 티켓 발행
- `Money`: 투입 금액
- `Evaluator`: 로또 당첨 판단
- `Prize`: 당첨 값
- `PrizeRankConstants`: 당첨 순위에 관한 상수값들 (Enum 클래스)

### 📁 View

- `ConsoleInput`
- `ConsoleOutput`

### 📁 Exception

- `DivideByLottoPriceException`
  -  투입 금액이 로또 금액(1,000원)으로 나누어 떨어지지 않는 경우

- `DuplicateNumbersLottoException`
  - 로또 번호가 중복되게 입력했을 경우
- `EmpyStringException`
  - 사용자가 아무 값도 입력하지 않은 경우
- `InvalidLottoFormatException`
  - 잘못된 형식으로 로또 번호를 입력했을 경우
- `InvalidNumberFormatException`
  - 잘못된 형식으로 숫자를 입력했을 경우
- `InvalidNumberScopeException`
  - 잘못된 범위의 숫자 값을 입력했을 경우
