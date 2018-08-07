package game.vo;
/**
 * <pre>
 * 
 * Class Name : TournamentInfo
 * Info : 토너먼트 정보 객체 클래스
 *  
 * </pre>
 * @author LEE SEONG-HYUN
 */
public class TournamentInfo {
    
    /** 팀 고유번호 */
    private int teamNo;
    /** 소속 국가 이름 */
    private String countryName;
    /** 전적정보 : 토너먼트 대전구분(--강전) */
    private String round="";
    /** 전적정보 : 승리 횟수*/
    private int winNo=0;
    /** 전적정보 : 패배 횟수 */
    private int loseNo=0;
}
