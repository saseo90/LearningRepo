package game.main;

import game.service.LeagueService;
import game.vo.GroupInfoListUtil;
import game.vo.TeamInfoListUtil;

/**
 * <pre>
 * 
 * Class Name : PlayRunnerMain
 * Info : 실행 클래스
 *  
 * 게임규칙 : 
 *  1.(팀정보)
 *    축구팀 16개가 참가한다. 
 *    축구팀의 정보는 팀고유번호와 소속국가이름 이다.
 *    팀고유번호는 랜덤함수로 무작위로 부여된다.
 *  2.(게임진행)
 *    4조로 리그전을 통해 각조에서 2개팀을 선발한다.
 *    8개의 팀이 토너먼트를 통해 4강에 진출하고, 4강에서 결승에 진출한다.
 *    결승에서 우승/준우승을 결정한다.
 *  3.(경기결과)
 *    경기는 랜덤함수를 사용해 점수가 높은 팀이 승리한다.
 *    
 *  
 * </pre>
 * @author LEE SEONG-HYUN
 *
 */
public class PlayRunnerMain {

    public static void main(String[] args) {
        TeamInfoListUtil teamInfoListUtil = new TeamInfoListUtil();//참가국 16개 팀 입력
//      System.out.println("팀구성 결과 \n"+teamInfoListUtil.getTeamIngoList());
        GroupInfoListUtil groupInfoListUtil = new GroupInfoListUtil();//리그 조편성 4개조 4개팀
//      System.out.println("조편성 결과 \n"+groupInfoListUtil.getGroupInfoList());
        LeagueService leagueUtil = new LeagueService();//리그 실행
        System.out.println("리그 경기 결과 \n"+groupInfoListUtil.getGroupInfoALL());
        System.out.println("리그 통과팀 정보 리스트 \n"+leagueUtil.getPassTeamInfoList());
        leagueUtil.getPassTeamInfoList();
    }
    
}
