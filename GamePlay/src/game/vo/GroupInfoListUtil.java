package game.vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <pre>
 * 
 * Class Name : GroupInfoListUtil
 * Info : 리그 조별 정보 리스트
 *  
 * </pre>
 * @author LEE SEONG-HYUN
 *
 */
public class GroupInfoListUtil {
    
    
    /** 
     * 리그 조편성 리스트
     */
    private static List<GroupInfo> groupInfoList=null;
    
    /** 그룹이름 및 그룹 개수(4개) */
    private static String[][] groupTable ={
    { "A조" }, 
    { "B조" }, 
    { "C조" }, 
    { "D조" }
    };

    public GroupInfoListUtil() {
        if(groupInfoList==null){
            madeGroup();
        }
    }
    /** 그룹정보 반환 : 전체 그룹 반환 */
    public String[][] getGroupTable() {
        return groupTable;
    }
    /** 그룹정보 반환 : 전체 그룹 반환 */
    public List<GroupInfo> getGroupInfoALL() {
        return groupInfoList;
    }
    
    /** 그룹정보 반환 : 특정 그룹 검색 반환 */
    public List<GroupInfo> getGroupInfo(String groupName) {
        List<GroupInfo> result = new ArrayList<GroupInfo>();
        for (GroupInfo groupInfo : groupInfoList) {
            if(groupInfo.getGroupName().equals(groupName)){
                result.add(groupInfo);
            }
        }
        return result;
    }
    /** 그룹정보 반환 : 특정 그룹 검색 소속팀 반환 */
    public List<TeamInfo> getGroupTeamInfo(String groupName) {
        List<TeamInfo> result = new ArrayList<TeamInfo>();
        TeamInfoListUtil tilu = new TeamInfoListUtil();
        for (GroupInfo groupInfo : groupInfoList) {
            if(groupInfo.getGroupName().equals(groupName)){
                result.add(tilu.getSearchTeanInfo(groupInfo.getTeamNo()));
            }
        }
        return result;
    }
    /** 그룹정보 반환 : 토너먼트 진출가능 소속팀 검색 반환 */
    public List<TeamInfo> getPassTeamInfoList() {
        List<TeamInfo> result = new ArrayList<TeamInfo>();
        TeamInfoListUtil tilu = new TeamInfoListUtil();
        for (GroupInfo groupInfo : groupInfoList) {
            if(groupInfo.getflag()){
                result.add(tilu.getSearchTeanInfo(groupInfo.getTeamNo()));
            }
        }
        return result;
    }

    /** 그룹생성 : 조편성 */
    private void madeGroup() {

        groupInfoList= new ArrayList<GroupInfo>();
        TeamInfoListUtil tilUtil = new TeamInfoListUtil();
        HashSet<Integer> teamNoTemp = new HashSet<Integer>();//중복확인 위한 임시개체 : 이미 편성된 팀번호
        for (String[] groupName : groupTable) {//4개 조 편성
            for (int i = 0; i < 4; i++) {//4개 팀 배정
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
                tilUtil.updateGroupName(number, groupName[0]);//팀정보 유틸에 조편성 정보 업데이트
                GroupInfo gi = new GroupInfo(groupName[0], number);
                groupInfoList.add(gi);//GroupInfoListUtil 의 리그 조편성 리스트
            }
        }//for

    }
}
