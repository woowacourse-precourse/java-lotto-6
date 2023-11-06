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
- [ ] User 클래스 구현하기
- [x] ConsoleReder 구현하기
    - readNumber
    - readNumberList
- [x] LotteryCommission 구현하기
    - winningNumbers
    - bonusNumber