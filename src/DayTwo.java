import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class DayTwo {

    public boolean checkIfSafe(int[] arrayToCheck){


        Integer trend = null;

        for (int i = 1; i < arrayToCheck.length; i++){

            int diff = arrayToCheck[i] - arrayToCheck[i-1];

            if(Math.abs(diff) < 1 || Math.abs(diff) > 3){

                return false;
            }

            if (trend == null){
                if(diff > 0){

                    trend = 1;


                }
                else

                    trend = -1;
            }

            if((diff <0 && trend == 1) || (diff > 0 && trend == -1)){
                return false;
            }

        }

        return true;
    }


    public static void main(String[] args) {

        String filePath = "src\\resource\\day2Input.txt";

        try{
            List<String> lines = Files.readAllLines(Path.of(filePath));

            DayTwo d2 = new DayTwo();
            int safe = 0;

            for(int i = 0; i < lines.size(); i++){
                int[] intArray = Arrays.stream(lines.get(i).split("\\s+")).mapToInt(Integer::parseInt).toArray();

                if(d2.checkIfSafe(intArray)){
                    safe++;
                }

            }

            System.out.println("Part 1 = " + safe);


        }
        catch (IOException e){
            System.err.println("Error reading file:" + e);
        }
    }
}
