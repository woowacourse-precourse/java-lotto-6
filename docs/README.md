# 로또 게임 📟

## 📌 기능 설계
1. 상수들을 저장할 enum class
   - 로또의 가격 정보
   - 로또 당첨 숫자의 범위
   - 로또의 자릿수
   
2. 출력할 메세지들을 담을 enum class 
3. 로또 정보를 담고있을 Lotto class
   - 이는 6개의 로또번호 attribute 와 보너스 attribute 를 가진다.
   - 로또 번호들을 특정 형식에 맞게 반환해주는 getLottoInfo method
4. 당첨 로또를 담고있는 WinnerLotto class
   - Lotto 타입의 lotto attribute
   - int 타입의 bonusNum attribute
5. Lotto판매점의 역할을 해줄 LottoShop
   - Random한 숫자의 Lotto를 발행해주는 메소드
   - 구매할 금액을 입력하고 갯수에 맞춰 구매하는 메소드
   - 우승 로또의 번호를 입력하는 메소드
   - 보너스 번호를 입력하는 메소드
   - 위 두 메소드를 이용하여 우승 로또를 선정해줄 메소드
6. 상금에 대한 PRIZE Class
   - 1등~5등에 당첨된 갯수를 각각 담고잇을 attributes
   - lotto와 우승 로또를 입력받아 당첨 등수를 계산해줄 메소드
   - 당첨 통계를 출력해줄 메소드
   - 총 수익률을 출력할 메소드
7. 게임 참가자가 구매한 로또들을 저장할 Wallet Class
   - 구매한 로또들을 담을 attribute, 구매할 금액을 담은 attribute를 가짐
   - 내가 구매한 로또들을 출력하는 메소드
   - 구매금액을 입력받는 메소드
   - 구매금액을 검증하는 메소드들
