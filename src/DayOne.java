import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;

public class DayOne {



    public static void main(String[] args) {


        long startTime = System.nanoTime();

        String filePath = "src\\resource\\day1Input.txt";

        try{
            List<String> lines = Files.readAllLines(Path.of(filePath));

            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            for(String line : lines){
                String[] split = line.split("\\s+");
                if(split.length == 2){
                    list1.add(Integer.parseInt(split[0]));
                    list2.add(Integer.parseInt(split[1]));
                }

            }

            list1.sort(Integer::compareTo);
            list2.sort(Integer::compareTo);

            List<Integer> list3 = new LinkedList<>();

            for(int i = 0; i < list1.size(); i++){

                int x = list1.get(i);
                int y = list2.get(i);

                int z = Math.abs(y-x);

                list3.add(z);
            }

            int sum = list3.stream().mapToInt(Integer::intValue).sum();

            System.out.println(sum);

            long elapsedTime = System.nanoTime() - startTime;
            System.out.println("Elapsed time: " + (elapsedTime / 1_000_000_000.0) + " seconds");
        }
        catch (IOException e){

            System.err.println("Error reading file:" + e);

        }

    }
}
