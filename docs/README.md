## 목표
입력한 금액만큼 로또를 구매하고 중복되지 않는 6개의 숫자와 보너스 번호를 입력받아 당첨 로또를 정해주면
1등~5등까지 개수와 총 수익률을 보여주도록 하는 게임을 만들자.

다만, 메소드가 15라인을 넘지 않도록 구현하며 else를 사용하지 않는다.

## 기능 목록
- [x] 구입 금액 입력
  - [x] 1000 단위로 정확히 나누어 떨어지지 않는 다면 `IllegalArgumentException` 발생
  - [x] 숫자 이외의 값의 경우 `IllegalArgumentException` 발생
- [x] 구입한 개수만큼 로또 출력
- [x] 당첨 번호 입력
  - [x] 1~45 이외의 값을 입력하는 경우 `IllegalArgumentException` 발생
  - [x] 숫자 이외의 값을 입력하는 경우 `IllegalArgumentException` 발생
  - [x] 중복된 값을 입력하는 경우 `IllegalArgumentException` 발생
  - [x] 입력 포멧이 맞지 않는 경우 `IllegalArgumentException` 발생
- [x] 보너스 번호 입력
  - [x] 1~45 이외의 값을 입력하는 경우 `IllegalArgumentException` 발생
  - [x] 숫자 이외의 값을 입력하는 경우 `IllegalArgumentException` 발생
  - [x] 보너스 숫자가 기존의 로또 번호와 중복되는 경우 `IllegalArgumentException` 발생
- [x] 로또 생성시 오름차순으로 정렬
- [x] 당첨 통계
- [x] 수익률 계산
- [x] `IllegalArgumentException` 예외 발생시 "[ERROR]" 메시지 포함하도록 구현 후 해당 부분부터 다시 진행

## 커밋 컨벤션
**태그** : 제목의 형태이며, :뒤에만 space가 있도록 한다.

feat : 새로운 기능 추가

fix : 버그 수정

docs : 문서 수정

style : 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우

refactor : 코드 리펙토링

test : 테스트 코드, 리펙토링 테스트 코드 추가

chore : 빌드 업무 수정, 패키지 매니저 수정

## 파일 구조
```bash
├── main
│   └── java
│       └── lotto
│           ├── Application.java
│           ├── controller
│           │   └── LottoController.java
│           ├── domain
│           │   ├── BonusNumber.java
│           │   ├── Lotto.java
│           │   └── Result.java
│           ├── excpetion
│           │   ├── DivedException.java
│           │   ├── DuplicatedException.java
│           │   ├── NotInRageException.java
│           │   ├── NotNumberException.java
│           │   ├── SizeException.java
│           │   └── constant
│           │       └── ExceptionMessage.java
│           ├── service
│           │   ├── LottoGeneratorService.java
│           │   ├── LottoGeneratorServiceImpl.java
│           │   ├── StatisticsService.java
│           │   ├── StatisticsServiceImpl.java
│           │   ├── WinningLottoFactory.java
│           │   └── WinningLottoFactoryImpl.java
│           ├── utils
│           │   ├── NumberConstant.java
│           │   └── NumberParser.java
│           ├── validate
│           │   ├── LottoValidator.java
│           │   └── NumberValidator.java
│           └── view
│               ├── InputView.java
│               ├── OutputView.java
│               └── constant
│                   ├── InputMessage.java
│                   └── OutputMessage.java
└── test
    └── java
        ├── lotto
        │   ├── ApplicationTest.java
        │   └── LottoTest.java
        └── service
            ├── BonusNumberFactoryTest.java
            ├── LottoGenerateTest.java
            ├── StatisticsTest.java
            └── WinningLottoFactoryTest.java
```