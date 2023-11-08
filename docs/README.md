# 미션 - 로또

## 🚀 기능 프로세스
1. 구입 금액 입력
2. 발행한 로또 수량 및 번호 출력
3. 당첨 번호 입력
4. 보너스 번호 입력
5. 당첨 통계 출력

## 🚀 기능 목록
- 로또 정보 클래스 : Lotto.java
    - 우승 번호와 비교 후 등수 반환 메서드 : lottoResult(List<Integer winningNumbers, int bonusNumber)
    - 구입한 로또 번호 출력 : showNumbers();
- 로또 게임 진행 클래스 : LottoService.java
  - 결과 계산 
    - 로또 결과 계산 기능 : calLottoResult()
    - 수익률 계산 기능 : calProfitMargin()
    - 로또 결과 출력 : ResultView.printResult(int[] lottoResult, double profitMargin)
- 입력 : InputService.java
  - 구입 금액 입력 : InputService.createLottoTickets()
  - 게임 운영 정보 입력 : InputService.createGameInfo()
    - 당첨 번호 입력
    - 보너스 번호 입력
- 출력 : ResultView.java
  - 로또 결과 : printResult(int[] lottoResult, double profitMargin)
    - 당첨 수 출력
    - 수익률 출력
- 유효성 검증 : Validation.java
  - 빈값 확인 : emptyCheck(String value)
  - 글자 입력 확인 : numberCheck(String value), parseIntCheck(String value)
  - 입력 범위 확인 : rangeCheck(int value)
  - 입력 부족 확인 : lackInputCheck(List<Integer> numbers)
  - 중복 확인
    - duplicationCheck(int[] preprocessedNumbers) : 우승 번호 입력 시
    - duplicationCheck(List<Integer> winnerNumbers, int bonusNumber) : 보너스 번호 입력 시
  - 지폐 단위 확인 : banknoteCheck(int cost)
- 에러 관리 
  - ErrorCollection.java, ViewConstant.java
