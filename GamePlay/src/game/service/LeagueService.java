package game.service;

import java.util.List;

import game.vo.GroupInfo;
import game.vo.GroupInfoListUtil;
import game.vo.TeamInfo;

/**
 * <pre>
 * 
 * Class Name : LeagueService
 * Info : 리그 대진표 정보 및 리그 경기실행
 *  
 * </pre>
 * @author LEE SEONG-HYUN
 *
 */
public class LeagueService {
    
    /** 리그 통과팀 정보 리스트 */
    private static List<TeamInfo> passTeamInfoList=null;
    
    public LeagueService() {
        if(passTeamInfoList==null){
            runLeague();
        }
    }
    /**
     * 리그 통과팀 정보 리스트
     * @return List<TeamInfo> passTeamInfoList
     */
    public List<TeamInfo> getPassTeamInfoList() {
        return passTeamInfoList;        
    }
    
    /** 리그 전체 실행 */
    private void runLeague() {
        GroupInfoListUtil gilu = new GroupInfoListUtil();
        String[][] groupNames = gilu.getGroupTable();
        for (String[] strings : groupNames) {//조 갯수 만큼 반복
            String groupName = strings[0];
            List<TeamInfo> groupInfoList = gilu.getGroupTeamInfo(groupName);
            for (int i = 0; i < groupInfoList.size()-1; i++) {
                TeamInfo teamNoA = groupInfoList.get(i);//팀 A
                for (int j = i+1; j < groupInfoList.size(); j++) {
                    TeamInfo teamNoB = groupInfoList.get(j);//팀 B
                    
                    int scoreA;//A팀 점수
                    int scoreB;//B팀 점수
                    //무작위 점수 생성 : A팀
                    double scorTemp= Math.random();
                    scoreA = (int)((scorTemp *100))+1;
                    do{//무작위 점수 생성 : B팀
                        scorTemp= Math.random();
                        scoreB = (int)((scorTemp *100))+1;
                    }
                    while (scoreA==scoreB);//중복검사 : scoreA 와 scoreB 같지 않도록 함.
                    //리그 대전 결과 저장 : 조이름, 팀고유번호, 승리 or 패배 메서드 호출
                    if(scoreA>scoreB){//A 승리, B팀 패배
                        extantTest(groupName, teamNoA, teamNoB);
                    }else{//B팀 승리, A팀 패배
                        extantTest(groupName, teamNoB, teamNoA);
                    }
                }
            }
            resultMatche(groupName);
        }
        resultPassTeamInfoList();
    }
    /**
     * 승점 정보 업데이트
     * 기존에 객체가 존재하면 true
     * 존재하지 않으면 false
     * @param groupName 조 이름
     * @param teamNoWin 승리한 팀번호
     * @param teamNoLose 패배한 팀번호
     * @return boolean 
     */
    private boolean extantTest(String groupName, TeamInfo teamNoWin, TeamInfo teamNoLose ) {
        boolean result = false;
        GroupInfoListUtil gilUtil = new GroupInfoListUtil();
        List<GroupInfo> teamInfoList  = gilUtil.getGroupInfo(groupName);
        for (GroupInfo teamInfo : teamInfoList) {
            if(teamInfo.getTeamNo()==teamNoWin.getTeamNo()){
                teamInfo.updateWin();
            }else if(teamInfo.getTeamNo()==teamNoLose.getTeamNo()){
                teamInfo.updateLose();
            }
        }
        return result;
    }
    /**
     * 특정 조(그룹)내의  순위 및 진출 업데이트
     * @param groupName 조 이름
     */
    private void resultMatche(String groupName) {
        GroupInfoListUtil gilUtil = new GroupInfoListUtil();
        List<GroupInfo> teamInfoList  = gilUtil.getGroupInfo(groupName);
        
        int firstTeamNo=-1;//1등 팀고유번호
        int firstWinNo=-1;//1등 승리수
        int secondTeamNo=-1;//2등 
        int secondWinNo=-1;//2등 승리수
        //System.out.println("사이즈 "+teamInfoList.size());
        for (GroupInfo teamA : teamInfoList) {//순위 계산
            int tempTeamNo= teamA.getTeamNo();
            int tempWinNo= teamA.getWinNo();
            if(tempWinNo>firstWinNo){//1등 갱신
                if(firstWinNo>=secondWinNo){//2등 갱신
                    secondTeamNo= firstTeamNo;
                    secondWinNo= firstWinNo;
                }
                firstTeamNo= tempTeamNo;
                firstWinNo= tempWinNo;
            }else if(tempWinNo==firstWinNo||tempWinNo>secondWinNo){//2등 갱신
                secondTeamNo= tempTeamNo;
                secondWinNo= tempWinNo;
            }
        }
        for (GroupInfo groupInfo : teamInfoList) {
            if(groupInfo.getTeamNo()==firstTeamNo){
                groupInfo.updateRank(1);
                groupInfo.updateFlag();
            }else if(groupInfo.getTeamNo()==secondTeamNo){
                groupInfo.updateRank(2);
                groupInfo.updateFlag();
            }
        }
    }
    /**
     * 토너먼트 진출팀 리스트
     * @param groupName 조 이름
     */
    private void resultPassTeamInfoList() {
        GroupInfoListUtil gilUtil = new GroupInfoListUtil();
        List<TeamInfo> temp = gilUtil.getPassTeamInfoList();
        passTeamInfoList = temp;
    }
}
