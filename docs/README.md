# 로또 프로젝트
로또 프로젝트는 로또에 참여하는 사람들 간의 행위에 도움을 주는 취지에서 만든 프로젝트입니다.
이 프로젝트는 크게 다음과 같은 기능을 해줍니다.
1. 고객으로부터 돈을 받으면 그 금액에 정확히 맞는 로또의 수량에 맞춰 로또 번호를 제공합니다.
2. 로또 번호는 완벽히 무작위이고, 로또 정책에 따라 한 장의 로또 번호에는 중복된 수가 없고, 한 명의 고객에게는 중복된 로또를 지급하지 않습니다.
3. 로또 당첨 번호와 보너스 번호를 입력받으면 그 번호에 맞춰 해당 고객의 당첨내역과 수익률을 안내해줍니다.

# 시퀀스 기능 목록
- [x] 로또 구입 금액을 입력 받는다.
    - [x] 구입금액을 입력해달라고 안내 문구를 출력한다. - OutputView$beforeInputMoney()
      ```text
      구입금액을 입력해 주세요.
      ```
    - [x] 입력받은 금액을 검증한다. - InputView$inputMoney()
        - [x] 숫자인지 검증한다. - InputValidator$parseValidatedInt()
            - [x] int형으로 변환 가능한지 검증한다. - InputValidtor$validateMemorySizeLimit()
        - [x] 1,000원으로 나누어떨어지는지 검증한다.
            - [x] 금액이 양수인지 검증한다.
            - [x] 1,000원으로 나누어떨어지는지 검증한다.
        - [x] 검증에 실패하면 "[ERROR] ~" 메시지와 함께 `IllegalArgumentException`을 던진다.
- [x] 로또 구입 결과를 반환한다. - OutputView$printPurchasedLottoes(lottoesDto)
  - [x] 로또 발행 수량을 계산해야 한다.(로또 한 장의 가격은 1,000원이다.) - LottoService$calculateLottoCount(int money)
      - [x] 몇 개를 구입했는지 안내 문구를 출력한다. - OutputView$printLottoCount(lottoesDto)
        ```text
        $[개수]개를 구매했습니다.
        ```
  - [x] 로또 번호를 로또 발행 수량만큼 생성한다. - LottoService$generateLottoes(int lottoesCount)
      - [x] 로또 번호의 숫자 범위는 1~45다. - Lotto$generateNumbers()
      - [x] 중복되지 않는 6개의 숫자를 무작위로 뽑는다. - Lotto$generateNumbers()
          - [x] 6개의 숫자는 오름차순으로 정렬한다. - Lotto$generateNumbers()
      - [x] 발행된 로또 번호 간에도 중복되지 않게 뽑는다. - Lotto$generateNumbers()
      - [x] 각 로또 번호를 출력해서 보여준다. - OutputView$printGeneratedLottoes(lottoesDto)
        ```text
        [8, 21, 23, 41, 42, 43]
        [3, 5, 11, 16, 32, 38]
        [7, 11, 16, 35, 36, 44]
        [1, 8, 11, 31, 41, 42]
        [13, 14, 16, 38, 42, 45]
        [7, 11, 30, 40, 42, 43]
        [2, 13, 22, 32, 38, 45]
        [1, 3, 5, 14, 22, 45]
        ```
- [ ] 당첨 번호를 입력받는다.
    - [ ] 입력받기 전 안내 문구를 출력한다.
      ```text
      당첨 번호를 입력해 주세요.
      ```
    - [ ] 번호는 쉼표(,)를 기준으로 구분한다.
    - [ ] 번호가 쉼표를 기준으로 구분했을 때 숫자인지 검증한다.
    - [ ] 각 숫자가 1~45 사이의 숫자인지 검증한다.
    - [ ] 숫자가 총 6개가 맞는지 검증한다.
    - [ ] 숫자가 중복되는 숫자가 없는지 검증한다.
    - [ ] 검증에 실패하면 "[ERROR] ~" 메시지와 함께 `IllegalArgumentException`을 던진다.
