package game.main;

import game.service.TimesTableService;

/**
 * <pre>
 * 
 * Class Name : PlayRunnerMain
 * Info : 구구단 게임 실행 클래스
 *  
 * 게임규칙 : 
 *  1.(실행정보)
 *  - 구구단 실행정보 입력 :  
 *    단, 정보입력이 없는 경우 전체실행
 *  2.(게임진행)
 *  - 2단부터 9단까지 출력한다.
 *  - 2단부터 사용자가 입력한 특정한 단까지 출력한다.
 *  - 사용자가 입력한 특정단까지 출력한다. 
 *  3.(게임결과)
 *    콘솔에 출력한다.
 *  
 * </pre>
 * @author seo-HG
 *
 */
public class PlayRunnerMain {

    public static void main(String[] args) {
        TimesTableService tts = new TimesTableService();
        System.out.println("[2단부터 9단까지 계산]\n"+tts.runTimesTables());
        int n = 7;
        System.out.println("[2단부터 "+n+"단까지 계산]\n"+tts.runTimesTables(n));
        n = 11;
        System.out.println("["+n+"단을 계산]\n"+tts.runTimesTable(n));
    }
    
}
