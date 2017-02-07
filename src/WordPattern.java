import java.util.HashMap;
import java.util.Map;

/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null) {
            return true;
        }

        if (pattern == null || str == null) {
            return false;
        }

        String[] content = str.split(" ");
        if (pattern.length() != content.length) {
            return false;
        }

        Map<Character, String> tmp = new HashMap<Character, String>();
        for (int i = 0; i < content.length; i++) {
            char c = pattern.charAt(i);
            if (!tmp.containsKey(c)) {
                if (tmp.containsValue(content[i])) {
                    return false;
                }
                tmp.put(c, content[i]);
            } else {
                if (!tmp.get(c).equals(content[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
