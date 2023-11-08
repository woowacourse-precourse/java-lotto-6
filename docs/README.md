## 객체간 메시지 다이어그램
"객체지향의 사실과 오해"를 읽으며 배운 지식을 최대한 적용해보려 노력하였습니다.    
그중 하나가 다음과 같은 객체간의 메시지 다이어그램 입니다. 자소서에 작성했든 **지식3:실습7**의 비율을 항상 유지하려 노력합니다.    
이번 프리코스 과정 동안 계속 증명해나갈 예정입니다!    
<img width="755" alt="로또" src="https://github.com/zbqmgldjfh/ServletEx/assets/60593969/8b2a87d2-5952-41ee-a34b-8e4542774b63">

## 구현 기능 목록
- [x] Input
    - [x] 로또 구입 금액을 입력받는다. 1,000원 단위로 입력받으며 1,000원으로 나누어 떨어지지 않는 경우 IllegalArgumentException을 던진다
    - [x] 당첨 번호와 보너스 번호를 입력받는다.
      - [x] 1부터 45사이의 숫자가 아닌 경우, IllegalArgumentException을 던진다
      - [x] 중복된 숫자를 입력한 경우, IllegalArgumentException을 던진다
      - [x] 당첨번호는 6자리를 입력 받는다, 아닐시 IllegalArgumentException을 던진다
      - [x] 보너스번호는 1자리를 입력 받는다, 아닐시 IllegalArgumentException을 던진다
    - [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
      - [x] Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
- [x] Core
    - [x] 진행 조건
      - [x] 입력받은 로또 번호들을 Value Object로 만든다
      - [x] Lotto를 LottoNumber를 포한하는 일급 컬랙션으로 만든다
      - [x] 구입 금액만큼의 로또 번호를 생성한다
      - [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 계산한다
    - [x] 종료 조건
      - [x] 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다
- [x] Output
    - [x] 구입 금액 문구 출력
    - [x] 구매한 로또의 수 출력
    - [x] 당첨번호 입력 문구 출력
    - [x] 보너스번호 입력 문구 출력
    - [x] 당첨 통계 출력
    - [x] 총 수익률 출력
- [x] 추가사항
    - [x] 테스트 코드를 작성한다
    - [x] Value Object 를 활용한다.
    - [x] 1급 컬렉션 활용
    - [x] 제공된 Lotto 클래스를 활용해 구현해야 한다.
    - [x] 객체간의 메시지 다이어그램을 그려본다 (중요)
    - [x] 3항 연산자를 쓰지 않는다.
    - [x] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
      - [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라
    - [x] else 예약어를 쓰지 않는다.
    - [x] Java Enum을 적용한다.
    - [x] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
      - [x] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - [x] Random 값 추출은 pickUniqueNumbersInRange()를 활용한다.
    - [x] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
        

