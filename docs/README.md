# 기능 목록
- [x] 로또를 발행한다. - LottoMachine#generate
  - [x] 구입금액을 입력받는다. (구입 금액에 따라, 1장당 1000원) - LottoMachine#readAmount
    - [x] 발행된 복권 리스트 보여주기(오름차순으로 정렬) - Display#Lottos
  - [ ] 당첨번호+보너스번호 입력받기 - LottoMachine#readWinningNumber, LottoMachine#readBonusNumber

- [ ] 로또 번호와 당첨 번호를 비교한다. - Operator#matchNumbers
- [ ] 당첨내역 및 수익률을 출력한다. - Display#WinningRecords, Display#ProfitRate
  - [ ] 수익률은 소수점 둘째 자리에서 반올림한다.

- [ ] 예외 상황(잘못된 값 입력)시 에러문구를 출력한다. - Lotto#validate

-----

# 기능 요구 사항
- [ ] 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- [ ] 로또 1장의 가격은 1,000원이다.
- [ ] 당첨 번호와 보너스 번호를 입력받는다.
- [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고,
"[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

# 유의사항

### 기존 유의사항
- [ ] indent depth 가 3이 넘지않도록 한다 (2까지만)
- [ ] 3항연산자 금지
- [ ] 메서드가 한 가지 일만 하도록 작게 만들기
- [ ] JUnit 5와 AssertJ를 이용하여 기능목록을 구현한 코드의 테스트 코드 작성 후 확인
### 1 주차 미션 공통 피드백 중
- [ ] 이름을 통해 의도 드러내기
- [ ] 축약하지 않기(하지만 두 단어로 유지하기 위해 노력)
- [ ] 의미 있는 공백라인
- [ ] Java API, Collection 활용
### 추가된 프로그래밍 요구사항
- [ ] 메서드의 길이 < 15라인 -> 한가지 일만 잘 하도록 구현
- [ ] else 예약어를 쓰지 않는다.
- [ ] Java Enum 적용하기
- [ ] 도메인 로직에 단위 테스트를 구현한다. -> UI 로직 분리(제외)
