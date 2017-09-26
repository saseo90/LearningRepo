package game.vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <pre>
 * 
 * Class Name : TeamInfoListUtil
 * Info : 참가국 리스트 객체 를 static 하게 생성.
 *  
 * </pre>
 * @author seo-HG
 *
 */
public class TeamInfoListUtil {
    
    /** 
     * 참가팀정보 리스트
     */
    private static List<TeamInfo> teamInfoList=null;
    
    public TeamInfoListUtil() {
        if(teamInfoList==null){
            teamInfoList();
        }
    }
    
    /** 
     * 팀 정보 반환 : 참가팀정보 리스트
     * @return teamInfoList 참가팀정보 리스트
     */
    public List<TeamInfo>  getTeamIngoList() {
        return teamInfoList;      
    }
    /** 
     * 팀 정보 검색
     * @param TeamNo 팀 고유번호 
     * @return teamInfo 팀정보 객체
     */
    public TeamInfo getSearchTeanInfo(int TeamNo){
        TeamInfo teamInfo= null;
        for (TeamInfo teamInfoTemp : teamInfoList) {
            if(teamInfoTemp.getTeamNo()==TeamNo){
                teamInfo=teamInfoTemp;
                break;
            }
        }
        return teamInfo;
    }
    /** 
     * 조편성 정보 입력
     * @param TeamNo 팀 고유번호 
     * @return teamInfo 팀정보 객체
     */
    public boolean updateGroupName(int TeamNo,String GroupName){
        boolean result= false;
        for (TeamInfo teamInfoTemp : teamInfoList) {
            if(teamInfoTemp.getTeamNo()==TeamNo){
                teamInfoTemp.setGroupName(GroupName);
                result=true;
                break;
            }
        }
        return result;
    }
    
    /** 
     * 참가팀 정보 리셋 후 static 하게 데이터 입력
     */
    private void teamInfoList() {
        
        /** 참가팀 정보 테이블 : 2002년 월드컵 순위 1~16 국가 */
        String[][] teamInfoTable ={
        { "01" , "브라질" }, 
        { "02" , "독일" }, 
        { "03" , "터키" }, 
        { "04" , "대한민국" }, 
        { "05" , "스페인" }, 
        { "06" , "잉글랜드" }, 
        { "07" , "세네갈" },
        { "08" , "미국" }, 
        { "09" , "일본" }, 
        { "10" , "덴마크" }, 
        { "11" , "멕시코" }, 
        { "12" , "아일랜드" },
        { "13" , "스웨덴" },
        { "14" , "벨기에" },
        { "15" , "이탈리아" },
        { "16" , "파라과이" }
        };
        
        List<TeamInfo> teamInfoListTemp = new ArrayList<TeamInfo>();
        TeamInfo teamInfoTemp = null;
        
        HashSet<Integer> teamNoTemp = new HashSet<Integer>();//중복확인 위한 임시개체
        for (String[] strings : teamInfoTable) 
        {
            int number;//팀고유번호
            while (true)//무작위 팀고유번호 생성
            {
                double randTemp= Math.random();
                number = (int)((randTemp *16))+1;
                if(!teamNoTemp.contains(number))//중복검사 : value 가 false 일떼, 중복되지 않을 때 진행
                {
                    teamNoTemp.add(number);
                    break;
                };
            }
            teamInfoTemp = new TeamInfo(number,strings[1]);
            teamInfoListTemp.add(teamInfoTemp);
        }
        teamInfoList = teamInfoListTemp;
    }

}
