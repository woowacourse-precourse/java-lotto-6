# 로또

## 기능 목록

### 사용자 입력 받기 - 총 3회

- [x] 로또 구입 금액 입력
- [x] 당첨 번호 입력
- [x] 보너스 번호 입력

### 출력

- [x] 구입 금액 입력에 따른 로또 구매 기능(로또 객체 생성) 구현
- [x] 로또 구매 목록에 따른 당첨 통계 출력

## Exception check-list

- 구입 금액
    - [x] 1000원으로 나누어 떨어져야 함
    - [x] 숫자여야 함
- 당첨 번호 리스트
    - [x] 6개여야 함
    - [x] 숫자여야 함
    - [x] 6개가 각각 중복되지 않아야 함
    - [x] 1, 45 사이의 숫자여야 함
- 보너스 볼
    - [x] 숫자여야 함
    - [x] 1, 45 사이의 숫자여야 함
    - [x] 당첨 번호 리스트에 포함되지 않아야 함

## Refactoring check-list

- [x] 상수 분리하기: Contants 클래스 사용
- [x] User 클래스 구현하기
    - money
    - lottoList
- [x] ConsoleReder 구현하기
    - readNumber
    - readNumberList
- [x] LotteryCommission 구현하기
    - winningNumbers
    - bonusNumber

---

## 11.08 - 리팩토링

### LottoController

#### 멤버

- LottoCommision
- User

#### 동작

- run

### Lotto

#### 멤버

- Numbers - 로또 번호 6자리 리스트

#### 동작

- Validate
    - 6개의 숫자가 존재하는가?
    - 숫자인가?
    - 중복된 숫자가 존재하는가?
    - 1, 45 사이의 숫자인가?

### LottoPaper

#### 멤버

- List<Lotto>
- Map<Enum, Boolean> - 로또 결과

### User

#### 멤버

- Money
- LottoPaper 1개

#### 동작

- Validate
- 금액이 1000원으로 나누어 떨어지는가?
- 금액이 숫자인가?

### LottoCommission

#### 멤버

- 로또 당첨 번호 6개
- 로또 보너스 번호 1개

#### 동작

- Validate
    - 로또 당첨 번호 6개
        - 6개의 숫자가 존재하는가?
        - 숫자인가?
        - 중복된 숫자가 존재하는가?
        - 1, 45 사이의 숫자인가?
    - 로또 번호스 번호 1개
        - 숫자인가?
        - 중복된 숫자가 존재하는가?
        - 1, 45 사이의 숫자인가?
- 결과체크_함수(LottoPaper)

### LottoResult (Enum)

- THREE("3개 일치 (5,000원)", 5000),
- FOUR("4개 일치 (50,000원)", 50000),
- FIVE("5개 일치 (1,500,000원)", 1500000),
- FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
- SIX("6개 일치 (2,000,000,000원)", 2000000000);

### ConsoleReader

- 동작
    - readNumber
    - readNumbers
