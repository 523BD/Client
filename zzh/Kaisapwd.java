package cn.zzh;
public class Kaisapwd {
    public Kaisapwd() {
    }

    public static String Encrypt(String u) {
        int round = 3;
        char[] str = u.toCharArray();

        for(int i = 0; i < str.length; ++i) {
            if (i < str.length - round) {
                str[i] = (char)(str[i] + round);
            } else {
                str[i] = (char)(str[i] - str.length);
            }
        }

        String encrypt = new String(str);
        return encrypt;
    }
}
