# 미션 - 로또

## 🔍 예상 기능

- 단순출력 기능 ex) 구입금액 요구, ui 안내등
- 구입금액 입력받기
- 구입금액 입력값 검증
- 당첨번호/보너스번호 입력박기
- 당첨번호/보너스번호 입력값 검증
- 로또 티켓 생성
- 생성된 티켓 출력
- 당첨여부 확인
- 당첨 통계 및 수익률 계산, 출력


## 필요 예상 클래스

- Application(psvm 실행)
- Lotto ⚙️고정 (로또 번호 저장, 검증, +추가기능 추가)
- WinningNumber(당첨번호 입력, 입력값 검증, 당첨확인)
- SystemOutput(각종 결과 정리/출력)
- Enum
  - Exception Messages
  - Winnings

### 필요 예상 메서드

- Lotto
  - 생성자(티켓 번호 입력)
  - validate
  - getNumbers
- BuyTickets
  - 생성자(구매 금액 입력)
  - validate
  - makeLotteryNumbers
  - getLotteryNumbers
- CheckWinningNumbers
  - 생성자(List티켓, 당첨번호)
  - matchUserNumberWithWinningNumbers
  - getResult
- SystemOutput
  - requestPurchaseAmount
  - showPurchaseInformation
  - requestWinningNumbers
  - requestBonusNumbers
  - showLotteryResult

## 수정

- 흐름 수정

### 클래스 수정사항

- 클래스 리팩토링
- 클래스 추가

### 메서드 수정사항

- 매서드 리팩토링
- 매서드 추가
