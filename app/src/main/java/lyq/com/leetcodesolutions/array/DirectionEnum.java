package lyq.com.leetcodesolutions.array;

import android.util.Log;

import javax.xml.transform.Source;

/**
 * @author sunshiny
 * @date 2020-05-16.
 * @desc
 */
public enum  DirectionEnum{
    RIGHT(1,"right"),
    DOWN(2,"down"),
    LEFT(3,"left"),
    UP(0, "up");

    private int code;
    private String des;

    DirectionEnum(int code,String des) {
       this.code = code;
       this.des = des;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public static DirectionEnum getDirctionByCode(int code) {
        for (DirectionEnum value : DirectionEnum.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }

}
