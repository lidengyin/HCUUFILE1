package cn.hctech2006.hcuufile.config;

import cn.hctech2006.hcuufile.bean.FileType;

import java.io.IOException;
import java.io.InputStream;

/**
 * 文件类型操作类
 * @author zhihao.du
 *
 */
public final class FileTypeJudge {

    /**
     * Constructor
     */
    private FileTypeJudge() {
    }

    /**
     * 将文件头转换成16进制字符串
     * @param
     * @return 16进制字符串
     */
    private static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            System.out.println("返回bull");
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            //System.out.println("V:"+v);
            String hv = Integer.toHexString(v);
            System.out.print(hv);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);

        }
        System.out.println("stringBuilder.toString()"+stringBuilder.toString());
        return stringBuilder.toString();
    }
    /**
     * 得到文件头
     * @param
     * @return 文件头
     * @throws
     */
    private static String getFileContent(InputStream is) throws IOException {
        byte[] b = new byte[28];
        InputStream inputStream = null;
        try {
            is.read(b, 0, 28);
            System.out.println("b:"+b);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw e;
                }
            }
        }
        return bytesToHexString(b);
    }
    /**
     * 获取文件类型类
     * @param
     * @return 文件类型
     */
    public static FileType getType(InputStream is) throws IOException {
        String fileHead = getFileContent(is);
        System.out.println("fileHead:"+fileHead);
        if (fileHead == null || fileHead.length() == 0) {
            return null;
        }
        fileHead = fileHead.toUpperCase();
        System.out.println("fileHeadUpper:"+fileHead);
        FileType[] fileTypes = FileType.values();
        for (FileType type : fileTypes) {
            System.out.println(type.name()+":"+type.getValue());
            if (fileHead.startsWith(type.getValue())) {
                return type;
            }
        }
        return null;
    }
    /**
     * 获取文件类型
     * @param is
     * @return
     * @throws Exception
     */
    public static String getFileType(InputStream is) throws Exception{
        FileType fileType = getType(is);
        if(fileType!=null){
            return fileType.getValue();
        }
        return null;
    }
}
