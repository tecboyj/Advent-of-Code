package Testing;

public class Testing {
    public static void main(String[] args) {
        String s = "1";
        System.out.println(numCheck(s));
    }
    public static boolean numCheck(String s) {
        for (int i = 1; i < 10; i++) if (s.contains(String.valueOf(i))) return true;
        return false;
    }
}