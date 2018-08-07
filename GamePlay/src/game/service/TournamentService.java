package game.service;

import java.util.ArrayList;
import java.util.List;

import game.vo.TeamInfo;

/**
 * <pre>
 * 
 * Class Name : TournamentService
 * Info : 토너먼트 리그 대진표 정보 및 토너먼트 경기실행
 * 
 * </pre>
 * @author LEE SEONG-HYUN
 */
public class TournamentService {

    /** 
     * 참가팀정보 리스트
     */
    private static List<TeamInfo> teamInfoList = null;

    /**
     * 토너먼트 경기이력
     */
    private static ArrayList<String> tournamentLog = new ArrayList<String>();

    public TournamentService() {
        if(teamInfoList==null){
            runTournament();
            System.out.println(tournamentLog);
        }
    }
    /**
     * 토너먼트 실행
     * 
     * 1. 토너먼트 진출팀 정보받기
     * 2. 대진표 작성
     * 
     * 
     */
    private void runTournament(){
//        토너먼트 진출팀 정보받기
//        GroupInfoListUtil groupInfoListUtil = new GroupInfoListUtil();
//        List<TeamInfo> beforeTeam = groupInfoListUtil.getPassTeamInfoList();
        addLog("토너먼트 시작");
        LeagueService leagueService = new LeagueService();
        List<TeamInfo> beforeTeam = leagueService.getPassTeamInfoList();
        int teamSize = beforeTeam.size();//토너먼트 대상 팀 개수 
//        System.out.println("teamSize::"+teamSize);

//      팀정보 순서 섞기
        for (int i = 0; i < teamSize; i++) {
            double randTemp = Math.random();
            int number = (int)((randTemp * teamSize));
            randTemp = Math.random();
            int number2 = (int)((randTemp * teamSize));
//            System.out.println("number::"+number+",number2::"+number2);
            TeamInfo teamInfo = beforeTeam.get(number);
            beforeTeam.remove(number);
            beforeTeam.add(number2, teamInfo);
        }
//      토너먼트 1차 대진표 게임진행
        teamSize = teamSize/2;//토너먼트 1차 게임 횟수 
        for (int i = 0; i < teamSize; i++) {
            int indexA = i*2; 
            int indexB = indexA+1;
            int scoreA;//A팀 점수
            int scoreB;//B팀 점수
            //무작위 점수 생성 : A팀
            double scorTemp= Math.random();
            scoreA = (int)((scorTemp *10))+1;
            do{//무작위 점수 생성 : B팀
                scorTemp= Math.random();
                scoreB = (int)((scorTemp *10))+1;
            }
            while (scoreA==scoreB);//중복검사 : scoreA 와 scoreB 같지 않도록 함.
//          토너먼트 대전 결과 저장 : "--강전", 대전이름(A팀 vs B팀), 승리팀 이름, 승리팀 고유번호, 패배팀 이름, 패배팀 고유번호, 결과(10:2), 메서드 호출

            TeamInfo teamInfoA = beforeTeam.get(indexA);
            TeamInfo teamInfoB = beforeTeam.get(indexB);
//            if(scoreA>scoreB){//B팀 승리, A팀 패배
//                teamInfoA = beforeTeam.get(indexB);
//                teamInfoB = beforeTeam.get(indexA);  
//            }
            String round = "";
            if(2<teamSize){
                round = teamSize*2+"강전";
            }else if(2==teamSize){
                round = "준결승전";
            }else if(1==teamSize){
                round = "결승전";
            }
            addResultRecord(round,teamInfoA.getCountryName(), teamInfoA.getTeamNo(),teamInfoB.getCountryName(), teamInfoB.getTeamNo(),scoreA,scoreB);
        }
        
        addLog("토너먼트 종료");
    }
    /**
     * 토너먼트 경기결과 기록저장
     * @param round 대전구분(--강전)
     * @param nameA 승리팀이름
     * @param noA  승리팀번호 
     * @param nameB 패배팀이름
     * @param noB 패배팀번호
     * @param scoreA 승리팀점수
     * @param scoreB 패배팀점수
     */
    private void addResultRecord(String round, String nameA, int noA, String nameB, int noB, int scoreA, int scoreB) {
        String cont = round;
        cont += ", "+nameA+"("+noA+")"+" vs "+nameB+"("+noB+")";
        cont += ", "+scoreA;
        if(scoreA>scoreB){cont += "(승)";} 
        cont += " : "+scoreB;
        if(scoreA<scoreB){cont += "(승)";}
        addLog(cont);
    }

    private void addLog(String cont){
        tournamentLog.add(cont);
    }

}
