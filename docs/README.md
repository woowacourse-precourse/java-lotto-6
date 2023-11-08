# 구현 객체(MVC)
## 컨트롤러
### LottoController 클래스
- admin : DHLottery
- member : Member
- run() : void
- input() : void

## 모델
### DHLottery 클래스
- winningNumber
- bonusNumber
- checkLotto(Lotto) : ScoreType

### Lotto 클래스
- randomNumber : List<Integer>
- score : ScoreType

### Member 클래스
- amount : Integer
- lottos : List<Lotto>
- scores : List<ScoreType>
- winningMoney : Double

### ScoreType 열거형
- 1등
- 2등
- 3등
- 4등
- 5등

## 뷰
### Print 클래스
- inputAmount()
- buyLottos()
- inputWinningNumber()
- inputBonusNumber()
- scoreBoard(List<ScoreType>)
- rateOfReturn(Double)
### ErrorPrint 클래스
- notDivideBy1000()
- notNumber()
- not6Number()
- existSameNumber()
- outOfRangeValue()

# 동작원리
- 구입금액 입력받음(1000원 단위로)
    - 1000원 단위 아닐 시 - "[ERROR] 1000원 단위가 아닙니다. 다시 입력하세요"
    - 숫자 입력이 아닐 시 - "[ERROR] 숫자입력이 아닙니다. 다시 입력하세요"
- 구입 금액 당 랜덤 로또 구매 장 수 출력
- 당첨 번호 입력 받음
    - 입력값이 6개의 숫자로 이루어지지않았을 시 - "[ERROR] 당첨 번호가 6개가 아닙니다. 다시 입력하세요"
    - 당첨 번호에 중복 숫자 값이 있을 시 - "[ERROR] 중복된 값이 존재합니다. 다시 입력하세요"
    - 당첨 번호의 범위가 1~45 이외 의 값일 시 - "[ERROR] 범위 이외의 값이 존재합니다. 다시 입력하세요"
- 보너스 번호 입력 받음
    - 보너스 번호가 숫자 이외의 값일 시 - "[ERROR] 숫자입력이 아닙니다. 다시 입력하세요"
    - 보너스 번호가 중복 숫자 값이 있을 시 - "[ERROR] 중복된 값이 존재합니다. 다시 입력하세요"
    - 보너스 번호의 범위가 1~45 이외 의 값일 시 - "[ERROR] 범위 이외의 값이 존재합니다. 다시 입력하세요"
- 해당 상황에 맞는 출력을 진행
- 수익률을 출력 후 종료


# 예외처리
"[ERROR] ~~~~~" 입력 후 해당 위치에서 재시작
- 입력값 1000단위 아닐 시
- 입력값 숫자 아닐 시
- winningNumber 6개의 숫자 아닐 시
- winningNumber 중복 숫자 있을 시
- winningNumber 숫자 범위 1~45 이외일 시
- bounsNumber 숫자 아닐 시
- bonusNumber 숫자가 winningNumber와 중복 값 있을 시
- bonusNumber 숫자 범위 1~45 이외일 시