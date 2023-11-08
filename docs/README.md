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
  - 기존 흐름
    - BuyTickets 생성
    - 당첨번호를 생성 인자로 Lotto 클래스 생성
    - lotto번호 생성후 받은 값을 Lotto클래스에서 매칭 메서드 반복으로 당첨 판정
    - 판정값을 Application 에 쌓아뒀다가 한번에 출력
  - 수정된 흐름
    - BuyTickets 생성
    - 로또번호들을 Map으로 반환
    - 당첨번호 / 보너스번호 요구
    - 반환된 번호들을 각각 iter를 통해 매칭진행
    - 각각의 번호를 반복마다 생성 인자삼아 생성
    - 당첨번호와 보너스번호와 매칭하여 각가의 결과를 Calculation클래스에서 집계
    - 결과 출력

### 클래스 수정사항

- 클래스 리팩토링 
  - 예상클래스의 CheckWinningNumbers의 기능들을 Lotto클래스로 병합
  - SystemOutput -> SystemIO 로 변경, 입출력 UI 전담
- 클래스 추가
  - Calculation 클래스 추가 후 당첨 집계 기능을 전담

### 메서드 수정사항

- 매서드 리팩토링
  - Lotto - getNumbers -> getWinningRank
- 매서드 추가
  - BuyTickets - validateMultipleOfThousand
  - BuyTickets - getPurchaseAmount
  - BuyTickets - getLotteryNumbers
