package cn.hctech2006.hcuufile.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 判断浏览器类型是否是IE浏览器,以及是否是其他浏览器
 */
public class HttpUtils {
    //IE浏览器类型的请求头对应的关键字,win10以前是MSIE以及Trident但是win上的Edge浏览器已经换成了Edge关键字
    private static String[] IEBrowserSignals = {"MSIE", "Trident", "Edge"};
    public static boolean isMSBrowser(HttpServletRequest request){
        //获取浏览器类型关键字
        String userAgent = request.getHeader("User-Agent");
        for(String signal : IEBrowserSignals){
            //如果判断是IE浏览器
            if(userAgent.contains(signal)){
                return true;
            }
        }
        //不存在关键字就不是
        return false;
    }
}
