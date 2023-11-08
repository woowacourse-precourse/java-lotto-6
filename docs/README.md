# 로또 

## 기능 목록
- [ O ] 숫자 범위가 1~45까지인 로또 번호를 생성한다. - Lotto#createLottoRandomNumber()
- [ O ] 총 지불 금액을 1,000원으로 나눈 몫을 구한다. - LottoSalesman#lottoCount
  - [ O ] 1,000원으로 나누어 떨어지지 않는 경우 예외처리 한다. - LottoSalesman#getMoneyException()
- [ O ] 1개의 로또를 발행한다. - LottoSalesman#oneLottoCreate()
  - [ O ] 1개의 로또는 천원이다.
  - [ O ] 1개의 로또에는 6개의 로또 번호가 들어간다. Lotto#validate
    - [ O ] 보너스 번호 1개를 생성한다. LottoSalesman#bonusNumberGenerator
    - [ O ] 모든 번호는 중복되지 않아야한다. - Lotto#dupulicationCheck()
- 사용자 로또 번호와 당첨 번호를 비교한다. - Referee#compare()
  - [ O ] 발행한 로또 수량 및 번호를 출력한다. - ResultLotto#
    - [ O ] 로또 번호는 오름차순으로 정렬하여 보여준다. -> 처음 로또에 로또 번호를 넣을 때 정렬하면 좋을 것 같다.
  - 당첨 내역
    - [ O ] 6개 번호가 일치하면 1등, 2,000,000,000원 
    - [ O ] 5개 번호와 보너스 번호가 일치하면 2등, 30,000,000원
    - [ O ] 5개 번호가 일치하면 3등, 1,500,000원
    - [ O ] 4개 번호가 일치하면 4등, 50,000원
    - [ O ] 3개 번호가 일치하면 5등, 5,000원
  - 당첨
    - [ O ] 당첨내역 및 수익률을 출력한다. (수익률은 소수점 둘째 자리 반올림) - ResultLotto
    - [ ] 로또 게임을 종료시킨다. - Application#LottoEnd
  - [ ] 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨다.
    - [ ] [ERROR]로 시작하는 에러 메시지 출력 후
    - [ ] 입력을 다시 받는다.

사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.


## 요구사항

- else 예약어를 쓰지 않는다. switch/case도 허용하지 않는다.
- Java Enum을 적용한다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI 로직은 제외한다.
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
- 랜덤 값 추출은 List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);을 사용한다.
- 제공된 Lotto 클래스를 활용해 구현한다.
  - numbers의 접근 제어자인 private을 변경할 수 없다.
  - Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
  - Lotto의 패키지 변경은 가능하다.