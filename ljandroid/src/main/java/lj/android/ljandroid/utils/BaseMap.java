package lj.android.ljandroid.utils;

import java.util.HashMap;

/**
 * 作者：刘杰（QQ:770161055,WeChat:yjso0826）
 * 时间： 2017/2/20
 */

public class BaseMap extends HashMap {
    @Override
    public Object put(Object key, Object value) {
        if (StringTools.isStringNull(value)||StringTools.isStringNull(key)){
            return null;
        }
        return super.put(key, value);
    }
}
