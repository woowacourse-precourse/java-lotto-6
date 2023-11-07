### 기능 구현 리스트

* Lotto(Domain)
    1. 로또 유효성 검사 추가
    2. 당첨 번호 리스트와 보너스 번호로 로또 등수(LottoRank) 구하는 로직 작성

* LottoRank(Domain)
    1. Enum 타입으로 로또 등수 정의 (당첨 번호 일치 수, 보너스 번호 일치 수, 상금)
    2. 당첨 번호 일치 수와 보너스 번호 일치 수로 로또 등수를 구하는 로직 작성

* LottoResultCalculator(Domain)
    1. EnumMap을 가진 로또 결과를 출력한다.

* InputView
    * 돈, 당첨 번호, 보너스 번호를 입력받는다.

* OutputView
    * 여러 안내 문자를 출력한다.

* LottoController
    * 인풋에서 에러가 난 경우 다시 입력받음.