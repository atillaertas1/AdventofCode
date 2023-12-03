package DAY_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle_ONE {
    public static void main(String[] args) {
        String[] input = null;
        int sum = 0;
        // file handler
        try{
            File file = new File("src/DAY_1/input.txt");
            Scanner reader = new Scanner(file);
            int lineCounter = 0;
            while (reader.hasNextLine()){
                reader.nextLine();
                lineCounter++;
            }

            input = new String[lineCounter];
            reader = new Scanner(file);

            for(int i = 0; i < lineCounter; i++){
                if (reader.hasNextLine()){
                    input[i] = reader.nextLine();
                }
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        ////////////////////////////////////////////////////
        for (String text : input) {
            int first = findFirsDigit(text);
            int last = findLastDigit(text);
            sum += (first + last);
        }

        System.out.println(sum);

    }

    private static int findFirsDigit(String text){
        for (int j = 0; j < text.length(); j++) {
            if (Character.isDigit(text.charAt(j)) ) {
                return Character.getNumericValue(text.charAt(j)) * 10;
            }
        }
        return 0;
    }

    private static int findLastDigit(String text){
        for (int j = text.length() - 1; j >= 0; j--) {
            if (Character.isDigit(text.charAt(j))) {
                return Character.getNumericValue(text.charAt(j));
            }
        }
        return 0;
    }
}