- [ ] 보너스 번호를 입력받는다.
    - [ ] 입력받기 전 안내 문구를 출력한다.
      ```text
      보너스 번호를 입력해 주세요.
      ```
    - [ ] 숫자로 입력받았는지 검증한다.
    - [ ] 숫자가 1~45 사이의 숫자인지 검증한다.
    - [ ] 당첨 번호 중 중복된 숫자가 없는지 검증한다.
    - [ ] 검증에 실패하면 "[ERROR] ~" 메시지와 함께 `IllegalArgumentException`을 던진다.
- [ ] 당첨 내역을 계산한다.
  ```text
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
  ```
- [ ] 수익률을 계산한다.
    - [ ] 수익률은 소수점 둘째 자리에서 반올림한다.
- [ ] 당첨 통계를 출력한다.
    - [ ] 당첨 통계 시작 문구를 출력한다.
      ```text
      당첨 통계
      ---
      ```
    - [ ] 당첨 내역 먼저 출력한다.
      ```text
      3개 일치 (5,000원) - 1개
      4개 일치 (50,000원) - 0개
      5개 일치 (1,500,000원) - 0개
      5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
      6개 일치 (2,000,000,000원) - 0개
      ```
    - [ ] 수익률을 출력한다.
      ```text
      총 수익률은 62.5%입니다.
      ```

# 객체 다이어그램
## LottoController
1. 역할 : 뷰와 서비스 간에 필요한 데이터를 전달하는 중간자 역할
2. 상태 : InputView, OutputView, LottoService
3. 행위
    - void run()
    - MoneyDto getMoneyFromClient()
    - LottoesDto createLottoes(MoneyDto)
    - WinNumbersDto createWinNumbers()
    - ResultDto getResult()

## LottoService
1. 역할 : 리포지토리에 필요한 데이터를 입력하거나 꺼내서 핵심 비즈니스 로직을 담당
2. 상태 : LottoRepository
3. 행위
    - LottoesDto purchaseLottoes(MoneyDto moneyDto)
    - int calculateLottoCount(int money)
    - List<LottoDto> generateLottoes()
    - ResultDto generateResult(WinNumbersDto)
        - LottoDto calculateWinResult()
        - double calculateBenefitRate()

## LottoRepository
1. 역할 : Lotto 도메인을 관리한다. 도메인을 LottoRepository 외부로 노출시키지 않고, 필요한 데이터만 DTO로 감싸서 전달한다.
2. 상태 : lottoes
3. 행위
    - LottoDto createLotto()
    - void save(Lotto)
    - List<LottoDto> findLottoDtoes()

## Lotto
1. 역할 : Lotto 도메인. 로또 번호를 검증 및 관리한다.
2. 상태 : numbers
3. 행위
    - void validate(List<Integer>)
    - List<Integer> getNumbers()

## LottoDto
1. 역할 : LottoRepository에서 LottoService로 Lotto 관련 필요 데이터를 전달하는 모델
2. 상태 : numbers, ~~correctNumbers, isBonusCorrect~~
3. 행위 : 레코드

## MoneyDto
1. 역할 : LottoController에서 LottoService로 돈 관련 데이터를 전달하는 모델
2. 상태 : money
3. 행위 : 레코드

## LottoesDto
1. 역할 : LottoDto들을 묶어서 하나의 DTO로 서비스에서 컨트롤러로 데이터를 전달하는 모델
2. 상태 : List<LottoDto>
3. 행위 : 레코드

## WinNumbersDto
1. 역할 : 당첨 번호와 보너스 번호를 컨트롤러에서 서비스로 전달하는 모델
2. 상태 : LottoDto, bonusNumber
3. 행위 : 레코드, 검증

## ResultDto
1. 역할 : 당첨 내역과 수익률을 계산한 결과를 감싸서 서비스에서 컨트롤러로 전달하는 모델
2. 상태 : Map<Ranking, Integer> rankingNumbers, benefitRate
3. 행위 : 레코드

## `Enum` Ranking
1. 역할 : 1~5등에 따른 출력 문장과 상금 정보를 주는 열거형
2. 상태 : FIRST, SECOND, THIRD, FOURTH, FIFTH
3. 행위
    - getMessage()
    - getPrizeMoney()