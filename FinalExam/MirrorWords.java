package FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

                    String Yes = scan.nextLine();
                    Pattern YesButActuallyWork = Pattern.compile("([@#])(?<mes1>[A-Za-z]{3,})\\1\\1(?<mes2>[A-Za-z]{3,})\\1");
                    Matcher matcher = YesButActuallyWork.matcher(Yes);

                    //List<String> MirroredWords = new ArrayList<>();
                    List<String> MirroredWordsFinal = new ArrayList<>();
                    int o = 0;
                    while (matcher.find()) {
                        o++;
                        String firstWord = matcher.group("mes1");
                        String reversedPart = matcher.group("mes2");
                        String reverse = new StringBuffer(reversedPart).reverse().toString();
                        if (firstWord.equals(reverse)) {
                            //MirroredWords.add(matcher.group("mes1"));
                            String endMirror = matcher.group("mes1") + " <=> " + matcher.group("mes2");
                            MirroredWordsFinal.add(endMirror);
                        }

                    }
                    if (o != 0) {
                        System.out.println(o + " word pairs found!");
                    } else {
                        System.out.println("No word pairs found!");
                    }
                    if (MirroredWordsFinal.size() > 0) {
                        System.out.println("The mirror words are:");
                  String string = String.join(", ", MirroredWordsFinal);
                     System.out.print(string);
                    } else {
                        System.out.println("No mirror words!");
                    }
                }
            }
