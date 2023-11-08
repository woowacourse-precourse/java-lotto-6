## 우아한 테크코스 프리코스 로또 구현

### 진행방식
- 1000원 단위의 로또 구매 금액을 입력
    - 해당 금액만큼의 랜덤 로또를 생성
    - 생성된 로또 번호들을 출력
- 당첨 번호 6자리 입력
- 당첨 보너스 번호 1자리 입력
    - 해당 번호들을 통해 당첨 로또를 생성
- 구매한 로또 번호와 당첨 로또 번호를 비교하여 당첨된 로또 상금을 순위별로 저장
    - 당첨된 순위 통계를 출력
- 당첨된 순위 통계와 구매 금액을 통해 수익률 계산
    - 수익률 출력

### 예외 처리
- Enum 으로 메시지를 관리하였고 사용하는 모든 에러 메시지에 "[ERROR]" 문자열을 추가해주기 위해 예외 메시지를 가져올 때 해당 Enum 변수를 추가
- 지정해둔 Exception 발생시 Exception Enum 변수를 가져오는 것이 아니라 해당 메시지를 가져오도록 IllegalArgumentException를 상속받고 파라미터는 Enum 상수, 반환 값은
  Enum String message를 반환하여 처리
- 예외가 발생하면 이번에는 던지는 것이 아니라 예외 문자열을 반환하고 다시 입력하도록 진행
- 진행한 예외처리는 다음과 같음
    - 구매 입력, 당첨 로또 번호, 보너스 번호를 입력하지 않았을 때
    - 구매 입력이 1000원 단위로 입력되지 않았을 때
    - 로또 번호가 중복되었을 때
    - 로또 번호가 6개가 아닐 때
    - 로또 번호가 1~45의 숫자가 아닐 때
    - 당첨 로또 번호가 중복되었을 때
    - 당첨 로또 번호가 6개가 아닐 때
    - 당첨 로또 번호가 1~45의 숫자가 아닐 때
    - 보너스 번호가 1~45의 숫자가 아닐 때
    - 보너스 번호가 당첨 로또 번호와 중복될 때
    - String 에서 Integer 변환이 되지 못할 때
    - 당첨된 로또를 확인할 경우 최대인 6개가 넘게 당첨될 때
        - 해당 예외는 메서드 로직에서는 터질 수 없는 문제로 판단하여 예외처리는 진행하지 않았음

### 로또 프로젝트 클래스 구조
- LottoView : 화면 입력과 출력을 담당하는 뷰
    - ViewMessage : 뷰에서 출력하기 위한 문자열을 보관한 Enum Class
- PlayLotto : 뷰와 서비스 연결하고 로또 동작이 돌아가도록 요청
- LottoService : 로또 진행 중 객체 생성이나 로또 비즈니스 로직을 진행하는 서비스
- TextProcessor : 뷰로 출력하기 위해 문자열을 조작하여 반환하기 위한 서비스
- LottoTickets : 요청된 횟수만큼 랜덤된 Lotto를 생성하여 보관하는 객체
- Lotto : 생성된 랜덤 로또 객체
- WinningLotto : 입력된 값으로 생성한 당첨 로또 객체
    - ValidateLottoNumbers : Lotto 클래스와 WinningLotto 클래스의 중복 로직을 없애기 위한 추상 클래스. Lotto와 WinningLotto는 해당 클래스를 상속받음
    - LottoWinningRank : 맞춘 로또 번호의 개수와 당첨 상금으로 로또 등수를 보관한 Enum Class
    - LottoTotalPrize : 구매한 로또에 대해 당첨된 내역을 저장하기 위한 객체로 LottoWinningRank 값을 통해 변경
- CustomIllegalArgumentException : 지정된 Enum 예외 메시지를 통해 값를 담아 부모인 IllegalArgumentException 생성 (해당 프로젝트는
  IllegalArgumentException 만 생성)
    - ExceptionMessage : 예외 발생 메시지를 보관한 Enum Class
- 테스트 : 클래스별 메소드 단위 테스트 진행

### 이번에 프로젝트를 진행하면서 고민한 요소
- 뷰에서 출력하기 위한 문자열 변환 방법
    - ViewMessage에 Enum으로 문자열을 관리하고 특정 타입의 값이 필요할 경우 메서드 오버로딩을 통해 같은 메서드명으로 문자열 반환
- 예외 처리하여 뷰에 출력하기 위한 방법
    - trt-catch 문을 통해 지정한 예외가 발생하면 해당 예외 메시지를 출력하고 진행했던 메서드 재귀를 통해 재입력
- 예외 메시지 enum 값을 바로 출력하기 위한 방법
    - 기존 throw new IllegalArgumentException(ErrorMessage.EMPTY_PURCHASE_AMOUNT.getMessage()); -> throw new
      CustomIllegalArgumentException(ErrorMessage.EMPTY_PURCHASE_AMOUNT)) 으로 변경
- Lotto와 WinningLotto의 중복로직을 제거하되 다른 예외를 반환하기위한 방법
    - ValidateLottoNumbers 추상 클래스를 통해 상속받아 비슷한 로직을 메서드로 분리하여 사용
- 상수 관리를 Enum과 필드 정적 변수 사용에 대한 고민
    - 전 계층에 대해 관리하는 것데 대해 고민하여 각각 사용
- 로또 당첨 내역을 확인하고 저장하는 방법
    - 생성한 로또 객체들의 당첨 개수를 확인하여 당첨 등수를 나타내는 LottoWinningRank Enum 값인 matchingNumbers를 비교
        - 해당 방법은 기존 if문 범벅으로 맞춘 개수를 확인했으나 Stream을 통해 LottoWinningRank Enum의 matchingNumbers를 순회하며 조회하는 것으로 변경
- 로또 당첨 내역을 저장하는 방법
    - 당첨 객체를 생성하고 당첨시 당첨 객체의 Map을 통해 LottoWinningRank Key의 value를 받아와 기존 value + 1 값으로 변경

### 3주차 과제 정리
- [프리코스 3주차 진행](https://github.com/InJun2/TIL/blob/main/Event/woowacourse-precourse/Week3.md)