# 기능 구현 목록

## domain
- generator
  - `LottoNumbersGenerator` : interface
  - `LottoRandomNumbersGenerator` : 랜덤한 로또 번호들을 생성하는 기능
- Lotto
  - 중복 예외 처리
  - 범위 예외 처리
  - 개수 예외 처리
- LottoRank
  - Enum으로 구현
  - 맞춘 개수, 보너스 유무, 상금으로 구성
- LottoStore
  - Lotto를 구매하는 기능
  - 구매 금액 예외 처
- WinningLotto
  - 당첨 번호를 의미하며 Lotto와 BonusNumber로 구성
  - bonusNumber 중복, 범위 예외 처리
  - lotto와 맞춰보며 LottoRank를 반환하는 기능
- WinningResult
  - LottoRank별 당첨 횟수를 저장하는 기능
  - Map<LottoRank, Inter> 로 구성
- WinningStatistics
  - WinningResult를 통해 당첨 통계를 저장하는 기능
  - 총 수익률을 계산하는 기능

## view
- InputView
- OutputView
- InputUtil
  - 다양한 입력 예외 처리
  - 입력 받은 문자열을 정수 리스트로 변환하는 기능
  - 자연수로 변환하는 기능
  - 예외가 발생 시 다시 입력 받는 기능

## exception
- AppException
  - 애플리케이션 예외 처리
  - [ERROR] prefix를 붙임
- ErrorMessage
  - 예외 메시지를 저장하는 Enum
  - 예외 메시지를 반환하는 기능

## controller
- LottoController
  - 로또 구매
  - 구매한 로또 출력
  - 당첨 번호 입력
    - 당첨 번호와 보너스 번호를 입력 받음 
  - 당첨 통계를 계산
  - 당첨 통계 출력 기능
