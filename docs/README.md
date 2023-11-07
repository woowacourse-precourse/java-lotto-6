# 🚀 기능 명세서

- [x] 로또 구입 금액 입력 
  - [x] "구입 금액을 입력해주세요." - InputView#inputPurchasePrice()
    - 로또 1장의 가격 = 1000원
    - [x] 입력 값이 숫자 형식이 아닌 경우 예외 처리
  - [x] 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리 - Amount#validate()
- [x] 로또 발행 
  - [x] 입력받은 금액만큼 로또 발행 - LottoPublisher#publishLottosByAmount()
    - [x] 발행 가능한 로또 개수 계산 - LottoPublisher#countLottoTicketsAvailableForPurchase()
    - [x] "0개를 구매했습니다." - OutputView#printPublishedLottoCount()
    - [x] "[0, 0, 0, 0, 0, 0]" - OutputView#printPublishedLottos()
    - [x] 중복되지 않는 랜덤 6개 숫자 - RandomNumberGenerator#createUniqueRandomNumbers()
      - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용
    - [x] 오름차순 정렬 - RandomNumberGenerator#sortRandomNumbers()
- [x] 당첨 번호 입력 
  - [x] "당첨 번호를 입력해 주세요." - InputView#inputWinningNumbers()
    - 쉼표로 구분
    - [x] 1~45 사이의 로또 당첨 번호 - Lotto#validate()
    - [ ] 중복되지 않는 로또 당첨 번호 - Lotto#validate()
    - [x] 6개의 당첨 번호 - Lotto#validate()
  - [ ] "보너스 번호를 입력해 주세요." - InputView#inputBonusNumber()
    - 1~45 사이의 보너스 번호 1개 - Bonus#validate()
- [ ] 당첨 판단 - Lottos#determineWinnings()
  - 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
  - 당첨 번호와 같은 숫자가 있는지 판별 - Lotto#countWinningNumbers()
  - 보너스 번호와 같은 숫자가 있는지 판별 - Lotto#hasBonusNumber()
- [ ] 당첨 내역 출력 - OutputView#printWinningResult
  - [ ] "3개 일치 (5,000원) - 1개\
    4개 일치 (50,000원) - 0개\
    5개 일치 (1,500,000원) - 0개\
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\
    6개 일치 (2,000,000,000원) - 0개"
- [ ] 수익률 계산 - Calculator#calculateROI()
  - [ ] 상금 계산 - WinningResult#getLotteryPrize()
  - 소수점 둘째 자리에서 반올림
- [ ] 수익률 출력 - OutputView#printEarningRate()
  - [ ] "총 수익률은 00.0%입니다." 



## ⚠️구현 요구 사항
- Java Enum을 적용한다.
- 도메인 로직에 단위 테스트를 구현해야 한다.
  - 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
- Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
- 예외 처리
  - "[ERROR] 메세지 내용"
  - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리