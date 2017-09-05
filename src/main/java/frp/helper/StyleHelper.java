package frp.helper;

/**
 * @author ZhuHanxi
 * @Date 04/09/2017
 */
public class StyleHelper {

    public static String stampStyleByTypeAndAvailability(Integer type, Integer state) {
        if (state==0) {
            return "stamp-disabled";
        }
        switch (type) {
            case 1:
                return "stamp-orange";
            case 2:
                return "stamp-red";
            case 3:
                return "stamp-green";
            case 4:
                return "stamp-blue";
            default:
                return "stamp-disabled";
        }
    }

    public static String ownerNameById(Integer ownerId) {
        switch (ownerId) {
            default:
            case 1:
                return "大野猪";
            case 0:
                return "小猪";
        }
    }

}
