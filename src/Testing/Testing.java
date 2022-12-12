package Testing;

public class Testing {
    public static void main(String[] args) {
        String s = "$ cd /";
        System.out.println(s.substring(s.indexOf("cd") + 3));
    }
}