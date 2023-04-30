package ua.lviv.iot.algo.part1.lab5;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceNumbersWithLetters {
    private String text;
    private int length;
    public ReplaceNumbersWithLetters (String text, int length){
        this.text = text;
        this.length = length;
    }
    public void doOperation(){
        Pattern pattern = Pattern.compile("\\b[1-9]\\b");
        Matcher matcher = pattern.matcher(text);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String match = matcher.group();
            int number = Integer.parseInt(match);
            char letter = (char) ('A' + number - 1);
            matcher.appendReplacement(result, Character.toString(letter));
        }
        matcher.appendTail(result);
        System.out.println(result.toString());
    }
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ReplaceNumbersWithLetters <text> <length>");
            return;
        }
        String text = args[0];
        int length = Integer.parseInt(args[1]);

        ReplaceNumbersWithLetters object = new ReplaceNumbersWithLetters(text, length);
        object.doOperation();
    }
}
