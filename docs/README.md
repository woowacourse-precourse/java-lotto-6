#기능 구현 목록

1. lottoPlayer

   1-1. generateLottos(int) : 정해진 개수만큼 로또를 생성한다

   1-2. removeLottos : 보유중인 로또 제거

   1-3. addMoney(int) : 당첨금 추가

   

2. lottoAdmin

   2-1. lottoAdmin : 당첨번호 및 보너스 번호 입력받아 저장(생성자)

   2-2. checkLottos(Player) : player가 보유한 로또 확인 후 등수 return (lottoRank) 

   2-3. payPrizeMoney(Player) : player에게 당첨금 지급

   

3. lottoRank(enum)

   3-1. 로또 등수 표기 및 당첨금 확인

   

4. lottoApp

   4-1. playGame : 전체 게임 진행
