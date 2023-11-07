<p align="center">
    <img src="./woowacourse_logo.png" alt="우아한테크코스" width="600px">
</p>

# 프리코스 미션 3주차 - 로또 추첨 🎱

## 프로젝트 구조 🌳

```

├─main
│  └─lotto
│      │  Application.class
│      │
│      ├─controller
│      │      LottoController.class
│      │
│      ├─domain
│      │  │  Amount.class
│      │  │  BonusNumber.class
│      │  │  JudgeCounter.class
│      │  │  Lotto.class
│      │  │  LottoJudge.class
│      │  │  LottoTicket.class
│      │  │  WinnerNumbers.class
│      │  │
│      │  ├─convertor
│      │  │      AmountConvertor.class
│      │  │      BonusNumberConvertor.class
│      │  │      Convertor.class
│      │  │      WinnerNumberConvertor.class
│      │  │      WinnerNumberSpiltConvertor.class
│      │  │
│      │  └─validator
│      │          AmountValidator.class
│      │          BonusNumberValidator.class
│      │          LottoValidator.class
│      │          Validator.class
│      │          WinnerNumberValidator.class
│      │
│      ├─util
│      │  └─constants
│      │          DomainConstants.class
│      │          InputConstants.class
│      │          OutputConstants$1.class
│      │          OutputConstants$2.class
│      │          OutputConstants$3.class
│      │          OutputConstants$4.class
│      │          OutputConstants$5.class
│      │          OutputConstants$6.class
│      │          OutputConstants$7.class
│      │          OutputConstants.class
│      │          Prize.class
│      │          ValidateConstants.class
│      │
│      └─view
│          ├─input
│          │      AmountView.class
│          │      BonusNumberView.class
│          │      Input.class
│          │      WinnerNumberView.class
│          │
│          └─output
│                  LottoStatisticsView.class
│                  LottoView.class
│                  Output.class
│
└─test
    └─lotto
            AmountValidatorTest.class
            ApplicationTest.class
            BonusNumberValidatorTest.class
            LottoTest.class
            WinnerNumberValidatorTest.class

```




# 로또 구매 금액 입력
- [X] 구매자로 부터 로또 구매 금액을 입력 받습니다.
  - [X] [예외 체크]
    - [X] 숫자 형식으로 입력 했는지 확인
    - [X] 1,000원 단위 인지 확인
      - [X] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 예외를 발생시키며 다시 입력 받습니다.

# 로또 생성
- [X] 입력된 금액을 정산하여 구매 개수 만큼 로또를 생산합니다.
  - [X] 1~45까지의 숫자 중 중복되지 않는 6개의 숫자를 무작위로 추출하여 로또 번호를 생성합니다.
  - [X] 생성 된 로또 번호를 오름차순으로 정리합니다.
  - [X] 입력 받은 금액만큼 로또 번호를 반복해서 생성합니다.
  - [X] 생성된 로또 번호들을 로또 티켓에 옮겨 담습니다.
    - [X] [예외 체크]
      - [X] 당첨 번호가 6개인지 확인합니다.
      - [X] 당첨 번호 중 중복이 있는지 확인합니다.
      - [X] 숫자가 1 ~ 45까지의 범위에 속하는지 확인 합니다.
        - [X] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 예외를 발생시키며 다시 입력 받습니다.

# 로또 출력
- [X] 로또 티켓을 출력합니다.

# 로또 당첨 번호 입력
- [X] 로또 당첨 번호를 입력 받습니다.
  - [X] 쉼표(,)를 기준으로 각 숫자를 분리합니다.
    - [X] [예외 체크]
      - [X] 숫자만 입력 되었는지 확인 합니다.
      - [X] 기타 에러는 로또에서 체크됨
        - [X] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 예외를 발생시키며 다시 입력 받습니다.

# 로또 보너스 번호 입력    
- [X] 보너스 번호를 입력 받습니다.
    - [X] 입력 받은 숫자 사이 공백을 제거합니다.
      - [X] [예외 체크]
        - [X] 숫자만 입력 되었는지 확인 합니다.
        - [X] 숫자가 1 ~ 45까지의 범위에 속하는지 확인 합니다.
            - [X] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 예외를 발생시키며 다시 입력 받습니다.


# 로또 번호 당첨 확인
- [X] 로또 번호의 당첨 여부를 확인합니다.
  - [X] 로또 번호와 당첨 번호를 비교하여 일치하는 숫자의 개수를 확인합니다.
  - [X] 5개 일치 시 구매한 로또에 당첨 번호 포함 여부를 확인 합니다.
  - [X] 당첨 결과를 생성합니다.

# 당첨 통계 생성
- [X] 로또의 당첨 통계를 생성합니다.
  - [X] 당첨 개수 별로 당첨 결과를 생성합니다.
  - [X] 총 당첨 결과를 기준으로 수익률을 생성합니다.

