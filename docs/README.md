# 기능 목록

## Controller
- [x] LottoController : 어플리케이션의 시작점
  - lottoInputView : 사용자에게 보여지는 부분
  - lottoMakingService : 사용자가 입력한 금액에 따라 로또 만들기
  - lottoContainer : 사용자가 가진 로또 묶음
  - winningNumbers : 당첨 번호
  - bonusNumber : 보너스 번호
  - LottoController(LottoView lottoInputView, LottoMaker lottoMakingService) : 의존성 주입
  - run() : 프로그램 진행 흐름 관리
  - result() : 결과 계산
  - countMatch(List<Integer> numbers, List<Integer> winningNumbers) : 당첨 숫자 개수 카운트
  - 생각해볼 문제 :
    - 계산은 Calculator 클래스를 만들어서 관리하는 게 나을까?
    - 너무 복잡하다
    - 결과 산출하는 부분 하드코딩이 아니라 다른 스타일로 바꾸자. enum?

## Model
- [x] Lotto : 6개의 숫자를 받아 Lotto로 관리하는 모델
  - numbers : 6개의 숫자
  - Lotto(List<Integer> numbers) : 숫자 유효성 검증한 뒤 숫자 주입
  - validate(List<Integer> numbers) : 숫자 유효성 검증 메서드
  - getNumbers() : 숫자 getter 메서드
  - 생각해볼 문제 : 
    - validate에 다른 예외 상황이 있을 것 같다. 로또 번호 범위라던지..


- [x] LottoContainer : 사용자가 가진 로또들을 하나로 관리하는 컨테이너
  - lottos : 로또 리스트
  - add(Lotto lotto) : 로또 리스트에 로또를 담는 메서드
  - getLottos() : 로또 getter 메서드
  - 생각해볼 문제 :
    - Container가 굳이 필요한가? Controller에서 List로 관리하면 안되나?
    

- [x] LottoMaker : 로또를 생성하는 클래스
  - START_NUMBER = 1;
  - END_NUMBER = 45;
  - PICK_NUMBER = 6;
  - issue(int cash) : 사용자가 입력한 금액만큼의 로또를 생성해 lottoContainer로 리턴
  - issueLottoPaper() : 랜덤으로 숫자를 골라 로또로 만들어주는 메서드
  - 생각해볼 문제 : 
    - LottoMaker는 Controller에 가야하지 않나
    - NUMBER 상수들을 전역적으로 쓰고 싶다

- [x] Prize : 상금 정보를 기록하는 enum 클래스
  - 맞춘 수에 따라 Enum상수를 추가
  - THREE, FOUR, FIVE, FIVE_PLUS, SIX
  - prize : 상금
  - rank : 몇 개 일치하는지 String
  - prizeCount(int matchCount, boolean matchBonus) : 맞춘 수에 따라 해당 Enum상수 리턴
  - 생각해볼 문제 :
    - 아직 뭔가 더러운 느낌. 중복되는 rank 문자열을 리턴하는 게 마음에 안 듦

## View
- [x] LottoView : 사용자에게 보여지는 부분
  - inputCash() : 구입 금액 입력
  - validateInputCash(int cash) : 구입 금액 검증
  - printPickedLotto(LottoContainer lottoContainer) : 구입 결과 출력
  - inputWinningNumbers() : 당첨 번호 입력
  - validateWinningNumbers(List<Integer> winningNumbers) : 당첨 번호 검증
  - inputBonusNumber() : 보너스 번호 입력
  - validateBonusNumber(int bonusNumber) : 보너스 번호 검증
  - printWinnings(Map<String, Integer> winnings, int cash) : 당첨 결과 출력
  - 생각해볼 문제 :
    - 코드가 너무 길다.
    - View를 입력, 검증, 출력 세 개로 나눌 수 있지 않을까
    - 예외처리가 겹치는 게 많다. 메서드로 만들어서 필요에 따라 추가할 수 있지 않을까
    - inputBonusNumber에서 winningNumbers를 계속 넣어주는 것보다 편한 방법이 있지 않을까?
  
## Utility
- [x] Constant : 모든 클래스에 공통적으로 사용되는 상수 정의
  - LOTTO_START_NUMBER : 시작 숫자 (1)
  - LOTTO_END_NUMBER : 마지막 숫자 (45)
  - LOTTO_PICK_NUMBER : 선택 숫자 (6)