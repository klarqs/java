package latin.pig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PigLatin {

    public static void main(String[] args) {
        List<String> sentenceArray = new ArrayList<String>();

        System.out.println();

        System.out.println("Grace wants you to enter a phrase: ");
        Scanner input = new Scanner(System.in);
        String phrase = input.nextLine();
        phrase.split(" ");

        for(String word : phrase.split(" ")) {
            char first = word.charAt(0);
            sentenceArray.add(word.substring(1) + first + "ay");
        }

        System.out.println(sentenceArray);

        /* StringTokenizer words = new StringTokenizer(phrase);
        while (words.hasMoreTokens()) {
            System.out.println(words.nextToken());
        } */

    }
}
