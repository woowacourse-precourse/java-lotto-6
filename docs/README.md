# 기능 목록

## Controller
- [x] LottoController : 어플리케이션 실행 관리
  - lottoInputView : 입력 UI
  - lottoOutputView : 출력 UI
  - lottoMakingService : 로또 생성 서비스
  - lottoWinningService : 사용자가 가진 로또 묶음
  - LottoController(LottoView lottoInputView, LottoMaker lottoMakingService) : 의존성 주입
  - run() : 프로그램 진행 흐름 관리

## Model
- [x] Lotto : 6개의 숫자를 받아 Lotto로 관리하는 모델
  - numbers : 6개의 숫자
  - Lotto(List<Integer> numbers) : 숫자 유효성 검증한 뒤 숫자 주입
  - validate(List<Integer> numbers) : 숫자 유효성 검증 메서드
  - getNumbers() : 숫자 getter 메서드
  - 생각해볼 문제 :
    - getter메서드 안 써도 데이터를 뽑아올 수 있다고 하던데..


- [x] LottoContainer : 사용자가 가진 로또들을 하나로 관리하는 컨테이너
  - lottos : 로또 리스트
  - add(Lotto lotto) : 로또 리스트에 로또를 담는 메서드
  - getLottos() : 로또 getter 메서드


- [x] Prize : 상금 정보를 기록하는 enum 클래스
  - 맞춘 수에 따라 Enum상수를 추가
  - THREE, FOUR, FIVE, FIVE_PLUS, SIX
  - prize : 상금
  - rank : 몇 개 일치하는지 String
  - prizeCount(int matchCount, boolean matchBonus) : 맞춘 수에 따라 해당 Enum상수 리턴
  - 생각해볼 문제 :
    - 아직 뭔가 더러운 느낌. 중복되는 rank 문자열을 리턴하는 게 마음에 안 듦

## View
- [x] LottoInputView : 입력 UI
  - inputCash() : 구입 금액 입력
  - cashParser(String inputValue) : 구입 금액 검증 및 int 변환
  - inputWinningNumbers() : 당첨 번호 입력
  - winningNumbersParser(String inputValue) : 당첨 번호 검증 및 리스트 변환
  - inputBonusNumber() : 보너스 번호 입력
  - bonusNumberParser(String inputValue, List<Integer> winningNumbers) : 보너스 번호 검증 및 int 변환
  

## Utility
- [x] Constant : 모든 클래스에 공통적으로 사용되는 상수 정의
  - LOTTO_START_NUMBER : 시작 숫자 (1)
  - LOTTO_END_NUMBER : 마지막 숫자 (45)
  - LOTTO_PICK_NUMBER : 선택 숫자 (6)
  - LOTTO_PRICE : 로또 가격(1000)

- [x] Validator : 입력값 검증 클래스
  - validateInputCash(int cash) : 구매 금액 유효성 검증
  - validateLottoNumbers(List<Integer> winningNumbers) : 당첨 번호 유효성 검증
  - validateNumbers(List<Integer> numbers) : 로또 개수 검증
  - validateEachWinningNumber(int winningNumber, Map<Integer, Integer> sameNumberCheck) : 
각 로또 숫자 검증
  - validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) : 보너스 숫자 유효성 검증


## Service
- [x] LottoMakingService : 로또 생성
  - issue(int cash) : 로또 뭉치 생성
  - issueLottoPaper() : 로또 한장 생성
- [x] LottoWinningService : 로또 결과 계산
  - calculateWinnings(LottoContainer lottoContainer, List<Integer> winningNumbers, int bonusNumber) : 로또 결과 리턴
  - judgeWinnings(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) : 당첨 등수 리턴
  - countMatch(List<Integer> numbers, List<Integer> winningNumbers) : 당첨 번호와 로또 번호 매칭 결과 리턴