### [Controller]
- LottoController
  - [x] 로또 구입 금액 입력 - Budget
  - [x] 로또 구입 개수 만큼 로또 번호 생성 - quantity
  - [x] 당첨 번호 입력 - WinningLotto
  - [x] 보너스 번호 입력 - WinningLotto
  - [x] 당첨 통계 생성 (Statistic)
  - [x] 당첨 통계 출력

### [Domain]
- [x] Lotto 
  - [x] 다른 로또 번호 일치하는 번호 개수 구하기
  - [x] 특정 숫자가 로또 번호에 포함되었는지
  - [x] 정렬되지 않은 리스트 들어올 경우 정렬하기
- [x] Budget
  - budget: 구입 예산
  - [x] 발권 개수 구하기
- [x] LottoTickets
  - List<Lotto> 
  - [x] 로또 번호 생성 (로또 번호는 오름차순으로 저장)
- [x] WinningLotto
  - Lotto, bonusNumber
  - [x] LottoTickets와 비교해서 Rank 찾기
- [x] Statistic : 로또 당첨 통계
  - Map<Rank, Integer> : 등수와 당첨 갯수
  - [x] WinningLotto의 Rank 찾기 메서드를 이용해 당첨 개수 증가시키기
  - [x] budget을 인자로 받아 수익률 구하기
- [x] Rank - 로또 당첨 enum
  - 1등, 2등, 3등, 4등, 5등, 낙첨 
  - [x] 일치하는 번호 개수와 보너스 번호 존재 유무를 통해 Rank 구하기
  - 
### [View]
- InputView
  - [x] 로또 구입 금액 입력
  - [x] 당첨 번호 입력
  - [x] 보너스 번호 입력
- OutputView
  - [x] 발행한 로또 수량 출력
  - [x] 생성된 자동 복권 번호 출력
  - [x] 당첨 내역 출력
  - [x] 수익률 출력


### [Util]
- Validator
  - 공통
    - [x] 비어있는 문자열을 입력하는 경우
    - [x] 음수를 입력하는 경우
    - [x] 숫자 이외의 값을 입력하는 경우
  - 로또 구입 금액 입력
    - [x] 1000원으로 나누어 떨어지지 않는 경우
  - 당첨 번호 
    - [x] 1 - 45 외의 숫자를 입력하는 경우
    - [x] 중복된 번호를 입력하는 경우
    - [x] 6개 이상의 값을 입력하는 경우
  - 보너스 번호 입력
    - [x] 1 - 45 외의 숫자를 입력하는 경우
    - [x] 당첨 번호와 겹치는 번호가 있을 경우
- ErrorMessage
  - [x] 에러 메세지 enum